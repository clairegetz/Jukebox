package Tests;

import Model.SongManager.Song;
import Model.SongManager.SongLibrary;
import org.junit.Test;

public class SongLibraryTest {
    @Test
    public void addingSongs() {
        SongLibrary l = new SongLibrary();
        assert(l.getSongCount()==0);
        l.addSong(new Song("1", "artist1", 23));
        l.addSong(new Song("2", "artist2", 14));
        l.addSong(new Song("3", "artist3", 13));
        l.addSong(new Song("4", "artist4", 1));
        assert(l.getSongCount()==4);
        System.out.println(l);
    }

    @Test
    public void sortByName() {
        SongLibrary l = new SongLibrary();
        assert(l.getSongCount()==0);
        l.addSong(new Song("2", "artist2", 14));
        l.addSong(new Song("3", "artist3", 13));
        l.addSong(new Song("1", "artist1", 23));
        l.addSong(new Song("4", "artist4", 1));
        assert(l.getSongCount()==4);

        String property = "name";
        isInOrder(l, property);
        System.out.println(l);
    }

    @Test
    public void sortByArtist() {
        SongLibrary l = new SongLibrary();
        assert(l.getSongCount()==0);
        l.addSong(new Song("2", "artist2", 14));
        l.addSong(new Song("1", "artist1", 23));
        l.addSong(new Song("4", "artist4", 1));
        l.addSong(new Song("3", "artist3", 13));
        assert(l.getSongCount()==4);

        String property = "artist";
        isInOrder(l, property);
        System.out.println(l);
    }

    @Test
    public void sortByDuration() {
        SongLibrary l = new SongLibrary();
        assert(l.getSongCount()==0);
        l.addSong(new Song("1", "artist1", 23));
        l.addSong(new Song("2", "artist2", 14));
        l.addSong(new Song("3", "artist3", 13));
        l.addSong(new Song("4", "artist4", 1));
        assert(l.getSongCount()==4);

        String property = "duration";
        isInOrder(l, property);
        System.out.println(l);
    }

    private void isInOrder(SongLibrary l, String property) {
        l.sort(property);

        Song[] songs = l.getLibrary();
        for (int i = 0; i< l.getSongCount()-1; i++) {
            assert(l.checkProperty(property, songs[i], '<', songs[i+1]));
        }
    }
}
