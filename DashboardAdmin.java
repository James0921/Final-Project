import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JLabel adminLbl = new JLabel(loginPage.getUserName() + "(Admin)");
        adminLbl.setFont(new Font("Arial", Font.BOLD, 19));

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
                label1.setFont(new Font("Arial", Font.BOLD, 19));

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

                JLabel passLbl = new JLabel("Password");
                JTextField passTxt = new JTextField(15); 

                JLabel confirmPassLbl = new JLabel("Confirm Password");
                JTextField confirmPassTxt = new JTextField(15); 

                JPanel panel2 = new JPanel(new GridBagLayout());
                panel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 300));

                panel2.add(lastNameLbl, gbc(0,1,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(lastNameTxt, gbc(0,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(firstNameLbl, gbc(0,3,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(firstNameTxt, gbc(0,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(middleNameLbl, gbc(0,5,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(middleNameTxt, gbc(0,6,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(birthDateLbl, gbc(1,1,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(birthDateTxt, gbc(1,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(genderLbl, gbc(1,3,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(genderTxt, gbc(1,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(emailLbl, gbc(3,1,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(emailTxt, gbc(3,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(passLbl, gbc(3,3,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(passTxt, gbc(3,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(confirmPassLbl, gbc(3,5,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(confirmPassTxt, gbc(3,6,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));

                JLabel subjectLbl = new JLabel("Subject");
                subjectLbl.setFont(new Font("Arial", Font.BOLD, 19));

                JCheckBox scienceChk = new JCheckBox("Science");
                JCheckBox englishChk = new JCheckBox("English");
                JCheckBox mathChk = new JCheckBox("Math");
                JCheckBox filipinoChk = new JCheckBox("Filipino");

                JPanel panel3 = new JPanel(new GridBagLayout());
                panel3.add(subjectLbl, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel3.add(scienceChk, gbc(0,1,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel3.add(englishChk, gbc(0,2,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel3.add(mathChk, gbc(0,3,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel3.add(filipinoChk, gbc(0,4,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));

                JLabel classesLbl = new JLabel("Classes");
                classesLbl.setFont(new Font("Arial", Font.BOLD, 19));

                JCheckBox bsit2A = new JCheckBox("BSIT 2A");
                JCheckBox bsit2B = new JCheckBox("BSIT 2B");
                JCheckBox bsit2C= new JCheckBox("BSIT 2C");
                JCheckBox bsit2D = new JCheckBox("BSIT 2D");

                JPanel panel4 = new JPanel(new GridBagLayout());
                panel4.add(classesLbl, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel4.add(bsit2A, gbc(0,1,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel4.add(bsit2B, gbc(0,2,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel4.add(bsit2C, gbc(0,3,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel4.add(bsit2D, gbc(0,4,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                
                JButton insertBtn = new JButton("Insert");
                insertBtn.setBackground(Color.GREEN);
                insertBtn.setPreferredSize(new Dimension(100,50));
                
                JPanel panel5 = new JPanel(new GridBagLayout());
                panel5.add(insertBtn);


                JPanel mainPanel = new JPanel(new GridLayout(2,1));
                JPanel bottomPanel = new JPanel(new GridLayout(1,2));
                
                frame.add(panel1, BorderLayout.NORTH);
                mainPanel.add(panel2);
                bottomPanel.add(panel3);
                bottomPanel.add(panel4);
                bottomPanel.add(panel5);
                mainPanel.add(bottomPanel);

                frame.add(mainPanel);
                frame.setVisible(true);
            }
        });

        addTeacherBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("Add Teacher");
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("ADD TEACHER");
                label1.setFont(new Font("Arial", Font.BOLD, 19));

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

                JLabel passLbl = new JLabel("Password");
                JTextField passTxt = new JTextField(15); 

                JLabel confirmPassLbl = new JLabel("Confirm Password");
                JTextField confirmPassTxt = new JTextField(15); 

                JPanel panel2 = new JPanel(new GridBagLayout());
                panel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 300));

                panel2.add(lastNameLbl, gbc(0,1,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(lastNameTxt, gbc(0,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(firstNameLbl, gbc(0,3,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(firstNameTxt, gbc(0,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(middleNameLbl, gbc(0,5,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(middleNameTxt, gbc(0,6,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(birthDateLbl, gbc(1,1,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(birthDateTxt, gbc(1,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(genderLbl, gbc(1,3,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(genderTxt, gbc(1,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(emailLbl, gbc(3,1,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(emailTxt, gbc(3,2,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(passLbl, gbc(3,3,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(passTxt, gbc(3,4,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(confirmPassLbl, gbc(3,5,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));
                panel2.add(confirmPassTxt, gbc(3,6,1,GridBagConstraints.CENTER,new Insets(5,5,0,5)));

                JLabel subjectLbl = new JLabel("Subject");
                subjectLbl.setFont(new Font("Arial", Font.BOLD, 19));

                JCheckBox scienceChk = new JCheckBox("Science");
                JCheckBox englishChk = new JCheckBox("English");
                JCheckBox mathChk = new JCheckBox("Math");
                JCheckBox filipinoChk = new JCheckBox("Filipino");

                JPanel panel3 = new JPanel(new GridBagLayout());
                panel3.add(subjectLbl, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel3.add(scienceChk, gbc(0,1,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel3.add(englishChk, gbc(0,2,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel3.add(mathChk, gbc(0,3,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel3.add(filipinoChk, gbc(0,4,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));

                JLabel classesLbl = new JLabel("Classes");
                classesLbl.setFont(new Font("Arial", Font.BOLD, 19));

                JCheckBox bsit2A = new JCheckBox("BSIT 2A");
                JCheckBox bsit2B = new JCheckBox("BSIT 2B");
                JCheckBox bsit2C= new JCheckBox("BSIT 2C");
                JCheckBox bsit2D = new JCheckBox("BSIT 2D");

                JPanel panel4 = new JPanel(new GridBagLayout());
                panel4.add(classesLbl, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel4.add(bsit2A, gbc(0,1,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel4.add(bsit2B, gbc(0,2,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel4.add(bsit2C, gbc(0,3,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                panel4.add(bsit2D, gbc(0,4,1,GridBagConstraints.WEST, new Insets(2,2,2,2)));
                
                JButton insertBtn = new JButton("Insert");
                insertBtn.setBackground(Color.GREEN);
                insertBtn.setPreferredSize(new Dimension(100,50));
                
                JPanel panel5 = new JPanel(new GridBagLayout());
                panel5.add(insertBtn);


                JPanel mainPanel = new JPanel(new GridLayout(2,1));
                JPanel bottomPanel = new JPanel(new GridLayout(1,2));
                
                frame.add(panel1, BorderLayout.NORTH);
                mainPanel.add(panel2);
                bottomPanel.add(panel3);
                bottomPanel.add(panel4);
                bottomPanel.add(panel5);
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
                label1.setFont(new Font("Arial", Font.BOLD, 19));
                
                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.add(label1);

                String[] columnTitles = {"Name", "Classes", "Subjects"};

                Object[][] data = {
                    {"Tralalelo Tralala", "BSIT-2A, BSIT-2B", "Science"},
                    {"Joey Doey", "BSIT-2C", "Math"},
                    {"","",""},
                    {"","",""},
                    {"","",""},
                    {"","",""},
                    {"","",""},
                    {"","",""}
                };

                JTable table = new JTable(data, columnTitles);

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
                label1.setFont(new Font("Arial", Font.BOLD, 19));
                
                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.add(label1);

                String[] columnTitles = {"Name", "Classes", "Subjects"};

                Object[][] data = {
                    {"Bhalerina Chapocina", "BSIT-2M", "English, Math, SCience"},
                    {"Joey Doey", "BSIT-2C", "Css, App Dev"},
                    {"","",""},
                    {"","",""},
                    {"","",""},
                    {"","",""},
                    {"","",""},
                    {"","",""}
                };

                JTable table = new JTable(data, columnTitles);

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
        //leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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