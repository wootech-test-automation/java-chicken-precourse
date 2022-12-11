package domain.repository;

import domain.type.Order;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public static List<Order> tables() {
        return Collections.unmodifiableList(orders);
    }

    public static void addOrder(Order order) {
        orders.add(order);
    }
}
