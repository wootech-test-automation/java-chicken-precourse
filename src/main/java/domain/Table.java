package domain;

public class Table {
    private final int number;
    private boolean ordered;

    public Table(final int number) {
        this.number = number;
    }

    public void orderTable() {
        ordered = true;
    }

    public boolean isOrdered() {
        return ordered;
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
