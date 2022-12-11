package domain;

public class Order {
    private final int tableNumber;
    private final String menuName;
    private final int quantity;
    private final int totalPrice;

    public Order(final int tableNumber, final String menuName, final int quantity, final int price) {
        this.tableNumber = tableNumber;
        this.menuName = menuName;
        this.quantity = quantity;
        this.totalPrice = quantity * price - (quantity / 10 * 10000);
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean containsTableNumber(final int tableNumber) {
        return this.tableNumber == tableNumber;
    }
}
