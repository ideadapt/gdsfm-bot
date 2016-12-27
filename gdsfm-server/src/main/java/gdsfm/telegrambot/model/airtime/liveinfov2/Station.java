
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
@JsonPropertyOrder({ "env", "schedulerTime", "source_enabled", "timezone", "AIRTIME_API_VERSION" })
public class Station {

	@JsonProperty("env")
	private String env;
	@JsonProperty("schedulerTime")
	private String schedulerTime;
	@JsonProperty("source_enabled")
	private String sourceEnabled;
	@JsonProperty("timezone")
	private String timezone;
	@JsonProperty("AIRTIME_API_VERSION")
	private String aIRTIMEAPIVERSION;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("env")
	public String getEnv() {
		return env;
	}

	@JsonProperty("env")
	public void setEnv(String env) {
		this.env = env;
	}

	@JsonProperty("schedulerTime")
	public String getSchedulerTime() {
		return schedulerTime;
	}

	@JsonProperty("schedulerTime")
	public void setSchedulerTime(String schedulerTime) {
		this.schedulerTime = schedulerTime;
	}

	@JsonProperty("source_enabled")
	public String getSourceEnabled() {
		return sourceEnabled;
	}

	@JsonProperty("source_enabled")
	public void setSourceEnabled(String sourceEnabled) {
		this.sourceEnabled = sourceEnabled;
	}

	@JsonProperty("timezone")
	public String getTimezone() {
		return timezone;
	}

	@JsonProperty("timezone")
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@JsonProperty("AIRTIME_API_VERSION")
	public String getAIRTIMEAPIVERSION() {
		return aIRTIMEAPIVERSION;
	}

	@JsonProperty("AIRTIME_API_VERSION")
	public void setAIRTIMEAPIVERSION(String aIRTIMEAPIVERSION) {
		this.aIRTIMEAPIVERSION = aIRTIMEAPIVERSION;
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
