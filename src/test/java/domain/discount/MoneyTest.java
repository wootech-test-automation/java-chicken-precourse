package domain.discount;

import domain.discount.policy.CountPerDiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MoneyTest {


    @Test
    void 개수_카운트_테스트() {
        var result = new Money(17000).discount(new CountPerDiscountPolicy(1)).result();
        Assertions.assertThat(result).isEqualTo("17000원");
    }

}