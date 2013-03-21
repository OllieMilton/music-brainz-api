package musicbrainz.domain;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class LifeSpan {
	@XStreamAsAttribute
	private String begin;
	public String getBegin() {
		return begin;
	}
}
