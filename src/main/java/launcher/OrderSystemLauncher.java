package launcher;

import exception.InvalidInputException;
import launcher.context.OrderSystemContext;
import launcher.status.InitStatus;
import launcher.status.OrderSystemStatus;
import launcher.status.QuitStatus;
import view.OutputView;

public class OrderSystemLauncher {

    private final OrderSystemContext context = new OrderSystemContext();
    private OrderSystemStatus orderSystemStatus = new InitStatus();

    public void execute() {
        while (orderSystemStatus.runnable()) {
            try {
                orderSystemStatus = orderSystemStatus.next(context);
            } catch (InvalidInputException exception) {
                OutputView.error(exception.getMessage());
            } catch (IllegalStateException exception) {
                OutputView.error(exception.getMessage());
                orderSystemStatus = new QuitStatus();
            }
        }
    }
}
