package gdsfm.telegrambot.bot;

import java.time.LocalDateTime;
import java.util.List;

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

import gdsfm.telegrambot.model.CurrentTrack;
import gdsfm.telegrambot.model.HistoryTrack;
import gdsfm.telegrambot.repository.AirtimeHistoryEntryMongoRepository;
import gdsfm.telegrambot.repository.AirtimeLiveEntryMongoRepository;

/**
 * Created by ggrassi on 28.12.16.
 */
@Component
public class TelegramBot extends TelegramLongPollingBot {

    private static final Logger logger = LoggerFactory.getLogger(TelegramBot.class);

    private final int maxSize = 10;

    @Autowired
    private AirtimeHistoryEntryMongoRepository historyRepository;

    @Autowired
    private AirtimeLiveEntryMongoRepository liveRepository;

    @Value("${bot.token}")
    private String token;

    @Value("${bot.username}")
    private String username;

/*    @Autowired
    public TelegramBot(HistoryEntryRepository historyRepository) {
        super();
        this.historyRepository=historyRepository;
    }*/

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            SendMessage response = new SendMessage();
            Long chatId = message.getChatId();
            response.setChatId(chatId);
            String text = message.getText();

            try {
                if (text.contains("/after")) {

                    List<HistoryTrack> historyAfter = historyRepository.findByEndsAfter(LocalDateTime.now().minusHours(1), new PageRequest(0, maxSize));
                    response.setText(historyAfter.toString());
                } else if(text.contains("/history")) {
                    List<HistoryTrack> allByOrderByStartsAsc = historyRepository.findAllByOrderByStartsDesc(new PageRequest(0, maxSize));
                    response.setText(allByOrderByStartsAsc.toString());

                }else{
                    CurrentTrack liveTrack = liveRepository.findAll()
                            .stream()
                            .findFirst()
                            .orElseGet(() -> new CurrentTrack());
                    response.setText(liveTrack.toString());;
                }

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
