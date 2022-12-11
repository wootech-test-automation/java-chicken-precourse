package domain.discount;

import domain.discount.policy.Discount;

public class Money {
    private final Long money;

    public Money(final int money) {
        this.money = (long) money;
    }

    public Money(final Long amount) {
        this.money = amount;
    }

    public String result() {
        return String.format("%s원", money);
    }


    public Money discount(Discount minusDiscount) {
        return minusDiscount.discount(this);
    }

    public Long amount() {
        return money;
    }

    public Money addMoney(Money amount) {
        return new Money(this.money + amount.money);
    }
}
