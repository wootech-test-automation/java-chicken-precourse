package domain.order;

import domain.category.Category;
import domain.discount.Money;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private final static String ORDER_COLUMN_FORMAT = "메뉴 수량 금액";
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public String result() {
        return ORDER_COLUMN_FORMAT + "\n" + orders.stream().map(Order::result).collect(Collectors.joining("\n"));
    }

    public Money calculateAll() {
        var chickenPrice = orders.stream().filter(order -> order.existCategory(Category.CHICKEN)).mapToInt(Order::price)
                .sum();
        var count = (int) orders.stream().filter(order -> order.existCategory(Category.CHICKEN)).count();
        var discountChickenPrice = chickenPrice - count / 10 * 10000;
        var beveragePrice = orders.stream().filter(order -> order.existCategory(Category.BEVERAGE))
                .mapToInt(Order::price).sum();
        return new Money(discountChickenPrice + beveragePrice);
    }
}
