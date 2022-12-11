package view;

import controller.dto.MenuSelectDto;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String FUNCTION_SELECT = "## 원하는 기능을 선택하세요.";
    public static final String TABLE_SELECT = "## 테이블을 선택하세요.";
    public static final String MENU_ORDER = "## 등록할 메뉴를 선택하세요.";
    public static final String QUANTITY = "## 메뉴의 수량을 입력하세요.";

    public static String inputTableNumber() {
        System.out.println();
        System.out.println(TABLE_SELECT);
        return scanner.next();
    }

    public static String inputMain() {
        System.out.println(FUNCTION_SELECT);
        return scanner.next();
    }

    public static MenuSelectDto inputMenu() {
        System.out.println();
        System.out.println(MENU_ORDER);
        String menu = scanner.next();
        System.out.println();
        System.out.println(QUANTITY);
        String quantity = scanner.next();

        return new MenuSelectDto(menu, quantity);
    }
}
