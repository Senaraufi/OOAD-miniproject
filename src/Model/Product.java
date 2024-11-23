package Model;

import Interfaces.Purchasable;

public abstract class Product implements Purchasable {
    protected String name;
    protected double price;
    protected String imageFileName;

    public Product(String name, double price, String imageFileName) {
        this.name = name;
        this.price = price;
        this.imageFileName = imageFileName;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    @Override
    public abstract void purchaseItem();

    @Override
    public abstract void returnItem();

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
