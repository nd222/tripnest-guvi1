import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusBookingApp {

    private JFrame frame;
    private JTextField fromField, toField, dateField, passengersField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BusBookingApp().initializeUI());
    }

    public void initializeUI() {
        frame = new JFrame("Bus Booking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Input fields panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("From:"));
        fromField = new JTextField();
        formPanel.add(fromField);

        formPanel.add(new JLabel("To:"));
        toField = new JTextField();
        formPanel.add(toField);

        formPanel.add(new JLabel("Date:"));
        dateField = new JTextField("yyyy-mm-dd"); // Placeholder for date format
        formPanel.add(dateField);

        formPanel.add(new JLabel("Passengers:"));
        passengersField = new JTextField();
        formPanel.add(passengersField);

        frame.add(formPanel, BorderLayout.CENTER);

        // Search button
        JButton searchButton = new JButton("Search Bus");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBus();
            }
        });

        frame.add(searchButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void searchBus() {
        String from = fromField.getText().trim();
        String to = toField.getText().trim();
        String date = dateField.getText().trim();
        String passengers = passengersField.getText().trim();

        // Validation
        if (from.isEmpty() || to.isEmpty() || date.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all required fields.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Display search details
        JOptionPane.showMessageDialog(frame, String.format(
                "Searching buses from %s to %s on %s for %s passengers.",
                from, to, date, passengers.isEmpty() ? "1" : passengers));
    }
}
