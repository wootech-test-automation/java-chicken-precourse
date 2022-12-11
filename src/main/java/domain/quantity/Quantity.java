package domain.quantity;

import exception.InvalidInputException;

public class Quantity {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 99;
    private final int number;

    public Quantity(int input) {
        validateInputGreaterThanMinNumber(input);
        validateInputLessThanMaxNumber(input);
        this.number = input;
    }

    private void validateInputLessThanMaxNumber(int input) {
        if (input > MAX_NUMBER) {
            throw new InvalidInputException("수량은 99보다 클 수 없습니다.");
        }
    }

    private void validateInputGreaterThanMinNumber(int input) {
        if (input < MIN_NUMBER) {
            throw new InvalidInputException("수량은 1보다 작을 수 없습니다.");
        }
    }

    public int number() {
        return this.number;
    }

    public Quantity add(Quantity quantity) {
        return new Quantity(number + quantity.number);
    }
}
