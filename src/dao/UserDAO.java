package dao;

import db.DBConnection;
import model.User;
import java.sql.*;

public class UserDAO {

    // Register User
    public static boolean register(User user) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO users(name,email,password) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.name);
            ps.setString(2, user.email);
            ps.setString(3, user.password);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Login User, returns userId if success
    public static int login(String email, String password) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT id FROM users WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // login failed
    }
}
