package domain;

import message.ErrorMessage;
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
        Order order = new Order(1, "임시", Category.CHICKEN, quantity, 20000);

        // then
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(quantity * 20000 - (quantity / 10 * 10000));
    }

    @ParameterizedTest
    @CsvSource({"-1", "0", "100"})
    @DisplayName("주문 가능 개수 범위 벗어날시 예외 처리 테스트")
    void outOfBoundsQuantityException(int quantity) {
        // given
        // when
        // then
        Assertions.assertThatThrownBy(() -> new Order(1, "임시", Category.CHICKEN, quantity, 20000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_BOUNDS_QUANTITY);
    }

}