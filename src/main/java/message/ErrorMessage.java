package message;

public class ErrorMessage {
    public static final String MENU_SELECT_ERROR = "[ERROR] 옳지 않은 메뉴 선택 입력입니다.";
    public static final String INVALID_NUMERIC_ERROR = "[ERROR] 숫자만 입력해야 합니다.";
    public static final String OUT_BOUNDS_TABLE_NUMBER = "[ERROR] 존재하는 테이블 번호를 입력해야 합니다.";
    public static final String NO_MENU_ERROR = "[ERROR] 존재하지 않는 메뉴 입니다.";
    public static final String OUT_BOUNDS_QUANTITY = "[ERROR] 주문 가능한 수량은 1 ~ 99개 입니다.";

    private ErrorMessage() {
    }
}
