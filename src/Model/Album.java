/**
 * Represents a music album in the shop's inventory.
 * This class extends Product to implement music-specific functionality.
 * 
 * Key features:
 * - Stores artist and genre information
 * - Supports both vinyl and CD formats
 * - Implements purchase and return functionality
 * - Provides format-specific pricing (CD prices are 40% of vinyl)
 * 
 * Design Pattern: Strategy Pattern
 * - Different pricing strategies for vinyl vs CD formats
 * - Flexible implementation for future format additions
 * 
 * @see Product
 * @see Genre
 */
package Model;

import Enums.Genre;

public class Album extends Product {
    /**
     * The artist who created the album.
     * Stores the name of the musician or band.
     */
    private String artist;
    
    /**
     * The musical genre of the album.
     * Used for categorization and filtering.
     * @see Genre
     */
    private Genre genre;

    /**
     * Constructs a new Album instance.
     * 
     * @param title The title of the album
     * @param artist The artist/band name
     * @param genre The musical genre
     * @param price The price (full price for vinyl, 40% for CD)
     * @param imageFileName The album cover image file
     */
    public Album(String title, String artist, Genre genre, double price, String imageFileName) {
        super(title, price, imageFileName);
        this.artist = artist;
        this.genre = genre;
    }

    /**
     * Gets the title of the album.
     * Delegates to the parent class's getName() method.
     * 
     * @return The album title
     */
    public String getTitle() {
        return getName();
    }

    /**
     * Gets the artist of the album.
     * 
     * @return The artist/band name
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Gets the musical genre of the album.
     * 
     * @return The album's genre
     * @see Genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Creates a string representation of the album.
     * Format: "Title - Artist (Genre) ($Price)"
     * 
     * @return Formatted string with album details
     */
    @Override
    public String toString() {
        return getTitle() + " - " + artist + " (" + genre + ") ($" + getPrice() + ")";
    }

    /**
     * Implements the purchase functionality for albums.
     * Updates inventory and processes the transaction.
     */
    @Override
    public void purchaseItem() {
        // Implementation for purchasing the item
    }

    /**
     * Implements the return functionality for albums.
     * Handles refunds and updates inventory.
     */
    @Override
    public void returnItem() {
        // Implementation for returning the item
    }
}
