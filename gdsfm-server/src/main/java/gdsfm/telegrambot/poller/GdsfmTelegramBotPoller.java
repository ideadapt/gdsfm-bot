package gdsfm.telegrambot.poller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import gdsfm.telegrambot.model.CurrentTrack;
import gdsfm.telegrambot.model.HistoryTrack;
import gdsfm.telegrambot.model.airtime.itemhistoryfeed.AirtimeHistoryEntry;
import gdsfm.telegrambot.model.airtime.liveinfov2.AirtimeLiveInfo;
import gdsfm.telegrambot.repository.AirtimeHistoryEntryJpaRepository;
import gdsfm.telegrambot.repository.AirtimeHistoryEntryMongoRepository;
import gdsfm.telegrambot.repository.AirtimeLiveEntryMongoRepository;
import gdsfm.telegrambot.repository.ShowRepository;

@EnableAutoConfiguration
@EnableScheduling
public class GdsfmTelegramBotPoller {
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

		historyEntryMongoRepository.save(tracks);
	}

	@Scheduled(fixedDelay = 15000)
	public void parseAndStoreCurrent() {
		final RestTemplate restTemplate = new RestTemplate();
		final AirtimeLiveInfo liveInfo = restTemplate.getForObject("http://gdsfm.airtime.pro/api/live-info-v2",
				AirtimeLiveInfo.class);
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
}
