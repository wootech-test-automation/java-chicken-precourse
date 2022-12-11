package launcher.context;

import domain.discount.Money;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.order.OrderRepository;
import domain.order.Orders;
import domain.payment.Payment;
import domain.quantity.Quantity;
import domain.table.Table;
import domain.table.TableRepository;
import java.util.List;

public class OrderSystemContext {

    public List<Table> findAllTable() {
        return TableRepository.tables();
    }


    public List<Menu> findAllMenu() {
        return MenuRepository.menus();
    }

    public Menu findMenuById(final int id) {
        return MenuRepository.findById(id);
    }

    public void orderMenu(Menu menu, Quantity quantity, Table selectedTable) {
        var order = new Order(quantity, menu);
        OrderRepository.setOrder(selectedTable, order);
    }

    public Orders findOrderByTable(Table selectedTable) {
        return OrderRepository.findOrdersByTable(selectedTable);
    }

    public List<Integer> findOrderedTableNumbers() {
        return OrderRepository.findOrderedTables();
    }

    public Money calculateOrderPrice(Payment payment, Table selectedTable) {
        return OrderRepository.findOrdersByTable(selectedTable)
                .calculateAll()
                .discount(payment.getDiscountPolicy());
    }

    public void initializeOrders(Table selectedTable) {
        OrderRepository.initializeByTable(selectedTable);

    }

}
