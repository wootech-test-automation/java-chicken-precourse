package view;

public class IoPrinter {
    private static final String TITLE_FORMAT = "## %s";

    protected static void println(final Object message) {
        System.out.println(message);
    }

    protected static void println() {
        println("");
    }

    protected static void printTitle(final Object title) {
        println(String.format(TITLE_FORMAT, title));
    }
}
