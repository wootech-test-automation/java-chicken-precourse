package launcher.status;

import launcher.context.OrderSystemContext;
import view.InputView;
import view.OutputView;

public class PaymentStatus implements OrderSystemStatus {
    @Override
    public OrderSystemStatus next(OrderSystemContext context) {
        OutputView.printTables(context.findAllTable(), context.findOrderedTableNumbers());

        var nowSelectedTable = InputView.readTable();

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
