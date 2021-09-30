import java.util.ArrayList;
import java.util.Objects;

public class Artist {
    public String name;
    public ArrayList<Song> songs;

    public Artist(String name) {
        this.name = name;
        songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public boolean matches(String name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(name, artist.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
