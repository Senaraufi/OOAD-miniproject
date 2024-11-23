package Main;

import Enums.Genre;
import Model.Album;
import Model.CD;
import Model.Customer;
import Model.ShoppingCart;
import Exceptions.PurchaseLimitException;

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

        // Initialize available CDs
        List<CD> availableCDs = new ArrayList<>();
        availableCDs.add(new CD("OK Computer", "Radiohead", Genre.ROCK, 19.99, "ok_computer.jpg", 12, "53:21"));
        availableCDs.add(new CD("Blue", "Joni Mitchell", Genre.FOLK, 15.99, "blue.jpg", 10, "35:41"));
        availableCDs.add(new CD("Kind of Blue", "Miles Davis", Genre.JAZZ, 17.99, "kind_of_blue.jpg", 5, "45:44"));

        // Print available albums
        System.out.println("Available Albums:");
        System.out.println("-----------------");
        for (int i = 0; i < availableAlbums.size(); i++) {
            System.out.println((i + 1) + ". " + availableAlbums.get(i));
        }
        System.out.println();

        // Print available CDs
        System.out.println("Available CDs:");
        System.out.println("----------------");
        for (int i = 0; i < availableCDs.size(); i++) {
            System.out.println((i + 1) + ". " + availableCDs.get(i));
        }
        System.out.println();

        // Create a customer
        System.out.println("Creating Customer:");
        System.out.println("-----------------");
        Customer customer = new Customer("John");
        System.out.println("New customer created: " + customer.getName());
        System.out.println();

        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart(customer);

        // Add items to cart
        System.out.println("Adding items to cart:");
        System.out.println("--------------------");
        cart.addItem(availableAlbums.get(0));
        System.out.println("✓ Added to cart: " + availableAlbums.get(0).getTitle());
        cart.addItem(availableCDs.get(0));
        System.out.println("✓ Added to cart: " + availableCDs.get(0).getTitle());
        System.out.println("\nCart contents:");
        System.out.println(cart);
        System.out.println();

        // Process checkout
        System.out.println("Processing Checkout:");
        System.out.println("-------------------");
        try {
            cart.checkout();
            System.out.println("✓ Checkout completed successfully");
        } catch (PurchaseLimitException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        System.out.println();

        // Print customer details
        System.out.println("Customer Details:");
        System.out.println("----------------");
        System.out.println(customer);
        
        System.out.println("\n=== End of Transaction ===\n");
    }
}
