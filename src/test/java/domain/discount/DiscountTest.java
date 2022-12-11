package domain.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountTest {


    @Test
    void 테스트() {
        var a = 11 / 10 * 10000;
        var b = 10000;
        Assertions.assertThat(a).isEqualTo(b);
    }
}