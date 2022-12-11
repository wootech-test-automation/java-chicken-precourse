package domain.calculator;

import domain.type.Order;
import domain.type.PaymentType;
import java.util.List;

public class DefaultDiscountCalculatorImpl implements DiscountCalculator {

    @Override
    public int calculate(PaymentType paymentType, List<Order> orders) {
        int totalChickenCount = orders.stream()
                .filter(Order::isChicken)
                .mapToInt(Order::getTotalCount).sum();
        int totalChickenPrice = orders.stream()
                .filter(Order::isChicken)
                .mapToInt(Order::getTotalPrice)
                .sum();
        int result = discount(totalChickenPrice, totalChickenCount);
        return discount(result, paymentType);
    }

    private int discount(int totalPrice, int totalChickenCount) {
        int discountPrice = (totalChickenCount / 10) * 10_000;
        return totalPrice - discountPrice;
    }

    private int discount(int totalPrice, PaymentType paymentType) {
        if (paymentType.equals(PaymentType.CACHE)) {
            return (int) (totalPrice * 0.95);
        }
        return totalPrice;
    }
}
