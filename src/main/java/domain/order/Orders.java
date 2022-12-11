package domain.order;

import domain.category.Category;
import domain.discount.Money;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private static final int MAX_AMOUNT = 99;
    private static final String ORDER_COLUMN_FORMAT = "메뉴 수량 금액";
    
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        validateGreaterThanMaxQuantity(sumAllQuantity() + order.getQuantity());
        this.orders.add(order);
    }

    private void validateGreaterThanMaxQuantity(int amount) {
        if (amount > MAX_AMOUNT) {
            throw new InvalidInputException("주문 총 수량은 99개 보다 많을 수 없습니다.");
        }

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

    public boolean isRegisterOrder() {
        return orders.size() >= 1;
    }

    private int sumAllQuantity() {
        return orders.stream().mapToInt(Order::getQuantity).sum();
    }
}
