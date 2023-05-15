package scottbraaten.Week2Lab;

/**************************************************** 
Program Name: HealthProfileGUI.java 
Programmer's Name: Scott Braaten
Program Description: GUI for BMI, BMI Category, and Max 
Heart Rate calculated based on user's age, weight, and height.
***********************************************************/

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HealthProfileGUI extends JFrame {
    private JTextField txtName, txtBMI, txtCategory, txtHR;
    private JFormattedTextField txtAge, txtWeight, txtHeightFt, txtHeightIn;
    private JButton displayButton, clearButton;
    private int heartRate;
    private double bmi;
    private String category;
    
    public HealthProfileGUI() {
        super("Health Profile");
        
        txtName = new JTextField(20);
        txtAge = new JFormattedTextField(NumberFormat.getNumberInstance());
        txtWeight = new JFormattedTextField(NumberFormat.getNumberInstance());
        txtHeightFt = new JFormattedTextField(NumberFormat.getNumberInstance());
        txtHeightIn = new JFormattedTextField(NumberFormat.getNumberInstance());
        
        txtName.setEditable(true);
        txtAge.setEditable(true);
        txtWeight.setEditable(true);
        txtHeightFt.setEditable(true);
        txtHeightIn.setEditable(true);
        
        displayButton = new JButton("Display");
        clearButton = new JButton("Clear");
        txtBMI = new JTextField(20);
        txtCategory = new JTextField(20);
        txtHR = new JTextField(20);
        
        setLayout(new GridLayout(0, 2));
        add(new JLabel("Name"));
        add(txtName);
        add(new JLabel("Age"));
        add(txtAge);
        add(new JLabel("Weight"));
        add(txtWeight);
        add(new JLabel("Height-Ft"));
        add(txtHeightFt);
        add(new JLabel("Height-In"));
        add(txtHeightIn);
        add(displayButton);
        add(clearButton);
        add(new JLabel("BMI"));
        add(txtBMI);
        add(new JLabel("Category"));
        add(txtCategory);
        add(new JLabel("Max Heart Rate"));
        add(txtHR);
        
        displayButton.addActionListener(new ButtonHandler(0));
        clearButton.addActionListener(new ButtonHandler(1));
    }
    
    private boolean validateInput() {
        String error = "";
        if (txtName.getText().equals("")) {
            error += "Please enter a name.\n\n";
        }

        if (txtAge.getText().equals("") || Integer.parseInt(txtAge.getText()) < 1) {
            error += "Please enter your age as a positive integer.\n\n";
        }
        
        if (txtWeight.getText().equals("") || Double.parseDouble(txtWeight.getText()) <= 0) {
            error += "Please enter your weight as a positive number.\n\n";
        }
        
        if (txtHeightFt.getText().equals("") || Integer.parseInt(txtHeightFt.getText()) < 1) {
            error += "Please enter your height in feet as a positive integer.\n\n";
        }
        
        if (txtHeightIn.getText().equals("") || Integer.parseInt(txtHeightIn.getText()) < 1) {
            error += "Please enter your height in inches as a positive integer.\n\n";
        }
        
        if (error.length() > 0) {
            JOptionPane.showMessageDialog(this, error);
            return false;
        }
        
        return true;
    }
    
    private void inputProcessing() {
        if (validateInput()) {
            HealthProfile currentUser = new HealthProfile(txtName.getText(), Integer.parseInt(txtAge.getText()), Double.parseDouble(txtWeight.getText()), Double.parseDouble(txtHeightFt.getText()), Double.parseDouble(txtHeightIn.getText()));
            
            bmi = currentUser.getBMI();
            category = currentUser.getCategory();
            heartRate = currentUser.getMaxHR();
            
            txtBMI.setText(String.valueOf(bmi));
            txtCategory.setText(category);
            txtHR.setText(String.valueOf(heartRate));
        }
    }
    
    private class ButtonHandler implements ActionListener {
        private int type;
        
        public ButtonHandler(int type) {
            this.type = type;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (type == 0) {
                inputProcessing();
            } else if (type == 1) {
                txtName.setText("");
                txtAge.setText("");
                txtWeight.setText("");
                txtHeightFt.setText("");
                txtHeightIn.setText("");
                txtBMI.setText("");
                txtCategory.setText("");
                txtHR.setText("");
            }
        }
    }
    
    public static void main(String[] args) {
        HealthProfileGUI frame = new HealthProfileGUI();
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
