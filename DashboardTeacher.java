import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardTeacher extends JFrame{
    private GridBagConstraints gbc(int x, int y, int width, int anchor, Insets inset){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.anchor = anchor;
        gbc.insets = inset;
        return gbc;
    }

    public DashboardTeacher(){
        JFrame frame = new JFrame("Teacher Dashboads");
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel label1 = new JLabel("Tralelo Tralala(TEACHER)");
        label1.setFont(new Font("Arial", Font.BOLD, 19));

        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.setPreferredSize(new Dimension(1000,100));      
        panel1.add(label1, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,0,0)));

        JButton classListBtn = new JButton("Class List");
        classListBtn.setBackground(Color.LIGHT_GRAY);
        classListBtn.setPreferredSize(new Dimension(200,50));

        JButton inputGradesBtn = new JButton("Input Grades");
        inputGradesBtn.setBackground(Color.LIGHT_GRAY);
        inputGradesBtn.setPreferredSize(new Dimension(200,50));

        classListBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame();
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("Tralelo Tralala(TEACHER) - Class List");
                label1.setFont(new Font("Arial", Font.BOLD, 19));

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.add(label1);

                String[] columnTitle = {"Class" , "Subject"};

                Object[][] data = {
                    {"BSIT-2M", "Science"},
                    {"", ""},
                    {"", ""}
                };

                JTable table = new JTable(data, columnTitle);

                table.setRowHeight(50);
                JScrollPane scrollPane = new JScrollPane(table);

                frame.add(panel1, BorderLayout.NORTH);
                frame.add(scrollPane);

                frame.setVisible(true);
            }
        });

        inputGradesBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame();
                frame.setSize(800,500);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("Tralalelo Tralala(TEACHER) - Input Grades");
                label1.setFont(new Font("Arial", Font.BOLD, 19));

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.add(label1);

                JLabel studentNameLbl = new JLabel("Student Name");
                JTextField studentNameTxt = new JTextField(15);
                studentNameTxt.setPreferredSize(new Dimension(100,30));

                JLabel subjectLbl = new JLabel("Student Name");
                JTextField subjectTxt = new JTextField(15);
                subjectTxt.setPreferredSize(new Dimension(100,30));

                JLabel gradeLbl = new JLabel("Student Name");
                JTextField gradeTxt = new JTextField(15);
                gradeTxt.setPreferredSize(new Dimension(100,30));

                JButton insertBtn = new JButton("Insert");
                insertBtn.setBackground(Color.green);
                insertBtn.setPreferredSize(new Dimension(100,30));
                JButton searchBtn = new JButton("Search");
                searchBtn.setBackground(Color.green);
                searchBtn.setPreferredSize(new Dimension(100,30));

                JPanel panel2 = new JPanel(new GridBagLayout());
                panel2.add(studentNameLbl, gbc(0,0,1,GridBagConstraints.CENTER, new Insets(0, 0, 0, 0)));
                panel2.add(studentNameTxt, gbc(0,1,1,GridBagConstraints.CENTER, new Insets(0, 10, 0, 10)));
                panel2.add(subjectLbl, gbc(1,0,1,GridBagConstraints.CENTER, new Insets(0, 0, 0, 0)));
                panel2.add(subjectTxt, gbc(1,1,1,GridBagConstraints.CENTER, new Insets(0, 10, 0, 10)));
                panel2.add(gradeLbl, gbc(2,0,1,GridBagConstraints.CENTER, new Insets(0, 0, 0, 0)));
                panel2.add(gradeTxt, gbc(2,1,1,GridBagConstraints.CENTER, new Insets(0, 10, 0, 10)));
                panel2.add(insertBtn, gbc(0,2,1,GridBagConstraints.CENTER, new Insets(10, 10, 0, 10)));
                panel2.add(searchBtn, gbc(1,2,1,GridBagConstraints.CENTER, new Insets(10, 10, 0, 10)));

                JPanel mainPanel = new JPanel(new GridLayout(2,1));
                frame.add(panel1, BorderLayout.NORTH);
                mainPanel.add(panel2);           
                frame.add(mainPanel);

                frame.setVisible(true);
            }
        });

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        leftPanel.add(classListBtn, gbc(0,0,1,GridBagConstraints.CENTER, new Insets(0,0,5,0)));
        leftPanel.add(inputGradesBtn, gbc(0,1,1,GridBagConstraints.CENTER, new Insets(0,0,5,0)));

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel mainPanel = new JPanel(new GridLayout(1,2));


        
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        frame.add(mainPanel);
        frame.add(panel1, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}