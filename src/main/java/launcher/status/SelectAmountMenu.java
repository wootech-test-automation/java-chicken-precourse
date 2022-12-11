package launcher.status;

import domain.type.Amount;
import domain.type.Menu;
import domain.type.Order;
import domain.type.Table;
import launcher.ChickenLauncher;

public class SelectAmountMenu extends AbstractChickenGameStatus {

    private final Table table;
    private final Menu menu;

    public SelectAmountMenu(ChickenLauncher context, Table table, Menu menu) {
        super(context);
        this.table = table;
        this.menu = menu;
    }

    @Override
    public ChickenGameStatus process() {
        Amount amount = inputView.inputAmount();
        Order order = new Order(new Table(table.getNumber(), true), menu, amount);
        chickenGame.saveOrder(order);
        return new MainMenuGameStatus(context);
    }
}
