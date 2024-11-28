/**
 * Represents a CD product in the music shop.
 * Extends Product class with CD-specific functionality.
 * 
 * Key features:
 * - CD-specific properties (artist, genre, number of tracks, duration)
 * - CD-specific formatting in toString method
 * 
 * Design Pattern: Template Method
 * - Extends Product base class
 * - Overrides toString behavior
 * 
 * @see Product
 * @see Purchasable
 */
package Model;

import Enums.Genre;

/**
 * Represents a CD product in the music shop.
 * Extends Product class with CD-specific functionality.
 * 
 * Key features:
 * - CD-specific properties (artist, genre, number of tracks, duration)
 * - CD-specific formatting in toString method
 * 
 * Design Pattern: Template Method
 * - Extends Product base class
 * - Overrides toString behavior
 * 
 * @see Product
 * @see Purchasable
 */
public class CD extends Product {
    private String artist;
    private Genre genre;
    private int numberOfTracks;
    private String duration;     // Total playing time (e.g., "74:32")

    /**
     * Constructs a new CD with the specified details.
     * 
     * @param title CD title
     * @param artist Artist name
     * @param genre Music genre
     * @param price CD price
     * @param imageFileName Image file name for the CD
     * @param numberOfTracks Number of tracks on the CD
     * @param duration Total playing time of the CD
     */
    public CD(String title, String artist, Genre genre, double price, String imageFileName, int numberOfTracks, String duration) {
        super(title, price, imageFileName);
        this.artist = artist;
        this.genre = genre;
        this.numberOfTracks = numberOfTracks;
        this.duration = duration;
    }

    /**
     * Returns the title of the CD.
     * 
     * @return CD title
     */
    public String getTitle() {
        return getName();
    }

    /**
     * Returns the artist of the CD.
     * 
     * @return Artist name
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the genre of the CD.
     * 
     * @return Music genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Returns the number of tracks on the CD.
     * 
     * @return Number of tracks
     */
    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    /**
     * Returns the total playing time of the CD.
     * 
     * @return Total playing time (e.g., "74:32")
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Returns a string representation of the CD.
     * Includes CD-specific details (artist, genre, number of tracks, duration).
     * 
     * @return Formatted string with CD details
     */
    @Override
    public String toString() {
        return getTitle() + " - " + artist + " (" + genre + ") " + numberOfTracks + " tracks, " + duration + " ($" + getPrice() + ")";
    }

    /**
     * Processes the purchase of a CD.
     * Handles inventory updates and transaction recording.
     */
    @Override
    public void purchaseItem() {
        // Implementation for purchasing the CD
    }

    /**
     * Processes the return of a CD.
     * Handles inventory restoration and refund calculation.
     */
    @Override
    public void returnItem() {
        // Implementation for returning the CD
    }
}
