package domain.type;

import java.util.Objects;

public class Table {
    private final int number;

    private final boolean isOrdered;

    public Table(int number) {
        this.number = number;
        this.isOrdered = false;
    }

    public Table(int number, boolean isOrdered) {
        this.number = number;
        this.isOrdered = isOrdered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Table table = (Table) o;
        return number == table.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
