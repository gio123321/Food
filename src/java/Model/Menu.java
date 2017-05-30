package Model;

import Enum.BeverageType;
import Enum.MenuType;
import java.util.ArrayList;

public class Menu {

    private int id;
    
    private String name;

    private MenuType type;

    private ArrayList<Food> Foods;
    
    private BeverageType beverage;
    
    
    public Menu() {
    }

    public Menu(int id, String name, MenuType type, ArrayList<Food> Foods, BeverageType beverage) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.Foods = Foods;
        this.beverage = beverage;
    }

    public Menu(String name, MenuType type, ArrayList<Food> Foods, BeverageType beverage) {
        this.name = name;
        this.type = type;
        this.Foods = Foods;
        this.beverage = beverage;
    }

    public Menu(int id, String name, MenuType type, BeverageType beverage) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.beverage = beverage;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BeverageType getBeverage() {
        return beverage;
    }

    public void setBeverage(BeverageType beverage) {
        this.beverage = beverage;
    }

    @Override
    public String toString() {
        return  id + " " + name + " " + type + " " + Foods + " " + beverage;
    }
    
    
}
