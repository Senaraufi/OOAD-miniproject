/**
 * Interface defining the contract for purchasable items in the music shop.
 * Implemented by products that can be bought and returned.
 * 
 * Key features:
 * - Defines standard purchase operations
 * - Ensures consistent transaction handling
 * - Supports return functionality
 * 
 * Design Pattern: Strategy Pattern
 * - Allows different purchase implementations
 * - Enables flexible return policies
 * 
 * @see Product
 * @see Album
 */
package Interfaces;

public interface Purchasable {
    /**
     * Processes the purchase of an item.
     * Implementations should handle:
     * - Stock updates
     * - Transaction recording
     * - Price calculations
     * 
     * @throws PurchaseLimitException if purchase violates limits
     */
    void purchaseItem();
    
    /**
     * Processes the return of a previously purchased item.
     * Implementations should handle:
     * - Stock restoration
     * - Refund calculations
     * - Return validation
     */
    void returnItem();
}
