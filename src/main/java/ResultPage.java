import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ResultPage extends JFrame {
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public ResultPage(ArrayList<String[]> feedbackData) {
        setTitle("Feedback Results");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // 🌟 Table Panel
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Submitted Feedback"));

        // Create Table Model
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Gender", "Email", "First Name", "Last Name", "Comment"});

        // Add Data
        for (String[] row : feedbackData) {
            tableModel.addRow(row);
        }

        // Create Table
        dataTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(dataTable);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        add(tablePanel);
    }
}
