
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
@JsonPropertyOrder({ "previous", "current", "next" })
public class Tracks {

	@JsonProperty("previous")
	private Previous previous;
	@JsonProperty("current")
	private LiveInfo_ current;
	@JsonProperty("next")
	private Next next;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("previous")
	public Previous getPrevious() {
		return previous;
	}

	@JsonProperty("previous")
	public void setPrevious(Previous previous) {
		this.previous = previous;
	}

	@JsonProperty("current")
	public LiveInfo_ getCurrent() {
		return current;
	}

	@JsonProperty("current")
	public void setCurrent(LiveInfo_ current) {
		this.current = current;
	}

	@JsonProperty("next")
	public Next getNext() {
		return next;
	}

	@JsonProperty("next")
	public void setNext(Next next) {
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
