package ui;

import dao.CourseDAO;
import dao.EnrollmentDAO;
import javax.swing.*;
import java.util.ArrayList;

public class CourseListFrame extends JFrame {

    public CourseListFrame(int userId) {
        setTitle("Courses");
        setSize(400,300);

        ArrayList<String> courses = CourseDAO.getCourses();
        JList<String> list = new JList<>(courses.toArray(new String[0]));

        JButton enroll = new JButton("Enroll");

        enroll.addActionListener(e -> {
            int id = Integer.parseInt(list.getSelectedValue().split(" ")[0]);
            EnrollmentDAO.enroll(userId, id);
            JOptionPane.showMessageDialog(this,"Enrolled Successfully");
        });

        add(new JScrollPane(list),"Center");
        add(enroll,"South");

        setVisible(true);
    }
}
