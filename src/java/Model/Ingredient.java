package Model;

import Enum.FoodType;
import Enum.QuantityType;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Ingredient {

    private int id;

    private String name;

    private double quantity;

    private QuantityType type;

    private String comment;

    public Ingredient() {
    }

    public Ingredient(String name, double quantity, QuantityType type, String comment) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public QuantityType getType() {
        return type;
    }

    public void setType(QuantityType type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String objectsToString(ArrayList<Ingredient> ingredients) {
        String s = "";
        for (int i = 0; i < ingredients.size(); i++) {
            s += ingredients.get(i).name + "&" + ingredients.get(i).quantity + "&" + ingredients.get(i).type.name() + "&" + ingredients.get(i).comment + "@";
        }
        return s;
    }

    public static ArrayList<Ingredient> stringToObject(String ingredients) {
        ArrayList<Ingredient> ins = new ArrayList<>();
        String[] s1 = ingredients.split("@");
        ArrayList<String> in = new ArrayList<>(Arrays.asList(s1));

        for (String s : in) {
            String[] s2 = s.split("&");
            ArrayList<String> al = new ArrayList<>(Arrays.asList(s2));
            Ingredient ingredient = new Ingredient(al.get(0), Double.parseDouble(al.get(1)), QuantityType.valueOf(al.get(2)), al.get(3));
            ins.add(ingredient);

        }

        return ins;
    }

    @Override
    public String toString() {
        return name + "  " + quantity + " " + type + " " + comment;
    }

}
