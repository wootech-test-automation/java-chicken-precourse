package service;

import controller.dto.MenuSelectDto;
import domain.Menu;
import domain.Order;
import domain.repository.OrderRepository;
import java.util.List;

public class OrderService {
    private final MenuService menuService = new MenuService();
    private final TableService tableService = new TableService();

    public static List<Order> findAllByTableNumber(final int tableNumber) {
        return OrderRepository.findAllByTableNumber(tableNumber);
    }

    public void order(final MenuSelectDto menuSelectDto, final int tableNumber) {
        Menu findMenu = menuService.findMenu(menuSelectDto.getMenuNumber());
        OrderRepository.saveOrder(
                new Order(tableNumber, findMenu.getName(), menuSelectDto.getQuantity(), findMenu.getPrice()));
        tableService.addOrdered(tableNumber);
    }
}
