package utils;

import message.ErrorMessage;

public class InputValidator {
    public static final String ORDER_NUMBER = "1";
    public static final String PAYMENT_NUMBER = "2";
    public static final String QUIT_NUMBER = "3";

    private InputValidator() {
    }

    public static int validateMainSelect(final String userInput) {
        if (!userInput.equals(ORDER_NUMBER) && !userInput.equals(PAYMENT_NUMBER) && !userInput.equals(QUIT_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.MENU_SELECT_ERROR);
        }
        return Integer.parseInt(userInput);
    }
}
