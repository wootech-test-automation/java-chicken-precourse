package launcher.status;

import domain.table.Table;
import exception.DidNotExistsOrders;
import exception.InvalidInputException;
import launcher.context.OrderSystemContext;
import view.InputView;
import view.OutputView;

public class PaymentStatus implements OrderSystemStatus {
    @Override
    public OrderSystemStatus next(OrderSystemContext context) {
        OutputView.printTables(context.findAllTable(), context.findOrderedTableNumbers());

        var nowSelectedTable = InputView.readTable();

        return process(context, nowSelectedTable);
    }

    private OrderSystemStatus process(OrderSystemContext context, Table nowSelectedTable) {
        while (true) {
            try {
                return paymentProcess(context, nowSelectedTable);
            } catch (DidNotExistsOrders exception) {
                OutputView.error(exception.getMessage());
                return new SelectMenuStatus();
            } catch (InvalidInputException exception) {
                OutputView.error(exception.getMessage());
            }
        }
    }

    private SelectMenuStatus paymentProcess(OrderSystemContext context, Table nowSelectedTable) {
        OutputView.printOrderList(context.findOrderByTable(nowSelectedTable));

        var price = context.calculateOrderPrice(InputView.readPayments(nowSelectedTable), nowSelectedTable);
        
        OutputView.printFinalPaymentAmount(price);
        context.initializeOrders(nowSelectedTable);
        return new SelectMenuStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
