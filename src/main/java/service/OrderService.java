package service;

import controller.dto.MenuSelectDto;
import domain.Menu;
import domain.Order;
import domain.repository.OrderRepository;
import exception.TableMenuEmptyException;
import java.util.List;
import message.ErrorMessage;

public class OrderService {
    private final MenuService menuService = new MenuService();
    private final TableService tableService = new TableService();

    public static List<Order> findAllByTableNumber(final int tableNumber) {
        List<Order> orders = OrderRepository.findAllByTableNumber(tableNumber);
        if (orders.isEmpty()) {
            throw new TableMenuEmptyException(ErrorMessage.NO_ORDER_MENU_ERROR);
        }
        return orders;
    }

    public void order(final MenuSelectDto menuSelectDto, final int tableNumber) {
        Menu findMenu = menuService.findMenu(menuSelectDto.getMenuNumber());
        OrderRepository.saveOrder(
                new Order(tableNumber, findMenu.getName(), menuSelectDto.getQuantity(), findMenu.getPrice()));
        tableService.addOrdered(tableNumber);
    }
}
