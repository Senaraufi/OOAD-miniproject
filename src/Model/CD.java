package Model;

import Enums.Genre;

public class CD extends Product {
    private String artist;
    private Genre genre;
    private int numberOfTracks;
    private String duration;     // Total playing time (e.g., "74:32")

    public CD(String title, String artist, Genre genre, double price, String imageFileName, int numberOfTracks, String duration) {
        super(title, price, imageFileName);
        this.artist = artist;
        this.genre = genre;
        this.numberOfTracks = numberOfTracks;
        this.duration = duration;
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

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return getTitle() + " - " + artist + " (" + genre + ") " + numberOfTracks + " tracks, " + duration + " ($" + getPrice() + ")";
    }

    @Override
    public void purchaseItem() {
        // Implementation for purchasing the CD
    }

    @Override
    public void returnItem() {
        // Implementation for returning the CD
    }
}
