package domain.discount.policy;

import domain.discount.Money;

public class ZeroDiscountPolicy implements Discount {

    @Override
    public Money discount(Money money) {
        return money;
    }
}
