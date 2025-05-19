import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame{
    JFrame frame = new JFrame("Login");
    private String username;
    //private String password;

    public void setUserName(String userName){
        this.username = userName;
    }

    public String getUserName(){
        return username;
    }

    private GridBagConstraints gbc(int x, int y, int width, int anchor, Insets insets){
        GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = x;
            gbc.gridy = y;
            gbc.gridwidth = width;
            gbc.anchor = anchor;
            gbc.insets = insets;
            return gbc;
    }

    public LoginPage(){
        frame.setSize(500,350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Log In");
        label1.setFont(new Font("Arial", Font.BOLD, 40));

        JLabel userLbl = new JLabel("Username");
        JTextField userTxt = new JTextField("", 15);

        JLabel passLbl = new JLabel("Password");
        JTextField passTxt = new JTextField("", 15);

        String[] options = {"Admin", "Student", "Teacher"};
        JComboBox<String> typeMenu = new JComboBox<>(options);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(Color.GREEN);

        loginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 

                int choice = typeMenu.getSelectedIndex();

                setUserName(userTxt.getText());

                if(choice == 0){
                    new DashboardAdmin(LoginPage.this);
                    frame.dispose(); 
                } else if(choice == 1){
                    new DashboardStudent(LoginPage.this);
                    frame.dispose(); 
                } else if(choice == 2){
                    new DashboardTeacher(LoginPage.this);
                    frame.dispose(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Please type a valid input");
                }
            };
        });
        
        JPanel panel = new JPanel(new GridBagLayout());
        
        panel.add(label1, gbc(0, 0, 2, GridBagConstraints.CENTER, new Insets(10,0,20,0)));
        panel.add(userLbl, gbc(0, 1, 2, GridBagConstraints.CENTER, new Insets(5,0,0,0)));
        panel.add(userTxt, gbc(0, 2, 2, GridBagConstraints.CENTER, new Insets(5,0,5,0)));
        panel.add(passLbl, gbc(0, 3, 2, GridBagConstraints.CENTER, new Insets(5,0,0,0)));
        panel.add(passTxt, gbc(0, 4, 2, GridBagConstraints.CENTER, new Insets(5,0,5,0)));
        panel.add(typeMenu, gbc(0, 5, 1, GridBagConstraints.CENTER, new Insets(20,0,0,0)));
        panel.add(loginBtn, gbc(1, 5, 1, GridBagConstraints.CENTER, new Insets(20,0,0,0)));


        frame.add(panel);
    }

    public void startFrame(){
        frame.setVisible(true);
    };
}