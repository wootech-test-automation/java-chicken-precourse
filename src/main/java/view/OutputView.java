package view;

import domain.Menu;
import domain.Table;
import java.util.List;

public class OutputView extends IoPrinter {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
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

    public static void printOrderList() {
        println("## 주문 내역\n"
                + "메뉴 수량 금액\n"
                + "후라이드 1 16000\n"
                + "콜라 1 1000");
    }

    public static void printFinalPaymentAmount() {
        printTitle("최종 결제 금액");
        println("170000원");
    }
}
