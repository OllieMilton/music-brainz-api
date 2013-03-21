package musicbrainz.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class MBEvent {

	@XStreamAsAttribute
	private String date;
	@XStreamAsAttribute
	private String country;
	@XStreamAsAttribute
	@XStreamAlias (value="catalog-number")
	private String catalogNumber;
	@XStreamAsAttribute
	private String barcode;
	@XStreamAsAttribute
	private String format;
	private MBLabel label;
	
	public String getDate() {
		return date;
	}

	public String getCountry() {
		return country;
	}

	public String getCatalogNumber() {
		return catalogNumber;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getFormat() {
		return format;
	}

	public MBLabel getLabel() {
		return label;
	}
	
}
