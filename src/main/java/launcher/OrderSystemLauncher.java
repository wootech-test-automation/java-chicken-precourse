package launcher;

import launcher.context.OrderSystemContext;
import launcher.status.InitStatus;
import launcher.status.OrderSystemStatus;

public class OrderSystemLauncher {

    private final OrderSystemContext context = new OrderSystemContext();
    private OrderSystemStatus orderSystemStatus = new InitStatus();

    public void execute() {
        while (orderSystemStatus.runnable()) {
            orderSystemStatus = orderSystemStatus.next(context);
        }
    }
}
