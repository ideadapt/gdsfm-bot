package gdsfm.telegrambot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by ggrassi on 29.12.16.
 */
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HistoryTrack {
    @Id
    private String history_id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime starts;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime ends;

    private String instance_id;
    private String track_title;
    private String artist_name;

    public HistoryTrack() {
    }

    public HistoryTrack(String history_id, LocalDateTime starts, LocalDateTime ends, String instance_id, String track_title, String artist_name) {
        this.history_id = history_id;
        this.starts = starts;
        this.ends = ends;
        this.instance_id = instance_id;
        this.track_title = track_title;
        this.artist_name = artist_name;
    }

    public String getHistory_id() {
        return history_id;
    }

    public void setHistory_id(String history_id) {
        this.history_id = history_id;
    }

    public LocalDateTime getStarts() {
        return starts;
    }

    public void setStarts(LocalDateTime starts) {
        this.starts = starts;
    }

    public LocalDateTime getEnds() {
        return ends;
    }

    public void setEnds(LocalDateTime ends) {
        this.ends = ends;
    }

    public String getInstance_id() {
        return instance_id;
    }

    public void setInstance_id(String instance_id) {
        this.instance_id = instance_id;
    }

    public String getTrack_title() {
        return track_title;
    }

    public void setTrack_title(String track_title) {
        this.track_title = track_title;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    @Override
    public String toString() {
        return "HistoryTrack{" +
                "history_id='" + history_id + '\'' +
                ", starts=" + starts +
                ", ends=" + ends +
                ", instance_id='" + instance_id + '\'' +
                ", track_title='" + track_title + '\'' +
                ", artist_name='" + artist_name + '\'' +
                '}';
    }
}
