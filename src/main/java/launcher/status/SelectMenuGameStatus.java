package launcher.status;

import domain.type.Menu;
import domain.type.Table;
import exception.IllegalInputArgumentException;
import java.util.List;
import launcher.ChickenLauncher;

public class SelectMenuGameStatus extends AbstractChickenGameStatus {

    private static final String ERROR_MESSAGE = "존재하지 않는 메뉴를 입력하셨습니다.";
    private final Table table;

    public SelectMenuGameStatus(ChickenLauncher context, Table table) {
        super(context);
        this.table = table;

    }

    @Override
    public ChickenGameStatus process() {
        List<Menu> menus = chickenGame.getMenus();
        outputView.printMenus(menus);
        int menuNumber = inputView.inputMenu();
        Menu menu = getMenu(menus, menuNumber);
        return new SelectAmountMenu(context, table, menu);
    }

    private Menu getMenu(List<Menu> menus, int number) {
        return menus.stream()
                .filter(menu -> menu.getNumber() == number)
                .findAny()
                .orElseThrow(() -> new IllegalInputArgumentException(ERROR_MESSAGE));
    }
}
