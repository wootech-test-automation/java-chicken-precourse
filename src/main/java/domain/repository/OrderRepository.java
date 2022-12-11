package domain.repository;

import domain.type.Amount;
import domain.type.Order;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public static List<Order> orders() {
        return Collections.unmodifiableList(orders);
    }

    public static void addOrder(Order order) {
        if (modifyOrder(order)) {
            return;
        }
        orders.add(order);
    }

    private static boolean modifyOrder(Order order) {
        for (int i = 0; i < orders.size(); ++i) {
            Order existOrder = orders.get(i);
            if (existOrder.equalMenu(order)) {
                Amount newAmount = genNewAmount(order, existOrder);
                Order newOrder = new Order(existOrder.getTable(), existOrder.getMenu(), newAmount);
                orders.set(i, newOrder);
                return true;
            }
        }
        return false;
    }

    private static Amount genNewAmount(Order order, Order existOrder) {
        Amount existAmount = existOrder.getAmount();
        Amount amount = order.getAmount();
        return new Amount(existAmount.intValue() + amount.intValue());
    }
}
