package launcher.status;

import domain.ChickenGame;
import launcher.ChickenLauncher;
import view.InputView;
import view.OutputView;

public abstract class AbstractChickenGameStatus implements ChickenGameStatus {

    protected final ChickenLauncher context;
    protected final ChickenGame chickenGame;
    protected final InputView inputView;
    protected final OutputView outputView;

    public AbstractChickenGameStatus(ChickenLauncher context) {
        this.context = context;
        this.chickenGame = context.getChickenGame();
        this.inputView = context.getInputView();
        this.outputView = context.getOutputView();
    }
}
