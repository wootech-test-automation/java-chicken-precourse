package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String MAIN_MENU = "## 메인화면";
    private static final String ORDER = "1 - 주문등록";
    private static final String PAYMENT = "2 - 결제하기";
    private static final String QUIT = "3 - 프로그램 종료";
    public static final String TABLE_LIST = "## 테이블 목록";

    public static void printTables(final List<Table> tables) {
        System.out.println(TABLE_LIST);
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    public static void printMain() {
        System.out.println(MAIN_MENU);
        System.out.println(ORDER);
        System.out.println(PAYMENT);
        System.out.println(QUIT);
        System.out.println();
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMessage(final String message) {
        System.out.println(message);
    }
}
