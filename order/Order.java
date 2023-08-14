package order;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Cart cart;
    public double discountRate;
    private LocalDate orderDate;
    private double totalPrice;

    public Order(Cart cart) {
        this.cart = cart;
        this.discountRate = 0.0;
        this.orderDate = LocalDate.now();
        this.totalPrice = cart.getTotalPrice();
    }

    public double getFinalPrice() {
        return totalPrice * (1 - discountRate);
    }

    public void decreaseStockAllItem() {
        List<OrderItem> orderList = cart.getOrderList();
        for (OrderItem orderItem : orderList) {
            orderItem.getProduct().decreaseStock(orderItem.getQuantity());
        }
    }
}
