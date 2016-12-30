
package gdsfm.telegrambot.model.airtime.liveinfov2.track;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class LiveInfoTrack {
	
	//TODO: bad idea, find better id that collides
	@Id
	private String id = UUID.randomUUID().toString();
	
	@JsonProperty("name")
	private String name;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime starts;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime ends;
	
	@JsonProperty("type")
	private String type;
	@JsonProperty("media_item_played")
	private Boolean mediaItemPlayed;
	
	@JsonProperty("record")
	private String record;
	
	@Transient
	@JsonProperty("metadata")
	private TrackMetadata metadata;

	@JsonIgnore
	@Transient
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("starts")
	public LocalDateTime getStarts() {
		return starts;
	}

	@JsonProperty("starts")
	public void setStarts(LocalDateTime starts) {
		this.starts = starts;
	}

	@JsonProperty("ends")
	public LocalDateTime getEnds() {
		return ends;
	}

	@JsonProperty("ends")
	public void setEnds(LocalDateTime ends) {
		this.ends = ends;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("media_item_played")
	public Boolean getMediaItemPlayed() {
		return mediaItemPlayed;
	}

	@JsonProperty("media_item_played")
	public void setMediaItemPlayed(Boolean mediaItemPlayed) {
		this.mediaItemPlayed = mediaItemPlayed;
	}

	@JsonProperty("metadata")
	public TrackMetadata getMetadata() {
		return metadata;
	}

	@JsonProperty("metadata")
	public void setMetadata(TrackMetadata metadata) {
		this.metadata = metadata;
	}

	@JsonProperty("record")
	public String getRecord() {
		return record;
	}

	@JsonProperty("record")
	public void setRecord(String record) {
		this.record = record;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
