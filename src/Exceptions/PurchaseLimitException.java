/**
 * Custom exception thrown when a purchase exceeds allowed limits.
 * Used to enforce business rules regarding purchase quantities.
 * 
 * Key features:
 * - Extends RuntimeException for unchecked exception handling
 * - Provides detailed error messages
 * - Supports both quantity and price limit violations
 * 
 * Usage examples:
 * - When cart quantity exceeds maximum allowed items
 * - When purchase total exceeds spending limit
 * - When single item quantity exceeds stock
 */
package Exceptions;

public final class PurchaseLimitException extends RuntimeException {
    /**
     * Constructs a new PurchaseLimitException with the specified message.
     * 
     * @param message Detailed description of the limit violation
     */
    public PurchaseLimitException(String message) {
        super(message);
    }

    /**
     * Constructs a new PurchaseLimitException with a message and cause.
     * 
     * @param message Detailed description of the limit violation
     * @param cause The underlying cause of the exception
     */
    public PurchaseLimitException(String message, Throwable cause) {
        super(message, cause);
    }
}
