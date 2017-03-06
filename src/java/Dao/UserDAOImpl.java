package Dao;

import Enum.Gender;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO{

    private Connection conn;
    
    private PreparedStatement pstmt;
    
    @Override
    public void addUser(User user) {
       try {
            String sql = "INSERT INTO food_user (name,lastname,password) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSurName());
            pstmt.setString(3, user.getPassword());
            pstmt.setGender(4, user.getGender());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public User getUser(String fname, String password) {
        try {
            String sql = "SELECT * FROM food_user WHERE name = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fname);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("firstname");
                String surname = rs.getString("lastname");
                Gender gender = rs.getString("gender");
                User user = new User(name, password, surname, gender);
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
