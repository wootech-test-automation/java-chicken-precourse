package domain;

import java.util.Objects;
import message.ErrorMessage;

public class Order {
    public static final int LIMIT_QUANTITY = 99;
    private final int tableNumber;
    private final String menuName;
    private int quantity;
    private int totalPrice;
    private int discountPrice;

    public Order(final int tableNumber, final String menuName, final int quantity, final int price) {
        validate(quantity);
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
        validate(order.quantity);
        this.quantity += order.quantity;
        this.totalPrice += order.totalPrice;
        overrideDiscountPrice();
    }


    private void overrideDiscountPrice() {
        discountPrice = quantity / 10 * 10000;
    }

    private void validate(final int quantity) {
        if (quantity < 1 || this.quantity + quantity > LIMIT_QUANTITY) {
            throw new IllegalArgumentException(ErrorMessage.OUT_BOUNDS_QUANTITY);
        }
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

    @Override
    public String toString() {
        return menuName + " " + quantity + " " + totalPrice;
    }
}
