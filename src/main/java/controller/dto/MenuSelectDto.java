package controller.dto;

import message.ErrorMessage;

public class MenuSelectDto {
    private int menuNumber;
    private int quantity;

    public MenuSelectDto(final String menuNumber, final String quantity) {
        try {
            this.menuNumber = Integer.parseInt(menuNumber);
            this.quantity = Integer.parseInt(quantity);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_ERROR);
        }
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public int getQuantity() {
        return quantity;
    }
}
