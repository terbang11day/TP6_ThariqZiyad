package order;

import product.Product;

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getFinalPrice() {
        int discount = product.checkDiscount(quantity);
        double price = product.getPrice() * quantity;
        return price * (1 - discount / 100.0);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return String.format("%s  %d kg  %.2f", product.getName(), quantity, getFinalPrice());
    }
}
