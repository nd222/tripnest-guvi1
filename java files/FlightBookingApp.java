import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlightBookingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlightFinder");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        // Input fields
        JLabel fromLabel = new JLabel("From:");
        JTextField fromField = new JTextField();

        JLabel toLabel = new JLabel("To:");
        JTextField toField = new JTextField();

        JLabel departureLabel = new JLabel("Departure Date:");
        JTextField departureField = new JTextField();

        JLabel returnLabel = new JLabel("Return Date (Optional):");
        JTextField returnField = new JTextField();

        JLabel passengersLabel = new JLabel("Passengers:");
        JTextField passengersField = new JTextField();

        JCheckBox studentCheckbox = new JCheckBox("Student");
        JCheckBox seniorCheckbox = new JCheckBox("Senior Citizen");
        JCheckBox armedForcesCheckbox = new JCheckBox("Armed Forces");

        JButton submitButton = new JButton("Search Flights");

        // Adding components to the panel
        panel.add(fromLabel);
        panel.add(fromField);

        panel.add(toLabel);
        panel.add(toField);

        panel.add(departureLabel);
        panel.add(departureField);

        panel.add(returnLabel);
        panel.add(returnField);

        panel.add(passengersLabel);
        panel.add(passengersField);

        panel.add(studentCheckbox);
        panel.add(seniorCheckbox);

        panel.add(armedForcesCheckbox);
        panel.add(new JLabel("")); // Empty cell for padding

        panel.add(new JLabel("")); // Empty cell for padding
        panel.add(submitButton);

        frame.add(panel, BorderLayout.CENTER);

        // Action Listener for submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String from = fromField.getText();
                String to = toField.getText();
                String departureDate = departureField.getText();
                String returnDate = returnField.getText();
                String passengers = passengersField.getText();
                String specialFares = "";

                if (studentCheckbox.isSelected()) {
                    specialFares += "Student ";
                }
                if (seniorCheckbox.isSelected()) {
                    specialFares += "Senior Citizen ";
                }
                if (armedForcesCheckbox.isSelected()) {
                    specialFares += "Armed Forces ";
                }

                String summary = "Searching for flights:\n" +
                        "From: " + from + "\n" +
                        "To: " + to + "\n" +
                        "Departure Date: " + departureDate + "\n" +
                        "Return Date: " + returnDate + "\n" +
                        "Passengers: " + passengers + "\n" +
                        "Special Fares: " + (specialFares.isEmpty() ? "None" : specialFares);

                JOptionPane.showMessageDialog(frame, summary, "Flight Search Summary", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}
