package gdsfm.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class GdsfmTelegramBotServerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GdsfmTelegramBotServerApplication.class, args);
	}
}