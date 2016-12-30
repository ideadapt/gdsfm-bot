package gdsfm.telegrambot.bot;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import gdsfm.telegrambot.controller.GdsfmTelegramBotController;
import gdsfm.telegrambot.model.airtime.liveinfov2.AirtimeLiveInfo;
import gdsfm.telegrambot.model.airtime.liveinfov2.show.Show;
import gdsfm.telegrambot.model.airtime.liveinfov2.track.LiveInfoTrack;

@Component
public class GdsfmTelegramBot extends TelegramLongPollingBot {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final int maxSize = 10;

	@Autowired
	private GdsfmTelegramBotController controller;

	@Value("${bot.token}")
	private String token;

	@Value("${bot.username}")
	private String username;

	@Override
	public String getBotUsername() {
		return username;
	}

	@Override
	public String getBotToken() {
		return token;
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage()) {
			Message message = update.getMessage();
			Long chatId = message.getChatId();

			SendMessage response = new SendMessage();
			response.setChatId(chatId);
			response.setParseMode("HTML");

			String text = message.getText();
			try {
				if (text.equals("/")) {
					logger.info("Add debug code here");
				} else if (text.startsWith("/current")) {
					response.setText(current(message));
				} else if (text.startsWith("/last")) {
					response.setText(last(message));
				} else if (text.startsWith("/history")) {
					response.setText(history(message));
				}

				if (response != null && response.getText() != null && !response.getText().equals("")) {
					sendMessage(response);
					logger.info("Sent response \"{}\" for \"{}\" in {}", response.getText().substring(0, 20), text,
							chatId);
				} else {
					logger.info("No Response for \"{}\" in {}", text, chatId);
				}

			} catch (TelegramApiException e) {
				logger.error("Failed to send message \"{}\" to {} due to error: {}", text, chatId, e.getMessage());
			}
		}
	}

	protected String current(Message message) {
		final AirtimeLiveInfo liveInfo = controller.current();
		String text = null;

		LiveInfoTrack track = liveInfo.getTracks().getCurrent();
		Show show = liveInfo.getShows().getCurrent();

		if (track != null && track.getName() != null && !track.getName().equals("")) {
			text = track.getName();
		}

		if (show != null && show.getName() != null && !show.getName().equals("")) {
			text = show.getName();
		}

		if (text == null) {
			text = "(no data)";
		}

		return text;
	}

	protected String last(Message message) {
		return controller.last(maxSize).toString();
	}

	protected String history(Message message) {
		final StringBuilder response = new StringBuilder();
		controller.history(LocalDateTime.now().minusHours(4), maxSize).stream().forEach(h -> {
			response.append("<i>[" + h.getStarts() + "]</i> ");
			response.append("<b>");
			response.append(h.getArtist_name());
			response.append(" - ");
			response.append(h.getTrack_title());
			response.append("</b>");
			response.append("\n");
		});
		return response.toString();
	}

}
