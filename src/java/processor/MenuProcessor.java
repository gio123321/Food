package processor;

import Dao.MenuDAO;
import Dao.MenuDAOImpl;
import Model.Menu;

public class MenuProcessor {

    private static MenuDAO menuDAO = new MenuDAOImpl();

    public static void addMenu(Menu menu) {
        int id = menuDAO.addmenu(menu);
        menu.setId(id);
        menuDAO.fillFoods(menu);
    }
}
