package launcher.keyword;

import exception.IllegalInputArgumentException;
import java.util.Arrays;

public enum MainFeatureKeyword {
    ORDER("1"),
    PAY("2"),
    QUIT("3");

    private static final String ERROR_MESSAGE = "1, 2, 3만 입력해 주세요.";
    private final String keyword;

    MainFeatureKeyword(String keyword) {
        this.keyword = keyword;
    }

    public static MainFeatureKeyword keywordOf(String keyword) {
        return Arrays.stream(MainFeatureKeyword.values())
                .filter(mainFeatureKeyword -> keyword.equals(mainFeatureKeyword.keyword))
                .findAny()
                .orElseThrow(() -> new IllegalInputArgumentException(ERROR_MESSAGE));
    }
}
