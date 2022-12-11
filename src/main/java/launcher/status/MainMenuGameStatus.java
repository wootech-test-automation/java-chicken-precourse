package launcher.status;

import launcher.ChickenLauncher;
import launcher.keyword.MainFeatureKeyword;

public class MainMenuGameStatus extends AbstractChickenGameStatus {

    public MainMenuGameStatus(ChickenLauncher context) {
        super(context);
    }

    @Override
    public ChickenGameStatus process() {
        MainFeatureKeyword mainFeatureKeyword = inputView.inputMainFeature();
        if (mainFeatureKeyword.equals(MainFeatureKeyword.ORDER)) {
            return new OrderTableListMenuStatus(context);
        }
        if (mainFeatureKeyword.equals(MainFeatureKeyword.PAY)) {
            return new PayTableListGameStatus(context);
        }
        // quit
        return new QuitStatus(context);
    }
}