package launcher.status;

import launcher.ChickenLauncher;

public class QuitStatus extends AbstractChickenGameStatus {

    public QuitStatus(ChickenLauncher context) {
        super(context);
    }

    @Override
    public ChickenGameStatus process() {
        return null;
    }

    @Override
    public boolean isRunnable() {
        return false;
    }
}
