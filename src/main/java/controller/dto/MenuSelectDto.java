package controller.dto;

import message.ErrorMessage;

public class MenuSelectDto {
    private int menu;
    private int quantity;

    public MenuSelectDto(final String menu, final String quantity) {
        try {
            this.menu = Integer.parseInt(menu);
            this.quantity = Integer.parseInt(quantity);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_ERROR);
        }
    }

    public int getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
