package Dao;

import Model.Menu;

public interface MenuDAO {

    int addmenu(Menu menu);
    
    void fillFoods(Menu menu);
}
