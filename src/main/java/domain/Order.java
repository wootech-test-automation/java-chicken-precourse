package domain;

import java.util.Objects;

public class Order {
    private final int tableNumber;
    private final String menuName;
    private int quantity;
    private int totalPrice;
    private int discountPrice;

    public Order(final int tableNumber, final String menuName, final int quantity, final int price) {
        this.tableNumber = tableNumber;
        this.menuName = menuName;
        this.quantity = quantity;
        this.totalPrice = quantity * price;
        discountPrice = (quantity / 10 * 10000);
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
        return totalPrice - discountPrice;
    }

    public boolean containsTableNumber(final int tableNumber) {
        return this.tableNumber == tableNumber;
    }

    public void addOrder(final Order order) {
        this.quantity += order.quantity;
        this.totalPrice += order.totalPrice;
        overrideDiscountPrice();
    }

    private void overrideDiscountPrice() {
        discountPrice = quantity / 10 * 10000;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return tableNumber == order.tableNumber && Objects.equals(menuName, order.menuName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableNumber, menuName);
    }
}
