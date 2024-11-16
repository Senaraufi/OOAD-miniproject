package Main;

import Enums.Genre;
import Model.Album;
import Model.Customer;
import Model.Sale;
import Exceptions.PurchaseLimitException;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create albums
        Album album1 = new Album("Greatest Hits", "Queen", Genre.ROCK);
        Album album2 = new Album("Thriller", "Michael Jackson", Genre.POP);
        Album album3 = new Album("Dark Side of the Moon", "Pink Floyd", Genre.ROCK);

        // Create a customer
        Customer customer = new Customer("John");

        // Purchase albums
        try {
            customer.purchaseAlbum(album1);
            customer.purchaseAlbum(album2);
            customer.purchaseAlbum(album3);
        } catch (PurchaseLimitException e) {
            System.out.println(e.getMessage());
        }

        // Create a sale
        Sale sale = new Sale(customer, album1, new Date());

        // Print sale and customer details
        System.out.println(sale);
        System.out.println(customer);
    }
}
