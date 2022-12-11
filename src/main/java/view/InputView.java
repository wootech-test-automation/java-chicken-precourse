package view;

import camp.nextstep.edu.missionutils.Console;
import domain.payment.Payment;
import domain.quantity.Quantity;
import domain.table.Table;
import exception.InvalidInputException;
import java.util.NoSuchElementException;
import launcher.code.MainMenu;

public class InputView extends IoPrinter {

    public static int inputTableNumber() {
        return 0;
    }

    public static MainMenu readMainMenuCommand() {
        printTitle("메인화면");
        println(MainMenu.messages());
        println();
        printTitle("원하는 기능을 선택하세요");
        return MainMenu.from(readLineAfterNewLine());
    }

    private static String readLineAfterNewLine() {
        final var input = readLine();
        println();
        return input;
    }

    private static String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalStateException();
        }
    }

    public static Table readTable() {
        printTitle("테이블을 선택하세요.");
        return new Table(readLineToInteger());
    }

    public static int readLineToInteger() {
        try {
            return Integer.parseInt(readLineAfterNewLine());
        } catch (Exception exception) {
            throw new InvalidInputException("정수만 입력할 수 있습니다.");
        }
    }

    public static int readMenu() {
        printTitle("등록할 메뉴를 선택하세요.");
        return readLineToInteger();
    }

    public static Quantity readQuantity() {
        printTitle("메뉴의 수량을 입력하세요.");
        return new Quantity(readLineToInteger());
    }

    public static Payment readPayments(Table nowSelectedTable) {
        printTitle(String.format("%s번 테이블의 결제를 진행합니다", nowSelectedTable.number()));
        printTitle(Payment.messages());
        return Payment.from(readLineAfterNewLine());
    }
}
