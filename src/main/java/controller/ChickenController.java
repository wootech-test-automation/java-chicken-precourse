package controller;

import utils.InputValidator;
import view.InputView;
import view.OutputView;

public class ChickenController {

    public void run() {
        try {
            OutputView.printMain();
            determineMainMenuSelection(InputValidator.validateMainSelect(InputView.inputMain()));
        } catch (IllegalArgumentException exception) {
            OutputView.printMessage(exception.getMessage());
        }
    }

    private void determineMainMenuSelection(final int validateMainSelect) {

    }
}
