import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardStudent extends JFrame{
    public DashboardStudent(LoginPage loginPage){
        JFrame frame = new JFrame("Student Dashboard");
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel label1 = new JLabel(loginPage.getUserName() +"(STUDENT)");
        label1.setFont(new Font("Arial", Font.BOLD, 19));
        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(800,100));
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel1.add(label1);

        JButton gradeBtn = new JButton("Grades");
        gradeBtn.setBackground(Color.LIGHT_GRAY);
        gradeBtn.setFont(new Font("Arial", Font.BOLD, 40));
        JButton scheduleBtn = new JButton("Schedules");
        scheduleBtn.setBackground(Color.LIGHT_GRAY);
        scheduleBtn.setFont(new Font("Arial", Font.BOLD, 40));

        gradeBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame();
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("GRADES");
                label1.setFont(new Font("Arial", Font.BOLD, 19));

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.add(label1);

                String[] columnTitle = {"Subject", "Grades"};

                Object[][] data = {
                    {"Science", 88.83},
                    {"Computer System Servicing", "91.01"},
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

        scheduleBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame();
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("SCHEDULES");
                label1.setFont(new Font("Arial", Font.BOLD, 19));

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.add(label1);

                String[] columnTitle = {"Subject", "Grades"};

                Object[][] data = {
                    {"Science", 88.83},
                    {"Computer System Servicing", "91.01"},
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

        JPanel leftPanel = new JPanel(new GridLayout(2,1));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Operations"));
        leftPanel.add(gradeBtn);
        leftPanel.add(scheduleBtn);
        
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Operations"));

        JPanel mainPanel = new JPanel(new GridLayout());
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(mainPanel);

        frame.setVisible(true);
    }
}