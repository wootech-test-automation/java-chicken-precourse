package domain.order;

import domain.table.Table;
import domain.table.TableRepository;
import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    private static final Map<Table, Orders> tableByOrders = new HashMap<>();

    static {
        TableRepository.tables().forEach(table -> tableByOrders.put(table, new Orders()));
    }

    public static void setOrder(final Table table, final Order order) {
        findOrdersByTable(table).addOrder(order);
    }

    private static Orders findOrdersByTable(final Table table) {
        return tableByOrders.get(table);
    }


    public static Orders findOrderByTable(Table selectedTable) {
        return tableByOrders.get(selectedTable);
    }
}
