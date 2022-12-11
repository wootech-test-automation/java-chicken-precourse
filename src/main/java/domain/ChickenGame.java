package domain;

import domain.calculator.DefaultDiscountCalculatorImpl;
import domain.calculator.DiscountCalculator;
import domain.repository.MenuRepository;
import domain.repository.OrderRepository;
import domain.repository.TableRepository;
import domain.type.Menu;
import domain.type.Order;
import domain.type.PaymentType;
import domain.type.Table;
import java.util.List;
import java.util.stream.Collectors;

public class ChickenGame {

    private final DiscountCalculator discountCalculator = new DefaultDiscountCalculatorImpl();

    public List<Menu> getMenus() {
        return MenuRepository.menus();
    }

    public List<Table> getTables() {
        return TableRepository.tables();
    }

    public void saveOrder(Order order) {
        OrderRepository.addOrder(order);
        Table table = order.getTable();
        TableRepository.setTable(table, true);
    }

    public List<Order> getOrders(Table table) {
        TableRepository.setTable(table, false);
        List<Order> orders = OrderRepository.orders().stream()
                .filter(order -> order.getTable().equals(table))
                .collect(Collectors.toList());
        OrderRepository.removeAll(table);
        return orders;
    }

    public int calculatePrice(PaymentType paymentType, List<Order> orders) {
        return discountCalculator.calculate(paymentType, orders);
    }
}
