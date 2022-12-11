package domain.order;

import domain.category.Category;
import domain.menu.Menu;
import domain.quantity.Quantity;

public class Order {
    private static final String ORDER_RESULT_FORMAT = "%s %s %s";
    private final Quantity quantity;
    private final Menu menu;

    public Order(Quantity quantity, Menu menu) {
        this.quantity = quantity;
        this.menu = menu;
    }

    public String result() {
        return String.format(ORDER_RESULT_FORMAT, menu.getName(), quantity.number(), menu.price());
    }

    public int price() {
        return menu.price() * quantity.number();
    }

    public boolean existCategory(Category category) {
        return menu.sameCategory(category);
    }

    public int getQuantity() {
        return quantity.number();
    }
}
