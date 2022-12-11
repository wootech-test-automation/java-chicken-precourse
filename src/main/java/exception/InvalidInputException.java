package exception;

public class InvalidInputException extends IllegalArgumentException {
    private static final String ERROR_FORMAT = "%s [input = %s]";

    public InvalidInputException(final String message, final String input) {
        super(String.format(ERROR_FORMAT, message, input));
    }

    public InvalidInputException(final String message) {
        super(message);
    }

    public InvalidInputException() {
        super("유효하지 않는 입력입니다.");
    }

}
