import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        // 지우고 시작
        System.out.println("┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓");
        System.out.println("| 1 || 2 || 3 || 5 || 6 || 8 |");
        System.out.println("┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛");
        System.out.println("[치킨] 1 - 후라이드 : 16000원");
        System.out.println("[치킨] 2 - 양념치킨 : 16000원");
        System.out.println("[치킨] 3 - 반반치킨 : 16000원");
        System.out.println("[치킨] 4 - 통구이 : 16000원");
        System.out.println("[치킨] 5 - 간장치킨 : 17000원");
        System.out.println("[치킨] 6 - 순살치킨 : 17000원");
        System.out.println("[음료] 21 - 콜라 : 1000원");
        System.out.println("[음료] 22 - 사이다 : 1000원");
        System.out.println("## 테이블 목록");
        System.out.println("┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓");
        System.out.println("| 1 || 2 || 3 || 5 || 6 || 8 |");
        System.out.println("┗ # ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛");
        System.out.println("[치킨] 1 - 후라이드 : 16000원");
        System.out.println("[치킨] 2 - 양념치킨 : 16000원");
        System.out.println("[치킨] 3 - 반반치킨 : 16000원");
        System.out.println("[치킨] 4 - 통구이 : 16000원");
        System.out.println("[치킨] 5 - 간장치킨 : 17000원");
        System.out.println("[치킨] 6 - 순살치킨 : 17000원");
        System.out.println("[음료] 21 - 콜라 : 1000원");
        System.out.println("[음료] 22 - 사이다 : 1000원");
        System.out.println("## 테이블 목록");
        System.out.println("┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓┏ - ┓");
        System.out.println("| 1 || 2 || 3 || 5 || 6 || 8 |");
        System.out.println("┗ # ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛┗ - ┛");
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        System.out.println("후라이드 1 16000");
        System.out.println("콜라 1 1000");
        System.out.println("17000원");
    }
}
