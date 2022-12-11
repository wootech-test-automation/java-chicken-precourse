package view;

import domain.type.Menu;
import domain.type.Order;
import domain.type.Table;

import java.util.List;

public class OutputView extends View {
    private static final String TOP_LINE = "┏ - ┓";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "┗ %s ┛";

    public void printTables(final List<Table> tables) {
        print("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
        printEmptyLine();
    }

    public void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            print(menu);
        }
        printEmptyLine();
    }

    public void printOrders(final List<Order> orders) {
        print("## 주문 내역");
        print("메뉴 수량 금액");
        for (Order order : orders) {
            print(order);
        }
        printEmptyLine();
    }

    public void printError(String message) {
        super.printError(message);
    }

    private void printBottomLine(List<Table> tables) {
        for (Table table : tables) {
            if (table.isOrdered()) {
                printf(BOTTOM_LINE, "#");
                continue;
            }
            printf(BOTTOM_LINE, "-");
        }
    }

    private void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            printf(line);
        }
        printEmptyLine();
    }

    private void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            printf(TABLE_FORMAT, table);
        }
        printEmptyLine();
    }

    public void printPrice(int calculatePrice) {
        print("## 최종 결제할 금액");
        print(String.format("%d원", calculatePrice));
        printEmptyLine();
    }
}
