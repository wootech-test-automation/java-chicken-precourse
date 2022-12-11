package launcher.status;

import domain.table.Table;
import exception.InvalidInputException;
import launcher.context.OrderSystemContext;
import view.InputView;
import view.OutputView;

public class SetOrderStatus implements OrderSystemStatus {
    @Override
    public OrderSystemStatus next(OrderSystemContext context) {
        OutputView.printTables(context.findAllTable(), context.findOrderedTableNumbers());

        var selectedTable = InputView.readTable();
        return process(context, selectedTable);
    }

    private OrderSystemStatus process(OrderSystemContext context, Table selectedTable) {
        while (true) {
            try {
                OutputView.printMenus(context.findAllMenu());
                var menu = context.findMenuById(InputView.readMenu());
                var quantity = InputView.readQuantity();
                context.orderMenu(menu, quantity, selectedTable);
                return new SelectMenuStatus();
            } catch (InvalidInputException exception) {
                OutputView.error(exception.getMessage());
            }
        }
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
