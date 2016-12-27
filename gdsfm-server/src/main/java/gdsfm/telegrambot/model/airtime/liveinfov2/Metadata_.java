
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
@JsonPropertyOrder({ "id", "name", "mime", "ftype", "directory", "filepath", "import_status", "currentlyaccessing",
		"editedby", "mtime", "utime", "lptime", "md5", "track_title", "artist_name", "bit_rate", "sample_rate",
		"format", "length", "album_title", "genre", "comments", "year", "track_number", "channels", "url", "bpm",
		"rating", "encoded_by", "disc_number", "mood", "label", "composer", "encoder", "checksum", "lyrics",
		"orchestra", "conductor", "lyricist", "original_lyricist", "radio_station_name", "info_url", "artist_url",
		"audio_source_url", "radio_station_url", "buy_this_url", "isrc_number", "catalog_number", "original_artist",
		"copyright", "report_datetime", "report_location", "report_organization", "subject", "contributor", "language",
		"soundcloud_id", "soundcloud_error_code", "soundcloud_error_msg", "soundcloud_link_to_file",
		"soundcloud_upload_time", "replay_gain", "owner_id", "cuein", "cueout", "hidden", "filesize", "description",
		"cloud_file_id" })
public class Metadata_ {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("mime")
	private String mime;
	@JsonProperty("ftype")
	private String ftype;
	@JsonProperty("directory")
	private Object directory;
	@JsonProperty("filepath")
	private String filepath;
	@JsonProperty("import_status")
	private Integer importStatus;
	@JsonProperty("currentlyaccessing")
	private Integer currentlyaccessing;
	@JsonProperty("editedby")
	private Object editedby;
	@JsonProperty("mtime")
	private String mtime;
	@JsonProperty("utime")
	private String utime;
	@JsonProperty("lptime")
	private String lptime;
	@JsonProperty("md5")
	private String md5;
	@JsonProperty("track_title")
	private String trackTitle;
	@JsonProperty("artist_name")
	private String artistName;
	@JsonProperty("bit_rate")
	private Integer bitRate;
	@JsonProperty("sample_rate")
	private Integer sampleRate;
	@JsonProperty("format")
	private Object format;
	@JsonProperty("length")
	private String length;
	@JsonProperty("album_title")
	private String albumTitle;
	@JsonProperty("genre")
	private String genre;
	@JsonProperty("comments")
	private String comments;
	@JsonProperty("year")
	private String year;
	@JsonProperty("track_number")
	private Integer trackNumber;
	@JsonProperty("channels")
	private Integer channels;
	@JsonProperty("url")
	private Object url;
	@JsonProperty("bpm")
	private Object bpm;
	@JsonProperty("rating")
	private Object rating;
	@JsonProperty("encoded_by")
	private Object encodedBy;
	@JsonProperty("disc_number")
	private Object discNumber;
	@JsonProperty("mood")
	private String mood;
	@JsonProperty("label")
	private Object label;
	@JsonProperty("composer")
	private String composer;
	@JsonProperty("encoder")
	private Object encoder;
	@JsonProperty("checksum")
	private Object checksum;
	@JsonProperty("lyrics")
	private Object lyrics;
	@JsonProperty("orchestra")
	private Object orchestra;
	@JsonProperty("conductor")
	private Object conductor;
	@JsonProperty("lyricist")
	private Object lyricist;
	@JsonProperty("original_lyricist")
	private Object originalLyricist;
	@JsonProperty("radio_station_name")
	private Object radioStationName;
	@JsonProperty("info_url")
	private Object infoUrl;
	@JsonProperty("artist_url")
	private Object artistUrl;
	@JsonProperty("audio_source_url")
	private Object audioSourceUrl;
	@JsonProperty("radio_station_url")
	private Object radioStationUrl;
	@JsonProperty("buy_this_url")
	private Object buyThisUrl;
	@JsonProperty("isrc_number")
	private Object isrcNumber;
	@JsonProperty("catalog_number")
	private Object catalogNumber;
	@JsonProperty("original_artist")
	private Object originalArtist;
	@JsonProperty("copyright")
	private String copyright;
	@JsonProperty("report_datetime")
	private Object reportDatetime;
	@JsonProperty("report_location")
	private Object reportLocation;
	@JsonProperty("report_organization")
	private Object reportOrganization;
	@JsonProperty("subject")
	private Object subject;
	@JsonProperty("contributor")
	private Object contributor;
	@JsonProperty("language")
	private Object language;
	@JsonProperty("soundcloud_id")
	private Object soundcloudId;
	@JsonProperty("soundcloud_error_code")
	private Object soundcloudErrorCode;
	@JsonProperty("soundcloud_error_msg")
	private Object soundcloudErrorMsg;
	@JsonProperty("soundcloud_link_to_file")
	private Object soundcloudLinkToFile;
	@JsonProperty("soundcloud_upload_time")
	private Object soundcloudUploadTime;
	@JsonProperty("replay_gain")
	private String replayGain;
	@JsonProperty("owner_id")
	private Integer ownerId;
	@JsonProperty("cuein")
	private String cuein;
	@JsonProperty("cueout")
	private String cueout;
	@JsonProperty("hidden")
	private Boolean hidden;
	@JsonProperty("filesize")
	private Integer filesize;
	@JsonProperty("description")
	private Object description;
	@JsonProperty("cloud_file_id")
	private Integer cloudFileId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("mime")
	public String getMime() {
		return mime;
	}

