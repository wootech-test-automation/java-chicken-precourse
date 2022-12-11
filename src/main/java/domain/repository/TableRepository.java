package domain.repository;

import domain.type.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static void setTable(Table table, boolean bool) {
        for (int i = 0; i < tables.size(); ++i) {
            Table existTable = tables.get(i);
            if (existTable.equals(table)) {
                tables.set(i, new Table(table.getNumber(), bool));
            }
        }
    }
}
