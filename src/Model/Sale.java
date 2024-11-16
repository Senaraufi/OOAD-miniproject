package Model;

import java.util.Date;

public class Sale {
    private Customer customer;
    private Album album;
    private Date saleDate;

    public Sale(Customer customer, Album album, Date saleDate) {
        this.customer = customer;
        this.album = album;
        this.saleDate = saleDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Album getAlbum() {
        return album;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "customer=" + customer.getName() +
                ", album=" + album.getTitle() +
                ", saleDate=" + saleDate +
                '}';
    }
}
