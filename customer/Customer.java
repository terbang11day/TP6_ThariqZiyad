package customer;

import order.Cart;
import order.Order;
import order.OrderItem;
import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer implements CanShop {
    protected String name;
    protected Cart cart;
    protected List<Order> orderHistory;

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

    public String getName() {
        return name;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public Cart getCart() {
        return cart;
    }
}
