import java.awt.*;
import java.awt.event.*;

public class LoginForm extends Frame implements ActionListener {
    TextField tf1, tf2;
    Button b1;
    Label l1, l2, l3;

    LoginForm() {
        l1 = new Label("Username:");
        l1.setBounds(50, 50, 100, 20);
        tf1 = new TextField();
        tf1.setBounds(150, 50, 150, 20);

        l2 = new Label("Password:");
        l2.setBounds(50, 100, 100, 20);
        tf2 = new TextField();
        tf2.setBounds(150, 100, 150, 20);
        tf2.setEchoChar('*');

        b1 = new Button("Login");
        b1.setBounds(150, 150, 80, 30);
        b1.addActionListener(this);

        l3 = new Label();
        l3.setBounds(50, 200, 250, 20);

        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(b1);
        add(l3);

        setSize(400, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = tf1.getText();
        String password = tf2.getText();

        if (username.equals("admin") && password.equals("admin")) {
            l3.setText("Login Successful!");
        } else {
            l3.setText("Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
