
package gdsfm.telegrambot.model.airtime.liveinfov2.track;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "previous", "current", "next" })
public class Tracks {

	@JsonProperty("previous")
	private LiveInfoTrack previous;
	@JsonProperty("current")
	private LiveInfoTrack current;
	@JsonProperty("next")
	private LiveInfoTrack next;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("previous")
	public LiveInfoTrack getPrevious() {
		return previous;
	}

	@JsonProperty("previous")
	public void setPrevious(LiveInfoTrack previous) {
		this.previous = previous;
	}

	@JsonProperty("current")
	public LiveInfoTrack getCurrent() {
		return current;
	}

	@JsonProperty("current")
	public void setCurrent(LiveInfoTrack current) {
		this.current = current;
	}

	@JsonProperty("next")
	public LiveInfoTrack getNext() {
		return next;
	}

	@JsonProperty("next")
	public void setNext(LiveInfoTrack next) {
		this.next = next;
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
