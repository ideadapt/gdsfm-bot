
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
@JsonPropertyOrder({ "name", "description", "genre", "id", "instance_id", "record", "url", "image_path",
		"image_cloud_file_id", "starts", "ends" })
public class Next_ {

	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("genre")
	private String genre;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("instance_id")
	private Integer instanceId;
	@JsonProperty("record")
	private Integer record;
	@JsonProperty("url")
	private String url;
	@JsonProperty("image_path")
	private String imagePath;
	@JsonProperty("image_cloud_file_id")
	private Object imageCloudFileId;
	@JsonProperty("starts")
	private String starts;
	@JsonProperty("ends")
	private String ends;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("genre")
	public String getGenre() {
		return genre;
	}

	@JsonProperty("genre")
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("instance_id")
	public Integer getInstanceId() {
		return instanceId;
	}

	@JsonProperty("instance_id")
	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}

	@JsonProperty("record")
	public Integer getRecord() {
		return record;
	}

	@JsonProperty("record")
	public void setRecord(Integer record) {
		this.record = record;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("image_path")
	public String getImagePath() {
		return imagePath;
	}

	@JsonProperty("image_path")
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@JsonProperty("image_cloud_file_id")
	public Object getImageCloudFileId() {
		return imageCloudFileId;
	}

	@JsonProperty("image_cloud_file_id")
	public void setImageCloudFileId(Object imageCloudFileId) {
		this.imageCloudFileId = imageCloudFileId;
	}

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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
