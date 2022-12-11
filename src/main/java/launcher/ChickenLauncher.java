package launcher;

import domain.ChickenGame;
import exception.IllegalInputArgumentException;
import launcher.status.ChickenGameStatus;
import launcher.status.MainMenuGameStatus;
import view.InputView;
import view.OutputView;

public class ChickenLauncher {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ChickenGame chickenGame = new ChickenGame();

    private ChickenGameStatus chickenGameStatus = new MainMenuGameStatus(this);

    public void play() {
        while (chickenGameStatus.isRunnable()) {
            try {
                chickenGameStatus = chickenGameStatus.process();
            } catch (IllegalInputArgumentException e) {
                outputView.printError(e.getMessage());
            } catch (IllegalArgumentException | IllegalStateException e) {
                break;
            }
        }
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public ChickenGame getChickenGame() {
        return chickenGame;
    }
}
