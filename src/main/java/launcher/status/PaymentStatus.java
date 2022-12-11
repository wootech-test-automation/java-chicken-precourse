package launcher.status;

import launcher.context.OrderSystemContext;
import view.InputView;
import view.OutputView;

public class PaymentStatus implements OrderSystemStatus {
    @Override
    public OrderSystemStatus next(OrderSystemContext context) {
        OutputView.printOrderList(context.findOrderByTable());

        var nowSelectedTable = context.nowSelectedTable();
        var price = context.calculateOrderPrice(InputView.readPayments(nowSelectedTable));

        OutputView.printFinalPaymentAmount(price);

        context.initializeOrders();
        return new SelectMenuStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
