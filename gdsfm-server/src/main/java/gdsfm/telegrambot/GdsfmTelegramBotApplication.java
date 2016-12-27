package gdsfm.telegrambot;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import gdsfm.telegrambot.model.airtime.itemhistoryfeed.AirtimeHistoryEntry;
import gdsfm.telegrambot.model.airtime.liveinfov2.LiveInfo;
import gdsfm.telegrambot.repository.HistoryEntryRepository;

@Controller
@EnableAutoConfiguration
@EnableScheduling
public class GdsfmTelegramBotApplication {

	@Autowired
	HistoryEntryRepository historyEntryRepository;

	@Scheduled(fixedDelay = 2000)
	public void parseAndStoreHistory() {
		RestTemplate restTemplate = new RestTemplate();
		AirtimeHistoryEntry[] entries = restTemplate.getForObject("http://gdsfm.airtime.pro/api/item-history-feed",
				AirtimeHistoryEntry[].class);
		historyEntryRepository.save(Arrays.asList(entries));
		// TODO don't replace history entries
	}

	@RequestMapping("/current")
	@ResponseBody
	String current() {
		final RestTemplate restTemplate = new RestTemplate();
		final LiveInfo liveInfo = restTemplate.getForObject("http://gdsfm.airtime.pro/api/live-info-v2",
				LiveInfo.class);
		return liveInfo.getTracks().getCurrent().getName();
	}

	@RequestMapping("/last")
	@ResponseBody
	List<AirtimeHistoryEntry> last(@RequestParam(value = "limit", defaultValue = "5") int limit) {
		// TODO add index to date
		final List<AirtimeHistoryEntry> entries = historyEntryRepository
				.findAllByOrderByStartsAsc(new PageRequest(0, limit));

		return entries.stream().sorted((e1, e2) -> e1.getStarts().isBefore(e2.getStarts()) ? 1 : 0).limit(5)
				.collect(Collectors.toList());
	}

	@RequestMapping("/history")
	@ResponseBody
	AirtimeHistoryEntry history(
			@RequestParam(value = "date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
		return historyEntryRepository.findByTrackAtDate(date, new PageRequest(0, 1)).stream().findAny().orElseGet(null);
	}

	@RequestMapping("/")
	@ResponseBody
	String dev() {
		RestTemplate restTemplate = new RestTemplate();
		String consumeJSONString = restTemplate.getForObject("http://gdsfm.airtime.pro/api/item-history-feed",
				String.class);
		System.out.println("JSON String: " + consumeJSONString);

		AirtimeHistoryEntry[] entries = restTemplate.getForObject("http://gdsfm.airtime.pro/api/item-history-feed",
				AirtimeHistoryEntry[].class);

		historyEntryRepository.save(Arrays.asList(entries));

		Arrays.asList(entries).stream().forEach(e -> {
			System.out.println(e);
		});

		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GdsfmTelegramBotApplication.class, args);
	}
}