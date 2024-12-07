import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightBookingApp {

    private JFrame frame;
    private JPanel returnDateGroup;
    private JButton oneWayButton, roundTripButton;
    private ButtonGroup tripTypeButtons;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FlightBookingApp().initializeUI());
    }

    public void initializeUI() {
        frame = new JFrame("Flight Booking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Trip type buttons panel
        JPanel tripTypePanel = new JPanel(new FlowLayout());
        oneWayButton = new JButton("One Way");
        roundTripButton = new JButton("Round Trip");

        // Add listeners for trip type selection
        oneWayButton.addActionListener(e -> selectTripType("one-way"));
        roundTripButton.addActionListener(e -> selectTripType("round-trip"));

        tripTypePanel.add(oneWayButton);
        tripTypePanel.add(roundTripButton);

        frame.add(tripTypePanel, BorderLayout.NORTH);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Departure Date:"));
        JTextField departureDateField = new JTextField();
        formPanel.add(departureDateField);

        returnDateGroup = new JPanel(new FlowLayout());
        returnDateGroup.add(new JLabel("Return Date:"));
        JTextField returnDateField = new JTextField();
        returnDateGroup.add(returnDateField);
        returnDateGroup.setVisible(false); // Initially hidden
        formPanel.add(returnDateGroup);

        frame.add(formPanel, BorderLayout.CENTER);

        // Submit button
        JButton submitButton = new JButton("Search Flights");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Searching for flights...");
            }
        });

        frame.add(submitButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void selectTripType(String type) {
        // Toggle return date visibility
        if (type.equals("round-trip")) {
            returnDateGroup.setVisible(true);
        } else {
            returnDateGroup.setVisible(false);
        }

        // Update button styles
        oneWayButton.setEnabled(!type.equals("one-way"));
        roundTripButton.setEnabled(!type.equals("round-trip"));
    }
}
