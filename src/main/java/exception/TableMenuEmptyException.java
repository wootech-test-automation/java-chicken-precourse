package exception;

public class TableMenuEmptyException extends RuntimeException {
    public TableMenuEmptyException(String message) {
        super(message);
    }
}
