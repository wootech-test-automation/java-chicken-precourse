package view;

import camp.nextstep.edu.missionutils.Console;
import controller.dto.MenuSelectDto;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String FUNCTION_SELECT = "## 원하는 기능을 선택하세요.";
    public static final String TABLE_SELECT = "## 테이블을 선택하세요.";
    public static final String MENU_ORDER = "## 등록할 메뉴를 선택하세요.";
    public static final String QUANTITY = "## 메뉴의 수량을 입력하세요.";
    public static final String PAYMENT_PROCESS = "## %d번 테이블의 결제를 진행합니다.\n";
    public static final String PAYMENT_TOOLS = "## 신용 카드는 1번, 현금은 2번";

    public static String inputTableNumber() {
        System.out.println();
        System.out.println(TABLE_SELECT);
        return Console.readLine();
    }

    public static String inputMain() {
        System.out.println(FUNCTION_SELECT);
        return Console.readLine();
    }

    public static MenuSelectDto inputMenu() {
        System.out.println();
        System.out.println(MENU_ORDER);
        String menu = Console.readLine();
        System.out.println();
        System.out.println(QUANTITY);
        String quantity = Console.readLine();

        return new MenuSelectDto(menu, quantity);
    }

    public static String inputPaymentTools(final int tableNumber) {
        System.out.println();
        System.out.printf(PAYMENT_PROCESS, tableNumber);
        System.out.println(PAYMENT_TOOLS);
        return Console.readLine();
    }
}