	@JsonProperty("mime")
	public void setMime(String mime) {
		this.mime = mime;
	}

	@JsonProperty("ftype")
	public String getFtype() {
		return ftype;
	}

	@JsonProperty("ftype")
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	@JsonProperty("directory")
	public Object getDirectory() {
		return directory;
	}

	@JsonProperty("directory")
	public void setDirectory(Object directory) {
		this.directory = directory;
	}

	@JsonProperty("filepath")
	public String getFilepath() {
		return filepath;
	}

	@JsonProperty("filepath")
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	@JsonProperty("import_status")
	public Integer getImportStatus() {
		return importStatus;
	}

	@JsonProperty("import_status")
	public void setImportStatus(Integer importStatus) {
		this.importStatus = importStatus;
	}

	@JsonProperty("currentlyaccessing")
	public Integer getCurrentlyaccessing() {
		return currentlyaccessing;
	}

	@JsonProperty("currentlyaccessing")
	public void setCurrentlyaccessing(Integer currentlyaccessing) {
		this.currentlyaccessing = currentlyaccessing;
	}

	@JsonProperty("editedby")
	public Object getEditedby() {
		return editedby;
	}

	@JsonProperty("editedby")
	public void setEditedby(Object editedby) {
		this.editedby = editedby;
	}

	@JsonProperty("mtime")
	public String getMtime() {
		return mtime;
	}

	@JsonProperty("mtime")
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	@JsonProperty("utime")
	public String getUtime() {
		return utime;
	}

	@JsonProperty("utime")
	public void setUtime(String utime) {
		this.utime = utime;
	}

	@JsonProperty("lptime")
	public String getLptime() {
		return lptime;
	}

	@JsonProperty("lptime")
	public void setLptime(String lptime) {
		this.lptime = lptime;
	}

	@JsonProperty("md5")
	public String getMd5() {
		return md5;
	}

	@JsonProperty("md5")
	public void setMd5(String md5) {
		this.md5 = md5;
	}

	@JsonProperty("track_title")
	public String getTrackTitle() {
		return trackTitle;
	}

