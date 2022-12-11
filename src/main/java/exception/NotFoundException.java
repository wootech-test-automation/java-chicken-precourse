package exception;

public class NotFoundException extends IllegalStateException {

    private static final String ERROR_MESSAGE = "%s를 찾을 수 없습니다.";

    public NotFoundException(String message) {
        super(String.format(ERROR_MESSAGE, message));
    }
}
