package Model;//declaring the package

import Enums.Genre;//importing the genre enum
import Interfaces.Purchasable;//importing the purchasable interface

public class Album implements Purchasable {//defining the album class
    private String title;//declaring the title variable
    private String artist;//declaring the artist variable
    private Genre genre;//declaring the genre variable
    private boolean isPurchased;//declaring the isPurchased variable


    public Album(String title, String artist, Genre genre) {//defining the constructor
        this.title = title;//initializing the title variable
        this.artist = artist;//initializing the artist variable
        this.genre = genre;//initializing the genre variable
        this.isPurchased = false;//initializing the isPurchased variable
    }

    public String getTitle() {//defining the getTitle method
        return title;//returning the title
    }

    public void setTitle(String title) {//defining the setTitle method
        this.title = title;//initializing the title variable
    }

    public String getArtist() {//defining the getArtist method
        return artist;//returning the artist
    }

    public void setArtist(String artist) {//defining the setArtist method
        this.artist = artist;//initializing the artist variable
    }

    public Genre getGenre() {//defining the getGenre method
        return genre;//returning the genre
    }

    public void setGenre(Genre genre) {//defining the setGenre method
        this.genre = genre;//initializing the genre variable
    }

    public boolean isPurchased() {//defining the isPurchased method
        return isPurchased;//returning the isPurchased variable
    }

    public void setPurchased(boolean isPurchased) {//defining the setPurchased method
        this.isPurchased = isPurchased;//initializing the isPurchased variable
    }

    @Override
    public void purchaseItem() {//defining the purchaseItem method
        this.isPurchased = true;//initializing the isPurchased variable
    }

    @Override
    public void returnItem() {//defining the returnItem method
        this.isPurchased = false;//initializing the isPurchased variable
    }

    @Override
    public String toString() {
        return "Album{" +//returning the album details
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre=" + genre +
                ", isPurchased=" + isPurchased +
                '}';
    }
}
