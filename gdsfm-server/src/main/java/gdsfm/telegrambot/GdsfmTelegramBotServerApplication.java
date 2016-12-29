package gdsfm.telegrambot;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import gdsfm.telegrambot.model.CurrentTrack;
import gdsfm.telegrambot.model.HistoryTrack;
import gdsfm.telegrambot.model.airtime.itemhistoryfeed.AirtimeHistoryEntry;
import gdsfm.telegrambot.model.airtime.liveinfov2.LiveInfo_;
import gdsfm.telegrambot.repository.AirtimeLiveEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import gdsfm.telegrambot.model.airtime.liveinfov2.LiveInfo;
import gdsfm.telegrambot.repository.HistoryEntryRepository;

@Controller
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan("gdsfm.telegrambot")
@SpringBootApplication
public class GdsfmTelegramBotServerApplication {

	@Autowired
	HistoryEntryRepository historyEntryRepository;

	@Autowired
	AirtimeLiveEntryRepository airtimeLiveEntryRepository;

	@Scheduled(fixedDelay = 2000)
	public void parseAndStoreHistory() {
		RestTemplate restTemplate = new RestTemplate();
		AirtimeHistoryEntry[] entries = restTemplate.getForObject("http://gdsfm.airtime.pro/api/item-history-feed",
				AirtimeHistoryEntry[].class);

		List<AirtimeHistoryEntry> liveInfos = Arrays.asList(entries);
		List<HistoryTrack> tracks = liveInfos.stream()
				.map(info -> new HistoryTrack(info.getHistory_id(), info.getStarts(), info.getEnds(), info.getInstance_id(), info
						.getTrack_title(), info.getArtist_name()))
				.collect(Collectors.toList());

		historyEntryRepository.deleteAll();
		historyEntryRepository.save(tracks);
	}

	@Scheduled(fixedDelay = 15000)
	public void parseAndStoreCurrent() {
		final RestTemplate restTemplate = new RestTemplate();
		final LiveInfo liveInfo = restTemplate.getForObject("http://gdsfm.airtime.pro/api/live-info-v2",
				LiveInfo.class);
		airtimeLiveEntryRepository.deleteAll();

		LiveInfo_ current = liveInfo.getTracks().getCurrent();

		airtimeLiveEntryRepository.save(Arrays.asList(new CurrentTrack(current.getName())));
	}

	@RequestMapping("/current")
	@ResponseBody
	String current() {

		List<CurrentTrack> all = airtimeLiveEntryRepository.findAll();

		if(all.isEmpty()){
			return "Sorry dude, to fast, im lazy need to have a beer and come later, ciao!!!!";
		}
		CurrentTrack current = all.stream().findFirst().orElseGet(null);
		return current.getName() ;
	}

	@RequestMapping("/last")
	@ResponseBody
	List<HistoryTrack> last(@RequestParam(value = "limit", defaultValue = "5") int limit) {
		// TODO add index to date
		final List<HistoryTrack> entries = historyEntryRepository
				.findAllByOrderByStartsDesc(new PageRequest(0, limit));

		return entries.stream().sorted((e1, e2) -> e1.getStarts().isBefore(e2.getStarts()) ? 1 : 0).limit(5)
				.collect(Collectors.toList());
	}

	@RequestMapping("/history")
	@ResponseBody
	List<HistoryTrack> history(
			@RequestParam(value = "date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
		return historyEntryRepository.findByEndsAfter(date, new PageRequest(0, 10))
				.stream()
				.collect(Collectors.toList());
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
		List<AirtimeHistoryEntry> liveInfos = Arrays.asList(entries);
		List<HistoryTrack> tracks = liveInfos.stream()
				.map(info -> new HistoryTrack(info.getHistory_id(), info.getStarts(), info.getEnds(), info.getInstance_id(), info
						.getTrack_title(), info.getArtist_name()))
				.collect(Collectors.toList());
		historyEntryRepository.save(tracks);

		Arrays.asList(entries).stream().forEach(e -> {
			System.out.println(e);
		});

		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GdsfmTelegramBotServerApplication.class, args);
	}
}