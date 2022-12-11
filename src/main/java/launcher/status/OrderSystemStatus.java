package launcher.status;

import launcher.context.OrderSystemContext;

public interface OrderSystemStatus {
    OrderSystemStatus next(OrderSystemContext context);

    boolean runnable();
}
