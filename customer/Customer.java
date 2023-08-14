package customer;

import order.Cart;
import order.Order;
import order.OrderItem;
import product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Kelas Customer merepresentasikan seorang pelanggan yang dapat berbelanja dan melakukan checkout.
 */
public class Customer implements CanShop {

    protected String name;
    protected Cart cart;
    protected List<Order> orderHistory;

    /**
     * Konstruktor untuk membuat objek Customer dengan nama tertentu.
     *
     * @param name Nama pelanggan.
     */
    public Customer(String name) {
        this.name = name;
        this.cart = new Cart();
        this.orderHistory = new ArrayList<>();
    }

    @Override
    public void addToCart(Product product, int quantity) {
        OrderItem orderItem = new OrderItem(product, quantity);
        cart.addOrderItem(orderItem);
        System.out.println("Berhasil menambahkan " + product.getName() + " ke keranjang.");
    }

    @Override
    public void checkout() {
        if (!cart.isEmpty()) {
            Order order = new Order(cart);
            order.decreaseStockAllItem();
            orderHistory.add(order);
            cart.clear();
            System.out.println("Berhasil Checkout.");
        } else {
            System.out.println("Keranjang Anda kosong. Tambahkan produk sebelum checkout.");
        }
    }

    /**
     * Mendapatkan nama pelanggan.
     *
     * @return Nama pelanggan.
     */
    public String getName() {
        return name;
    }

    /**
     * Mendapatkan riwayat pesanan pelanggan.
     *
     * @return Daftar pesanan yang pernah dilakukan.
     */
    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    /**
     * Mendapatkan keranjang belanja pelanggan.
     *
     * @return Keranjang belanja pelanggan.
     */
    public Cart getCart() {
        return cart;
    }
}
