package Exceptions; // Declaring the package

public class PurchaseLimitException extends Exception { // Defining the PurchaseLimitException class
    public PurchaseLimitException(String message) { // Constructor
        super(message); // Calling the superclass constructor
    }
}
