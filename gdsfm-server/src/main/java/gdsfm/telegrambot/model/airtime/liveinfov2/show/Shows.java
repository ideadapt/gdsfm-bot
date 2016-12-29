
package gdsfm.telegrambot.model.airtime.liveinfov2.show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "previous", "current", "next" })
public class Shows {

	@JsonProperty("previous")
	private List<Show> previous = null;
	@JsonProperty("current")
	private Show current;
	@JsonProperty("next")
	private List<Show> next = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("previous")
	public List<Show> getPrevious() {
		return previous;
	}

	@JsonProperty("previous")
	public void setPrevious(List<Show> previous) {
		this.previous = previous;
	}

	@JsonProperty("current")
	public Show getCurrent() {
		return current;
	}

	@JsonProperty("current")
	public void setCurrent(Show current) {
		this.current = current;
	}

	@JsonProperty("next")
	public List<Show> getNext() {
		return next;
	}

	@JsonProperty("next")
	public void setNext(List<Show> next) {
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
