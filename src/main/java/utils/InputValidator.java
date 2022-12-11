package utils;

import message.ErrorMessage;

public class InputValidator {
    public static final String ORDER_NUMBER = "1";
    public static final String PAYMENT_NUMBER = "2";
    public static final String QUIT_NUMBER = "3";
    public static final int TABLE_ONE = 1;
    public static final int TABLE_TWO = 2;
    public static final int TABLE_THREE = 3;
    public static final int TABLE_FIVE = 5;
    public static final int TABLE_SIX = 6;
    public static final int TABLE_EIGHT = 8;

    private InputValidator() {
    }

    public static int validateMainSelect(final String userInput) {
        if (!userInput.equals(ORDER_NUMBER) && !userInput.equals(PAYMENT_NUMBER) && !userInput.equals(QUIT_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.MENU_SELECT_ERROR);
        }
        return Integer.parseInt(userInput);
    }

    public static int validateTableNumber(final String userInput, final int tableSize) {
        int tableNumber = validateNumber(userInput);
        if (tableNumber != TABLE_ONE
                && tableNumber != TABLE_TWO
                && tableNumber != TABLE_THREE
                && tableNumber != TABLE_FIVE
                && tableNumber != TABLE_SIX
                && tableNumber != TABLE_EIGHT) {
            throw new IllegalArgumentException(ErrorMessage.OUT_BOUNDS_TABLE_NUMBER);
        }
        return tableNumber;
    }

    private static int validateNumber(final String inputTableNumber) {
        try {
            return Integer.parseInt(inputTableNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_ERROR);
        }
    }
}
