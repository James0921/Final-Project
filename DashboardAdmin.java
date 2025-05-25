import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DashboardAdmin extends JFrame{
    public JTextField subjectNameTxt;
    public JTextField sectionNameTxt;
    public JTextField searchNameTxt;
    public String selectedSection;

    private GridBagConstraints gbc(int x, int y, int width, int anchor, Insets inset){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.anchor = anchor;
        gbc.insets = inset;
        return gbc;
    }
    public DashboardAdmin(LoginPage loginPage){
        JFrame frame = new JFrame("Admin Dashboard");
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel adminLbl = new JLabel(loginPage.getUserName());
        adminLbl.setFont(new Font("Arial", Font.BOLD, 40));

        JButton addTeacherBtn = new JButton("Add new Teacher");
        addTeacherBtn.setBackground(Color.LIGHT_GRAY);
        addTeacherBtn.setFont(new Font("Arial", Font.BOLD, 40));

        JButton addStudentBtn = new JButton("Add new Student");
        addStudentBtn.setBackground(Color.LIGHT_GRAY);
        addStudentBtn.setFont(new Font("Arial", Font.BOLD, 40));

        JButton teacherRec = new JButton("Teachers Records");
        teacherRec.setBackground(Color.LIGHT_GRAY);
        teacherRec.setFont(new Font("Arial", Font.BOLD, 40));

        JButton studentRec = new JButton("Students Records");
        studentRec.setBackground(Color.LIGHT_GRAY);
        studentRec.setFont(new Font("Arial", Font.BOLD, 40));

        JButton manageSubjects = new JButton("Manage Subjects");
        manageSubjects.setBackground(Color.LIGHT_GRAY);
        manageSubjects.setFont(new Font("Arial", Font.BOLD, 35));

        JButton manageSections = new JButton("Manage Sections");
        manageSections.setBackground(Color.LIGHT_GRAY);
        manageSections.setFont(new Font("Arial", Font.BOLD, 35));

        JButton manageSchedule = new JButton("Manage Schedule");
        manageSchedule.setBackground(Color.LIGHT_GRAY);
        manageSchedule.setFont(new Font("Arial", Font.BOLD, 35));

        //*Dto i-modify yung functions
        addStudentBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Add Student");
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("ADD STUDENT");
                label1.setFont(new Font("Arial", Font.BOLD, 40));

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel1.add(label1, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));

                JLabel lastNameLbl = new JLabel("Last Name");
                JTextField lastNameTxt = new JTextField(15);
                
                JLabel firstNameLbl = new JLabel("First Name");
                JTextField firstNameTxt = new JTextField(15); 

                JLabel middleNameLbl = new JLabel("Middle Initial");
                JTextField middleNameTxt = new JTextField(15); 

                JLabel birthDateLbl = new JLabel("Date of Birth");
                JTextField birthDateTxt = new JTextField(15); 
                
                JLabel genderLbl = new JLabel("Gender");
                JTextField genderTxt = new JTextField(15); 

                JLabel emailLbl = new JLabel("Email");
                JTextField emailTxt = new JTextField(15); 

                JLabel usernameLbl = new JLabel("Username");
                JTextField usernameTxt = new JTextField(15); 

                JLabel passLbl = new JLabel("Password");
                JTextField passTxt = new JTextField(15); 

                JLabel confirmPassLbl = new JLabel("Confirm Password");
                JTextField confirmPassTxt = new JTextField(15); 

                JLabel classesLbl = new JLabel("Classes");
                classesLbl.setFont(new Font("Arial", Font.BOLD, 20));

                UserDao userDao = new UserDao();
                List<String> classList = userDao.fetchSectionName();

                String[] classOptions = classList.toArray(new String[0]);
                JComboBox<String> classMenu = new JComboBox<>(classOptions);

                JPanel panel2 = new JPanel(new GridBagLayout());

                panel2.add(lastNameLbl, gbc(0,0,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(lastNameTxt, gbc(0,1,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(firstNameLbl, gbc(1,0,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(firstNameTxt, gbc(1,1,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(middleNameLbl, gbc(2,0,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(middleNameTxt, gbc(2,1,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));

                panel2.add(birthDateLbl, gbc(0,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(birthDateTxt, gbc(0,3,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(genderLbl, gbc(1,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(genderTxt, gbc(1,3,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(emailLbl, gbc(2,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(emailTxt, gbc(2,3,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));

                panel2.add(usernameLbl, gbc(0,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(usernameTxt, gbc(0,5,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));                
                panel2.add(passLbl, gbc(1,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(passTxt, gbc(1,5,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(confirmPassLbl, gbc(2,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(confirmPassTxt, gbc(2,5,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));

                JPanel panel3 = new JPanel(new GridBagLayout());
                panel3.add(classesLbl, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel3.add(classMenu, gbc(0,1,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                
                JButton insertBtn = new JButton("Insert");
                insertBtn.setBackground(Color.GREEN);
                insertBtn.setFont(new Font("Arial", Font.BOLD, 25));
                insertBtn.setPreferredSize(new Dimension(150,50));
                
                JPanel panel4 = new JPanel(new GridBagLayout());
                panel4.add(insertBtn);

                insertBtn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        UserDao userDao = new UserDao();

                        java.sql.Date birthDate= null;
                        try{
                            String dateText = birthDateTxt.getText();
                            birthDate = java.sql.Date.valueOf(dateText);
                        }catch(IllegalArgumentException ex){
                            JOptionPane.showMessageDialog(null, "Invalid date format. Please enter BirthDate as YYYY-MM-DD");
                            return;
                        }

                        String selectedClass = (String)classMenu.getSelectedItem();

                        boolean success = userDao.insertStudent(lastNameTxt.getText(),firstNameTxt.getText(),middleNameTxt.getText(),birthDate,genderTxt.getText(),emailTxt.getText(),passTxt.getText(),usernameTxt.getText(),selectedClass);

                        if(success){
                            boolean insertSection = userDao.insertStudentSection(usernameTxt.getText(),selectedClass);
                            if(insertSection){
                                JOptionPane.showMessageDialog(null,"Student added successfully");
                                frame.dispose();
                            }
                        } else{
                            JOptionPane.showMessageDialog(null,"Failed to add, please try again");
                        }

                    }
                });

                JPanel mainPanel = new JPanel(new GridLayout(1,1));
                JPanel bottomPanel = new JPanel(new GridBagLayout());
                
                frame.add(panel1, BorderLayout.NORTH);
                bottomPanel.add(panel2, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                bottomPanel.add(panel3, gbc(0,1,2,GridBagConstraints.CENTER, new Insets(30,0,0,0)));
                bottomPanel.add(panel4, gbc(0,2,2,GridBagConstraints.CENTER, new Insets(30,0,0,0)));
                mainPanel.add(bottomPanel);

                frame.add(mainPanel);
                frame.setVisible(true);
            }
        });

        addTeacherBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                final JFrame frame = new JFrame("Add Teacher");
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                
                JLabel label1 = new JLabel("ADD TEACHER");
                label1.setFont(new Font("Arial", Font.BOLD, 40));

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel1.add(label1, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));

                JLabel lastNameLbl = new JLabel("Last Name");
                JTextField lastNameTxt = new JTextField(15);
                
                JLabel firstNameLbl = new JLabel("First Name");
                JTextField firstNameTxt = new JTextField(15); 

                JLabel middleNameLbl = new JLabel("Middle Initial");
                JTextField middleNameTxt = new JTextField(15); 

                JLabel usernameLbl = new JLabel("Username");
                JTextField usernameTxt = new JTextField(15); 

                JLabel passLbl = new JLabel("Password");
                JTextField passTxt = new JTextField(15); 

                JLabel confirmPassLbl = new JLabel("Confirm Password");
                JTextField confirmPassTxt = new JTextField(15); 

                JLabel birthDateLbl = new JLabel("Date of Birth");
                JTextField birthDateTxt = new JTextField(15); 
                
                JLabel genderLbl = new JLabel("Gender");
                JTextField genderTxt = new JTextField(15); 

                JLabel emailLbl = new JLabel("Email");
                JTextField emailTxt = new JTextField(15); 

                JLabel subjectLbl = new JLabel("Subject");
                subjectLbl.setFont(new Font("Arial", Font.BOLD, 20));

                UserDao userDao = new UserDao();
                List<String> subjectList = userDao.fetchSubjectName();
                List<String> sectionList = userDao.fetchSectionName();

                String[] subjectOptions = subjectList.toArray(new String[0]);
                JComboBox<String> subjectMenu = new JComboBox<>(subjectOptions);

                JLabel classesLbl = new JLabel("Classes");
                classesLbl.setFont(new Font("Arial", Font.BOLD, 20));

                String[] classOptions = sectionList.toArray(new String[0]);
                JComboBox<String> classMenu = new JComboBox<>(classOptions);

                JPanel panel2 = new JPanel(new GridBagLayout());

                panel2.add(lastNameLbl, gbc(0,0,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(lastNameTxt, gbc(0,1,1,GridBagConstraints.CENTER,new Insets(5,5,5,5)));
                panel2.add(firstNameLbl, gbc(1,0,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(firstNameTxt, gbc(1,1,1,GridBagConstraints.CENTER,new Insets(5,5,5,5)));
                panel2.add(middleNameLbl, gbc(2,0,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(middleNameTxt, gbc(2,1,1,GridBagConstraints.CENTER,new Insets(5,5,5,5)));

                panel2.add(usernameLbl, gbc(0,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(usernameTxt, gbc(0,3,1,GridBagConstraints.CENTER,new Insets(5,5,5,5)));
                panel2.add(passLbl, gbc(1,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(passTxt, gbc(1,3,1,GridBagConstraints.CENTER,new Insets(5,5,5,5)));
                panel2.add(confirmPassLbl, gbc(2,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(confirmPassTxt, gbc(2,3,1,GridBagConstraints.CENTER,new Insets(5,5,5,5)));

                panel2.add(birthDateLbl, gbc(0,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(birthDateTxt, gbc(0,5,1,GridBagConstraints.CENTER,new Insets(5,5,5,5)));
                panel2.add(genderLbl, gbc(1,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(genderTxt, gbc(1,5,1,GridBagConstraints.CENTER,new Insets(5,5,5,5)));
                panel2.add(emailLbl, gbc(2,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(emailTxt, gbc(2,5,1,GridBagConstraints.CENTER,new Insets(5,5,5,5)));

                JPanel panel3 = new JPanel(new GridBagLayout());
                panel3.add(subjectLbl, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,5,0)));
                panel3.add(subjectMenu, gbc(0,1,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));

                JPanel panel4 = new JPanel(new GridBagLayout());
                panel4.add(classesLbl, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,5,0)));
                panel4.add(classMenu, gbc(0,1,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                
                JButton insertBtn = new JButton("Insert");
                insertBtn.setBackground(Color.GREEN);
                insertBtn.setFont(new Font("Arial", Font.BOLD, 20));
                insertBtn.setPreferredSize(new Dimension(150,50));

                insertBtn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        UserDao userDao = new UserDao();

                        java.sql.Date birthDate = null;
                        try {
                            String dateText = birthDateTxt.getText(); 
                            birthDate = java.sql.Date.valueOf(dateText); 
                        } catch (IllegalArgumentException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the BirthDate as YYYY-MM-DD.");
                            return;
                        }

                        String selectedSubject = (String)subjectMenu.getSelectedItem();
                        String selectedSection = (String)classMenu.getSelectedItem();

                        boolean success = userDao.insertTeacher(lastNameTxt.getText(), firstNameTxt.getText(), middleNameTxt.getText(), 
                        birthDate, genderTxt.getText(), emailTxt.getText(), passTxt.getText(), selectedSubject, usernameTxt.getText());
                        if(success){
                            boolean insertSS = userDao.insertTeacherSS(usernameTxt.getText(),selectedSubject,selectedSection);
                            if(insertSS){
                                JOptionPane.showMessageDialog(null, "Teacher added successfuly");
                                frame.dispose();
                            }else{
                                JOptionPane.showMessageDialog(null, "Teacher subject not registered");
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Failed to register, please try again");
                        } 
                    }
                });
                
                JPanel panel5 = new JPanel(new GridBagLayout());
                panel5.add(insertBtn);

                JPanel mainPanel = new JPanel(new GridLayout(1,1));
                JPanel bottomPanel = new JPanel(new GridBagLayout());
                
                frame.add(panel1, BorderLayout.NORTH);
                bottomPanel.add(panel2, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                bottomPanel.add(panel3, gbc(0,1,2,GridBagConstraints.CENTER, new Insets(30,0,0,0)));
                bottomPanel.add(panel4, gbc(0,2,2,GridBagConstraints.CENTER, new Insets(20,0,0,0)));
                bottomPanel.add(panel5, gbc(0,3,2,GridBagConstraints.CENTER, new Insets(30,0,0,0)));
                mainPanel.add(bottomPanel);

                frame.add(mainPanel);

                frame.setVisible(true);
            }
        });

        teacherRec.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Teachers Records");
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("TEACHER RECORDS");
                label1.setFont(new Font("Arial", Font.BOLD, 40));
                
                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.add(label1);

                JButton searchBtn = new JButton("Search");
                searchBtn.setBackground(Color.GREEN);
                searchBtn.setFont(new Font("Arial", Font.BOLD, 20));
                searchBtn.setPreferredSize(new Dimension(150,50));

                searchNameTxt = new JTextField(15);
                searchNameTxt.setFont(new Font("Arial", Font.PLAIN, 30));
                searchNameTxt.setPreferredSize(new Dimension(300,50));

                JPanel panel2 = new JPanel(new GridBagLayout());
                panel2.add(searchBtn, gbc(0,0,1,GridBagConstraints.CENTER, new Insets(10,0,10,0)));
                panel2.add(searchNameTxt, gbc(1,0,1,GridBagConstraints.CENTER, new Insets(10,2,10,0)));

                UserDao userDao = new UserDao();
                List<Object[]> dbData = userDao.fetchTeacherTableData();

                String[] columnTitles = {"Name", "Subjects", "Email"};

                Object[][] data = new Object[dbData.size()][];
                for(int i = 0; i < dbData.size(); i++){
                    data[i] = dbData.get(i);
                }

                DefaultTableModel model = new DefaultTableModel(data, columnTitles);
                JTable table = new JTable(model);
                JTableHeader header = table.getTableHeader();
                header.setFont(new Font("Arial", Font.BOLD, 19));

                DefaultTableCellRenderer centerRow = new DefaultTableCellRenderer();
                centerRow.setHorizontalAlignment(SwingConstants.CENTER);

                for(int i = 0; i < table.getColumnCount(); i++){
                    table.getColumnModel().getColumn(i).setCellRenderer(centerRow);
                }

                searchBtn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String searchTerm = searchNameTxt.getText().trim();
                        List<Object[]> searchResults = userDao.searchTeacherRecord(searchTerm);

                        if(searchResults.isEmpty()){
                            JOptionPane.showMessageDialog(null,"No match found");
                        } else{
                            Object[][] newData = new Object[searchResults.size()][];
                            for(int i = 0; i < searchResults.size(); i ++){
                                newData[i] =searchResults.get(i);
                            }

                            DefaultTableModel model = new DefaultTableModel(newData, columnTitles);
                            table.setModel(model);

                            DefaultTableCellRenderer centerRow = new DefaultTableCellRenderer();
                            centerRow.setHorizontalAlignment(SwingConstants.CENTER);

                            for(int i = 0; i < table.getColumnCount(); i++){
                                table.getColumnModel().getColumn(i).setCellRenderer(centerRow);
                            }
                        }
                    }
                });

                table.setRowHeight(50);
                JScrollPane scrollPane = new JScrollPane(table);

                frame.add(panel1, BorderLayout.NORTH);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.add(panel2, BorderLayout.SOUTH);

                frame.setVisible(true);
            }
        });

        studentRec.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Student Records");
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("STUDENTS RECORDS");
                label1.setFont(new Font("Arial", Font.BOLD, 40));
                
                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.add(label1);

                JButton searchBtn = new JButton("Search");
                searchBtn.setBackground(Color.GREEN);
                searchBtn.setFont(new Font("Arial", Font.BOLD, 20));
                searchBtn.setPreferredSize(new Dimension(150,50));

                searchNameTxt = new JTextField(15);
                searchNameTxt.setFont(new Font("Arial", Font.PLAIN, 30));
                searchNameTxt.setPreferredSize(new Dimension(300,50));

                JPanel panel2 = new JPanel(new GridBagLayout());
                panel2.add(searchBtn, gbc(0,0,1,GridBagConstraints.CENTER, new Insets(10,0,10,0)));
                panel2.add(searchNameTxt, gbc(1,0,1,GridBagConstraints.CENTER, new Insets(10,2,10,0)));

                UserDao userDao = new UserDao();
                List<Object[]> dbData = userDao.fetchStudentsTableData();

                String[] columnTitles = {"Name", "Class", "Email"};

                Object[][] data = new Object[dbData.size()][];
                for(int i = 0; i < dbData.size(); i++){
                    data[i] = dbData.get(i);
                }
                
                DefaultTableModel model = new DefaultTableModel(data, columnTitles);

                JTable table = new JTable(model);
                JTableHeader header = table.getTableHeader();
                header.setFont(new Font("Arial", Font.BOLD, 19));

                DefaultTableCellRenderer centerRow = new DefaultTableCellRenderer();
                centerRow.setHorizontalAlignment(SwingConstants.CENTER);

                for(int i = 0; i < table.getColumnCount(); i++){
                    table.getColumnModel().getColumn(i).setCellRenderer(centerRow);
                }
             
                searchBtn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String searchTerm = searchNameTxt.getText().trim();
                        List<Object[]> searchResults = userDao.searchStudentRecord(searchTerm);

                        if(searchResults.isEmpty()){
                            JOptionPane.showMessageDialog(null,"No match found");
                        } else{
                            Object[][] newData = new Object[searchResults.size()][];
                            for(int i = 0; i < searchResults.size(); i ++){
                                newData[i] =searchResults.get(i);
                            }

                            DefaultTableModel model = new DefaultTableModel(newData, columnTitles);
                            table.setModel(model);

                            DefaultTableCellRenderer centerRow = new DefaultTableCellRenderer();
                            centerRow.setHorizontalAlignment(SwingConstants.CENTER);

                            for(int i = 0; i < table.getColumnCount(); i++){
                                table.getColumnModel().getColumn(i).setCellRenderer(centerRow);
                            }
                        }
                    }
                });

                table.setRowHeight(50);
                JScrollPane scrollPane = new JScrollPane(table);

                frame.add(panel1, BorderLayout.NORTH);
                frame.add(scrollPane, BorderLayout.CENTER);
                frame.add(panel2, BorderLayout.SOUTH);

                frame.setVisible(true);
            }
        });

        manageSubjects.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Manage Subjects");
                frame.setSize(500,400);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("<html><div style='text-align:center;'>CREATE / DELETE<br> SUBJECT</div></html>");
                label1.setFont(new Font("Arial", Font.BOLD, 30));

                JLabel subjectNameLbl = new JLabel("Subject Name: ");
                subjectNameLbl.setFont(new Font("Arial", Font.PLAIN, 19));

                subjectNameTxt = new JTextField(15);
                subjectNameTxt.setPreferredSize(new Dimension(150,50));
                subjectNameTxt.setFont(new Font("Arial", Font.PLAIN, 20));

                JButton insertBtn = new JButton("Create");
                insertBtn.setBackground(Color.LIGHT_GRAY);
                insertBtn.setFont(new Font("Arial", Font.BOLD, 25));
                insertBtn.setPreferredSize(new Dimension(200,50));

                JButton deleteBtn = new JButton("Delete");
                deleteBtn.setBackground(Color.LIGHT_GRAY);
                deleteBtn.setFont(new Font("Arial", Font.BOLD, 25));
                deleteBtn.setPreferredSize(new Dimension(200,50));

                JButton subjectListBtn = new JButton("Subject Lists");
                subjectListBtn.setBackground(Color.LIGHT_GRAY);
                subjectListBtn.setFont(new Font("Arial", Font.BOLD, 25));
                subjectListBtn.setPreferredSize(new Dimension(200,50));  

                insertBtn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        insertSubject();
                    }
                });

                deleteBtn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        deleteSubject();
                    }
                });

                subjectListBtn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ex){
                        subjectList();
                    }
                });

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(500,100));
                panel1.add(label1);

                JPanel panel2 = new JPanel(new GridBagLayout());
                panel2.add(subjectNameLbl, gbc(0,0,1, GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel2.add(subjectNameTxt, gbc(1,0,1, GridBagConstraints.CENTER, new Insets(0,0,0,0)));

                JPanel panel3 = new JPanel(new GridBagLayout());
                panel3.add(insertBtn, gbc(0,1,1,GridBagConstraints.CENTER, new Insets(0,0,0,10)));
                panel3.add(deleteBtn, gbc(1,1,1,GridBagConstraints.CENTER, new Insets(0,0,0,20)));
                panel3.add(subjectListBtn, gbc(0,2,2,GridBagConstraints.CENTER, new Insets(10,0,0,0)));

                JPanel panel4 = new JPanel(new GridLayout(2,1));
                panel4.add(panel2);
                panel4.add(panel3);

                frame.add(panel1, BorderLayout.NORTH);
                frame.add(panel4);

                frame.setVisible(true);
                
            }
        });

        manageSections.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Manage Sections");
                frame.setSize(500,400);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("<html><div style='text-align:center;'>CREATE / DELETE<br> SECTION</div></html>");
                label1.setFont(new Font("Arial", Font.BOLD, 30));

                JLabel sectionNameLbl = new JLabel("Section Name: ");
                sectionNameLbl.setFont(new Font("Arial", Font.PLAIN, 19));

                sectionNameTxt = new JTextField(15);
                sectionNameTxt.setPreferredSize(new Dimension(150,50));
                sectionNameTxt.setFont(new Font("Arial", Font.PLAIN, 20));

                JButton insertBtn = new JButton("Create");
                insertBtn.setBackground(Color.LIGHT_GRAY);
                insertBtn.setFont(new Font("Arial", Font.BOLD, 25));
                insertBtn.setPreferredSize(new Dimension(200,50));

                JButton deleteBtn = new JButton("Delete");
                deleteBtn.setBackground(Color.LIGHT_GRAY);
                deleteBtn.setFont(new Font("Arial", Font.BOLD, 25));
                deleteBtn.setPreferredSize(new Dimension(200,50));

                JButton subjectListBtn = new JButton("Section Lists");
                subjectListBtn.setBackground(Color.LIGHT_GRAY);
                subjectListBtn.setFont(new Font("Arial", Font.BOLD, 25));
                subjectListBtn.setPreferredSize(new Dimension(200,50));  

                insertBtn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        insertSection();
                    }
                });

                deleteBtn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        deleteSection();
                    }
                });

                subjectListBtn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ex){
                        sectionList();
                    }
                });

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(500,100));
                panel1.add(label1);

                JPanel panel2 = new JPanel(new GridBagLayout());
                panel2.add(sectionNameLbl, gbc(0,0,1, GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel2.add(sectionNameTxt, gbc(1,0,1, GridBagConstraints.CENTER, new Insets(0,0,0,0)));

                JPanel panel3 = new JPanel(new GridBagLayout());
                panel3.add(insertBtn, gbc(0,1,1,GridBagConstraints.CENTER, new Insets(0,0,0,10)));
                panel3.add(deleteBtn, gbc(1,1,1,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel3.add(subjectListBtn, gbc(0,2,2,GridBagConstraints.CENTER, new Insets(10,0,0,0)));

                JPanel panel4 = new JPanel(new GridLayout(2,1));
                panel4.add(panel2);
                panel4.add(panel3);

                frame.add(panel1, BorderLayout.NORTH);
                frame.add(panel4);

                frame.setVisible(true);
            }
        });

        manageSchedule.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Manage Schedule");
                frame.setSize(400,200);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                UserDao userDao = new UserDao();
                List<String> options = userDao.fetchSectionName();
                String[] sectionOptions = options.toArray(new String[0]);

                JComboBox<String> sectionMenu = new JComboBox<>(sectionOptions);
                sectionMenu.setPreferredSize(new Dimension(100,40));
                sectionMenu.setFont(new Font("Arial", Font.PLAIN, 20));

                JLabel label = new JLabel("SELECT SECTION");
                label.setFont(new Font("Arial", Font.PLAIN, 30));

                JButton button = new JButton("Enter");
                button.setBackground(Color.GREEN);
                button.setFont(new Font("Arial", Font.BOLD, 25));

                button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        selectedSection = (String) sectionMenu.getSelectedItem();
                        insertSchedule(selectedSection);
                    }
                });

                JPanel panel = new JPanel(new GridBagLayout());
                panel.add(label, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,10,0)));
                panel.add(sectionMenu, gbc(0,1,2,GridBagConstraints.CENTER, new Insets(0,0,10,0)));
                panel.add(button, gbc(0,2,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
            
                frame.add(panel);

                frame.setVisible(true);
            }
        });


        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel leftPanel = new JPanel(new GridLayout(2,1));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Add Operations"));
        JPanel rightPanel = new JPanel(new GridLayout(2,1));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Records"));
        JPanel bottomPanel = new JPanel(new GridLayout(1,2));   
        JPanel botPanel = new JPanel(new GridLayout(1,2));

        panel1.add(adminLbl, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(10,0,10,0)));
        leftPanel.add(addTeacherBtn);
        leftPanel.add(addStudentBtn);
        rightPanel.add(teacherRec);
        rightPanel.add(studentRec);
        bottomPanel.add(manageSubjects);
        bottomPanel.add(manageSections);
        botPanel.add(manageSchedule);

        JPanel mainBodyPanel = new JPanel(new GridLayout(1, 2));
        mainBodyPanel.add(leftPanel);
        mainBodyPanel.add(rightPanel);

        JPanel combinedBottomPanel = new JPanel(new BorderLayout()); 
        combinedBottomPanel.add(bottomPanel, BorderLayout.CENTER);
        combinedBottomPanel.add(botPanel, BorderLayout.SOUTH);   
        combinedBottomPanel.setBorder(BorderFactory.createTitledBorder("Manage")); 

        bottomPanel.setPreferredSize(new Dimension(1000,175));
        botPanel.setPreferredSize(new Dimension(500,175));

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(mainBodyPanel, BorderLayout.CENTER);
        frame.add(combinedBottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    } 

    public void insertSubject(){
        UserDao userDao = new UserDao();

        boolean success = userDao.insertSubject(subjectNameTxt.getText());

        if(success){
            JOptionPane.showMessageDialog(null, "Subject Created Successfuly");

        }else{
            JOptionPane.showMessageDialog(null,"Failed to add subject");
        }
    }

    public void insertSection(){
        UserDao userDao = new UserDao();

        boolean success = userDao.insertSection(sectionNameTxt.getText());

        if(success){
            JOptionPane.showMessageDialog(null,"Section Create Successfully");
        }else{
            JOptionPane.showMessageDialog(null,"Failed to add section");
        }
    }

    public void subjectList(){
        JFrame frame = new JFrame("Subject List");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel label1 = new JLabel("Subject Lists");
        label1.setFont(new Font("Arial", Font.BOLD, 40));
                            
        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(800,100));
        panel1.add(label1);

        UserDao userDao = new UserDao();
        List<Object[]> subjectsTable = userDao.fetchSubjectsTable();

        String[] columnTitles = {"Subject", "Teacher"};

        Object[][] data = new Object[subjectsTable.size()][];
        for(int i = 0; i < subjectsTable.size(); i++){
            data[i] = subjectsTable.get(i);
        }

        JTable table = new JTable(data, columnTitles);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 19));

        DefaultTableCellRenderer centerRow = new DefaultTableCellRenderer();
        centerRow.setHorizontalAlignment(SwingConstants.CENTER);

        for(int i = 0; i < table.getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(centerRow);
        }


        table.setRowHeight(50);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void sectionList(){
        JFrame frame = new JFrame("Section List");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel label1 = new JLabel("Section List");
        label1.setFont(new Font("Arial", Font.BOLD, 40));
                            
        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(800,100));
        panel1.add(label1);

        UserDao userDao = new UserDao();
        List<Object[]> sectionsTable = userDao.fetchSectionList();

        String[] columnTitles = {"Section", "Teacher"};

        Object[][] data = new Object[sectionsTable.size()][];
        for(int i = 0; i < sectionsTable.size(); i++){
            data[i] = sectionsTable.get(i);
        }

        JTable table = new JTable(data, columnTitles);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 19));

        DefaultTableCellRenderer centerRow = new DefaultTableCellRenderer();
        centerRow.setHorizontalAlignment(SwingConstants.CENTER);

        for(int i = 0; i < table.getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(centerRow);
        }


        table.setRowHeight(50);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void deleteSubject(){
        UserDao userDao = new UserDao();

        boolean success = userDao.deleteSubject(subjectNameTxt.getText());

        if(success){
            JOptionPane.showMessageDialog(null, "Subject  " + subjectNameTxt.getText() + " deleted");
        }else {
            JOptionPane.showMessageDialog(null, "Subject not found");
        }
    }

    public void deleteSection(){
        UserDao userDao = new UserDao();

        boolean success = userDao.deleteSection(sectionNameTxt.getText());

        if(success){
            JOptionPane.showMessageDialog(null, "Section " + sectionNameTxt.getText() + " deleted");
        }else {
            JOptionPane.showMessageDialog(null, "Section not found");
        }
    }

    public void insertSchedule(String selectedSection){
        JFrame frame = new JFrame("Manage Schedule");
                frame.setSize(800,600);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                UserDao userDao = new UserDao();

                JLabel label1 = new JLabel("Manage Schedule");
                label1.setFont(new Font("Arial", Font.BOLD, 35));
                JLabel label2 = new JLabel(selectedSection);
                label2.setFont(new Font("Arial", Font.BOLD, 25));

                JPanel panel = new JPanel(new GridBagLayout());
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.setPreferredSize(new Dimension(800,100));
                panel.add(label1, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel.add(label2, gbc(0,1,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));

                List<Object[]> scheduleTable = userDao.fetchScheduleTable(selectedSection);

                String[] columnTitles = {"SUBJECT", "DAY", "TIME"};

                Object[][] data = new Object[scheduleTable.size()][];
                    for (int i = 0; i < scheduleTable.size(); i++) {
                        data[i] = scheduleTable.get(i);
                    }
                DefaultTableModel model = new DefaultTableModel(data,columnTitles){
                    public boolean isCellEditable(int row, int column){
                        return column == 1 || column == 2;
                    }
                };

                model.addTableModelListener(ex -> {
                    if(ex.getType() == TableModelEvent.UPDATE){
                        int row = ex.getFirstRow();
                        int col = ex.getColumn();

                        if (col == 1 || col == 2) {
                            Object subjectObj = model.getValueAt(row, 0);
                            Object dayObj = model.getValueAt(row, 1);
                            Object timeObj = model.getValueAt(row, 2);

                            if (subjectObj != null && dayObj != null && !dayObj.toString().trim().isEmpty()
                                && timeObj != null && !timeObj.toString().trim().isEmpty()) {

                                String subject = model.getValueAt(row,0).toString();
                                String day = model.getValueAt(row, 1).toString();
                                String time = model.getValueAt(row, 2).toString();
                                    
                                boolean success = userDao.updateSchedule(day, time, subject, selectedSection);
                                if(success){
                                    JOptionPane.showMessageDialog(null,"Schedule Updated successfully");
                                }else{
                                    JOptionPane.showMessageDialog(null,"Error");
                                }
                            } else {
                                if(col == 2) {
                                    JOptionPane.showMessageDialog(null, "Please fill in both day and time before updating.");
                                }
                            }
                        }
                    }
                });   

                JTable table = new JTable(model);

                String[] validDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                JComboBox<String> dayMenu = new JComboBox<>(validDays);
                dayMenu.setPreferredSize(new Dimension(100,40));
                dayMenu.setFont(new Font("Arial", Font.PLAIN, 20));

                TableColumn dayColumn = table.getColumnModel().getColumn(1);
                dayColumn.setCellEditor(new DefaultCellEditor(dayMenu));

                JTableHeader header = table.getTableHeader();
                header.setFont(new Font("Arial", Font.BOLD, 19));

                DefaultTableCellRenderer centerRow = new DefaultTableCellRenderer();
                centerRow.setHorizontalAlignment(SwingConstants.CENTER);
                for(int i = 0; i < table.getColumnCount(); i++){
                    table.getColumnModel().getColumn(i).setCellRenderer(centerRow);
                }
                table.setRowHeight(50);
                JScrollPane scrollPane = new JScrollPane(table);

                frame.add(panel, BorderLayout.NORTH);
                frame.add(scrollPane);

                frame.setVisible(true);
    }
}