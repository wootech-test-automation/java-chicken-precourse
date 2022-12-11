package domain.repository;

import domain.type.Amount;
import domain.type.Menu;
import domain.type.Order;
import domain.type.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public void setOrderTable(Table table) {
        for (int i = 0; i < orders.size(); ++i) {
            Table existTable = orders.get(i).getTable();
            Menu existMenu = orders.get(i).getMenu();
            Amount existAmount = orders.get(i).getAmount();
            if (existTable.getNumber() == table.getNumber()) {
                orders.set(i, new Order(table, existMenu, existAmount));
            }
        }
    }

    public static List<Order> getOrders(Table table) {
        return OrderRepository.orders().stream()
                .filter(order -> order.getTable().equals(table))
                .collect(Collectors.toList());
    }

    public static void removeAll(Table table) {
        List<Order> tableOrders = OrderRepository.getOrders(table);
        orders.removeAll(tableOrders);
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
