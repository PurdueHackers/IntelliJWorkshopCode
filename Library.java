import java.util.ArrayList;
import java.io.*;

public class Library {
    ArrayList<Artist> artists;
    ArrayList<Song> songs;

    public Library(String filepath) {
        artists = new ArrayList<Artist>();
        songs = new ArrayList<Song>();

        try (BufferedReader in = new BufferedReader(new FileReader("data.txt"))) {
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                String[] data = in.readLine().split("//");
                data[0] = data[0].strip();
                data[1] = data[1].strip();

                Artist artist = fetchArtist(data[1]);
                if (artist == null) {
                    artist = new Artist(data[1]);
                    artists.add(artist);
                }

                Song song = new Song(data[0], artist);
                songs.add(song);
                artist.addSong(song);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public Artist fetchArtist(String name) {
        for (Artist artist : artists) {
            if (artist.matches(name)) return artist;
        }
        return null;
    }

    public static void main(String[] args) {
        Library lib = new Library("data.txt");
        ArrayList<Artist> artists = lib.getArtists();
        ArrayList<Song> songs = lib.getSongs();
    }
}
