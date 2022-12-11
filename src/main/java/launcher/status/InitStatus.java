package launcher.status;

import launcher.context.OrderSystemContext;

public class InitStatus implements OrderSystemStatus {
    @Override
    public OrderSystemStatus next(OrderSystemContext context) {
        return new QuitStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
