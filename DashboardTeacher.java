import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DashboardTeacher extends JFrame{
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

    public static void buttonStyle(JButton... buttons){
        for(JButton button : buttons){
            button.setFont(new Font("Arial", Font.BOLD, 40));
            button.setBackground(Color.LIGHT_GRAY);
        }
    }

    public static void btnImage(JButton button, String imagePath){
        ImageIcon image = new ImageIcon(DashboardAdmin.class.getResource(imagePath));
        Image imageResized = image.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
        ImageIcon iconResized = new ImageIcon(imageResized);

        button.setIcon(iconResized);
    }

    public DashboardTeacher(LoginPage loginPage){
        JFrame frame = new JFrame("Teacher Dashboads");
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel background = new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Image image = new ImageIcon(getClass().getResource("res/ptcbg2.png")).getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        frame.setContentPane(background);

        UserDao userDao = new UserDao();

        JLabel label1 = new JLabel(userDao.getName(loginPage.getUserName()) + "(TEACHER)");
        label1.setFont(new Font("Arial", Font.BOLD, 40));

        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.setPreferredSize(new Dimension(1000,100));      
        panel1.add(label1, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));

        JButton classListBtn = new JButton("Class List");

        JButton inputGradesBtn = new JButton("Input Grades");

        buttonStyle(classListBtn);
        buttonStyle(inputGradesBtn);
        btnImage(classListBtn, "res/classListIcon.png");
        btnImage(inputGradesBtn, "res/recordGradeIcon.png");

        classListBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame();
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("CLASS LIST");
                label1.setFont(new Font("Arial", Font.BOLD, 40));

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.add(label1);

                UserDao userDao = new UserDao();

                String[] columnTitle = {"Section" , "Subject"};

                Object[][] data = userDao.getClassList(loginPage.getUserName());

                JTable table = new JTable(data, columnTitle);
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
                frame.add(scrollPane);

                frame.setVisible(true);
            }
        });

        inputGradesBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame("selection");
                frame.setSize(400,200);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                
                JPanel panel = new JPanel();
                panel.setLayout(new GridBagLayout());

                UserDao userDao = new UserDao();
                JLabel label = new JLabel("SELECT SECTION");
                label.setFont(new Font("Arial", Font.PLAIN, 30));

                List<String> sections = userDao.fetchSectionName();
                String[] sectionOption = sections.toArray(new String[0]);

                JComboBox<String> sectionMenu = new JComboBox<>(sectionOption);
                sectionMenu.setPreferredSize(new Dimension(100,40));
                sectionMenu.setFont(new Font("Arial", Font.PLAIN, 20));

                JButton enter = new JButton("Enter");
                enter.setBackground(Color.GREEN);
                enter.setFont(new Font("Arial", Font.BOLD, 25));

                enter.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        selectedSection = (String) sectionMenu.getSelectedItem();
                        String subjectName = userDao.getTeacherSubjectName(loginPage.getUserName());
                        insertStudentTable(subjectName,selectedSection);
                    }
                });

                panel.add(label, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,10,0)));
                panel.add(sectionMenu, gbc(0,1,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel.add(enter, gbc(0,2,2,GridBagConstraints.CENTER, new Insets(10,0,0,0)));
                frame.add(panel);
                frame.setVisible(true);
            }
        });

        JPanel leftPanel = new JPanel(new GridLayout(2,1));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Operations"));
        leftPanel.add(classListBtn);
        leftPanel.add(inputGradesBtn);

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel mainPanel = new JPanel(new GridLayout(1,2));

        panel1.setOpaque(false);
        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        mainPanel.setOpaque(false);
        
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        background.setLayout(new BorderLayout());
        background.add(panel1, BorderLayout.NORTH);
        background.add(mainPanel);

        frame.setVisible(true);
    }

    public void insertStudentTable(String subjectName, String selectedSection){
        JFrame frame = new JFrame();
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                UserDao userDao = new UserDao();

                JLabel label1 = new JLabel(subjectName);
                label1.setFont(new Font("Arial", Font.BOLD, 40));
                JLabel label2 = new JLabel(selectedSection);
                label2.setFont(new Font("Arial", Font.PLAIN, 30));

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel1.setPreferredSize(new Dimension(400,100));
                panel1.add(label1, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                panel1.add(label2, gbc(0,1,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));
                
                List<Object[]> gradingTable = userDao.fetchSectionStudents(subjectName,selectedSection);

                String[] columnTitles = {"STUDENT NAME", "GRADE"};

                Object[][] data = new Object[gradingTable.size()][];
                for(int i = 0; i < gradingTable.size(); i++){
                    data[i] = gradingTable.get(i);
                }

                DefaultTableModel model = new DefaultTableModel(data,columnTitles){
                    public boolean isCellEditable(int row, int column){
                        return column == 1;
                    }
                };

                model.addTableModelListener(ex -> {
                    if(ex.getType() == TableModelEvent.UPDATE){
                        int row = ex.getFirstRow();
                        int column = ex.getColumn();

                        if(column ==1){
                            String name = model.getValueAt(row,0).toString();
                            Double newGrade = Double.parseDouble(model.getValueAt(row, 1).toString());
                            
                            boolean success = userDao.updateStudentGrade(newGrade,subjectName,name);
                            if(success){
                                JOptionPane.showMessageDialog(null,"Grade recorded successfully");
                            }else{
                                JOptionPane.showMessageDialog(null,"Error");
                            }
                        }
                    }
                });

                JTable table = new JTable(model);
                JTableHeader header = table.getTableHeader();
                header.setFont(new Font("Arial", Font.BOLD, 19));

                DefaultTableCellRenderer centerRow = new DefaultTableCellRenderer();
                centerRow.setHorizontalAlignment(SwingConstants.CENTER);
                for(int i = 0; i < table.getColumnCount(); i++){
                    table.getColumnModel().getColumn(i).setCellRenderer(centerRow);
                }
 
                table.setRowHeight(50);
                JScrollPane scrollPane = new JScrollPane(table);

                frame.add(panel1, BorderLayout.NORTH);;           
                frame.add(scrollPane);

                frame.setVisible(true);
    }
}