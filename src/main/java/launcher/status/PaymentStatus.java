package launcher.status;

import launcher.context.OrderSystemContext;
import view.InputView;
import view.OutputView;

public class PaymentStatus implements OrderSystemStatus {
    @Override
    public OrderSystemStatus next(OrderSystemContext context) {
        OutputView.printOrderList();

        var price = context.calculateOrderPrice(InputView.readPayments());

        OutputView.printFinalPaymentAmount(price);
        
        return new SelectMenuStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
