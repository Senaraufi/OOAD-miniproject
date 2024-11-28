/**
 * Represents a shopping cart in the music shop system.
 * Manages the collection of items a customer intends to purchase.
 * 
 * Key features:
 * - Item management (add/remove)
 * - Total price calculation
 * - Quantity tracking
 * - Purchase limit enforcement
 */
package Model;

import java.util.*;
import Exceptions.PurchaseLimitException;

public class ShoppingCart {
    /** Maximum number of items allowed in cart */
    private static final int MAX_ITEMS = 10;
    
    /** Collection of items in the cart */
    private final List<Product> items;
    
    /** Customer who owns this cart */
    private final Customer customer;

    /**
     * Constructs a new shopping cart for the given customer.
     * 
     * @param customer Customer who owns this cart
     */
    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    /**
     * Adds a product to the shopping cart.
     * 
     * @param product Product to add to cart
     * @throws PurchaseLimitException if cart would exceed maximum items
     */
    public void addItem(Product product) throws PurchaseLimitException {
        if (items.size() >= MAX_ITEMS) {
            throw new PurchaseLimitException("Cannot add more than " + MAX_ITEMS + " items to cart");
        }
        items.add(product);
    }

    /**
     * Removes a product from the shopping cart.
     * 
     * @param product Product to remove from cart
     */
    public void removeItem(Product product) {
        items.remove(product);
    }

    /**
     * Clears all items from the cart.
     */
    public void clearCart() {
        items.clear();
    }

    /**
     * Gets an unmodifiable list of items in cart.
     * 
     * @return Unmodifiable list of cart items
     */
    public List<Product> getItems() {
        return Collections.unmodifiableList(items);
    }

    /**
     * Gets the number of items in cart.
     * 
     * @return Number of items
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Gets the total price of all items in cart.
     * 
     * @return Total price
     */
    public double getTotal() {
        return items.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    /**
     * Completes the purchase of all items in cart.
     * 
     * @throws PurchaseLimitException if purchase would exceed customer's limit
     */
    public void checkout() throws PurchaseLimitException {
        for (Product item : items) {
            customer.purchaseItem(item);
        }
        clearCart();
    }

    /**
     * Returns a string representation of the cart.
     * 
     * @return Formatted string with cart details
     */
    @Override
    public String toString() {
        return String.format("Shopping Cart: %d items, Total: $%.2f", 
            items.size(), getTotal());
    }
}
