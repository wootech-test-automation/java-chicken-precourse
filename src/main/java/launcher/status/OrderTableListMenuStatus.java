package launcher.status;

import domain.type.Table;
import exception.IllegalInputArgumentException;
import java.util.List;
import launcher.ChickenLauncher;

public class OrderTableListMenuStatus extends AbstractChickenGameStatus {

    private static final String ERROR_MESSAGE = "테이블에 없는 값을 입력했습니다.";

    public OrderTableListMenuStatus(ChickenLauncher context) {
        super(context);
    }

    @Override
    public ChickenGameStatus process() {
        List<Table> tables = chickenGame.getTables();
        outputView.printTables(tables);
        Table table = inputView.inputTableNumber();
        validateTable(tables, table);
        return new SelectMenuGameStatus(context, table);
    }

    private void validateTable(List<Table> tables, Table table) {
        if (!tables.contains(table)) {
            throw new IllegalInputArgumentException(ERROR_MESSAGE);
        }
    }
}
