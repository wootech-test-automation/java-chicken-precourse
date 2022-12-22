package service;

import controller.dto.MenuSelectDto;
import domain.Menu;
import domain.Order;
import domain.repository.OrderRepository;
import exception.TableMenuEmptyException;
import java.util.List;
import message.ErrorMessage;

public class OrderService {
    public static final int CASH = 2;
    private final MenuService menuService = new MenuService();
    private final TableService tableService = new TableService();

    public List<Order> findAllByTableNumber(final int tableNumber) {
        List<Order> orders = OrderRepository.findAllByTableNumber(tableNumber);
        if (orders.isEmpty()) {
            throw new TableMenuEmptyException(ErrorMessage.NO_ORDER_MENU_ERROR);
        }
        return orders;
    }

    public int payOrders(final int validatePayment, final int tableNumber) {
        int payAmount = OrderRepository.findAllByTableNumber(tableNumber)
                .stream()
                .mapToInt(Order::getTotalPrice)
                .sum();
        OrderRepository.removeAllByTableNumber(tableNumber);
        tableService.removeOrderList(tableNumber);
        return calculatePayAmount(validatePayment, payAmount);
    }

    private int calculatePayAmount(final int validatePayment, final int payAmount) {
        if (validatePayment == CASH) {
            return (int) (payAmount - payAmount * (0.05));
        }
        return payAmount;
    }

    public void order(final MenuSelectDto menuSelectDto, final int tableNumber) {
        Menu findMenu = menuService.findMenu(menuSelectDto.getMenuNumber());
        OrderRepository.saveOrder(
                new Order(tableNumber,
                        findMenu.getName(),
                        findMenu.getCategory(),
                        menuSelectDto.getQuantity(),
                        findMenu.getPrice()));
        tableService.addOrdered(tableNumber);
    }
}
