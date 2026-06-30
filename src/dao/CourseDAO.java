package dao;

import db.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class CourseDAO {

    public static ArrayList<String> getCourses() {
        ArrayList<String> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM courses");
            while (rs.next()) {
                list.add(rs.getInt("id") + " - " +
                        rs.getString("title") + " ($" +
                        rs.getDouble("price") + ")");
            }
        } catch (Exception e) {}
        return list;
    }
}
