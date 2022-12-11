package view;

public class View {

    private static final String ERROR = "[ERROR]";

    protected void print(String message) {
        System.out.println(message);
    }

    protected void print(Object object) {
        System.out.println(object);
    }

    protected void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    protected void printEmptyLine() {
        System.out.println();
    }

    protected void printError(String message) {
        System.out.println(ERROR + " " + message);
    }
}
