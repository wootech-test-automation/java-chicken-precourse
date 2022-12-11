package exception;

public class IllegalInputArgumentException extends IllegalArgumentException {


    private static final String ERROR_MESSAGE = "잘못된 입력입니다.";

    public IllegalInputArgumentException(String message) {
        super(ERROR_MESSAGE + message);
    }
}
