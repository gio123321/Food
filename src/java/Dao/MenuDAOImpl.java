package Dao;

import Model.Food;
import Model.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            pstmt.setString(1, menu.getName());
            pstmt.setString(2, menu.getType().name());
            pstmt.setString(3, menu.getBeverage().getName());
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                    int id = rs.getInt(1);
                    return id;
                }
        } catch (SQLException ex) {
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
}
