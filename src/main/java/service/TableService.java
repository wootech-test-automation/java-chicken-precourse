package service;

import domain.Table;
import domain.repository.TableRepository;
import java.util.List;

public class TableService {

    public List<Table> findAllCurrentTables() {
        return TableRepository.tables();
    }
}
