package Model.SongManager;

public class SongLibrary {
    private Song[] library;
    private int songCount;

    public SongLibrary() {
        library = new Song[10];
        songCount = 0;
    }

    public void addSong(Song song) {
        library[songCount] = song;
        songCount++;
    }

    public void sort(String property) {
        QuickSort qs = new QuickSort();
        qs.sort(property);
    }

    public boolean checkProperty(String property, Song song1, char check, Song song2) {
        QuickSort qs = new QuickSort();
        return qs.checkProperty(property, song1, check, song2);
    }

    public int getSongCount() { return songCount; }
    public Song[] getLibrary() { return library; }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i<songCount; i++) {
            ret.append(library[i].toString()).append("\n");
        }
        return ret.toString();
    }

    public class QuickSort {
        private String key;

        // property is the key to sort on
        public void sort(String property) {
            key = property;

            if (library.length == 0 || library.length == 1) {
                return;
            }
            partition(0, getSongCount()-1);
        } // end sort

        private void partition(int low, int high) {
            int i = low;
            int j = high;
            Song pivot = library[low + (high - low)/2];
            while (i <= j) {
                // move i to the right
                while (checkProperty(library[i], '<', pivot)) {
                    i++;
                }
                // move j to the left
                while (checkProperty(library[j], '>', pivot)) {
                    j--;
                }
                // if larger item on left, swap
                if (i <= j) {
                    swap(i, j);
                    i++;
                    j--;
                }
            } // end while check
            if (low < j)
                partition(low, j);
            if (i < high)
                partition(i, high);
        }

        private boolean checkProperty(Song song, char check, Song pivot) {
            if (check == '<') {
                switch (key) {
                    case "name": {
                        int stringComp = song.getName().compareTo(pivot.getName());
                        return stringComp < 0;
                    }
                    case "artist": {
                        int stringComp = song.getArtist().compareTo(pivot.getArtist());
                        return stringComp < 0;
                    }
                    case "duration":
                        return song.getDuration() < pivot.getDuration();
                }
            } else {
                switch (key) {
                    case "name": {
                        int stringComp = song.getName().compareTo(pivot.getName());
                        return stringComp > 0;
                    }
                    case "artist": {
                        int stringComp = song.getArtist().compareTo(pivot.getArtist());
                        return stringComp > 0;
                    }
                    case "duration":
                        return song.getDuration() > pivot.getDuration();
                }
            }
            return false;
        } // checkProperty end

        private boolean checkProperty(String property, Song song1, char check, Song song2) {
            String temp = this.key;
            this.key = property;
            boolean result = checkProperty(song1, check, song2);
            this.key = temp;
            return result;
        }

        private void swap(int i, int j) {
            Song temp = library[i];
            library[i] = library[j];
            library[j] = temp;
        } // swap end
    } // QuickSort end
} // SongLibrary end
