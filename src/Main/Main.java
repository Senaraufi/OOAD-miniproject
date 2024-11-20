package Main;

import Enums.Genre;
import Model.Album;
import Model.Customer;
import Model.Sale;
import Exceptions.PurchaseLimitException;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n=== Music Store Management System ===\n");

        // Initialize available albums
        List<Album> availableAlbums = new ArrayList<>();
        availableAlbums.add(new Album("Greatest Hits", "Queen", Genre.ROCK, 29.99, "queen.jpg"));
        availableAlbums.add(new Album("Thriller", "Michael Jackson", Genre.POP, 24.99, "thriller.jpg"));
        availableAlbums.add(new Album("Dark Side of the Moon", "Pink Floyd", Genre.ROCK, 27.99, "darkside.jpg"));
        availableAlbums.add(new Album("Back in Black", "AC/DC", Genre.ROCK, 21.99, "back_in_black.jpg"));
        availableAlbums.add(new Album("21", "Adele", Genre.POP, 18.99, "adele_21.jpg"));

        // Print available albums
        System.out.println("Available Albums:");
        System.out.println("-----------------");
        for (int i = 0; i < availableAlbums.size(); i++) {
            System.out.println((i + 1) + ". " + availableAlbums.get(i));
        }
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
            customer.purchaseAlbum(availableAlbums.get(0));
            System.out.println("✓ Successfully purchased: " + availableAlbums.get(0).getTitle());
            
            customer.purchaseAlbum(availableAlbums.get(1));
            System.out.println("✓ Successfully purchased: " + availableAlbums.get(1).getTitle());
            
            customer.purchaseAlbum(availableAlbums.get(2));
            System.out.println("✓ Successfully purchased: " + availableAlbums.get(2).getTitle());
        } catch (PurchaseLimitException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        System.out.println();

        // Create a sale
        Sale sale = new Sale(customer, availableAlbums.get(0), new Date());

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
