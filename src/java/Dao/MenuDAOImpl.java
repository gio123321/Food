package Dao;

import Enum.BeverageType;
import Enum.MenuType;
import Model.Food;
import Model.Menu;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuDAOImpl implements MenuDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public MenuDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DatabaseUtil.databaseURL, DatabaseUtil.username, DatabaseUtil.passsword);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int addmenu(Menu menu) {
        try {
            pstmt = con.prepareStatement("INSERT INTO Menu (name,menutype,beverage) VALUES (?,?,?) RETURNING id");

            String name = menu.getName();
            byte namebytes[] = name.getBytes("ISO-8859-1");
            name = new String(namebytes, "UTF-8");

            pstmt.setString(1, name);
            pstmt.setString(2, menu.getType().name());
            pstmt.setString(3, menu.getBeverage().name());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                return id;
            }
        } catch (SQLException | UnsupportedEncodingException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public void fillFoods(Menu menu) {
        try {
            for (Food food : menu.getFoods()) {
                pstmt = con.prepareStatement("INSERT INTO menu_food (menu_id,food_id) VALUES (?,?);");
                pstmt.setInt(1, menu.getId());
                pstmt.setInt(2, food.getId());
                pstmt.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<Menu> getMenus() {

        ArrayList<Menu> menus = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM menu");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String menutypestr = rs.getString("menutype");
                MenuType menutype = MenuType.valueOf(menutypestr);
                String beveragestr = rs.getString("beverage");
                BeverageType beverage = BeverageType.valueOf(beveragestr);

                Menu menu = new Menu(id, name, menutype, beverage);
                menus.add(menu);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return menus;
    }

    @Override
    public ArrayList<Integer> getFoodIdsForMenu(Menu menu) {
        ArrayList<Integer> al = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM menu_food WHERE menu_id = (?)");
            pstmt.setInt(1, menu.getId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                int foodId = rs.getInt("food_id");
                al.add(foodId);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return al;
    }

    @Override
    public ArrayList<Menu> getMenusByName(String name) {
        ArrayList<Menu> menus = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM menu WHERE name = ?");
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String menutypestr = rs.getString("menutype");
                MenuType menutype = MenuType.valueOf(menutypestr);
                String beveragestr = rs.getString("beverage");
                BeverageType beverage = BeverageType.valueOf(beveragestr);

                Menu menu = new Menu(id, name, menutype, beverage);
                menus.add(menu);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return menus;
    }

}
