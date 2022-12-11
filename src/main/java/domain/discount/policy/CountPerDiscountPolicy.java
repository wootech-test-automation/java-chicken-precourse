package domain.discount.policy;

import domain.discount.Money;

public class CountPerDiscountPolicy implements Discount {
    private static final int COUNT_PER_MONEY = 10000;
    private static final int DIVISION = 10;
    private final long count;

    public CountPerDiscountPolicy(long count) {
        this.count = count / 10;

    }

    @Override
    public Money discount(Money money) {
        return new Money(money.amount() - count * COUNT_PER_MONEY);
    }
}
