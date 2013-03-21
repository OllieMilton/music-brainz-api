package musicbrainz.domain;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class DiscList {
	@XStreamAsAttribute
	private int count;

	public int getCount() {
		return count;
	}
	
}
