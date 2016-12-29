package gdsfm.telegrambot.bot;

import gdsfm.telegrambot.model.HistoryTrack;
import gdsfm.telegrambot.model.airtime.itemhistoryfeed.AirtimeHistoryEntry;
import gdsfm.telegrambot.repository.HistoryEntryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.List;

/**
 * Created by ggrassi on 28.12.16.
 */
@Component
public class TelegramBot extends TelegramLongPollingBot{

    private static final Logger logger = LoggerFactory.getLogger(TelegramBot.class);

    @Autowired
    private HistoryEntryRepository repository;

    @Value("${bot.token}")
    private String token;

    @Value("${bot.username}")
    private String username;

/*    @Autowired
    public TelegramBot(HistoryEntryRepository repository) {
        super();
        this.repository=repository;
    }*/

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            SendMessage response = new SendMessage();
            Long chatId = message.getChatId();
            response.setChatId(chatId);
            String text = message.getText();

            List<HistoryTrack> allByOrderByStartsAsc = repository.findAllByOrderByStartsAsc(new PageRequest(0, 1));

            HistoryTrack airtimeHistoryEntry = allByOrderByStartsAsc.stream().findFirst().get();

            response.setText(airtimeHistoryEntry.getArtist_name() +" - "+airtimeHistoryEntry.getTrack_title());

            try {
                sendMessage(response);
                logger.info("Sent message \"{}\" to {}", text, chatId);
            } catch (TelegramApiException e) {
                logger.error("Failed to send message \"{}\" to {} due to error: {}", text, chatId, e.getMessage());
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
