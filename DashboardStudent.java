import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardStudent extends JFrame{
    public DashboardStudent(LoginPage loginPage){
        JFrame frame = new JFrame("Student Dashbo           ard");
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel label1 = new JLabel(loginPage.getUserName() +"(STUDENT)");
        label1.setFont(new Font("Arial", Font.BOLD, 40));
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
                label1.setFont(new Font("Arial", Font.BOLD, 40));

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.add(label1);

                UserDao userDao = new UserDao();

                String[] columnTitle = {"Subject", "Grades"};

                Object[][] data = userDao.getStudentGrades(loginPage.getUserName());  

                JTable table = new JTable(data, columnTitle);

                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

                for (int i = 0; i < table.getColumnCount(); i++) {
                    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

                JTableHeader header = table.getTableHeader();
                header.setFont(new Font("Arial", Font.BOLD, 19));

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
                label1.setFont(new Font("Arial", Font.BOLD, 40));

                JPanel panel1 = new JPanel(new GridBagLayout());
                panel1.setPreferredSize(new Dimension(800,100));
                panel1.add(label1);

                String[] columnTitle = {"Subject", "Day", "Time"};  

                Object[][] data = {
                    {"Science", "Monday", "8:00 AM"},
                    {"Computer System Servicing", "Monday", "3:00 PM"},
                    {"", "", ""}
                };
                
                JTable table = new JTable(data, columnTitle);
                JTableHeader header = table.getTableHeader();
                header.setFont(new Font("Arial", Font.BOLD, 19));
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

                for(int i = 0; i < table.getColumnCount(); i++){
                    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }

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