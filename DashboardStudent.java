import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DashboardStudent extends JFrame{
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

    public DashboardStudent(LoginPage loginPage){
        JFrame frame = new JFrame("Student Dashboard");
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

        JLabel label1 = new JLabel(userDao.getName(loginPage.getUserName()) +"(STUDENT)");
        label1.setFont(new Font("Arial", Font.BOLD, 40));
        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setPreferredSize(new Dimension(800,100));
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel1.add(label1);

        JButton gradeBtn = new JButton("Grades"); 
        JButton scheduleBtn = new JButton("Schedules");

        buttonStyle(gradeBtn);
        buttonStyle(scheduleBtn);
        btnImage(gradeBtn, ("res/gradesIcon.png"));
        btnImage(scheduleBtn, ("res/scheduleIcon.png"));

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

                UserDao userDao = new UserDao();

                String[] columnTitle = {"Subject", "Day", "Time"};  

                List<Object[]> schedTable = userDao.getSchedule(loginPage.getUserName());

                Object[][] data = new Object[schedTable.size()][];
                    for (int i = 0; i < schedTable.size(); i++) {
                        data[i] = schedTable.get(i);
                    }
                
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

        leftPanel.setOpaque(false);
        rightPanel.setOpaque(false);
        mainPanel.setOpaque(false);
        panel1.setOpaque(false);
        
        background.setLayout(new BorderLayout());
        background.add(panel1, BorderLayout.NORTH);
        background.add(mainPanel);

        frame.setVisible(true);
    }
}