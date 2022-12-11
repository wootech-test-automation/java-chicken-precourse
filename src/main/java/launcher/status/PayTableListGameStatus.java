package launcher.status;

import domain.type.Table;
import exception.IllegalInputArgumentException;
import java.util.List;
import launcher.ChickenLauncher;

public class PayTableListGameStatus extends AbstractChickenGameStatus {

    private static final String ERROR_EMPTY_TABLE = "테이블에 없는 값을 입력했습니다.";
    private static final String ERROR_CANNOT_PAY_TABLE = "빈 테이블을 결제할 수 없습니다. 처음으로 돌아갑니다.";

    public PayTableListGameStatus(ChickenLauncher context) {
        super(context);
    }

    @Override
    public ChickenGameStatus process() {
        List<Table> tables = chickenGame.getTables();
        outputView.printTables(tables);
        Table table = inputView.inputTableNumber();
        validateTable(tables, table);
        if (isNotOrderedTable(tables, table)) {
            return new MainMenuGameStatus(context);
        }
        return new PayGameGameStatus(context, table);
    }

    private void validateTable(List<Table> tables, Table table) {
        if (!tables.contains(table)) {
            throw new IllegalInputArgumentException(ERROR_EMPTY_TABLE);
        }
    }

    private boolean isNotOrderedTable(List<Table> tables, Table table) {
        for (Table existTable : tables) {
            if (existTable.equals(table) && !existTable.isOrdered()) {
                outputView.printError(ERROR_CANNOT_PAY_TABLE);
                return true;
            }
        }
        return false;
    }
}
