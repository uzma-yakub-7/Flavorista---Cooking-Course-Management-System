package dao;

import db.DBConnection;
import java.sql.*;

public class EnrollmentDAO {

    public static boolean enroll(int userId, int courseId) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO enrollments(user_id,course_id) VALUES(?,?)"
            );
            ps.setInt(1, userId);
            ps.setInt(2, courseId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {}
        return false;
    }
}
