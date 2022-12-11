package domain.menu;

import domain.category.Category;

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
}