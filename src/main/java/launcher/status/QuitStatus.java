package launcher.status;

import launcher.context.OrderSystemContext;

public class QuitStatus implements OrderSystemStatus {
    @Override
    public OrderSystemStatus next(OrderSystemContext context) {
        return null;
    }

    @Override
    public boolean runnable() {
        return false;
    }
}
