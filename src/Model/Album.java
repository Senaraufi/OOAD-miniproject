package Model;

import Enums.Genre;

public class Album extends Product {
    private String artist;
    private Genre genre;

    public Album(String title, String artist, Genre genre, double price, String imageFileName) {
        super(title, price, imageFileName);
        this.artist = artist;
        this.genre = genre;
    }

    public String getTitle() {
        return getName();
    }

    public String getArtist() {
        return artist;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return getTitle() + " - " + artist + " (" + genre + ") ($" + getPrice() + ")";
    }

    @Override
    public void purchaseItem() {
        // Implementation for purchasing the item
    }

    @Override
    public void returnItem() {
        // Implementation for returning the item
    }
}
