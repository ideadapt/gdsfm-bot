
package gdsfm.telegrambot.model.airtime.liveinfov2;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "starts", "ends", "type", "name", "media_item_played", "metadata", "record" })
public class LiveInfo_ {

	@JsonProperty("starts")
	private String starts;
	@JsonProperty("ends")
	private String ends;
	@JsonProperty("type")
	private String type;
	@JsonProperty("name")
	private String name;
	@JsonProperty("media_item_played")
	private Boolean mediaItemPlayed;
	@JsonProperty("metadata")
	@JsonIgnore
	private Metadata_ metadata;
	@JsonProperty("record")
	private String record;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("starts")
	public String getStarts() {
		return starts;
	}

	@JsonProperty("starts")
	public void setStarts(String starts) {
		this.starts = starts;
	}

	@JsonProperty("ends")
	public String getEnds() {
		return ends;
	}

	@JsonProperty("ends")
	public void setEnds(String ends) {
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
	public Metadata_ getMetadata() {
		return metadata;
	}

	@JsonProperty("metadata")
	public void setMetadata(Metadata_ metadata) {
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
