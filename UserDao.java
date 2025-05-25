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

    public boolean insertSubject(String subjectName){
        String sql = "insert into subjects(subject_name) values(?)";
        

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
                
                pst.setString(1, subjectName);

                int affectedRows = pst.executeUpdate();
                return affectedRows > 0;

        }catch (SQLException e){
                e.printStackTrace();
                return false;
        }
    }

    public boolean insertSection(String section){
        String sql = "insert into sections(section_name) values(?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

                pst.setString(1,section);

                int affectedRows = pst.executeUpdate();
                return affectedRows > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertTeacherSS(String username, String subject, String section){
        String updateSubjectSql  = "update subjects set teacher_id = (select teacher_id from teachers where lower(username) = lower(?)) where subject_name = ?";
        String updateSectionSql = "update teachers set section_id = (select section_id from sections where lower(section_name) = lower(?)) where lower(username) = lower(?)";

        try(Connection conn = DBConnection.getConnection()){
            conn.setAutoCommit(false);
            
            try(
                PreparedStatement pst1 = conn.prepareStatement(updateSubjectSql);
                PreparedStatement pst2 = conn.prepareStatement(updateSectionSql)
            ){
                    pst1.setString(1, username);
                    pst1.setString(2, subject);
                    int rowsUpdated1 = pst1.executeUpdate();

                    pst2.setString(1,section);
                    pst2.setString(2,username);
                    int rowsUpdated2 = pst2.executeUpdate();

                    if(rowsUpdated1 > 0 && rowsUpdated2 > 0){
                        conn.commit();
                        return true;
                    } else{
                        conn.rollback();
                        return false;
                    }
            }catch(SQLException e){
                conn.rollback();
                e.printStackTrace();
                return false;
            } finally {
                conn.setAutoCommit(true);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insertStudentSection(String username, String section){
        String sql = "update students set section_id = (select section_id from sections where lower(section_name) = lower(?)) where lower(username) = lower(?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

            pst.setString(1,section);
            pst.setString(2,username);
            int rowsUpdate = pst.executeUpdate();

            if(rowsUpdate > 0){
                return true;
            }else{
                return false;
            }

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

    public List<Object[]> fetchSubjectsTable(){
        List<Object[]> data = new ArrayList<>();
        String query = "select s.subject_name, concat(t.last_name, ' ', t.first_name, ' ', t.middle_initial) as fullName " + 
                    "from subjects s " + 
                    "left join teachers t on s.teacher_id = t.teacher_id";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery()){

            while(rs.next()){
                Object[] row = new Object[2];
                row[0] = rs.getString("subject_name");
                row[1] = rs.getString("fullName");
                data.add(row);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    public List<Object[]> fetchSectionList() {
        List<Object[]> data = new ArrayList<>();
        String query = "select s.section_name, concat(t.last_name, ' ', t.first_name, ' ', t.middle_initial) as fullName " +
                    "from sections s " +
                    "left join teachers t on s.section_id = t.section_id";          

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Object[] row = new Object[3];
                row[0] = rs.getString("section_name");
                row[1] = rs.getString("fullName");
                data.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public List<Object[]> fetchSectionStudents(String subject, String section){
        List<Object[]> data = new ArrayList<>();
        String query = "select concat(s.last_name, ', ', s.first_name, ' ', s.middle_initial) as fullName, g.grade from students s left join grades g on s.student_id = g.student_id and g.subject = ? where s.`class` = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){
            pst.setString(1, subject);
            pst.setString(2,section);
                
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                Object[]row = new Object[2];
                row[0] = rs.getString("fullName");
                row[1] = rs.getString("grade");
                data.add(row);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return data;
    }

    public List<Object[]> fetchScheduleTable(String section){
        List<Object[]> data = new ArrayList<>();
        String query = "select sub.subject_name, sched.day_of_week, sched.time from subjects sub left join schedules sched on sub.subject_id = sched.subject_id and sched.class = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){
                pst.setString(1, section);

                try(ResultSet rs = pst.executeQuery()){
                    while(rs.next()){
                        String subjectName = rs.getString("subject_name");

                        String dayOfWeek = rs.getString("day_of_week");
                        String time = rs.getString("time");

                        if (dayOfWeek == null) dayOfWeek = "";
                        if (time == null) time = "";

                        Object[]row = new Object[3];
                        row[0] = subjectName; 
                        row[1] = dayOfWeek;   
                        row[2] = time;   
                        data.add(row);
                    }
                }

        }catch(SQLException e){
            e.printStackTrace(); 
        }
        return data;
    }

    public List<Object[]> getSchedule(String username){
        List<Object[]> data = new ArrayList<>();
        String classQuery = "select class from students where lower(username) = lower(?)";
        String query = "select sub.subject_name, sched.day_of_week, sched.time from subjects sub left join schedules sched on sub.subject_id = sched.subject_id and sched.class = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstClass = conn.prepareStatement(classQuery)) {

            pstClass.setString(1, username);
            try (ResultSet rsClass = pstClass.executeQuery()) {
                if (rsClass.next()) {
                    String studentClass = rsClass.getString("class");

                    try (PreparedStatement pstSchedule = conn.prepareStatement(query)) {
                        pstSchedule.setString(1, studentClass);
                        try (ResultSet rsSchedule = pstSchedule.executeQuery()) {
                            while (rsSchedule.next()) {
                                String subject = rsSchedule.getString("subject_name");
                                String day = rsSchedule.getString("day_of_week");
                                String time = rsSchedule.getString("time");

                                if (day == null) day = "";
                                if (time == null) time = "";

                                data.add(new Object[]{subject, day, time});
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public String getTeacherSubjectName(String username){
        String sql = "select subject from teachers where lower(username) = lower(?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
            pst.setString(1,username);

            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){ 
                    return rs.getString("subject");
                }else{
                    return null;
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateStudentGrade(Double grade, String subject, String name){
        String selectSql = "SELECT student_id FROM students WHERE lower(concat(last_name, ', ', first_name, ' ', middle_initial)) LIKE lower(?)";
        String checkSql = "SELECT COUNT(*) FROM grades WHERE student_id = ? and subject = ?";
        String insertSql = "INSERT INTO grades (student_id, grade, subject) VALUES (?, ?, ?)";
        String updateSql = "UPDATE grades SET grade = ? WHERE student_id = ? and subject = ?";

        try (Connection conn = DBConnection.getConnection()) {
            try (PreparedStatement selectPst = conn.prepareStatement(selectSql)) {
                selectPst.setString(1, "%" + name + "%");
                ResultSet rs = selectPst.executeQuery();

                if (rs.next()) {
                    int studentId = rs.getInt("student_id");

                    try (PreparedStatement checkPst = conn.prepareStatement(checkSql)) {
                        checkPst.setInt(1, studentId);
                        checkPst.setString(2,subject);
                        ResultSet checkRs = checkPst.executeQuery();

                        if (checkRs.next() && checkRs.getInt(1) > 0) {
                            try (PreparedStatement updatePst = conn.prepareStatement(updateSql)) {
                                updatePst.setDouble(1, grade);
                                updatePst.setString(2, subject);
                                updatePst.setInt(3, studentId);
                                updatePst.executeUpdate();
                            }
                        } else {
                            try (PreparedStatement insertPst = conn.prepareStatement(insertSql)) {
                                insertPst.setInt(1, studentId);
                                insertPst.setDouble(2, grade);
                                insertPst.setString(3, subject);
                                insertPst.executeUpdate();
                            }
                        }
                        return true;
                    }
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSchedule(String day, String time, String subject, String section){
        String sql = "UPDATE schedules " +
             "JOIN subjects ON schedules.subject_id = subjects.subject_id " +
             "JOIN sections ON schedules.class = sections.section_name " +
             "SET schedules.day_of_week = ?, schedules.time = ? " +
             "WHERE subjects.subject_name = ? AND sections.section_name = ?";

        String insertSql = "INSERT INTO schedules (subject_id, class, day_of_week, time) " +
                       "SELECT s.subject_id, sec.section_name, ?, ? " +
                       "FROM subjects s, sections sec " +
                       "WHERE s.subject_name = ? AND sec.section_name = ?";

        try (Connection conn = DBConnection.getConnection()) {

        try (PreparedStatement updatePst = conn.prepareStatement(sql)) {
            updatePst.setString(1, day);
            updatePst.setString(2, time);
            updatePst.setString(3, subject);
            updatePst.setString(4, section);

            int rowsAffected = updatePst.executeUpdate();

            if (rowsAffected > 0) {
                return true; 
            }
        }

        try (PreparedStatement insertPst = conn.prepareStatement(insertSql)) {
            insertPst.setString(1, day);
            insertPst.setString(2, time);
            insertPst.setString(3, subject);
            insertPst.setString(4, section);

            int rowsInserted = insertPst.executeUpdate();

            return rowsInserted > 0; 
        }        
        }catch(SQLException e){
            e.printStackTrace(); 
            return false;   
        }
    }

    public List<String> fetchSubjectName(){
        List<String> subjectNames = new ArrayList<>();
        String query = "select subject_name from subjects";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                subjectNames.add(rs.getString("subject_name"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return subjectNames;
    }

    public List<String> fetchSectionName(){
        List<String> sectionNames = new ArrayList<>();
        String query = "select section_name from sections";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                sectionNames.add(rs.getString("section_name"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return sectionNames;
    }

    public boolean deleteSubject(String subName){
        String sql = "delete from subjects where subject_name = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){

                pst.setString(1, subName);

                int rowsUpdated = pst.executeUpdate();
                return rowsUpdated > 0;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSection(String section){
        String sql = "delete from sections where section_name = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
                pst.setString(1, section);

                int rowsUpdated = pst.executeUpdate();
                return rowsUpdated > 0;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
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

    public boolean loginStudent(String username, String password){
        String query = "select password from students where lower(username) = lower(?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){
                pst.setString(1, username);
                ResultSet rs = pst.executeQuery();

                if(rs.next()){
                    String storedPassword = rs.getString("password");
                    return password.equals(storedPassword);
                } else {
                    return false;
                }
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean loginTeacher(String username, String password){
        String query = "select password from teachers where lower(username) = lower(?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){
                pst.setString(1,username);
                ResultSet rs = pst.executeQuery();

                if(rs.next()){
                    String storedPassword = rs.getString("password");
                    return password.equals(storedPassword);
                } else{
                    return false;
                }

        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    //unused
    public Object[][] getStudentGrades(String username){
        String idQuery = "select student_id from students where lower(username) = lower(?)";
        String detailQuery = "select subject, grade from grades where student_id = ?";

        List<Object[]> rows = new ArrayList<>();

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(idQuery)){

            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                int studentId = rs.getInt("student_id");

                try(PreparedStatement detailPst = conn.prepareStatement(detailQuery)){
                    detailPst.setInt(1, studentId);
                    ResultSet detailRs = detailPst.executeQuery();

                    while(detailRs.next()){
                        Object[] row = new Object[2];
                        row[0] = detailRs.getString("subject");
                        row[1] = detailRs.getString("grade");
                        rows.add(row);
                    }
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        Object[][] data = new Object[rows.size()][2];
        for(int i = 0; i < rows.size(); i++){
            data[i] = rows.get(i);
        } 
        return data;
    }

    public Object[][] getClassList(String username){
        String query = "select s.section_name, sub.subject_name " +
                    "from teachers t join sections s on t.section_id = s.section_id " +
                    "join subjects sub on t.teacher_id = sub.teacher_id " +
                    "where lower(t.username) = lower(?)";

        List<Object[]> rows = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[2];
                row[0] = rs.getString("section_name");
                row[1] = rs.getString("subject_name");
                rows.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Object[][] data = new Object[rows.size()][2];
        for (int i = 0; i < rows.size(); i++) {
            data[i] = rows.get(i);
        }

        return data;
   }

    public List<Object[]> searchTeacherRecord(String name){ 
        List<Object[]> searchResult = new ArrayList<>();
        String sql = "select concat(last_name, ', ', first_name, ' ',middle_initial) as fullName, subject, email from teachers where lower (concat(last_name, ', ', first_name, ' ', middle_initial)) like lower(?)";

        try(Connection conn = DBConnection.getConnection(); 
            PreparedStatement pst = conn.prepareStatement(sql)){

            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                searchResult.add(new Object[]{
                    rs.getString("fullName"),
                    rs.getString("subject"),
                    rs.getString("email")
                });
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return searchResult;
    }

    public List<Object[]> searchStudentRecord(String name){
        List<Object[]> searchResult = new ArrayList<>();
        String sql = "select concat(last_name, ', ', first_name, ' ', middle_initial) as fullName, class, email from students where lower(concat(last_name, ', ', first_name, ' ', middle_initial)) like lower(?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)){
                
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                searchResult.add(new Object[]{
                    rs.getString("fullName"),
                    rs.getString("class"),
                    rs.getString("email")
                });
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return searchResult;
    }

    
}