package domain.menu;

import domain.category.Category;
import java.util.Objects;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    public String getName() {
        return name;
    }

    public int price() {
        return price;
    }

    public boolean sameId(int id) {
        return number == id;
    }

    public boolean sameCategory(Category category) {
        return this.category == category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return number == menu.number && price == menu.price && Objects.equals(getName(), menu.getName())
                && category == menu.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, getName(), category, price);
    }
}
