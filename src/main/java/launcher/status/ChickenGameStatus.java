package launcher.status;

public interface ChickenGameStatus {

    ChickenGameStatus process();

    default boolean isRunnable() {
        return true;
    }
}
