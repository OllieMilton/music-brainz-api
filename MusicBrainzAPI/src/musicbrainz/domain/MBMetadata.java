package musicbrainz.domain;

import java.util.ArrayList;
import java.util.List;


import com.thoughtworks.xstream.annotations.XStreamAlias;

public class MBMetadata {

	@XStreamAlias (value="release-list")
	private List<MBRelease> releaseList = new ArrayList<MBRelease>();
	private MBRelease release;
	
	public List<MBRelease> getReleaseList() {
		return releaseList;
	}

	public MBRelease getRelease() {
		return release;
	}

}
