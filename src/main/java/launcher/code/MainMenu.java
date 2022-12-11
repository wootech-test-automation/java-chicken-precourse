package launcher.code;

import exception.InvalidInputException;
import java.util.Arrays;
import java.util.stream.Collectors;
import launcher.status.OrderSystemStatus;
import launcher.status.PaymentStatus;
import launcher.status.QuitStatus;
import launcher.status.SelectTableStatus;
import launcher.status.SetOrderStatus;

public enum MainMenu {
    MENU_1("1", "주문등록", new SelectTableStatus(new SetOrderStatus())),
    MENU_2("2", "결제하기", new SelectTableStatus(new PaymentStatus())),
    MENU_3("3", "프로그램 종료", new QuitStatus());

    private final String command;
    private final String message;
    private final OrderSystemStatus nextStatus;

    MainMenu(String command, String message, OrderSystemStatus nextStatus) {
        this.command = command;
        this.message = message;
        this.nextStatus = nextStatus;
    }

    public static String messages() {
        return Arrays.stream(values())
                .map(mainMenu -> String.format("%s - %s", mainMenu.command, mainMenu.message))
                .collect(Collectors.joining("\n"));
    }

    public static MainMenu from(final String input) {
        return Arrays.stream(values())
                .filter(mainMenu -> mainMenu.command.equals(input.trim()))
                .findAny()
                .orElseThrow(() -> new InvalidInputException("유효하지 않는 명령어 입니다", input));
    }

    public OrderSystemStatus nextStatus() {
        return nextStatus;
    }
}
