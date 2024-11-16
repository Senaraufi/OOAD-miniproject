package Model;

import Exceptions.PurchaseLimitException;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Album> purchasedAlbums;
    private static final int MAX_PURCHASES = 3;

    public Customer(String name) {
        this.name = name;
        this.purchasedAlbums = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void purchaseAlbum(Album album) throws PurchaseLimitException {
        if (purchasedAlbums.size() >= MAX_PURCHASES) {
            throw new PurchaseLimitException("Purchase limit reached. Return an album before purchasing another.");
        }
        album.purchaseItem();
        purchasedAlbums.add(album);
    }

    public void returnAlbum(Album album) {
        album.returnItem();
        purchasedAlbums.remove(album);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", purchasedAlbums=" + purchasedAlbums +
                '}';
    }
}
