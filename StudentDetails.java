import java.awt.*;
import java.awt.event.*;

public class StudentDetails extends Frame implements ActionListener {
    TextField nameField, rollField;
    TextArea addressArea, infoArea;
    List colorList;
    CheckboxGroup genderGroup;
    Checkbox male, female;
    Checkbox hobby1, hobby2, hobby3;
    Choice classChoice;
    Button addButton, removeButton;
    MenuBar menuBar;
    Menu menu;
    MenuItem addItem, removeItem;

    StudentDetails() {
        // Name
        Label nameLabel = new Label("Name:");
        nameLabel.setBounds(50, 50, 100, 20);
        nameField = new TextField();
        nameField.setBounds(150, 50, 150, 20);

        // Roll Number
        Label rollLabel = new Label("Roll Number:");
        rollLabel.setBounds(50, 100, 100, 20);
        rollField = new TextField();
        rollField.setBounds(150, 100, 150, 20);

        // Address
        Label addressLabel = new Label("Address:");
        addressLabel.setBounds(50, 150, 100, 20);
        addressArea = new TextArea();
        addressArea.setBounds(150, 150, 150, 60);

        // Favorite Color
        Label colorLabel = new Label("Favorite Color:");
        colorLabel.setBounds(50, 230, 100, 20);
        colorList = new List();
        colorList.setBounds(150, 230, 150, 60);
        colorList.add("Red");
        colorList.add("Green");
        colorList.add("Blue");
        colorList.add("Yellow");

        // Gender
        Label genderLabel = new Label("Gender:");
        genderLabel.setBounds(50, 300, 100, 20);
        genderGroup = new CheckboxGroup();
        male = new Checkbox("Male", genderGroup, false);
        male.setBounds(150, 300, 60, 20);
        female = new Checkbox("Female", genderGroup, false);
        female.setBounds(220, 300, 70, 20);

        // Hobbies
        Label hobbyLabel = new Label("Hobbies:");
        hobbyLabel.setBounds(50, 350, 100, 20);
        hobby1 = new Checkbox("Reading");
        hobby1.setBounds(150, 350, 70, 20);
        hobby2 = new Checkbox("Sports");
        hobby2.setBounds(230, 350, 60, 20);
        hobby3 = new Checkbox("Music");
        hobby3.setBounds(300, 350, 60, 20);

        // Class
        Label classLabel = new Label("Class:");
        classLabel.setBounds(50, 400, 100, 20);
        classChoice = new Choice();
        classChoice.setBounds(150, 400, 150, 20);
        classChoice.add("10th");
        classChoice.add("12th");
        classChoice.add("Undergraduate");
        classChoice.add("Postgraduate");

        // Buttons
        addButton = new Button("Add Details");
        addButton.setBounds(50, 450, 100, 30);
        addButton.addActionListener(this);

        removeButton = new Button("Remove Details");
        removeButton.setBounds(200, 450, 100, 30);
        removeButton.addActionListener(this);

        // Complete Info Area
        infoArea = new TextArea();
        infoArea.setBounds(50, 500, 300, 100);

        // Menu
        menuBar = new MenuBar();
        menu = new Menu("Menu");
        addItem = new MenuItem("Add");
        removeItem = new MenuItem("Remove");
        menu.add(addItem);
        menu.add(removeItem);
        menuBar.add(menu);
        setMenuBar(menuBar);
        
        addItem.addActionListener(this);
        removeItem.addActionListener(this);

        // Add components
        add(nameLabel);
        add(nameField);
        add(rollLabel);
        add(rollField);
        add(addressLabel);
        add(addressArea);
        add(colorLabel);
        add(colorList);
        add(genderLabel);
        add(male);
        add(female);
        add(hobbyLabel);
        add(hobby1);
        add(hobby2);
        add(hobby3);
        add(classLabel);
        add(classChoice);
        add(addButton);
        add(removeButton);
        add(infoArea);

        setSize(400, 650);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton || e.getSource() == addItem) {
            String name = nameField.getText();
            String roll = rollField.getText();
            String address = addressArea.getText();
            String color = colorList.getSelectedItem();
            String gender = genderGroup.getSelectedCheckbox().getLabel();
            String hobbies = "";
            if (hobby1.getState()) hobbies += "Reading ";
            if (hobby2.getState()) hobbies += "Sports ";
            if (hobby3.getState()) hobbies += "Music ";
            String studentClass = classChoice.getSelectedItem();

            infoArea.setText("Name: " + name + "\nRoll Number: " + roll + "\nAddress: " + address + 
                             "\nFavorite Color: " + color + "\nGender: " + gender + "\nHobbies: " + hobbies + 
                             "\nClass: " + studentClass);
        } else if (e.getSource() == removeButton || e.getSource() == removeItem) {
            nameField.setText("");
            rollField.setText("");
            addressArea.setText("");
            colorList.deselect(colorList.getSelectedIndex());
            genderGroup.setSelectedCheckbox(null);
            hobby1.setState(false);
            hobby2.setState(false);
            hobby3.setState(false);
            classChoice.select(0);
            infoArea.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentDetails();
    }
}
