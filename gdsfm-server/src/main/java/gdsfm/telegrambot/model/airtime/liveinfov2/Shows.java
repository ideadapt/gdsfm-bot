
package gdsfm.telegrambot.model.airtime.liveinfov2;

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
	private List<Object> previous = null;
	@JsonProperty("current")
	private LiveInfo__ current;
	@JsonProperty("next")
	private List<Next_> next = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("previous")
	public List<Object> getPrevious() {
		return previous;
	}

	@JsonProperty("previous")
	public void setPrevious(List<Object> previous) {
		this.previous = previous;
	}

	@JsonProperty("current")
	public LiveInfo__ getCurrent() {
		return current;
	}

	@JsonProperty("current")
	public void setCurrent(LiveInfo__ current) {
		this.current = current;
	}

	@JsonProperty("next")
	public List<Next_> getNext() {
		return next;
	}

	@JsonProperty("next")
	public void setNext(List<Next_> next) {
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
