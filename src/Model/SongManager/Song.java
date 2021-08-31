package Model.SongManager;

public class Song {
    private String name;
    private String artist;
    private double duration;

    public Song(String name, String artist, double duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    } // constructor end

    public String getName() { return this.name; }
    public String getArtist() { return this.artist; }
    public double getDuration() { return this.duration; }

    public String toString() {
        return this.name + " by " + this.artist + " -- " + this.duration;
    }
}
