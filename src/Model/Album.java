package Model;

import Enums.Genre;
import Interfaces.Purchasable;

public class Album implements Purchasable {
    private String title;
    private String artist;
    private Genre genre;
    private double price;
    private String imageFileName;

    public Album(String title, String artist, Genre genre, double price, String imageFileName) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.price = price;
        this.imageFileName = imageFileName;
    }

    public String getTitle() {
        return title;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public double getPrice() {
        return price;
    }

    public String getArtist() {
        return artist;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + genre + ") ($" + price + ")";
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
