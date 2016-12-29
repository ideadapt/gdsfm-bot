
package gdsfm.telegrambot.model.airtime.liveinfov2;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import gdsfm.telegrambot.model.airtime.liveinfov2.show.Shows;
import gdsfm.telegrambot.model.airtime.liveinfov2.station.Station;
import gdsfm.telegrambot.model.airtime.liveinfov2.track.Tracks;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "station", "tracks", "shows" })
public class AirtimeLiveInfo {

	@JsonProperty("station")
	private Station station;
	@JsonProperty("tracks")
	private Tracks tracks;
	@JsonProperty("shows")
	private Shows shows;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("station")
	public Station getStation() {
		return station;
	}

	@JsonProperty("station")
	public void setStation(Station station) {
		this.station = station;
	}

	@JsonProperty("tracks")
	public Tracks getTracks() {
		return tracks;
	}

	@JsonProperty("tracks")
	public void setTracks(Tracks tracks) {
		this.tracks = tracks;
	}

	@JsonProperty("shows")
	public Shows getShows() {
		return shows;
	}

	@JsonProperty("shows")
	public void setShows(Shows shows) {
		this.shows = shows;
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
