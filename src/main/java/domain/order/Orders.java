package domain.order;

import domain.category.Category;
import domain.discount.Money;
import domain.discount.policy.CountPerDiscountPolicy;
import exception.InvalidInputException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private static final int MAX_AMOUNT = 99;

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
        return orders.stream()
                .map(Order::result)
                .collect(Collectors.joining("\n"));
    }

    public Money calculateAll() {
        return new Money(0L)
                .addMoney(calculateByCategory(Category.CHICKEN))
                .discount(new CountPerDiscountPolicy(calculateCountByCategory(Category.CHICKEN)))
                .addMoney(calculateByCategory(Category.BEVERAGE));
    }

    private Long calculateCountByCategory(Category category) {
        return orders.stream()
                .filter(order -> order.existCategory(category))
                .count();
    }

    private Money calculateByCategory(Category category) {
        return new Money(orders.stream()
                .filter(order -> order.existCategory(category))
                .mapToInt(Order::price).sum()
        );
    }

    public boolean isRegisterOrder() {
        return orders.size() >= 1;
    }

    private int sumAllQuantity() {
        return orders.stream().mapToInt(Order::getQuantity).sum();
    }
}
