package musicbrainz.domain;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class TextRepresentation {
	@XStreamAsAttribute
	private String language;
	@XStreamAsAttribute
	private String script;
	
	public String getLanguage() {
		return language;
	}
	public String getScript() {
		return script;
	}
}
