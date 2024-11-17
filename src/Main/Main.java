package Main;

import Enums.Genre;
import Model.Album;
import Model.Customer;
import Model.Sale;
import Exceptions.PurchaseLimitException;

import java.util.Date;

public class Main {
    public static void main(String[] args) {//main method
        // Create albums
        Album album1 = new Album("Greatest Hits", "Queen", Genre.ROCK);//creating album1
        Album album2 = new Album("Thriller", "Michael Jackson", Genre.POP);//creating album2
        Album album3 = new Album("Dark Side of the Moon", "Pink Floyd", Genre.ROCK);//creating album3

        // Create a customer
        Customer customer = new Customer("John");//creating customer

        // Purchase albums
        try {
            customer.purchaseAlbum(album1);//purchasing album1
            customer.purchaseAlbum(album2);//purchasing album2
            customer.purchaseAlbum(album3);//purchasing album3
        } catch (PurchaseLimitException e) {
            System.out.println(e.getMessage());//printing the message
        }

        // Create a sale
        Sale sale = new Sale(customer, album1, new Date());//creating sale

        // Print sale and customer details
        System.out.println(sale);//printing sale
        System.out.println(customer);//printing customer
    }
}
