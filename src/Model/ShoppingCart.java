package Model;

import java.util.ArrayList;
import java.util.List;
import Exceptions.PurchaseLimitException;

public class ShoppingCart {
    private List<Product> items;
    private Customer customer;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public void clearCart() {
        items.clear();
    }

    public List<Product> getItems() {
        return new ArrayList<>(items); // Return a copy to prevent external modification
    }

    public int getItemCount() {
        return items.size();
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public void checkout() throws PurchaseLimitException {
        for (Product item : items) {
            customer.purchaseItem(item);
            new Sale(customer, item, new java.util.Date());
        }
        clearCart();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shopping Cart for ").append(customer.getName()).append(":\n");
        if (items.isEmpty()) {
            sb.append("Cart is empty");
        } else {
            items.forEach(item -> sb.append("- ").append(item.toString()).append("\n"));
            sb.append("Total: $").append(String.format("%.2f", getTotal()));
        }
        return sb.toString();
    }
}
