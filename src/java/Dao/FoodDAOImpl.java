package Dao;

import Enum.FoodType;
import Model.Food;
import Model.Ingredient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class FoodDAOImpl implements FoodDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public FoodDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseUtil.databaseURL, DatabaseUtil.username, DatabaseUtil.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addFood(Food food) {

        try {

            ArrayList<Ingredient> inArray = food.getIngredients();
            String ingredients = Ingredient.objectsToString(inArray);
            pstmt = con.prepareStatement("INSERT INTO FOOD (name,foodtype,cooking_way,ingredients) VALUES (?,?,?,?);");
            pstmt.setString(1, food.getName());
            pstmt.setString(2, food.getFoodtype().name());
            pstmt.setString(3, food.getCooking_way());
            pstmt.setString(4, ingredients);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public ArrayList<Food> getAllFoods() {

        ArrayList<Food> foods = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM food");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                FoodType type = FoodType.valueOf(rs.getString("foodtype"));
                String cooking_way = rs.getString("cooking_way");
                String ingredients = rs.getString("ingredients");
                ArrayList<Ingredient> ins = new ArrayList<>();
                ins = Ingredient.stringToObject(ingredients);

                Food food = new Food(id, ins, name, type, cooking_way);
                foods.add(food);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return foods;
    }

}
