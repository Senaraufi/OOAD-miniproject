package Model;//declaring the package   

import Exceptions.PurchaseLimitException;//importing the purchase limit exception

import java.util.ArrayList;//importing the array list
import java.util.List;//importing the list

public class Customer {//defining the customer class
    private String name;//declaring the name variable
    private List<Product> purchasedItems;//declaring the purchasedItems variable
    private static final int MAX_PURCHASES = 3;//declaring the MAX_PURCHASES variable


    public Customer(String name) {
        this.name = name;//initializing the name variable
        this.purchasedItems = new ArrayList<>();//initializing the purchasedItems variable
    }

    public String getName() {//defining the getName method
        return name;//returning the name
    }

    public void setName(String name) {//defining the setName method
        this.name = name;//initializing the name variable
    }

    public List<Product> getPurchasedItems() {//defining the getPurchasedItems method
        return purchasedItems;//returning the purchasedItems
    }

    public void setPurchasedItems(List<Product> purchasedItems) {//defining the setPurchasedItems method
        this.purchasedItems = purchasedItems;//initializing the purchasedItems variable
    }

    public void purchaseItem(Product product) throws PurchaseLimitException {//defining the purchaseItem method
        if (purchasedItems.size() >= MAX_PURCHASES) {
            throw new PurchaseLimitException("Purchase limit reached. Return an item before purchasing another.");
        }
        product.purchaseItem();//calling the purchaseItem method
        purchasedItems.add(product);//adding the product to the purchasedItems list
    }

    public void returnItem(Product product) {
        product.returnItem();//calling the returnItem method
        purchasedItems.remove(product);//removing the product from the purchasedItems list
    }

    @Override
    public String toString() {//defining the toString method
        return "Customer{" +//returning the customer details
                "name='" + name + '\'' +//getting the name
                ", purchasedItems=" + purchasedItems +//getting the purchasedItems
                '}';//end of string representation
    }
}
