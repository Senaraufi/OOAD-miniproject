package Main;

import Enums.Genre;
import Model.Album;
import Model.CD;
import Model.Customer;
import Model.Product;
import Model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Main entry point for the application.
 * Demonstrates the music shop functionality including customer purchases and receipt generation.
 */
public final class Main {
    /**
     * Main entry point for the application.
     * Demonstrates the complete purchase flow:
     * 1. Initializes inventory (albums and CDs)
     * 2. Creates a customer
     * 3. Simulates purchases
     * 4. Generates a receipt
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("\n=== Music Store Management System ===\n");

        // Initialize available albums and CDs
        List<Album> availableAlbums = initializeAlbums();
        List<CD> availableCDs = initializeCDs();

        // Display available inventory to the user
        System.out.println("Available Albums:");
        System.out.println("-----------------");
        for (int i = 0; i < availableAlbums.size(); i++) {
            System.out.println((i + 1) + ". " + availableAlbums.get(i));
        }
        System.out.println();

        System.out.println("Available CDs:");
        System.out.println("----------------");
        for (int i = 0; i < availableCDs.size(); i++) {
            System.out.println((i + 1) + ". " + availableCDs.get(i));
        }
        System.out.println();

        // Create a customer
        Customer customer = createCustomer();

        // Simulate customer purchases
        simulatePurchases(customer, availableAlbums, availableCDs);

        // Generate and display the purchase receipt
        generateReceipt(customer);

        System.out.println("\n=== End of Program ===\n");
    }

    private static List<Album> initializeAlbums() {
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Greatest Hits", "Queen", Genre.ROCK, 29.99, "queen.jpg"));
        albums.add(new Album("Thriller", "Michael Jackson", Genre.POP, 24.99, "thriller.jpg"));
        albums.add(new Album("Dark Side of the Moon", "Pink Floyd", Genre.ROCK, 19.99, "dark_side.jpg"));
        albums.add(new Album("Back in Black", "AC/DC", Genre.ROCK, 21.99, "back_in_black.jpg")); 
        albums.add(new Album("21", "Adele", Genre.POP, 18.99, "adele_21.jpg"));
        albums.add(new Album("The Rise and Fall Of A Midwest Princess", "Chappell Roan", Genre.POP, 35.50, "chappellRoan.jpeg"));
        albums.add(new Album("Hypnotize", "System of A Down", Genre.ROCK, 25.00, "SOAD.jpeg"));
        albums.add(new Album("In Utero", "Nirvana", Genre.ROCK, 22.00, "nirvana.jpg"));
        albums.add(new Album("Born This Way (Signed Edition)", "Lady Gaga", Genre.POP, 25.00, "ladygaga.jpg"));
        albums.add(new Album("The Marshall Mathers LP", "Eminem", Genre.RAP, 20.00, "eminem.png"));
        albums.add(new Album("OK Computer", "Radiohead", Genre.ROCK, 15.00, "radiohead.jpeg"));
        albums.add(new Album("Mellie Collie and The Infinite Sadness", "The Smashing Pumpkins", Genre.ROCK, 19.99, "smashingpumpkins.jpg"));
        albums.add(new Album("Doolittle", "Pixies", Genre.ROCK, 15.00, "pixies.jpg"));
        albums.add(new Album("Speak for Yourself", "Imogen Heap", Genre.ELECTRONIC, 18.00, "imogenheap.jpg"));
        albums.add(new Album("Grace", "Jeff Buckley", Genre.ROCK, 15.00, "jeffbuckley.jpeg"));
        albums.add(new Album("Weezer (Blue Album)", "Weezer", Genre.ROCK, 15.00, "weezer.jpg"));
        albums.add(new Album("The White Album", "The Beatles", Genre.ROCK, 15.00, "thebeatles.png"));
        albums.add(new Album("Graduation", "Kanye West", Genre.RAP, 15.00, "kanyewest.jpg"));
        albums.add(new Album("The Colour and the Shape", "Foo Fighters", Genre.ROCK, 23.99, "foofighters.jpeg"));
        albums.add(new Album("Rumours", "Fleetwood Mac", Genre.ROCK, 22.99, "fleetwoodmac.jpeg"));
        albums.add(new Album("Blue", "Joni Mitchell", Genre.FOLK, 15.00, "jonimitchell.jpg"));
        albums.add(new Album("Goo", "Sonic Youth", Genre.ROCK, 15.00, "sonicyouth.png"));
        albums.add(new Album("Tidal", "Fiona Apple", Genre.POP, 15.00, "fionaapple.jpg"));
        albums.add(new Album("Dreaming", "Andre Rieu", Genre.CLASSICAL, 15.00, "andrerieu.jpg"));
        albums.add(new Album("Come Away With Me", "Norah Jones", Genre.JAZZ, 15.00, "norahjones.jpg"));
        return albums;
    }

    private static List<CD> initializeCDs() {
        List<CD> cds = new ArrayList<>();
        cds.add(new CD("OK Computer", "Radiohead", Genre.ROCK, 19.99, "ok_computer.jpg", 12, "53:21"));
        cds.add(new CD("Blue", "Joni Mitchell", Genre.FOLK, 15.99, "blue.jpg", 10, "35:41"));
        cds.add(new CD("Kind of Blue", "Miles Davis", Genre.JAZZ, 17.99, "kind_of_blue.jpg", 5, "45:44"));
        return cds;
    }

    private static Customer createCustomer() {
        Customer customer = new Customer("CUST001", "John Doe");
        System.out.println("\nCustomer Created: " + customer.getCustomerId() + " - " + "John Doe");
        return customer;
    }

    private static void simulatePurchases(Customer customer, List<Album> albums, List<CD> cds) {
        customer.getCart().addItem(albums.get(0));  // Add Queen's Greatest Hits album
        customer.getCart().addItem(cds.get(0));     // Add Radiohead's OK Computer CD
    }

    private static void generateReceipt(Customer customer) {
        double total = 0;
        System.out.println("\nPurchase Receipt:");
        System.out.println("----------------");
        System.out.println("Customer: " + customer.getName() + " (" + customer.getCustomerId() + ")");
        System.out.println("\nItems purchased:");
        for (Product item : customer.getCart().getItems()) {
            System.out.println("- " + item.getName() + " ($" + String.format("%.2f", item.getPrice()) + ")");
            total += item.getPrice();
        }
        System.out.println("\nTotal Amount: $" + String.format("%.2f", total));
        System.out.println("----------------");
    }
}
