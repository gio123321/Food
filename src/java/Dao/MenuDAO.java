package Dao;

import Model.Food;
import Model.Menu;
import java.util.ArrayList;

public interface MenuDAO {

    int addmenu(Menu menu);
    
    void fillFoods(Menu menu);
    
    ArrayList<Menu> getMenus();
    
    ArrayList<Integer> getFoodIdsForMenu(Menu menu);
   
    }
