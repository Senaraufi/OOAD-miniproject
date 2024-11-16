package Exceptions;

public class PurchaseLimitException extends Exception {
    public PurchaseLimitException(String message) {
        super(message);
    }
}
