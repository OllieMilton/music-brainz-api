package musicbrainz.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import musicbrainz.domain.MBArtist;
import musicbrainz.domain.MBEvent;
import musicbrainz.domain.MBLabel;
import musicbrainz.domain.MBMetadata;
import musicbrainz.domain.MBRelease;
import musicbrainz.domain.MBTrack;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MusicBrainz {

	private static XStream xstream;
	
	static {
		Map<String, Class<?>> types = new HashMap<String, Class<?>>();
		types.put("metadata", MBMetadata.class);
		types.put("release", MBRelease.class);
		types.put("track", MBTrack.class);
		types.put("artist", MBArtist.class);
		types.put("event", MBEvent.class);
		types.put("label", MBLabel.class);
		xstream = new XStream(new DomDriver());
		for (Entry<String, Class<?>> ent : types.entrySet()) {
			xstream.alias(ent.getKey(), ent.getValue());
			xstream.processAnnotations(ent.getValue());
		}
	}
	
	/**
	 * Gets metadata for a specific release using the given url.
	 * @param musicBrainzUrl the musicbrainz url.
	 * @return The resultant {@code MBMetadata}.
	 */
	public static MBMetadata getAlbumMetadata(String musicBrainzUrl) {
		URL url = getURL(musicBrainzUrl);
		URLConnection con;
		Object o;
		try {
			con = url.openConnection();
			o = xstream.fromXML(con.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
		return (MBMetadata)o;
	}
	
	
	/**
	 * Searches releases using the given search criteria.
	 * @param artist the artist name. 
	 * @param albumName the album name.
	 * @return The resultant {@code MBMetadata}.
	 */
	public static MBMetadata searchAlbumMetadata(String artist, String albumName) {
		String sUrl = "http://musicbrainz.org/ws/1/release/?type=xml&title="+albumName+"&artist="+artist;
		URL url = getURL(sUrl);
		URLConnection con;
		MBMetadata result = null;
		try {
			con = url.openConnection();
			MBMetadata releases = (MBMetadata)xstream.fromXML(con.getInputStream());
			if (!releases.getReleaseList().isEmpty()) {
				MBRelease release = releases.getReleaseList().get(0);
				sUrl = "http://musicbrainz.org/ws/1/release/"+release.getId()+"?type=xml&inc=tracks+artist";
				url = getURL(sUrl);
				con = url.openConnection();
				result = (MBMetadata)xstream.fromXML(con.getInputStream());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
		return result;
	}
	
	public static void main(String[] args) {
		MBMetadata data = getAlbumMetadata("http://mm.musicbrainz.org/ws/1/release?type=xml&discid=pbEMghtm0TEFxJq3ZS345qjIiBk-&toc=1+10+167050+150+15345+27050+44940+61170+79155+101660+115450+131945+148855");
		data.getReleaseList();
	}
	
	private static URL getURL(String musicBrainzUrl) {
		try {
			URL url = new URL(musicBrainzUrl);
			return url;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
}
