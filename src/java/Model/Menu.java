package Model;

import Enum.MenuType;
import java.util.ArrayList;

public class Menu {

    private int id;

    private MenuType type;

    private ArrayList<Food> Foods;
    

    public Menu() {
    }

    public Menu(int id, MenuType type, ArrayList<Food> Foods) {
        this.id = id;
        this.type = type;
        this.Foods = Foods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public ArrayList<Food> getFoods() {
        return Foods;
    }

    public void setFoods(ArrayList<Food> Foods) {
        this.Foods = Foods;
    }

}
