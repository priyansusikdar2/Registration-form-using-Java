import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registrationform extends JFrame implements ActionListener {
    private JTextField nameField, emailField, dobField, phoneField;
    private JPasswordField passwordField;
    private JRadioButton maleButton, femaleButton;
    private JComboBox<String> countryCombo;
    private JCheckBox termsCheckBox;
    private JButton submitButton;
    private ButtonGroup genderGroup;

    private Font labelFont = new Font("Segoe UI", Font.BOLD, 18);
    private Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);

    public Registrationform() {
        setTitle("Registration Form");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Use a panel with padding and GridBagLayout for better design
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        // Add fields
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(createLabel("Name:"), gbc);
        gbc.gridx = 1;
        nameField = createTextField(20);
        panel.add(nameField, gbc);

        gbc.gridy = ++row;
        gbc.gridx = 0;
        panel.add(createLabel("Email:"), gbc);
        gbc.gridx = 1;
        emailField = createTextField(30); // Wider email field
        panel.add(emailField, gbc);

        gbc.gridy = ++row;
        gbc.gridx = 0;
        panel.add(createLabel("Password:"), gbc);
        gbc.gridx = 1;
        passwordField = new JPasswordField(20);
        passwordField.setFont(fieldFont);
        panel.add(passwordField, gbc);

        gbc.gridy = ++row;
        gbc.gridx = 0;
        panel.add(createLabel("Date of Birth:"), gbc);
        gbc.gridx = 1;
        dobField = createTextField(20);
        panel.add(dobField, gbc);

        gbc.gridy = ++row;
        gbc.gridx = 0;
        panel.add(createLabel("Phone Number:"), gbc);
        gbc.gridx = 1;
        phoneField = createTextField(20);
        panel.add(phoneField, gbc);

        gbc.gridy = ++row;
        gbc.gridx = 0;
        panel.add(createLabel("Gender:"), gbc);
        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        genderPanel.setBackground(Color.WHITE);
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        maleButton.setFont(fieldFont);
        femaleButton.setFont(fieldFont);
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        panel.add(genderPanel, gbc);

        gbc.gridy = ++row;
        gbc.gridx = 0;
        panel.add(createLabel("Country:"), gbc);
        gbc.gridx = 1;
        String[] countries = {"India", "USA", "UK", "Canada", "Australia", "Germany", "France", "Japan", "Brazil", "South Africa", "Italy", "Other"};
        countryCombo = new JComboBox<>(countries);
        countryCombo.setFont(fieldFont);
        panel.add(countryCombo, gbc);

        // Terms checkbox
        gbc.gridy = ++row;
        gbc.gridx = 1;
        termsCheckBox = new JCheckBox("I accept all the terms and conditions.");
        termsCheckBox.setFont(fieldFont);
        termsCheckBox.setBackground(Color.WHITE);
        panel.add(termsCheckBox, gbc);

        // Submit button
        gbc.gridy = ++row;
        gbc.gridx = 1;
        submitButton = new JButton("Submit");
        submitButton.setFont(labelFont);
        submitButton.setBackground(new Color(59, 89, 182));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(this);
        panel.add(submitButton, gbc);

        add(panel);
        setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(labelFont);
        return label;
    }

    private JTextField createTextField(int columns) {
        JTextField field = new JTextField(columns);
        field.setFont(fieldFont);
        return field;
    }

    public void actionPerformed(ActionEvent e) {
        if (!termsCheckBox.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please accept the terms and conditions.");
            return;
        }

        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String dob = dobField.getText();
        String phone = phoneField.getText();
        String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : "Not selected");
        String country = (String) countryCombo.getSelectedItem();

        JOptionPane.showMessageDialog(this,
                "Registration Successful!\n\n" +
                        "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "DOB: " + dob + "\n" +
                        "Phone: " + phone + "\n" +
                        "Gender: " + gender + "\n" +
                        "Country: " + country);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Registrationform());
    }
}
