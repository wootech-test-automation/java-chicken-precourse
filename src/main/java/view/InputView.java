package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String FUNCTION_SELECT = "## 원하는 기능을 선택하세요.";
    public static final String TABLE_SELECT = "## 주문할 테이블을 선택하세요.";

    public static String inputTableNumber() {
        System.out.println(TABLE_SELECT);
        return scanner.next();
    }

    public static String inputMain() {
        System.out.println(FUNCTION_SELECT);
        return scanner.next();
    }
}
