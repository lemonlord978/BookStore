/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author fsoft
 */
public class StudentDAO extends BaseDAO<Student> {

    @Override
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT [id]\n" +
                    "      ,[name]\n" +
                    "      ,[gender]\n" +
                    "      ,[dob]\n" +
                    "  FROM [Student]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setGender(rs.getString("gender"));
                s.setDob(rs.getDate("dob"));
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    public Student getStudent(int id) {
        try {
            String sql = "SELECT s.id,s.name,s.gender,s.dob FROM Student s\n"
                    + "WHERE s.id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getString("gender"));
                return s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insertStudent(Student s) {
        try {
            String sql = "INSERT INTO [Student]\n"
                    
                    + "           ([name]\n"
                    + "           ,[dob]\n"
                    + "           ,[gender])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, s.getName());
            statement.setDate(2, s.getDob());
            statement.setInt(3, s.getGender().equals("Male")?1:0);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStudent(Student s) {
        try {
            String sql = "UPDATE [Student]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[dob] = ?\n"
                    + "      ,[gender] = ?\n"
                    + " WHERE [id] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getName());
            statement.setDate(2, s.getDob());
            statement.setInt(3, s.getGender().equals("Male")? 1:0);
            statement.setInt(4, s.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStudent(int id) {
        try {
            String sql = "DELETE Student WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

