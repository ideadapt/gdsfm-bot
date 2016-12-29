package gdsfm.telegrambot.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by ggrassi on 29.12.16.
 */
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrentTrack {
    @Id
    public String name;

    public CurrentTrack() {
    }

    public CurrentTrack(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CurrentTrack{" +
                "name='" + name + '\'' +
                '}';
    }
}
