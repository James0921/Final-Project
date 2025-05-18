import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame{

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
        JFrame frame = new JFrame("Login Window");
        frame.setSize(400,350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Log In");
        label1.setFont(new Font("Arial", Font.BOLD, 19));

        JLabel userLbl = new JLabel("Username: ");
        JTextField userTxt = new JTextField("", 15);

        JLabel passLbl = new JLabel("Username: ");
        JTextField passTxt = new JTextField("", 15);

        JLabel typeLbl = new JLabel("Admin/Teacher/Student: ");
        JTextField typeTxt = new JTextField("", 15);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(Color.GREEN);

        loginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                String typeInput = typeTxt.getText();
                
                if(typeInput.equalsIgnoreCase("admin")){
                    new DashboardAdmin();
                    frame.dispose(); 
                } else if(typeInput.equalsIgnoreCase("student")){
                    new DashboardStudent();
                    frame.dispose(); 
                } else if(typeInput.equalsIgnoreCase("teacher")){
                    new DashboardTeacher();
                    frame.dispose(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Please type a valid input");
                }
            };
        });
        
        JPanel panel = new JPanel(new GridBagLayout());
        
        panel.add(label1, gbc(0, 0, 2, GridBagConstraints.CENTER, new Insets(10,0,20,0)));
        panel.add(userLbl, gbc(0, 1, 2, GridBagConstraints.CENTER, new Insets(5,0,0,0)));
        panel.add(userTxt, gbc(1, 2, 1, GridBagConstraints.CENTER, new Insets(5,0,5,0)));
        panel.add(passLbl, gbc(0, 3, 2, GridBagConstraints.CENTER, new Insets(5,0,0,0)));
        panel.add(passTxt, gbc(1, 4, 1, GridBagConstraints.CENTER, new Insets(5,0,5,0)));
        panel.add(typeLbl, gbc(0, 5, 2, GridBagConstraints.CENTER, new Insets(5,0,0,0)));
        panel.add(typeTxt, gbc(1, 6, 1, GridBagConstraints.CENTER, new Insets(5,0,5,0)));
        panel.add(loginBtn, gbc(0, 7, 2, GridBagConstraints.CENTER, new Insets(10,0,5,0)));


        frame.add(panel);

        frame.setVisible(true);
    }
}