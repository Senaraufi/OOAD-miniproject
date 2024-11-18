package Model;//declaring the package

import Enums.Genre;//importing the genre enum
import Interfaces.Purchasable;//importing the purchasable interface

public class Album implements Purchasable {//defining the album class
    private String title;//declaring the title variable
    private String artist;//declaring the artist variable
    private Genre genre;//declaring the genre variable
    private double price;//declaring the price variable
    private String imageFileName;//declaring the imageFileName variable

    public Album(String title, String artist, Genre genre, double price, String imageFileName) {//defining the constructor
        this.title = title;//initializing the title variable
        this.artist = artist;//initializing the artist variable
        this.genre = genre;//initializing the genre variable
        this.price = price;//initializing the price variable
        this.imageFileName = imageFileName;//initializing the imageFileName variable
    }

    public String getTitle() {//defining the getTitle method
        return title;//returning the title
    }

    public String getImageFileName() {//defining the getImageFileName method
        return imageFileName;//returning the imageFileName
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
        return title + " - " + artist + " ($" + price + ")";
    }

    @Override
    public void purchaseItem() {//defining the purchaseItem method
        // Implementation for purchasing the item
    }

    @Override
    public void returnItem() {//defining the returnItem method
        // Implementation for returning the item
    }
}
