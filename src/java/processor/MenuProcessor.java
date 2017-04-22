package processor;

import Dao.MenuDAO;
import Dao.MenuDAOImpl;
import Model.Menu;

public class MenuProcessor {
    
    private static MenuDAO menuDAO = new MenuDAOImpl();
    
    public static void addMenu(Menu menu) {
        menuDAO.addmenu(menu);
        menuDAO.fillFoods(menu);
    }
}
