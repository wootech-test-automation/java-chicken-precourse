package domain;

import exception.InvalidInputException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QuantityTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 100, 101})
    void 주문_수량은_0보다작거나_99보다_클_수없습니다(final int input) {
        Assertions.assertThatThrownBy(() -> new Quantity(input))
                .isInstanceOf(InvalidInputException.class);
    }
}