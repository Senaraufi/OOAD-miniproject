/**
 * Abstract base class representing a purchasable product in the music shop.
 * This class serves as the foundation for specific product types like albums.
 * 
 * Key features:
 * - Implements the Purchasable interface for consistent transaction handling
 * - Provides basic product attributes (name, price, image)
 * - Abstract methods ensure proper implementation in child classes
 * 
 * Design Pattern: Template Method Pattern
 * - Abstract class defines the skeleton of product operations
 * - Child classes provide specific implementations
 * 
 * @author [Your Name]
 * @version 1.0
 * @since [Date]
 */
package Model;

import Interfaces.Purchasable;

/**
 * Represents a product in the music shop.
 * 
 * This class provides the basic structure for products, including attributes and methods.
 * It is intended to be extended by child classes that provide specific implementations.
 * 
 * @see Purchasable
 * @see Album
 */
public abstract class Product implements Purchasable {
    /**
     * The name of the product.
     * 
     * This attribute is used to identify the product and is displayed to the user.
     */
    protected String name;
    
    /**
     * The price of the product.
     * 
     * This attribute represents the cost of the product and is used in transactions.
     */
    protected double price;
    
    /**
     * The file name of the product's image.
     * 
     * This attribute is used to display an image of the product to the user.
     */
    protected String imageFileName;

    /**
     * Constructs a new Product instance with the given attributes.
     * 
     * @param name The name of the product.
     * @param price The price of the product.
     * @param imageFileName The file name of the product's image.
     */
    public Product(String name, double price, String imageFileName) {
        this.name = name;
        this.price = price;
        this.imageFileName = imageFileName;
    }

    /**
     * Returns the name of the product.
     * 
     * @return The name of the product.
     */
    public final String getName() {
        return name;
    }

    /**
     * Returns the price of the product.
     * 
     * @return The price of the product.
     */
    public final double getPrice() {
        return price;
    }

    /**
     * Returns the file name of the product's image.
     * 
     * @return The file name of the product's image.
     */
    public final String getImageFileName() {
        return imageFileName;
    }

    /**
     * Abstract method to purchase the product.
     * Must be implemented by child classes.
     * 
     * This method is used to handle the purchase of a product and should be implemented
     * by child classes to provide specific logic.
     */
    @Override
    public abstract void purchaseItem();

    /**
     * Abstract method to return the product.
     * Must be implemented by child classes.
     * 
     * This method is used to handle the return of a product and should be implemented
     * by child classes to provide specific logic.
     */
    @Override
    public abstract void returnItem();

    /**
     * Returns a string representation of the product.
     * 
     * @return A string representation of the product.
     */
    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
