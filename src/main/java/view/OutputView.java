package view;

import domain.discount.Money;
import domain.menu.Menu;
import domain.order.Orders;
import domain.table.Table;
import java.util.List;

public class OutputView extends IoPrinter {
    private static final String TOP_LINE = "┏ - ┓";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "┗ %s ┛";
    private static final String ORDER_COLUMN_FORMAT = "메뉴 수량 금액";
    private static final String DASH = "-";
    private static final String HASH = "#";

    public static void printTables(final List<Table> tables, List<Integer> orderedTableNumbers) {
        printTitle("테이블 목록");
        printTable(tables, orderedTableNumbers);
        println();
    }

    private static void printTable(List<Table> tables, List<Integer> orderedTableNumbers) {
        printLine(TOP_LINE, tables.size());
        printTableNumbers(tables);
        printTableBottom(tables, orderedTableNumbers);
    }

    private static void printTableBottom(List<Table> tables, List<Integer> orderedTableNumbers) {
        for (final Table table : tables) {
            System.out.printf(BOTTOM_LINE, isContains(orderedTableNumbers, table));
        }
        System.out.println();
    }

    private static String isContains(List<Integer> orderedTableNumbers, Table table) {
        if (orderedTableNumbers.contains(table.number())) {
            return HASH;
        }
        return DASH;
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
        println();
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

    public static void printOrderList(final Orders orders) {
        printTitle("주문 내역");
        println("메뉴 수량 금액");
        println(orders.result());
        println();
    }

    public static void printFinalPaymentAmount(Money price) {
        printTitle("최종 결제 금액");
        println(price.result());
        println();
    }

    public static void error(String message) {
        println("[ERROR]" + message);
    }
}
