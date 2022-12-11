package launcher.status;


import launcher.context.OrderSystemContext;
import view.InputView;
import view.OutputView;

public class SelectTableStatus implements OrderSystemStatus {
    private final OrderSystemStatus nextStatus;

    public SelectTableStatus(OrderSystemStatus nextStatus) {
        this.nextStatus = nextStatus;
    }

    @Override
    public OrderSystemStatus next(OrderSystemContext context) {
        OutputView.printTables(context.findAllTable());
        var table = InputView.readTable();
        context.selectTable(table);
        return nextStatus;
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
