package musicbrainz.domain;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;


public class MBTrack {

	@XStreamAsAttribute
	private String id;
	private String title;
	private int duration;
	private MBArtist artist;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public MBArtist getArtist() {
		return artist;
	}

	public String getId() {
		return id;
	}
	
}
