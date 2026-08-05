import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {

    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnLogin;

    LoginForm() {

        setTitle("Login");

        txtUser = new JTextField();
        txtPass = new JPasswordField();
        btnLogin = new JButton("Login");

        txtUser.setBounds(100, 50, 150, 30);
        txtPass.setBounds(100, 100, 150, 30);
        btnLogin.setBounds(120, 150, 100, 30);

        add(txtUser);
        add(txtPass);
        add(btnLogin);

        btnLogin.addActionListener(this);

        setSize(400, 300);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        String user = txtUser.getText();
        String pass = String.valueOf(txtPass.getPassword());

        if(user.equals("admin") && pass.equals("1234")) {
            new ReservationForm();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Invalid Login");
        }
    }
}