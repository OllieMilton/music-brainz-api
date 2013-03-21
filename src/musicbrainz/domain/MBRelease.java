package musicbrainz.domain;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class MBRelease {

	@XStreamAsAttribute
	private String id;
	@XStreamAsAttribute
	private String type;
	@XStreamAlias (value="ext:score")
	@XStreamAsAttribute
	private String extScore;
	@XStreamAlias (value="track-list")
	private List<MBTrack> trackList = new ArrayList<MBTrack>();
	private String title;
	@XStreamAlias (value="text-representation")
	private TextRepresentation textRepresentation;
	private String asin;
	private MBArtist artist;
	@XStreamAlias (value="release-event-list")
	private List<MBEvent> releaseEvents = new ArrayList<MBEvent>();
	@XStreamAlias (value="disc-list")
	private DiscList discList;
	
	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getExtScore() {
		return extScore;
	}

	public List<MBTrack> getTrackList() {
		return trackList;
	}
	
	public String getTitle() {
		return title;
	}
	
	public MBArtist getArtist() {
		return artist;
	}

	public List<MBEvent> getReleaseEvents() {
		return releaseEvents;
	}
	
	public DiscList getDiscList() {
		return discList;
	}
	
	public String getAsin() {
		return asin;
	}
	
	public TextRepresentation getTextRepresentation() {
		return textRepresentation;
	}

}
