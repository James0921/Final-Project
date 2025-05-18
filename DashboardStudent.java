import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardStudent extends JFrame{
    private GridBagConstraints gbc(int x, int y, int width, int anchor, Insets inset){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.anchor = anchor;
        gbc.insets = inset;
        return gbc;
    }

    public DashboardStudent(){
        JFrame frame = new JFrame("Student Dashboard");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel label1 = new JLabel("Bhalerina Chapocina(STUDENT)");
        label1.setFont(new Font("Arial", Font.BOLD, 19));
        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(800,100));
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel1.add(label1);

        JButton gradeBtn = new JButton("Grades");
        gradeBtn.setBackground(Color.LIGHT_GRAY);
        gradeBtn.setPreferredSize(new Dimension(100,50));
        JButton scheduleBtn = new JButton("Schedules");
        scheduleBtn.setBackground(Color.LIGHT_GRAY);
        scheduleBtn.setPreferredSize(new Dimension(100,50));

        gradeBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frame = new JFrame();
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JLabel label1 = new JLabel("Bhallerina Chapocina(Student) - GRADES");
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

                JLabel label1 = new JLabel("Bhallerina Chapocina(Student) - SCHEDULES");
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

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        leftPanel.add(gradeBtn, gbc(0,0,2,GridBagConstraints.CENTER, new Insets(0,0,10,0)));
        leftPanel.add(scheduleBtn, gbc(0,1,2,GridBagConstraints.CENTER, new Insets(0,0,10,0)));
        
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel mainPanel = new JPanel(new GridLayout());
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(mainPanel);

        frame.setVisible(true);
    }
}