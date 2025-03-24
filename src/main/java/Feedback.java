import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Feedback extends JFrame {
    private JTextField emailField, firstNameField, lastNameField;
    private JTextArea commentArea;
    private JButton submitButton, displayButton;
    private JComboBox<String> genderBox;
    private JPanel formPanel;
    private ArrayList<String[]> feedbackData; // Use ArrayList instead of Vector

    public Feedback() {
        setTitle("Feedback Form");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        feedbackData = new ArrayList<>(); // Initialize ArrayList

        // 🌟 Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(220, 220, 250));

        // 🌟 Form Panel
        formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formPanel.setBackground(new Color(200, 230, 201));
        formPanel.setBorder(BorderFactory.createTitledBorder("User Details"));

        formPanel.add(new JLabel("Gender:"));
        genderBox = new JComboBox<>(new String[]{"Male", "Female"});
        formPanel.add(genderBox);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        formPanel.add(firstNameField);

        formPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        formPanel.add(lastNameField);

        formPanel.add(new JLabel("Comment:"));
        commentArea = new JTextArea(3, 20);
        formPanel.add(new JScrollPane(commentArea));

        // 🌟 Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(250, 230, 200));

        submitButton = new JButton("Submit");
        displayButton = new JButton("Display Result");
        displayButton.setEnabled(false); // Disabled until there is data

        buttonPanel.add(submitButton);
        buttonPanel.add(displayButton);

        // 🌟 Adding Sections
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);

        // 🌟 Event Listeners
        commentArea.addCaretListener(e -> validateComment());
        submitButton.addActionListener(e -> handleSubmit());
        displayButton.addActionListener(e -> handleDisplay());

        setVisible(true);
    }

    // ✅ Validate Comment Length (50-100 characters)
    private void validateComment() {
        int length = commentArea.getText().length();
        submitButton.setEnabled(length >= 50 && length <= 100);
    }

    // ✅ Handle Form Submission
    private void handleSubmit() {
        if (emailField.getText().isEmpty() || firstNameField.getText().isEmpty() ||
                lastNameField.getText().isEmpty() || commentArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
        } else {
            // Store feedback data as String[]
            String[] row = {
                    genderBox.getSelectedItem().toString(),
                    emailField.getText(),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    commentArea.getText()
            };

            feedbackData.add(row);
            displayButton.setEnabled(true); // Enable Display Button

            JOptionPane.showMessageDialog(this, "Feedback submitted successfully!");

            // Clear fields
            emailField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            commentArea.setText("");
        }
    }

    // ✅ Handle Display Button to Open ResultPage
    private void handleDisplay() {
        if (!feedbackData.isEmpty()) {
            new ResultPage(feedbackData).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No feedback available!");
        }
    }

    // ✅ Main Method to Run the Program
    public static void main(String[] args) {
        new Feedback();
    }
}
