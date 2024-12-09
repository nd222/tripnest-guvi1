import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CabBookingApp {

    private JFrame frame;
    private JTextField pickupField, dropField, dateField, timeField;
    private JComboBox<String> carTypeDropdown;
    private JPanel returnFieldsPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CabBookingApp().initializeUI());
    }

    public void initializeUI() {
        frame = new JFrame("Cab Booking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Trip type buttons
        JPanel tripTypePanel = new JPanel(new FlowLayout());
        JButton oneWayButton = new JButton("One Way");
        JButton roundTripButton = new JButton("Round Trip");

        oneWayButton.addActionListener(e -> setTripType("oneway", oneWayButton, roundTripButton));
        roundTripButton.addActionListener(e -> setTripType("roundtrip", oneWayButton, roundTripButton));

        tripTypePanel.add(oneWayButton);
        tripTypePanel.add(roundTripButton);
        frame.add(tripTypePanel, BorderLayout.NORTH);

        // Input fields
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Pickup Location:"));
        pickupField = new JTextField();
        formPanel.add(pickupField);

        formPanel.add(new JLabel("Drop Location:"));
        dropField = new JTextField();
        formPanel.add(dropField);

        formPanel.add(new JLabel("Date:"));
        dateField = new JTextField();
        formPanel.add(dateField);

        formPanel.add(new JLabel("Time:"));
        timeField = new JTextField();
        formPanel.add(timeField);

        formPanel.add(new JLabel("Car Type:"));
        carTypeDropdown = new JComboBox<>(new String[] { "Sedan", "SUV", "Hatchback" });
        formPanel.add(carTypeDropdown);

        // Return date and time fields
        returnFieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        returnFieldsPanel.setVisible(false);
        returnFieldsPanel.add(new JLabel("Return Date:"));
        JTextField returnDateField = new JTextField();
        returnFieldsPanel.add(returnDateField);

        returnFieldsPanel.add(new JLabel("Return Time:"));
        JTextField returnTimeField = new JTextField();
        returnFieldsPanel.add(returnTimeField);

        formPanel.add(returnFieldsPanel);
        frame.add(formPanel, BorderLayout.CENTER);

        // Search button
        JButton searchButton = new JButton("Search Cab");
        searchButton.addActionListener(e -> searchCab());
        frame.add(searchButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void setTripType(String type, JButton oneWayButton, JButton roundTripButton) {
        boolean isRoundTrip = type.equals("roundtrip");

        returnFieldsPanel.setVisible(isRoundTrip);
        oneWayButton.setEnabled(!isRoundTrip);
        roundTripButton.setEnabled(!oneWayButton.isEnabled());
    }

    private void searchCab() {
        String pickup = pickupField.getText();
        String drop = dropField.getText();
        String date = dateField.getText();
        String time = timeField.getText();
        String carType = (String) carTypeDropdown.getSelectedItem();

        if (pickup.isEmpty() || drop.isEmpty() || date.isEmpty() || time.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all required fields.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(frame, String.format(
                "Searching cab from %s to %s on %s at %s in a %s.", pickup, drop, date, time, carType));
    }
}
