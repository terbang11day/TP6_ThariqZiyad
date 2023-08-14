package order;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<OrderItem> orderList;

    public Cart() {
        this.orderList = new ArrayList<>();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderList.add(orderItem);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (OrderItem orderItem : orderList) {
            totalPrice += orderItem.getFinalPrice();
        }
        return totalPrice;
    }

    public List<OrderItem> getOrderList() {
        return orderList;
    }

    public void clear() {
        orderList.clear();
    }

    public boolean isEmpty() {
        return orderList.isEmpty();
    }
}
