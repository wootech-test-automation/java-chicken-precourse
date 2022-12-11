package domain.type;

import exception.IllegalInputArgumentException;
import java.util.Objects;

public class Amount {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 99;
    private static final String ERROR_MESSAGE = String.format("%d부터 %d까지만 입력하세요.", MIN_VALUE, MAX_VALUE);
    private final int value;

    public Amount(int value) {
        validateSize(value);
        this.value = value;
    }

    private static void validateSize(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalInputArgumentException(ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int intValue() {
        return this.value;
    }
}