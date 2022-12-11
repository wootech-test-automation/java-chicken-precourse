package domain.type;

import java.util.Objects;

public class Order {

    private final Table table;
    private final Menu menu;
    private final Amount amount;

    public Order(Table table, Menu menu, Amount amount) {
        this.table = table;
        this.menu = menu;
        this.amount = amount;
    }

    public boolean equalMenu(Order order) {
        return this.menu.equals(order.getMenu());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(table, order.table) && Objects.equals(menu, order.menu)
                && Objects.equals(amount, order.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, menu, amount);
    }

    public int getTotalCount() {
        return amount.intValue();
    }

    public int getTotalPrice() {
        return menu.getPrice() * amount.intValue();
    }

    public Amount getAmount() {
        return amount;
    }

    public Menu getMenu() {
        return menu;
    }

    public Table getTable() {
        return table;
    }

    public boolean isChicken() {
        return menu.getCategory().equals(Category.CHICKEN);
    }

    @Override
    public String toString() {
        return menu.getName() + " " + amount.intValue() + " " + getTotalPrice();
    }
}
