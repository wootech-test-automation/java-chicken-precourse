package domain.discount;

import domain.discount.policy.DiscountPolicy;
import domain.payment.Payment;

public class Money {
    private final Long money;

    public Money(final int money) {
        this.money = Long.valueOf(money);
    }

    public Money(final Long amount) {
        this.money = amount;
    }

    public String result() {
        return String.format("%s원", money);
    }

    public Money discount(Payment payment) {
        return new Money(DiscountPolicy.discount(money, payment.getDiscountPolicy()));
    }
}
