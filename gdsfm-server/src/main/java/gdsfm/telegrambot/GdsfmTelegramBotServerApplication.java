package gdsfm.telegrambot;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

import gdsfm.telegrambot.model.CurrentTrack;
import gdsfm.telegrambot.model.HistoryTrack;
import gdsfm.telegrambot.model.airtime.itemhistoryfeed.AirtimeHistoryEntry;
import gdsfm.telegrambot.model.airtime.liveinfov2.AirtimeLiveInfo;
import gdsfm.telegrambot.repository.AirtimeHistoryEntryJpaRepository;
import gdsfm.telegrambot.repository.AirtimeHistoryEntryMongoRepository;
import gdsfm.telegrambot.repository.AirtimeLiveEntryMongoRepository;
import gdsfm.telegrambot.repository.ShowRepository;

@Controller
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan("gdsfm.telegrambot")
@SpringBootApplication
public class GdsfmTelegramBotServerApplication {

	@Autowired
	AirtimeHistoryEntryMongoRepository historyEntryMongoRepository;

	@Autowired
	AirtimeLiveEntryMongoRepository liveEntryMongoRepository;

	@Autowired
	AirtimeHistoryEntryJpaRepository historyEntryJpaRepository;

	@Autowired
	ShowRepository showRepository;

	@Scheduled(fixedDelay = 2000)
	public void parseAndStoreHistory() {
		RestTemplate restTemplate = new RestTemplate();
		AirtimeHistoryEntry[] entries = restTemplate.getForObject("http://gdsfm.airtime.pro/api/item-history-feed",
				AirtimeHistoryEntry[].class);

		List<AirtimeHistoryEntry> liveInfos = Arrays.asList(entries);
		List<HistoryTrack> tracks = liveInfos.stream()
				.map(info -> new HistoryTrack(info.getHistory_id(), info.getStarts(), info.getEnds(),
						info.getInstance_id(), info.getTrack_title(), info.getArtist_name()))
				.collect(Collectors.toList());

		historyEntryMongoRepository.deleteAll();
		historyEntryMongoRepository.save(tracks);
	}

	@Scheduled(fixedDelay = 15000)
	public void parseAndStoreCurrent() {
		final RestTemplate restTemplate = new RestTemplate();
		final AirtimeLiveInfo liveInfo = restTemplate.getForObject("http://gdsfm.airtime.pro/api/live-info-v2",
				AirtimeLiveInfo.class);
		liveEntryMongoRepository.deleteAll();

		CurrentTrack current = new CurrentTrack(liveInfo.getTracks().getCurrent().getName());

		liveEntryMongoRepository.save(current);
	}

	@Scheduled(fixedDelay = 2000)
	public void parseAndStoreHistory2() {
		RestTemplate restTemplate = new RestTemplate();
		AirtimeHistoryEntry[] entries = restTemplate.getForObject("http://gdsfm.airtime.pro/api/item-history-feed",
				AirtimeHistoryEntry[].class);
		historyEntryJpaRepository.save(Arrays.asList(entries));
		// TODO don't replace history entries
	}

	@Scheduled(fixedDelay = 2000)
	public void parseAndStoreShows() {
		final RestTemplate restTemplate = new RestTemplate();
		final AirtimeLiveInfo liveInfo = restTemplate.getForObject("http://gdsfm.airtime.pro/api/live-info-v2",
				AirtimeLiveInfo.class);

		showRepository.save(liveInfo.getShows().getCurrent());
	}

	@RequestMapping("/current")
	@ResponseBody
	String current() {
		List<CurrentTrack> all = liveEntryMongoRepository.findAll();

		if (all.isEmpty()) {
			return "Sorry dude, to fast, im lazy need to have a beer and come later, ciao!!!!";
		}
		CurrentTrack current = all.stream().findFirst().orElseGet(null);
		return current.getName();
	}

	@RequestMapping("/current2")
	@ResponseBody
	String current2() {
		final RestTemplate restTemplate = new RestTemplate();
		final AirtimeLiveInfo liveInfo = restTemplate.getForObject("http://gdsfm.airtime.pro/api/live-info-v2",
				AirtimeLiveInfo.class);
		return liveInfo.getTracks().getCurrent().getName();
	}

	@RequestMapping("/last")
	@ResponseBody
	List<HistoryTrack> last(@RequestParam(value = "limit", defaultValue = "5") int limit) {
		// TODO add index to date
		final List<HistoryTrack> entries = historyEntryMongoRepository
				.findAllByOrderByStartsDesc(new PageRequest(0, limit));

		return entries.stream().sorted((e1, e2) -> e1.getStarts().isBefore(e2.getStarts()) ? 1 : 0).limit(5)
				.collect(Collectors.toList());
	}

	@RequestMapping("/history")
	@ResponseBody
	List<HistoryTrack> history(
			@RequestParam(value = "date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
		return historyEntryMongoRepository.findByEndsAfter(date, new PageRequest(0, 10)).stream()
				.collect(Collectors.toList());
	}

	@RequestMapping("/history2")
	@ResponseBody
	AirtimeHistoryEntry history2(
			@RequestParam(value = "date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
		return historyEntryJpaRepository.findByTrackAtDate(date, new PageRequest(0, 1)).stream().findAny()
				.orElseGet(null);
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
				.map(info -> new HistoryTrack(info.getHistory_id(), info.getStarts(), info.getEnds(),
						info.getInstance_id(), info.getTrack_title(), info.getArtist_name()))
				.collect(Collectors.toList());
		historyEntryMongoRepository.save(tracks);

		Arrays.asList(entries).stream().forEach(e -> {
			System.out.println(e);
		});

		return "Hello World!";
	}

	@RequestMapping("/dev2")
	@ResponseBody
	String dev2() {
		RestTemplate restTemplate = new RestTemplate();
		String consumeJSONString = restTemplate.getForObject("http://gdsfm.airtime.pro/api/item-history-feed",
				String.class);
		System.out.println("JSON String: " + consumeJSONString);

		AirtimeHistoryEntry[] entries = restTemplate.getForObject("http://gdsfm.airtime.pro/api/item-history-feed",
				AirtimeHistoryEntry[].class);

		historyEntryJpaRepository.save(Arrays.asList(entries));

		Arrays.asList(entries).stream().forEach(e -> {
			System.out.println(e);
		});

		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GdsfmTelegramBotServerApplication.class, args);
	}
}