package gdsfm.telegrambot.model.airtime.itemhistoryfeed;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.dom4j.tree.AbstractEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(indexes = { @Index(name = "STARTS", columnList = "starts") })
public class HistoryTrack extends AbstractEntity { //TODO try to remove
	private static final long serialVersionUID = 3621195233271594236L;

	@Id
	private String history_id;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime starts;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime ends;

	private String instance_id;
	private String track_title;
	private String artist_name;

	public LocalDateTime getStarts() {
		return starts;
	}

	public LocalDateTime getEnds() {
		return ends;
	}

	public String getHistory_id() {
		return history_id;
	}

	public String getInstance_id() {
		return instance_id;
	}

	public String getTrack_title() {
		return track_title;
	}

	public String getArtist_name() {
		return artist_name;
	}

	@Override
	public String toString() {
		return "AirtimeHistoryEntry [starts=" + starts + ", ends=" + ends + ", history_id=" + history_id
				+ ", instance_id=" + instance_id + ", track_title=" + track_title + ", artist_name=" + artist_name
				+ "]";
	}

}