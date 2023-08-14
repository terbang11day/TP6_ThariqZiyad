package customer;

import order.Order;
import product.Product;

public class GoldCustomer extends Customer {
    public GoldCustomer(String name) {
        super(name);
    }

    @Override
    public void addToCart(Product product, int quantity) {
        super.addToCart(product, quantity);
        System.out.println("Diskon 85% akan otomatis diberikan saat checkout.");
    }

    @Override
    public void checkout() {
        if (!getCart().isEmpty()) {
            Order order = new Order(getCart());
            order.decreaseStockAllItem();
            order.discountRate = 0.85;
            getOrderHistory().add(order);
            getCart().clear();
            System.out.println("Berhasil Checkout dengan diskon 85%.");
        } else {
            System.out.println("Keranjang Anda kosong. Tambahkan produk sebelum checkout.");
        }
    }
}
