package launcher.status;

import launcher.context.OrderSystemContext;
import view.InputView;

public class SelectMenuStatus implements OrderSystemStatus {
    @Override
    public OrderSystemStatus next(OrderSystemContext context) {
        var mainMenuCommand = InputView.readMainMenuCommand();
        
        return mainMenuCommand.nextStatus();
    }


    @Override
    public boolean runnable() {
        return true;
    }
}
