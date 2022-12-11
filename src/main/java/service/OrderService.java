package service;

import controller.dto.MenuSelectDto;
import domain.Menu;
import domain.Order;
import domain.repository.OrderRepository;

public class OrderService {
    private final MenuService menuService = new MenuService();

    public void order(final MenuSelectDto menuSelectDto, final int tableNumber) {
        Menu findMenu = menuService.findMenu(menuSelectDto.getMenuNumber());
        OrderRepository.saveOrder(
                new Order(tableNumber, findMenu.getName(), menuSelectDto.getQuantity(), findMenu.getPrice()));
    }
}
