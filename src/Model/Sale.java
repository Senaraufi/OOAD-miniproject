/**
 * Represents a sales transaction in the music shop system.
 * Records details of individual sales including products, customer, and timing.
 * 
 * Key features:
 * - Transaction recording
 * - Sales analytics support
 * - Customer purchase history
 * - Time-based reporting
 * 
 * Design Pattern: Value Object Pattern
 * - Immutable transaction record
 * - Complete transaction history
 * 
 * @see Product
 * @see Customer
 * @see ShoppingCart
 */
package Model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Sale {
    /** Unique identifier for the sale */
    private final String saleId;
    
    /** Customer who made the purchase */
    private final Customer customer;
    
    /** List of products purchased */
    private final List<Product> products;
    
    /** Total sale amount */
    private final double totalAmount;
    
    /** Time of sale */
    private final LocalDateTime saleTime;
    
    /**
     * Constructs a new Sale with the specified details.
     * Creates an immutable record of the transaction.
     * 
     * @param saleId Unique sale identifier
     * @param customer Customer making the purchase
     * @param products List of products purchased
     * @param totalAmount Total transaction amount
     */
    public Sale(String saleId, Customer customer, List<Product> products, double totalAmount) {
        this.saleId = saleId;
        this.customer = customer;
        this.products = new ArrayList<>(products); // Defensive copy
        this.totalAmount = totalAmount;
        this.saleTime = LocalDateTime.now();
    }
    
    /**
     * Gets the unique sale identifier.
     * 
     * @return Sale ID
     */
    public String getSaleId() {
        return saleId;
    }
    
    /**
     * Gets the customer who made the purchase.
     * 
     * @return Customer object
     */
    public Customer getCustomer() {
        return customer;
    }
    
    /**
     * Gets an unmodifiable list of purchased products.
     * Prevents external modification of sale record.
     * 
     * @return List of products
     */
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
    
    /**
     * Gets the total amount of the sale.
     * 
     * @return Total sale amount
     */
    public double getTotalAmount() {
        return totalAmount;
    }
    
    /**
     * Gets the time when the sale was made.
     * 
     * @return Sale timestamp
     */
    public LocalDateTime getSaleTime() {
        return saleTime;
    }
    
    /**
     * Returns a string representation of the sale.
     * Includes sale ID, customer, product count, and total amount.
     * 
     * @return Formatted string with sale details
     */
    @Override
    public String toString() {
        return String.format("Sale %s: Customer %s, %d items, Total: $%.2f", 
            saleId, customer.getName(), products.size(), totalAmount);
    }
}
