/**
 * Represents a customer in the music shop system.
 * Manages customer information and purchase history.
 * 
 * Key features:
 * - Customer profile management
 * - Purchase history tracking
 * - Purchase limit enforcement
 * - Shopping cart association
 */
package Model;

import java.util.*;
import Exceptions.PurchaseLimitException;

public class Customer {
    /** Maximum allowed purchases per customer */
    private static final int MAX_PURCHASES = 3;
    
    /** Customer's unique identifier */
    private final String customerId;
    
    /** Customer's name */
    private final String name;
    
    /** List of customer's purchases */
    private final List<Product> purchasedItems;
    
    /** Customer's shopping cart */
    private final ShoppingCart cart;

    /**
     * Constructs a new Customer with the specified details.
     * 
     * @param customerId Unique identifier
     * @param name Customer's name
     */
    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.purchasedItems = new ArrayList<>();
        this.cart = new ShoppingCart(this);
    }

    /**
     * Gets the customer's unique identifier.
     * 
     * @return Customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Gets the customer's name.
     * 
     * @return Customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the customer's shopping cart.
     * 
     * @return Shopping cart
     */
    public ShoppingCart getCart() {
        return cart;
    }

    /**
     * Gets an unmodifiable list of customer's purchases.
     * 
     * @return List of purchased items
     */
    public List<Product> getPurchasedItems() {
        return Collections.unmodifiableList(purchasedItems);
    }

    /**
     * Processes the purchase of an item.
     * 
     * @param product Product to purchase
     * @throws PurchaseLimitException if purchase would exceed limit
     */
    public void purchaseItem(Product product) throws PurchaseLimitException {
        if (purchasedItems.size() >= MAX_PURCHASES) {
            throw new PurchaseLimitException("Purchase limit reached. Return an item before purchasing another.");
        }
        product.purchaseItem();
        purchasedItems.add(product);
    }

    /**
     * Returns an item previously purchased.
     * 
     * @param product Product to return
     */
    public void returnItem(Product product) {
        product.returnItem();
        purchasedItems.remove(product);
    }

    /**
     * Returns a string representation of the customer.
     * 
     * @return Formatted string with customer details
     */
    @Override
    public String toString() {
        return String.format("Customer %s: %s (%d purchases)", 
            customerId, name, purchasedItems.size());
    }
}
