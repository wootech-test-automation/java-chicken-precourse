package domain.discount.policy;

public abstract class DiscountPolicy {
    private final long percent;

    public DiscountPolicy(long percent) {
        this.percent = percent;
    }

    public static Long discount(long amount, DiscountPolicy discountPolicy) {
        if (discountPolicy.percent == 0) {
            return amount;
        }
        return amount - (amount / discountPolicy.percent);
    }
}
