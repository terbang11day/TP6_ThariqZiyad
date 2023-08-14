package customer;

import product.Product;

public interface CanShop {
    void addToCart(Product product, int quantity);
    void checkout();
}
