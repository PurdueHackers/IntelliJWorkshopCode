import java.util.Objects;

public class Song {
    public String title;
    public Artist author;

    public Song(String title, Artist author) {
        this.title = title;
        this.author = author;
    }

    public Artist getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", author=" + author +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(title, song.title) &&
                Objects.equals(author, song.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
