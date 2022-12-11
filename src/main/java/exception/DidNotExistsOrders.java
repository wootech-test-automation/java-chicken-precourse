package exception;

public class DidNotExistsOrders extends IllegalArgumentException {
    public DidNotExistsOrders(String s) {
        super(s);
    }
}
