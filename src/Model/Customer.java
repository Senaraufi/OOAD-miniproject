package Model;//declaring the package   

import Exceptions.PurchaseLimitException;//importing the purchase limit exception

import java.util.ArrayList;//importing the array list
import java.util.List;//importing the list

public class Customer {//defining the customer class
    private String name;//declaring the name variable
    private List<Album> purchasedAlbums;//declaring the purchasedAlbums variable
    private static final int MAX_PURCHASES = 3;//declaring the MAX_PURCHASES variable


    public Customer(String name) {
        this.name = name;//initializing the name variable
        this.purchasedAlbums = new ArrayList<>();//initializing the purchasedAlbums variable
    }

    public String getName() {//defining the getName method
        return name;//returning the name
    }

    public void setName(String name) {//defining the setName method
        this.name = name;//initializing the name variable
    }

    public List<Album> getPurchasedAlbums() {//defining the getPurchasedAlbums method
        return purchasedAlbums;//returning the purchasedAlbums
    }

    public void setPurchasedAlbums(List<Album> purchasedAlbums) {//defining the setPurchasedAlbums method
        this.purchasedAlbums = purchasedAlbums;//initializing the purchasedAlbums variable
    }

    public void purchaseAlbum(Album album) throws PurchaseLimitException {//defining the purchaseAlbum method
        if (purchasedAlbums.size() >= MAX_PURCHASES) {
            throw new PurchaseLimitException("Purchase limit reached. Return an album before purchasing another.");
        }
        album.purchaseItem();//calling the purchaseItem method
        purchasedAlbums.add(album);//adding the album to the purchasedAlbums list
    }

    public void returnAlbum(Album album) {
        album.returnItem();//calling the returnItem method
        purchasedAlbums.remove(album);//removing the album from the purchasedAlbums list
    }

    @Override
    public String toString() {//defining the toString method
        return "Customer{" +//returning the customer details
                "name='" + name + '\'' +//getting the name
                ", purchasedAlbums=" + purchasedAlbums +//getting the purchasedAlbums
                '}';//end of string representation
    }
}
