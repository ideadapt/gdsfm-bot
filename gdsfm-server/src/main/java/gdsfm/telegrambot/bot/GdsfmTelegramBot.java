package gdsfm.telegrambot.bot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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
import gdsfm.telegrambot.model.airtime.itemhistoryfeed.HistoryTrack;
import gdsfm.telegrambot.model.airtime.liveinfov2.AirtimeLiveInfo;
import gdsfm.telegrambot.model.airtime.liveinfov2.show.Show;
import gdsfm.telegrambot.model.airtime.liveinfov2.track.LiveInfoTrack;

@Component
public class GdsfmTelegramBot extends TelegramLongPollingBot {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GdsfmTelegramBotController controller;

	@Value("${bot.default.maxResponseSize}")
	private int maxSize;

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
			final Message message = update.getMessage();
			
			final Long chatId = message.getChatId();
			final String text = message.getText();

			SendMessage response = null;
			try {
				if (text.equals("/")) {
					response = getDefaultResponse(message);
					response.setText(" \\o/");
				} else if (text.startsWith("/current")) {
					response = current(message);
				} else if (text.startsWith("/last")) {
					response = last(message);
				} else if (text.startsWith("/before")) {
					response = before(message);
				}else if (text.startsWith("/after")) {
					response = after(message);
				}

				if (response != null && response.getText() != null && !response.getText().equals("")) {
					sendMessage(response);
					logger.info("Sent response \"{}\" for \"{}\" in {}",
							response.getText().length() > 20 ? response.getText().substring(0, 20) + "..." : response.getText(),
							text,
							chatId);
				} else {
					logger.info("No Response for \"{}\" in {}", message.getText(), chatId);
				}

			} catch (TelegramApiException e) {
				logger.error("Failed to send message \"{}\" to {} due to error: {}", text, chatId, e.getMessage());
			}
		}
	}

	protected SendMessage current(Message message) {
		final SendMessage response = getDefaultResponse(message);
		final AirtimeLiveInfo liveInfo = controller.current();
		final StringBuilder text = new StringBuilder();
		// Line 1
		LiveInfoTrack track = liveInfo.getTracks().getCurrent();
		boolean trackAvailable = track != null && track.getName() != null && !track.getName().equals("");
		
		if (trackAvailable) {
			text.append("<b>");
			text.append(track.getName());
			text.append("</b>");
		}
		Show show = liveInfo.getShows().getCurrent();
		boolean showAvailable = show != null && show.getName() != null && !show.getName().equals("");
		
		if (!trackAvailable && showAvailable) {
			if (text.length() > 0) {
				text.append("\n");
			}
			text.append(show.getName());
		}
		if (!trackAvailable && !showAvailable) {
			text.append("(no data)");
		}
		text.append("\n");
		// Line 2
		text.append("Tune in ");
		if (trackAvailable && showAvailable) {
			text.append("to ");
			text.append("<i>");
			text.append(show.getName());
			text.append("</i> ");
		}
		text.append("at ");
		text.append("<a href=\"http://play.gds.fm/\">GDS.FM</a>");
		
		response.setText(text.toString());
		response.disableWebPagePreview();
		return response;
	}

	protected SendMessage last(Message message) {
		final SendMessage response = getDefaultResponse(message);
		final StringBuilder responseText = new StringBuilder();
		final int argLimit = parseLimitArgument(message, maxSize);
		controller.last(argLimit)
				.forEach(track -> responseText.append(formatHistoryTrack(track)));
		response.setText(responseText.toString());
		return response;
	}

	protected SendMessage after(Message message) {
		final SendMessage response = getDefaultResponse(message);
		final StringBuilder responseText = new StringBuilder();
		controller.after(LocalDateTime.now(), maxSize)
				.forEach(track -> responseText.append(formatHistoryTrack(track)));
		response.setText(responseText.toString());
		return response;
	}

	protected SendMessage before(Message message) {
		final SendMessage response = getDefaultResponse(message);
		final StringBuilder responseText = new StringBuilder();
		controller.before(LocalDateTime.now(), maxSize)
				.forEach(track -> responseText.append(formatHistoryTrack(track)));
		response.setText(responseText.toString());
		return response;
	}
	
	private SendMessage getDefaultResponse(Message message) {
		final SendMessage response = new SendMessage();
		response.setChatId(message.getChatId());
		response.setParseMode("HTML");
		return response;
	}
	
	private String formatHistoryTrack(HistoryTrack track) {
		final StringBuilder text = new StringBuilder();
		text.append("<b>");
		text.append(track.getArtist_name());
		text.append("</b>");
		text.append(" - ");
		text.append("<b>");
		text.append(track.getTrack_title());
		text.append("</b>");
		text.append("\n");
		text.append("<i>[" + formatLocalDateTime(track.getStarts()) + "]</i> ");
		text.append("\n\n");
		return text.toString();
	}

	private String formatLocalDateTime(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		return date.format(formatter);
	}

	private int parseLimitArgument(Message message, int maxSize) {
		final List<String> args = Arrays.asList(message.getText().split(" "));

		final String limit = args.stream().filter(arg -> {
					try {
						Integer.parseInt(arg);
						return true;
					} catch (NumberFormatException nfe) {
						return false;
					}
				}
		).findFirst().orElseGet(() -> String.valueOf(maxSize));
		final int argLimit = Integer.parseInt(limit);
		return argLimit <= maxSize ? argLimit : maxSize;
	}
}
