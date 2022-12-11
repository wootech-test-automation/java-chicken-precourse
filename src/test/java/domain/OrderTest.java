package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderTest {

    @ParameterizedTest
    @CsvSource({"10", "20", "30"})
    @DisplayName("주문에 대한 할인률 적용 테스트")
    void discountRateTest(int quantity) {
        // given
        // when
        Order order = new Order(1, "임시", quantity, 20000);

        // then
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(quantity * 20000 - (quantity / 10 * 10000));
    }

}