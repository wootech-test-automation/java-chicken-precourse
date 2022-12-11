package service;

import controller.dto.MenuSelectDto;
import domain.Order;

public class OrderService {
    private final MenuService menuService = new MenuService();

    public void order(final MenuSelectDto menuSelectDto, final int tableNumber) {
        validateMenu(menuSelectDto.getMenu());
    }

    private void validateMenu(final int menu) {
        menuService.findMenu(menu);
    }
}
