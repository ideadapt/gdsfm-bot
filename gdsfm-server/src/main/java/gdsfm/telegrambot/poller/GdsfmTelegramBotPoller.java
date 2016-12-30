package gdsfm.telegrambot.poller;

import java.util.Arrays;

import gdsfm.telegrambot.model.airtime.liveinfov2.show.Show;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import gdsfm.telegrambot.model.airtime.itemhistoryfeed.HistoryTrack;
import gdsfm.telegrambot.model.airtime.liveinfov2.AirtimeLiveInfo;
import gdsfm.telegrambot.model.airtime.liveinfov2.track.LiveInfoTrack;
import gdsfm.telegrambot.repository.HistoryTrackRepository;
import gdsfm.telegrambot.repository.LiveInfoTrackRepository;
import gdsfm.telegrambot.repository.ShowRepository;

@Service
@EnableAutoConfiguration
@EnableScheduling
public class GdsfmTelegramBotPoller {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	HistoryTrackRepository historyTrackRepository;
	
	@Autowired
	LiveInfoTrackRepository trackRepository;

	@Autowired
	ShowRepository showRepository;

	@Scheduled(fixedDelay = 2000)
	public void parseAndStoreAirtimeData() {
		log.info("Start of GdsfmTelegramBotPoller.parseAndStoreAirtimeData()");
		
		try {
			parseAndStoreHistoryTracks();
		} catch (Exception e) {
			log.error("Error during parseAndStoreHistoryTracks()", e);
		}
		
		try {
			parseAndStoreCurrentTrack();
		} catch (Exception e) {
			log.error("Error during parseAndStoreCurrentTrack()", e);
		}
		
		try {
			parseAndStoreCurrentShow();
		} catch (Exception e) {
			log.error("Error during parseAndStoreCurrentShow()", e);
		}
	}

	protected void parseAndStoreHistoryTracks() {
		final RestTemplate restTemplate = new RestTemplate();
		final HistoryTrack[] entries = restTemplate.getForObject("http://gdsfm.airtime.pro/api/item-history-feed", HistoryTrack[].class);
		historyTrackRepository.save(Arrays.asList(entries));
	}

	protected void parseAndStoreCurrentTrack() {
		final RestTemplate restTemplate = new RestTemplate();
		final AirtimeLiveInfo liveInfo = restTemplate.getForObject("http://gdsfm.airtime.pro/api/live-info-v2", AirtimeLiveInfo.class);
		final LiveInfoTrack current = liveInfo.getTracks().getCurrent();
		trackRepository.save(current);
	}

	protected void parseAndStoreCurrentShow() {
		final RestTemplate restTemplate = new RestTemplate();
		final AirtimeLiveInfo liveInfo = restTemplate.getForObject("http://gdsfm.airtime.pro/api/live-info-v2", AirtimeLiveInfo.class);
		final Show currentShow = liveInfo.getShows().getCurrent();
		showRepository.save(currentShow);
	}
}
