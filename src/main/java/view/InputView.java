package view;

import camp.nextstep.edu.missionutils.Console;
import domain.type.Amount;
import domain.type.PaymentType;
import domain.type.Table;
import exception.IllegalInputArgumentException;
import java.util.IllegalFormatException;
import launcher.keyword.MainFeatureKeyword;

public class InputView extends View {

    private static final String NUMBER_FORMAT_MESSAGE = "숫자 형태로 입력해주세요.";
    public static final String REQUEST_MAIN_FEATURE = "## 메인화면\n"
            + "1 - 주문등록\n"
            + "2 - 결제하기\n"
            + "3 - 프로그램 종료\n"
            + "\n"
            + "## 원하는 기능을 선택하세요.";

    private static final String REQUEST_TABLE_NUMBER = "## 테이블을 선택하세요.";
    private static final String REQUEST_MENU_NUMBER = "## 등록할 메뉴를 선택하세요.";
    private static final String REQUEST_AMOUNT_NUMBER = "## 메뉴의 수량을 입력하세요.";

    public MainFeatureKeyword inputMainFeature() {
        print(REQUEST_MAIN_FEATURE);
        String line = Console.readLine();
        MainFeatureKeyword mainFeatureKeyword = MainFeatureKeyword.keywordOf(line);
        printEmptyLine();
        return mainFeatureKeyword;
    }


    public Table inputTableNumber() {
        try {
            print(REQUEST_TABLE_NUMBER);
            int number = Integer.parseInt(Console.readLine());
            Table table =  new Table(number);
            printEmptyLine();
            return table;
        } catch (IllegalFormatException e) {
            throw new IllegalInputArgumentException(NUMBER_FORMAT_MESSAGE);
        }
    }

    public int inputMenu() {
        try {
            print(REQUEST_MENU_NUMBER);
            int number = Integer.parseInt(Console.readLine());
            printEmptyLine();
            return number;
        } catch (IllegalFormatException e) {
            throw new IllegalInputArgumentException(NUMBER_FORMAT_MESSAGE);
        }
    }

    public Amount inputAmount() {
        try {
            print(REQUEST_AMOUNT_NUMBER);
            int number = Integer.parseInt(Console.readLine());
            printEmptyLine();
            return new Amount(number);
        } catch (IllegalFormatException e) {
            throw new IllegalInputArgumentException(NUMBER_FORMAT_MESSAGE);
        }
    }

    public PaymentType inputPay() {
        String line = Console.readLine();
        PaymentType paymentType = PaymentType.keywordOf(line);
        printEmptyLine();
        return paymentType;
    }
}
