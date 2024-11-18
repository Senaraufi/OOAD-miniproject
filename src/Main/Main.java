package Main;

import Enums.Genre;
import Model.Album;
import Model.Customer;
import Model.Sale;
import Exceptions.PurchaseLimitException;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n=== Music Store Management System ===\n");

        // Create albums
        System.out.println("Creating Albums:");
        System.out.println("----------------");
        Album album1 = new Album("Greatest Hits", "Queen", Genre.ROCK, 29.99, "queen.jpg");
        Album album2 = new Album("Thriller", "Michael Jackson", Genre.POP, 24.99, "thriller.jpg");
        Album album3 = new Album("Dark Side of the Moon", "Pink Floyd", Genre.ROCK, 27.99, "darkside.jpg");
        
        System.out.println("1. " + album1);
        System.out.println("2. " + album2);
        System.out.println("3. " + album3);
        System.out.println();

        // Create a customer
        System.out.println("Creating Customer:");
        System.out.println("-----------------");
        Customer customer = new Customer("John");
        System.out.println("New customer created: " + customer.getName());
        System.out.println();

        // Purchase albums
        System.out.println("Processing Purchases:");
        System.out.println("--------------------");
        try {
            customer.purchaseAlbum(album1);
            System.out.println("✓ Successfully purchased: " + album1.getTitle());
            
            customer.purchaseAlbum(album2);
            System.out.println("✓ Successfully purchased: " + album2.getTitle());
            
            customer.purchaseAlbum(album3);
            System.out.println("✓ Successfully purchased: " + album3.getTitle());
        } catch (PurchaseLimitException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        System.out.println();

        // Create a sale
        Sale sale = new Sale(customer, album1, new Date());

        // Print sale and customer details
        System.out.println("Sale Details:");
        System.out.println("-------------");
        System.out.println(sale);
        System.out.println("\nCustomer Details:");
        System.out.println("----------------");
        System.out.println(customer);
        
        System.out.println("\n=== End of Transaction ===\n");
    }
}
