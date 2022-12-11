package view;

import camp.nextstep.edu.missionutils.Console;
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
}
