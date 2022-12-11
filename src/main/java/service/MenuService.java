package service;

import domain.Menu;
import domain.repository.MenuRepository;
import java.util.List;

public class MenuService {

    public List<Menu> finaAllCurrentMenus() {
        return MenuRepository.menus();
    }

    public Menu findMenu(final int menuNumber) {
        return MenuRepository.findMenuByNumber(menuNumber);
    }
}
