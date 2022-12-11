package launcher.status;

import domain.type.Order;
import domain.type.PaymentType;
import domain.type.Table;
import java.util.List;
import launcher.ChickenLauncher;

public class PayGameGameStatus extends AbstractChickenGameStatus {

    private final Table table;

    public PayGameGameStatus(ChickenLauncher context, Table table) {
        super(context);
        this.table = table;
    }

    @Override
    public ChickenGameStatus process() {
        List<Order> orders = chickenGame.getOrders(table);
        outputView.printOrders(orders);
        outputView.printPayTable(table);
        PaymentType paymentType = inputView.inputPay();
        int calculatePrice = chickenGame.calculatePrice(paymentType, orders);
        outputView.printPrice(calculatePrice);
        return new MainMenuGameStatus(context);
    }
}
