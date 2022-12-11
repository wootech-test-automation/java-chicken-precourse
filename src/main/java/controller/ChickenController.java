package controller;

import controller.dto.MenuSelectDto;
import domain.Menu;
import domain.Order;
import domain.Table;
import java.util.List;
import org.mockito.internal.matchers.Or;
import service.MenuService;
import service.OrderService;
import service.TableService;
import utils.InputValidator;
import view.InputView;
import view.OutputView;

public class ChickenController {
    public static final int ORDER = 1;
    public static final int PAYMENT = 2;

    private final TableService tableService = new TableService();
    private final MenuService menuService = new MenuService();
    private final OrderService orderService = new OrderService();

    public void run() {
        try {
            OutputView.printMain();
            determineMainMenuSelection(InputValidator.validateMainSelect(InputView.inputMain()));
        } catch (IllegalArgumentException exception) {
            OutputView.printMessage(exception.getMessage());
            run();
        }
    }

    private void determineMainMenuSelection(final int validatedMainSelect) {
        try {
            requestTableNumber(validatedMainSelect);
        } catch (IllegalArgumentException exception) {
            OutputView.printMessage(exception.getMessage());
            determineMainMenuSelection(validatedMainSelect);
        }
    }

    private void requestTableNumber(final int validatedMainSelect) {
        List<Table> allCurrentTables = tableService.findAllCurrentTables();
        OutputView.printTables(allCurrentTables);
        int tableNumber = InputValidator.validateTableNumber(InputView.inputTableNumber(), allCurrentTables.size());
        if (validatedMainSelect == ORDER) {
            requestOrder(tableNumber);
        }
        if (validatedMainSelect == PAYMENT) {
            requestPayment(tableNumber);
        }
    }

    private void requestOrder(final int tableNumber) {
        try {
            orderService.order(requestInputMenu(), tableNumber);
            run();
        } catch (IllegalArgumentException exception) {
            OutputView.printMessage(exception.getMessage());
            requestOrder(tableNumber);
        }
    }

    private MenuSelectDto requestInputMenu() {
        OutputView.printMenus(menuService.finaAllCurrentMenus());
        return InputView.inputMenu();
    }

    private void requestPayment(final int tableNumber) {
        OutputView.printOrders(OrderService.findAllByTableNumber(tableNumber));
    }

}
