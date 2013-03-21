package musicbrainz.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class MBArtist {

	@XStreamAsAttribute
	private String id;
	@XStreamAsAttribute
	private String type;
	private String name;
	@XStreamAlias (value="sort-name")
	private String sortName;
	@XStreamAlias (value="life-span")
	private LifeSpan lifeSpan;
	private String disambiguation;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public Object getLifeSpan() {
		return lifeSpan;
	}
	public String getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	public String getDisambiguation() {
		return disambiguation;
	}
}
