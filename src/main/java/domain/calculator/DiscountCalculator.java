package domain.calculator;

import domain.type.Order;
import domain.type.PaymentType;
import java.util.List;

public interface DiscountCalculator {

    int calculate(PaymentType paymentType, List<Order> orders);
}