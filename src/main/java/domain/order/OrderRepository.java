package domain.order;

import domain.table.Table;
import domain.table.TableRepository;
import exception.InvalidInputException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRepository {
    private static final Map<Table, Orders> tableByOrders = new HashMap<>();

    static {
        TableRepository.tables().forEach(table -> tableByOrders.put(table, new Orders()));
    }

    public static void setOrder(final Table table, final Order order) {
        var orders = tableByOrders.get(table);
        orders.addOrder(order);
    }


    public static Orders findOrdersByTable(Table selectedTable) {
        var orders = tableByOrders.get(selectedTable);
        if (orders.isRegisterOrder()) {
            return orders;
        }
        throw new InvalidInputException("해당 테이블에는 주문이 존재하지 않습니다.");
    }

    public static List<Integer> findOrderedTables() {
        return tableByOrders.entrySet().stream()
                .filter(tableOrdersEntry -> tableOrdersEntry.getValue().isRegisterOrder())
                .map(tableOrdersEntry -> tableOrdersEntry.getKey().number())
                .collect(Collectors.toList());
    }
}
