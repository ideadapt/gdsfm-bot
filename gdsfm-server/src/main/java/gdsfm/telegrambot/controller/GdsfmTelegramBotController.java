package gdsfm.telegrambot.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import gdsfm.telegrambot.model.airtime.itemhistoryfeed.HistoryTrack;
import gdsfm.telegrambot.model.airtime.liveinfov2.AirtimeLiveInfo;
import gdsfm.telegrambot.repository.HistoryTrackRepository;
import gdsfm.telegrambot.repository.ShowRepository;

@Controller
public class GdsfmTelegramBotController {

	@Autowired
	HistoryTrackRepository historyEntryJpaRepository;

	@Autowired
	ShowRepository trackRepository;
	
	@Autowired
	ShowRepository showRepository;

	@RequestMapping("/current")
	@ResponseBody
	public AirtimeLiveInfo current() {
		//TODO query from DB
		final RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://gdsfm.airtime.pro/api/live-info-v2", AirtimeLiveInfo.class);
	}

	@RequestMapping("/last")
	@ResponseBody
	public List<HistoryTrack> last(@RequestParam(value = "limit", defaultValue = "5") int limit) {
		return historyEntryJpaRepository.findByTrackAtDate(LocalDateTime.now(), new PageRequest(0, limit));
	}

	@RequestMapping("/history")
	@ResponseBody
	public List<HistoryTrack> history(@RequestParam(value = "date", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date, @RequestParam(value = "limit", defaultValue = "5") int limit) {
		return historyEntryJpaRepository.findByTrackAtDate(date, new PageRequest(0, limit));
	}

}
