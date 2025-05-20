import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao{
    public boolean insertTeacher(String lastName, String firstName, String middleInitial, Date birthDate, 
    String gender, String email, String password, String subject, String username){
        String sql = "insert into teachers(last_name, first_name, middle_initial, date_of_birth, gender, email, password, subject, username) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection(); 
            PreparedStatement pst = conn.prepareStatement(sql)){

            pst.setString(1, lastName);
            pst.setString(2,firstName);
            pst.setString(3, middleInitial);
            pst.setDate(4,birthDate);
            pst.setString(5, gender);
            pst.setString(6,email);
            pst.setString(7, password);
            pst.setString(8, subject);
            pst.setString(9, username);

            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;

        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertStudent(String lastname, String firstname, String midleInitial, Date birthdate, String gender, String email, String password, String username, String classA){
        String sql = "insert into students(last_name, first_name, middle_initial, date_of_birth, gender, email, password, username, class) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

                pst.setString(1,lastname);
                pst.setString(2,firstname);
                pst.setString(3,midleInitial);
                pst.setDate(4,birthdate);
                pst.setString(5,gender);
                pst.setString(6,email);
                pst.setString(7,password);
                pst.setString(8,username);
                pst.setString(9,classA);

                int affectedRows = pst.executeUpdate();
                return affectedRows > 0;

            }catch(SQLException e){
                e.printStackTrace();
                return false;
            }
    }

    public List<Object[]> fetchTeacherTableData() {
        List<Object[]> data = new ArrayList<>();

        String query = "SELECT CONCAT(last_name, ' ', first_name, ' ', middle_initial) AS fullName, subject, email FROM teachers";

        try (Connection conn = DBConnection.getConnection(); 
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Object[] row = new Object[3];
                row[0] = rs.getString("fullName");
                row[1] = rs.getString("subject");
                row[2] = rs.getString("email");
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public List<Object[]> fetchStudentsTableData(){
        List<Object[]> data = new ArrayList<>();

        String query = "select concat(last_name, ' ', first_name, ' ', middle_initial) as fullName, class, email from students";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {
                
            while(rs.next()){
                Object[] row = new Object[3];
                row[0] = rs.getString("fullName");
                row[1] = rs.getString("class");
                row[2] = rs.getString("email");
                data.add(row);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    public Integer getStudentIdByName(String studentName) throws SQLException {
    String sql = "SELECT student_id FROM students WHERE first_name = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studentName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("student_id");
            } else {
                return null; // Student not found
            }
        }
    }

    public void insertGrade(int studentId, String subject, double grade) throws SQLException {
        String sql = "INSERT INTO grades (student_id, subject, grade) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setString(2, subject);
            stmt.setDouble(3, grade);
            stmt.executeUpdate();
        }
    }
}