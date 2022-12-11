package service;

import domain.Menu;
import domain.repository.MenuRepository;
import java.util.List;

public class MenuService {

    public List<Menu> finaAllCurrentMenus() {
        return MenuRepository.menus();
    }

    public void findMenu(final int menu) {
//        return MenuRepository.findMenuByNumber(menu);
    }
}
