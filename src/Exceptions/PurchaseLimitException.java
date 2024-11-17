package Exceptions;//declaring the package

public class PurchaseLimitException extends Exception {//defining the purchase limit exception
    public PurchaseLimitException(String message) {
        super(message);//calling the super class constructor
    }
}
