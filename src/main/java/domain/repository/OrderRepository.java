package domain.repository;

import domain.Order;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public static List<Order> orders() {
        return Collections.unmodifiableList(orders);
    }

    public static List<Order> findAllByTableNumber(final int tableNumber) {
        return orders.stream()
                .filter(order -> order.containsTableNumber(tableNumber))
                .collect(Collectors.toList());
    }

    public static void saveOrder(final Order order) {
        if (isExistsOrder(order)) {
            addExistsOrder(order);
            return;
        }
        orders.add(order);
    }

    private static void addExistsOrder(final Order order) {
        List<Order> orders = findAllByTableNumber(order.getTableNumber());
        orders.stream()
                .filter(findOrder -> findOrder.equals(order))
                .findAny()
                .get()
                .addOrder(order);
    }

    private static boolean isExistsOrder(final Order order) {
        return orders.contains(order);
    }

    public static void removeAllByTableNumber(final int tableNumber) {
        List<Order> collect = orders.stream()
                .filter(order -> order.containsTableNumber(tableNumber))
                .collect(Collectors.toList());
        orders.removeAll(collect);
    }

    public static void deleteAll() {
        orders.clear();
    }
}
