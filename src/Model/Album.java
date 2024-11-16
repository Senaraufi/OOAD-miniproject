package Model;

import Enums.Genre;
import Interfaces.Purchasable;

public class Album implements Purchasable {
    private String title;
    private String artist;
    private Genre genre;
    private boolean isPurchased;

    public Album(String title, String artist, Genre genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.isPurchased = false;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public void purchaseItem() {
        this.isPurchased = true;
    }

    @Override
    public void returnItem() {
        this.isPurchased = false;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre=" + genre +
                ", isPurchased=" + isPurchased +
                '}';
    }
}
