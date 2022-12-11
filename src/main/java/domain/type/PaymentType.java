package domain.type;

import exception.IllegalInputArgumentException;
import java.util.Arrays;

public enum PaymentType {
    CARD("1"),
    CACHE("2");

    private static final String ERROR_MESSAGE = "1, 2만 입력 가능합니다.";
    private final String keyword;

    PaymentType(String keyword) {
        this.keyword = keyword;
    }

    public static PaymentType keywordOf(String keyword) {
        return Arrays.stream(PaymentType.values())
                .filter(paymentType -> keyword.equals(paymentType.keyword))
                .findAny()
                .orElseThrow(() -> new IllegalInputArgumentException(ERROR_MESSAGE));
    }
}
