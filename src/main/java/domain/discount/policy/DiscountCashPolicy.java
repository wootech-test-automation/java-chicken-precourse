package domain.discount.policy;

import domain.discount.Money;

public class DiscountCashPolicy implements Discount {

    @Override
    public Money discount(Money money) {
        final var amount = money.amount();
        return new Money(amount - (amount / 10L));
    }
}
