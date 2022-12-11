package launcher.context;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.order.OrderRepository;
import domain.order.Orders;
import domain.quantity.Quantity;
import domain.table.Table;
import domain.table.TableRepository;
import java.util.List;

public class OrderSystemContext {
    private Table selectedTable;

    public List<Table> findAllTable() {
        return TableRepository.tables();
    }

    public void selectTable(Table table) {
        this.selectedTable = TableRepository.findByTable(table);
    }

    public Table getNowSelectedTable() {
        return selectedTable;
    }

    public List<Menu> findAllMenu() {
        return MenuRepository.menus();
    }

    public Menu findMenuById(final int id) {
        return MenuRepository.findById(id);
    }

    public void purchaseQuantity(Quantity readStock) {

    }

    public void findAllOrderList() {

    }

    public void orderMenu(Menu menu, Quantity quantity) {
        var order = new Order(quantity, menu);
        OrderRepository.setOrder(selectedTable, order);
    }

    public Orders findOrderByTable() {
        return OrderRepository.findOrderByTable(selectedTable);
    }
}
