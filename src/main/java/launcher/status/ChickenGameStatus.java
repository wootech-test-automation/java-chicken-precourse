package launcher.status;

public interface ChickenGameStatus {

    void process();

    default boolean isRunnable() {
        return true;
    }
}
