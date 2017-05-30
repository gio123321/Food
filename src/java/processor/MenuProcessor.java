package processor;

import Dao.FoodDAO;
import Dao.FoodDAOImpl;
import Dao.MenuDAO;
import Dao.MenuDAOImpl;
import Model.Food;
import Model.Menu;
import java.util.ArrayList;

public class MenuProcessor {

    private static MenuDAO menuDAO = new MenuDAOImpl();

    public static void addMenu(Menu menu) {
        int id = menuDAO.addmenu(menu);
        menu.setId(id);
        menuDAO.fillFoods(menu);
    }

    public static ArrayList<Menu> getAllMenus() {
        ArrayList<Menu> menus = new ArrayList<>();
        FoodDAO foodDao = new FoodDAOImpl();
        ArrayList<Menu> menus1 = menuDAO.getMenus();
        
        for (Menu menu : menus1) {
            ArrayList<Integer> ids = menuDAO.getFoodIdsForMenu(menu);
            
            for (Integer n : ids) {
                ArrayList<Food> foods = new ArrayList<>();
                foods.add(foodDao.getFoodById(n));
                menu.setFoods(foods);
                menus.add(menu);
            }
        }
        return menus;
    }
}