	@JsonProperty("track_title")
	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}

	@JsonProperty("artist_name")
	public String getArtistName() {
		return artistName;
	}

	@JsonProperty("artist_name")
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	@JsonProperty("bit_rate")
	public Integer getBitRate() {
		return bitRate;
	}

	@JsonProperty("bit_rate")
	public void setBitRate(Integer bitRate) {
		this.bitRate = bitRate;
	}

	@JsonProperty("sample_rate")
	public Integer getSampleRate() {
		return sampleRate;
	}

	@JsonProperty("sample_rate")
	public void setSampleRate(Integer sampleRate) {
		this.sampleRate = sampleRate;
	}

	@JsonProperty("format")
	public Object getFormat() {
		return format;
	}

	@JsonProperty("format")
	public void setFormat(Object format) {
		this.format = format;
	}

	@JsonProperty("length")
	public String getLength() {
		return length;
	}

	@JsonProperty("length")
	public void setLength(String length) {
		this.length = length;
	}

	@JsonProperty("album_title")
	public String getAlbumTitle() {
		return albumTitle;
	}

	@JsonProperty("album_title")
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	@JsonProperty("genre")
	public String getGenre() {
		return genre;
	}

	@JsonProperty("genre")
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@JsonProperty("comments")
	public String getComments() {
		return comments;
	}

	@JsonProperty("comments")
	public void setComments(String comments) {
		this.comments = comments;
	}

	@JsonProperty("year")
	public String getYear() {
		return year;
	}

	@JsonProperty("year")
	public void setYear(String year) {
		this.year = year;
	}

	@JsonProperty("track_number")
	public Integer getTrackNumber() {
		return trackNumber;
	}

	@JsonProperty("track_number")
	public void setTrackNumber(Integer trackNumber) {
		this.trackNumber = trackNumber;
	}

	@JsonProperty("channels")
	public Integer getChannels() {
		return channels;
	}

	@JsonProperty("channels")
	public void setChannels(Integer channels) {
		this.channels = channels;
	}

	@JsonProperty("url")
	public Object getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(Object url) {
		this.url = url;
	}

	@JsonProperty("bpm")
	public Object getBpm() {
		return bpm;
	}

	@JsonProperty("bpm")
	public void setBpm(Object bpm) {
		this.bpm = bpm;
	}

	@JsonProperty("rating")
	public Object getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(Object rating) {
		this.rating = rating;
	}

	@JsonProperty("encoded_by")
	public Object getEncodedBy() {
		return encodedBy;
	}

	@JsonProperty("encoded_by")
	public void setEncodedBy(Object encodedBy) {
		this.encodedBy = encodedBy;
	}

	@JsonProperty("disc_number")
	public Object getDiscNumber() {
		return discNumber;
	}

	@JsonProperty("disc_number")
	public void setDiscNumber(Object discNumber) {
		this.discNumber = discNumber;
	}

	@JsonProperty("mood")
	public String getMood() {
		return mood;
	}

	@JsonProperty("mood")
	public void setMood(String mood) {
		this.mood = mood;
	}

	@JsonProperty("label")
	public Object getLabel() {
		return label;
	}

	@JsonProperty("label")
	public void setLabel(Object label) {
		this.label = label;
	}

	@JsonProperty("composer")
	public String getComposer() {
		return composer;
	}

	@JsonProperty("composer")
	public void setComposer(String composer) {
		this.composer = composer;
	}

	@JsonProperty("encoder")
	public Object getEncoder() {
		return encoder;
	}

	@JsonProperty("encoder")
	public void setEncoder(Object encoder) {
		this.encoder = encoder;
	}

	@JsonProperty("checksum")
	public Object getChecksum() {
		return checksum;
	}

	@JsonProperty("checksum")
	public void setChecksum(Object checksum) {
		this.checksum = checksum;
	}

	@JsonProperty("lyrics")
	public Object getLyrics() {
		return lyrics;
	}

	@JsonProperty("lyrics")
	public void setLyrics(Object lyrics) {
		this.lyrics = lyrics;
	}

	@JsonProperty("orchestra")
	public Object getOrchestra() {
		return orchestra;
	}

	@JsonProperty("orchestra")
	public void setOrchestra(Object orchestra) {
		this.orchestra = orchestra;
	}

	@JsonProperty("conductor")
	public Object getConductor() {
		return conductor;
	}

	@JsonProperty("conductor")
	public void setConductor(Object conductor) {
		this.conductor = conductor;
	}

	@JsonProperty("lyricist")
	public Object getLyricist() {
		return lyricist;
	}

	@JsonProperty("lyricist")
	public void setLyricist(Object lyricist) {
		this.lyricist = lyricist;
	}

	@JsonProperty("original_lyricist")
	public Object getOriginalLyricist() {
		return originalLyricist;
	}

	@JsonProperty("original_lyricist")
	public void setOriginalLyricist(Object originalLyricist) {
		this.originalLyricist = originalLyricist;
	}

	@JsonProperty("radio_station_name")
	public Object getRadioStationName() {
		return radioStationName;
	}

	@JsonProperty("radio_station_name")
	public void setRadioStationName(Object radioStationName) {
		this.radioStationName = radioStationName;
	}

	@JsonProperty("info_url")
	public Object getInfoUrl() {
		return infoUrl;
	}

	@JsonProperty("info_url")
	public void setInfoUrl(Object infoUrl) {
		this.infoUrl = infoUrl;
	}

	@JsonProperty("artist_url")
	public Object getArtistUrl() {
		return artistUrl;
	}

	@JsonProperty("artist_url")
	public void setArtistUrl(Object artistUrl) {
		this.artistUrl = artistUrl;
	}

	@JsonProperty("audio_source_url")
	public Object getAudioSourceUrl() {
		return audioSourceUrl;
	}

	@JsonProperty("audio_source_url")
	public void setAudioSourceUrl(Object audioSourceUrl) {
		this.audioSourceUrl = audioSourceUrl;
	}

	@JsonProperty("radio_station_url")
	public Object getRadioStationUrl() {
		return radioStationUrl;
	}

	@JsonProperty("radio_station_url")
	public void setRadioStationUrl(Object radioStationUrl) {
		this.radioStationUrl = radioStationUrl;
	}

	@JsonProperty("buy_this_url")
	public Object getBuyThisUrl() {
		return buyThisUrl;
	}

	@JsonProperty("buy_this_url")
	public void setBuyThisUrl(Object buyThisUrl) {
		this.buyThisUrl = buyThisUrl;
	}

	@JsonProperty("isrc_number")
	public Object getIsrcNumber() {
		return isrcNumber;
	}

	@JsonProperty("isrc_number")
	public void setIsrcNumber(Object isrcNumber) {
		this.isrcNumber = isrcNumber;
	}

	@JsonProperty("catalog_number")
	public Object getCatalogNumber() {
		return catalogNumber;
	}

	@JsonProperty("catalog_number")
	public void setCatalogNumber(Object catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	@JsonProperty("original_artist")
	public Object getOriginalArtist() {
		return originalArtist;
	}

	@JsonProperty("original_artist")
	public void setOriginalArtist(Object originalArtist) {
		this.originalArtist = originalArtist;
	}

	@JsonProperty("copyright")
	public String getCopyright() {
		return copyright;
	}

	@JsonProperty("copyright")
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	@JsonProperty("report_datetime")
	public Object getReportDatetime() {
		return reportDatetime;
	}

	@JsonProperty("report_datetime")
	public void setReportDatetime(Object reportDatetime) {
		this.reportDatetime = reportDatetime;
	}

	@JsonProperty("report_location")
	public Object getReportLocation() {
		return reportLocation;
	}

	@JsonProperty("report_location")
	public void setReportLocation(Object reportLocation) {
		this.reportLocation = reportLocation;
	}

	@JsonProperty("report_organization")
	public Object getReportOrganization() {
		return reportOrganization;
	}

	@JsonProperty("report_organization")
	public void setReportOrganization(Object reportOrganization) {
		this.reportOrganization = reportOrganization;
	}

	@JsonProperty("subject")
	public Object getSubject() {
		return subject;
	}

	@JsonProperty("subject")
	public void setSubject(Object subject) {
		this.subject = subject;
	}

	@JsonProperty("contributor")
	public Object getContributor() {
		return contributor;
	}

	@JsonProperty("contributor")
	public void setContributor(Object contributor) {
		this.contributor = contributor;
	}

	@JsonProperty("language")
	public Object getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(Object language) {
		this.language = language;
	}

	@JsonProperty("soundcloud_id")
	public Object getSoundcloudId() {
		return soundcloudId;
	}

	@JsonProperty("soundcloud_id")
	public void setSoundcloudId(Object soundcloudId) {
		this.soundcloudId = soundcloudId;
	}

	@JsonProperty("soundcloud_error_code")
	public Object getSoundcloudErrorCode() {
		return soundcloudErrorCode;
	}

	@JsonProperty("soundcloud_error_code")
	public void setSoundcloudErrorCode(Object soundcloudErrorCode) {
		this.soundcloudErrorCode = soundcloudErrorCode;
	}

	@JsonProperty("soundcloud_error_msg")
	public Object getSoundcloudErrorMsg() {
		return soundcloudErrorMsg;
	}

	@JsonProperty("soundcloud_error_msg")
	public void setSoundcloudErrorMsg(Object soundcloudErrorMsg) {
		this.soundcloudErrorMsg = soundcloudErrorMsg;
	}

	@JsonProperty("soundcloud_link_to_file")
	public Object getSoundcloudLinkToFile() {
		return soundcloudLinkToFile;
	}

	@JsonProperty("soundcloud_link_to_file")
	public void setSoundcloudLinkToFile(Object soundcloudLinkToFile) {
		this.soundcloudLinkToFile = soundcloudLinkToFile;
	}

	@JsonProperty("soundcloud_upload_time")
	public Object getSoundcloudUploadTime() {
		return soundcloudUploadTime;
	}

	@JsonProperty("soundcloud_upload_time")
	public void setSoundcloudUploadTime(Object soundcloudUploadTime) {
		this.soundcloudUploadTime = soundcloudUploadTime;
	}

	@JsonProperty("replay_gain")
	public String getReplayGain() {
		return replayGain;
	}

	@JsonProperty("replay_gain")
	public void setReplayGain(String replayGain) {
		this.replayGain = replayGain;
	}

	@JsonProperty("owner_id")
	public Integer getOwnerId() {
		return ownerId;
	}

	@JsonProperty("owner_id")
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	@JsonProperty("cuein")
	public String getCuein() {
		return cuein;
	}

	@JsonProperty("cuein")
	public void setCuein(String cuein) {
		this.cuein = cuein;
	}

	@JsonProperty("cueout")
	public String getCueout() {
		return cueout;
	}

	@JsonProperty("cueout")
	public void setCueout(String cueout) {
		this.cueout = cueout;
	}

	@JsonProperty("hidden")
	public Boolean getHidden() {
		return hidden;
	}

	@JsonProperty("hidden")
	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	@JsonProperty("filesize")
	public Integer getFilesize() {
		return filesize;
	}

	@JsonProperty("filesize")
	public void setFilesize(Integer filesize) {
		this.filesize = filesize;
	}

	@JsonProperty("description")
	public Object getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(Object description) {
		this.description = description;
	}

	@JsonProperty("cloud_file_id")
	public Integer getCloudFileId() {
		return cloudFileId;
	}

	@JsonProperty("cloud_file_id")
	public void setCloudFileId(Integer cloudFileId) {
		this.cloudFileId = cloudFileId;
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
