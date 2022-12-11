package controller;

import domain.Table;
import java.util.List;
import service.TableService;
import utils.InputValidator;
import view.InputView;
import view.OutputView;

public class ChickenController {
    public static final int ORDER = 1;
    public static final int PAYMENT = 2;

    private final TableService tableService = new TableService();

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

    private void requestPayment(final int tableNumber) {

    }

    private void requestOrder(final int tableNumber) {
    }
}
