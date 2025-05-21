import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DashboardAdmin extends JFrame{
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

                JLabel subjectLbl = new JLabel("Subject");
                subjectLbl.setFont(new Font("Arial", Font.BOLD, 20));

                String[] subjectOptions = {"Science", "English", "Math", "Filipino"};
                JComboBox<String> subjectMenu = new JComboBox<>(subjectOptions);

                JLabel classesLbl = new JLabel("Classes");
                classesLbl.setFont(new Font("Arial", Font.BOLD, 20));

                String[] classOptions = {"BSIT-2A", "BSIT-2B", "BSIT-2C", "BSIT-2D"};
                JComboBox<String> classMenu = new JComboBox<>(classOptions);

                JPanel panel2 = new JPanel(new GridBagLayout());
                panel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 300));

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

                panel3.add(subjectLbl, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel3.add(subjectMenu, gbc(0,1,1,GridBagConstraints.CENTER, new Insets(2,2,2,2)));

                JPanel panel4 = new JPanel(new GridBagLayout());
                panel4.add(classesLbl, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel4.add(classMenu, gbc(0,1,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                
                JButton insertBtn = new JButton("Insert");
                insertBtn.setBackground(Color.GREEN);
                insertBtn.setFont(new Font("Arial", Font.BOLD, 25));
                insertBtn.setPreferredSize(new Dimension(150,50));
                
                JPanel panel5 = new JPanel(new GridBagLayout());
                panel5.add(insertBtn);

                insertBtn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        UserDao userDao = new UserDao();

                        java.sql.Date birthDate= null;
                        try{
                            String dateText = birthDateTxt.getText();
                            birthDate = java.sql.Date.valueOf(dateText);
                        }catch(IllegalArgumentException ex){
                            JOptionPane.showMessageDialog(null, "Invalid date format. Please enter date as yyyy-mm-dd");
                            return;
                        }

                        String selectedClass = (String)classMenu.getSelectedItem();

                        boolean success = userDao.insertStudent(lastNameTxt.getText(),firstNameTxt.getText(),middleNameTxt.getText(),birthDate,genderTxt.getText(),emailTxt.getText(),passTxt.getText(),usernameTxt.getText(),selectedClass);

                        if(success){
                            JOptionPane.showMessageDialog(null,"Student added successfully");
                            frame.dispose();
                        } else{
                            JOptionPane.showMessageDialog(null,"Failed to add, please try again");
                        }

                    }
                });

                JPanel mainPanel = new JPanel(new GridLayout(1,1));
                JPanel bottomPanel = new JPanel(new GridBagLayout());
                
                frame.add(panel1, BorderLayout.NORTH);
                bottomPanel.add(panel2, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                bottomPanel.add(panel3, gbc(0,1,1,GridBagConstraints.CENTER, new Insets(20,185,0,0)));
                bottomPanel.add(panel4, gbc(1,1,1,GridBagConstraints.CENTER, new Insets(20,0,0,175)));
                bottomPanel.add(panel5, gbc(0,2,2,GridBagConstraints.CENTER, new Insets(30,0,0,0)));
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

                String[] subjectOptions = {"Science", "Math", "English", "Filipino"};
                JComboBox<String> subjectMenu = new JComboBox<>(subjectOptions);

                JLabel classesLbl = new JLabel("Classes");
                classesLbl.setFont(new Font("Arial", Font.BOLD, 20));

                String[] classOptions = {"BSIT-2A", "BSIT-2B", "BSIT-2C", "BSIT-2D"};
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
                panel3.add(subjectLbl, gbc(0,0,1,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel3.add(subjectMenu, gbc(0,1,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));

                JPanel panel4 = new JPanel(new GridBagLayout());
                panel4.add(classesLbl, gbc(0,0,1,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel4.add(classMenu, gbc(0,1,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                
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
                            JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date as yyyy-MM-dd.");
                            return;
                        }

                        String selectedSubject = (String)subjectMenu.getSelectedItem();

                        boolean success = userDao.insertTeacher(lastNameTxt.getText(), firstNameTxt.getText(), middleNameTxt.getText(), 
                        birthDate, genderTxt.getText(), emailTxt.getText(), passTxt.getText(), selectedSubject, usernameTxt.getText());
dispose(); 
                        if(success){
                            JOptionPane.showMessageDialog(null, "Teacher added successfuly");
                            frame.dispose();
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
                bottomPanel.add(panel3, gbc(0,1,1,GridBagConstraints.CENTER, new Insets(20,185,0,0)));
                bottomPanel.add(panel4, gbc(1,1,1,GridBagConstraints.CENTER, new Insets(20,0,0,175)));
                bottomPanel.add(panel5, gbc(0,2,2,GridBagConstraints.CENTER, new Insets(30,0,0,0)));
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

                UserDao userDao = new UserDao();
                List<Object[]> dbData = userDao.fetchTeacherTableData();

                String[] columnTitles = {"Name", "Subjects", "Email"};

                Object[][] data = new Object[dbData.size()][];
                for(int i = 0; i < dbData.size(); i++){
                    data[i] = dbData.get(i);
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

                UserDao userDao = new UserDao();
                List<Object[]> dbData = userDao.fetchStudentsTableData();

                String[] columnTitles = {"Name", "Class", "Email"};

                Object[][] data = new Object[dbData.size()][];
                for(int i = 0; i < dbData.size(); i++){
                    data[i] = dbData.get(i);
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
        });

        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel leftPanel = new JPanel(new GridLayout(2,1));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Add Operations"));
        JPanel rightPanel = new JPanel(new GridLayout(2,1));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Records"));

        panel1.add(adminLbl, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(10,0,10,0)));
        leftPanel.add(addTeacherBtn);
        leftPanel.add(addStudentBtn);
        rightPanel.add(teacherRec);
        rightPanel.add(studentRec);

        JPanel mainBodyPanel = new JPanel(new GridLayout(1, 2)); // 1 row, 2 columns
        mainBodyPanel.add(leftPanel);
        mainBodyPanel.add(rightPanel);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(mainBodyPanel);
        frame.setVisible(true);
    } 
}