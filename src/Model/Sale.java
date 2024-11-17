package Model; // Declare the package this class belongs to

import java.util.Date; // Import the Date class from java.util package

public class Sale { // Define the Sale class
    private Customer customer; // Declare a Customer object to hold the customer information
    private Album album; // Declare an Album object to hold the album information
    private Date saleDate; // Declare a Date object to hold the sale date

    // Constructor to initialize Sale object with customer, album, and sale date
    public Sale(Customer customer, Album album, Date saleDate) {
        this.customer = customer; // Set the customer
        this.album = album; // Set the album
        this.saleDate = saleDate; // Set the sale date
    }

    // Getter method for customer
    public Customer getCustomer() {
        return customer; // Return the customer
    }

    // Setter method for customer
    public void setCustomer(Customer customer) {
        this.customer = customer; // Set the customer
    }

    // Getter method for album
    public Album getAlbum() {
        return album; // Return the album
    }

    // Setter method for album
    public void setAlbum(Album album) {
        this.album = album; // Set the album
    }

    // Getter method for sale date
    public Date getSaleDate() {
        return saleDate; // Return the sale date
    }

    // Setter method for sale date
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate; // Set the sale date
    }

    // Override the toString method to provide a string representation of the Sale object
    @Override
    public String toString() {
        return "Sale{" +
                "customer=" + customer.getName() + // Get the customer's name
                ", album=" + album.getTitle() + // Get the album's title
                ", saleDate=" + saleDate + // Get the sale date
                '}'; // End of string representation
    }
}
