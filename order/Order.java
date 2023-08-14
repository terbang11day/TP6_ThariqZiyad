package order;

import java.time.LocalDate;
import java.util.List;

/**
 * Kelas Order merepresentasikan sebuah pesanan yang terdiri dari item-item pesanan dalam keranjang belanja.
 */
public class Order {
    private Cart cart;
    public double discountRate;
    private LocalDate orderDate;
    private double totalPrice;

    /**
     * Konstruktor untuk membuat objek Order berdasarkan keranjang belanja.
     *
     * @param cart Keranjang belanja yang berisi item-item pesanan.
     */
    public Order(Cart cart) {
        this.cart = cart;
        this.discountRate = 0.0;
        this.orderDate = LocalDate.now();
        this.totalPrice = cart.getTotalPrice();
    }

    /**
     * Menghitung harga akhir dari pesanan setelah diberikan diskon.
     *
     * @return Harga akhir pesanan setelah diberikan diskon.
     */
    public double getFinalPrice() {
        return totalPrice * (1 - discountRate);
    }

    /**
     * Mengurangi stok semua item pesanan dalam keranjang dari produk yang terkait.
     */
    public void decreaseStockAllItem() {
        List<OrderItem> orderList = cart.getOrderList();
        for (OrderItem orderItem : orderList) {
            orderItem.getProduct().decreaseStock(orderItem.getQuantity());
        }
    }

    /**
     * Mendapatkan tanggal pesanan.
     *
     * @return Tanggal pesanan dalam bentuk string.
     */
    public String getOrderDate() {
        return orderDate.toString();
    }

    /**
     * Mendapatkan keranjang belanja yang terkait dengan pesanan.
     *
     * @return Keranjang belanja yang berisi item-item pesanan.
     */
    public Cart getCart() {
        return null; // Implementasikan pengembalian keranjang belanja sesuai kebutuhan.
    }
}
