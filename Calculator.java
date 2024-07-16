import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    TextField tf1, tf2, tf3;
    Button b1, b2, b3, b4;

    Calculator() {
        tf1 = new TextField();
        tf1.setBounds(50, 50, 150, 20);
        tf2 = new TextField();
        tf2.setBounds(50, 100, 150, 20);
        tf3 = new TextField();
        tf3.setBounds(50, 150, 150, 20);
        tf3.setEditable(false);

        b1 = new Button("+");
        b1.setBounds(50, 200, 50, 50);
        b2 = new Button("-");
        b2.setBounds(110, 200, 50, 50);
        b3 = new Button("*");
        b3.setBounds(170, 200, 50, 50);
        b4 = new Button("/");
        b4.setBounds(230, 200, 50, 50);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        add(tf1);
        add(tf2);
        add(tf3);
        add(b1);
        add(b2);
        add(b3);
        add(b4);

        setSize(350, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int num1 = Integer.parseInt(tf1.getText());
        int num2 = Integer.parseInt(tf2.getText());
        int result = 0;

        if (e.getSource() == b1) {
            result = num1 + num2;
        } else if (e.getSource() == b2) {
            result = num1 - num2;
        } else if (e.getSource() == b3) {
            result = num1 * num2;
        } else if (e.getSource() == b4) {
            result = num1 / num2;
        }
        
        tf3.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
