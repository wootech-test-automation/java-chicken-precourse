package domain.discount.policy;

import domain.discount.Money;

public interface Discount {
    Money discount(Money money);
}
