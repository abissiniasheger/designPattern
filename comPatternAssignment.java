--------------------
[Program.java]
--------------------
public class Program {

	public static void main(String args[]) {
	
	// Make new empty "Study" playlist 
	Playlist studyPlaylist = new Playlist("Study");		

	// Make "Synth Pop" playlist and addToPlayList 2 songs to it.
	Playlist synthPopPlaylist = new Playlist("Synth Pop");
	Song synthPopSong1 = new Song("Girl Like You", "Toro Y Moi" );
	Song synthPopSong2 = new Song("Outside", "TOPS");
	synthPopPlaylist.addToPlayList(synthPopSong1);
	synthPopPlaylist.addToPlayList(synthPopSong2);

	// Make "Experimental" playlist and add 3 songs to it, 
	// then set playback speed of the playlist to 0.5x
	Playlist experimentalPlaylist = new Playlist("Experimental");		
	Song experimentalSong1 = new Song("About you", "XXYYXX");
	Song experimentalSong2 = new Song("Motivation", "Clams Casino");	
	Song experimentalSong3 = new Song("Computer Vision", "Oneohtrix Point Never");
	experimentalPlaylist.addToPlayList(experimentalSong1);
	experimentalPlaylist.addToPlayList(experimentalSong2);
	experimentalPlaylist.addToPlayList(experimentalSong3);
	float slowSpeed = 0.5f;
	experimentalPlaylist.setPlaybackSpeed(slowSpeed);
	
	// Add the "Synth Pop" playlist to the "Experimental" playlist
	experimentalPlaylist.addToPlayList(synthPopPlaylist);

	// Add the "Experimental" playlist to the "Study" playlist
	studyPlaylist.addToPlayList(experimentalPlaylist);

	// Create a new song and set its playback speed to 1.25x, play this song, 
	// get the name of glitchSong → "Textuell", then get the artist of this song → "Oval"
	Song glitchSong = new Song("Textuell", "Oval");
	float fasterSpeed = 1.25f;
	glitchSong.setPlaybackSpeed(fasterSpeed);
	glitchSong.play(); 
	String name = glitchSong.getName(); 
	String artist = glitchSong.getArtist(); 
	System.out.println ("The song name is " + name );
	System.out.println ("The song artist is " + artist );

	// add glitchSong to the "Study" playlist
	studyPlaylist.addToPlayList(glitchSong);

	// Play "Study" playlist.
	studyPlaylist.play(); 

	// Get the playlist name of studyPlaylist → "Study"
	System.out.println ("The Playlist's name is " + studyPlaylist.getName() );
	}
}

--------------------
[IComponent.java]
--------------------
public interface IComponent {

// Your code goes here!
	public void play();
	public void setPlaybackSpeed(float speed);
	public String getName();
	public String getArtist();
}

--------------------
[Playlist.java]
--------------------
public class Playlist implements IComponent {

	public String playlistName;
	public ArrayList<IComponent> playlist = new ArrayList();

	public Playlist(String playlistName) {
		this.playlistName = playlistName;
	}

	@override
	public void play()
	{
		for (IComponent song:playlist)
		{
			song.play();
		}
	}
	
	@override
	public void setPlaybackSpeed(float speed)
	{
		for (IComponent song:playlist)
		{
			song.setPlaybackSpeed(speed);
		}
	}
	
	@override
	public String getName()
	{
		for (IComponent song:playlist)
		{
			song.getName();
		}
	}
	
	public addToPlayList(IComponent song)
	{
		playlist.add(song);
	}
	
	public removeFromPlayList(IComponent song)
	{
		playlist.remove(song);
	}

}

--------------------
[Song.java]
--------------------
public class Song implements IComponent {
	public String songName;
	public String artist;
	public float speed = 1; // Default playback speed

	public Song(String songName, String artist) {
		this.songName = songName;
		this.artist = artist; 
	}

	@override
	public void play()
	{
		System.out.println("Playing a song");
	}
	
	@override
	public void setPlaybackSpeed(float speed)
	{
		this.speed = speed;
	}
	
	@override
	public void getName()
	{
		return songName;
	}
	
	@override
	public void getArtist()
	{
		return artist;
	}
}
