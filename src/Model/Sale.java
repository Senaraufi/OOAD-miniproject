package Model; // Declare the package this class belongs to

import java.util.Date; // Import the Date class from java.util package

public class Sale { // Define the Sale class
    private Customer customer; // Customer who made the purchase
    private Product product; // Product that was purchased
    private Date saleDate; // Date of the sale

    // Constructor to initialize Sale object with customer, product, and sale date
    public Sale(Customer customer, Product product, Date saleDate) {
        this.customer = customer; // Set the customer
        this.product = product; // Set the product
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

    // Getter method for product
    public Product getProduct() {
        return product; // Return the product
    }

    // Setter method for product
    public void setProduct(Product product) {
        this.product = product; // Set the product
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
                ", product=" + product.getName() + // Get the product's name
                ", saleDate=" + saleDate + // Get the sale date
                '}'; // End of string representation
    }
}
