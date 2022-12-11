
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
                    var input = new String[]{"1","1","1","1", "1","1","21","1","2","1","1","3"};
                    var expected = new String[]{
                            "┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓",
                            "| 1 || 2 || 3 || 5 || 6 || 8 |",
                            "┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛",
                            "[치킨] 1 - 후라이드 : 16000원",
                            "[치킨] 2 - 양념치킨 : 16000원",
                            "[치킨] 3 - 반반치킨 : 16000원",
                            "[치킨] 4 - 통구이 : 16000원",
                            "[치킨] 5 - 간장치킨 : 17000원",
                            "[치킨] 6 - 순살치킨 : 17000원",
                            "[음료] 21 - 콜라 : 1000원",
                            "[음료] 22 - 사이다 : 1000원",
                            "## 테이블 목록",
                            "┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓",
                            "| 1 || 2 || 3 || 5 || 6 || 8 |",
                            "┗ # ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛",
                            "[치킨] 1 - 후라이드 : 16000원",
                            "[치킨] 2 - 양념치킨 : 16000원",
                            "[치킨] 3 - 반반치킨 : 16000원",
                            "[치킨] 4 - 통구이 : 16000원",
                            "[치킨] 5 - 간장치킨 : 17000원",
                            "[치킨] 6 - 순살치킨 : 17000원",
                            "[음료] 21 - 콜라 : 1000원",
                            "[음료] 22 - 사이다 : 1000원",
                            "## 테이블 목록",
                            "┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓",
                            "| 1 || 2 || 3 || 5 || 6 || 8 |",
                            "┗ # ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛",
                            "## 주문 내역",
                            "메뉴 수량 금액",
                            "후라이드 1 16000",
                            "콜라 1 1000",
                            "17000원"

                    };
                    run(input);
                    assertThat(output()).contains(expected);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(
                () -> {
                    runException("-1");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
