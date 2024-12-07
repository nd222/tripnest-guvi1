import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationApp {

    private JFrame frame;
    private JButton scrollTopBtn;
    private JScrollPane scrollPane;
    private JPanel contentPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NavigationApp().initializeUI());
    }

    public void initializeUI() {
        frame = new JFrame("Navigation App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setLayout(new BorderLayout());

        // Navigation buttons
        JPanel navPanel = new JPanel(new FlowLayout());
        JButton busButton = new JButton("Bus Booking");
        JButton flightButton = new JButton("Flight Booking");
        JButton hotelButton = new JButton("Hotel Booking");

        busButton.addActionListener(e -> navigateTo("Bus"));
        flightButton.addActionListener(e -> navigateTo("Flight"));
        hotelButton.addActionListener(e -> navigateTo("Hotel"));

        navPanel.add(busButton);
        navPanel.add(flightButton);
        navPanel.add(hotelButton);

        frame.add(navPanel, BorderLayout.NORTH);

        // Content panel with scroll
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 20; i++) {
            JLabel label = new JLabel("Content Block " + i);
            label.setPreferredSize(new Dimension(500, 100));
            label.setOpaque(true);
            label.setBackground(new Color(240, 240, 240));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            contentPanel.add(label);
        }

        scrollPane = new JScrollPane(contentPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Scroll to top button
        scrollTopBtn = new JButton("Scroll to Top");
        scrollTopBtn.setVisible(false); // Initially hidden
        scrollTopBtn.addActionListener(e -> scrollToTop());
        frame.add(scrollTopBtn, BorderLayout.SOUTH);

        // Scroll listener to show/hide scrollTopBtn
        Timer scrollCheckTimer = new Timer(100, e -> checkScrollPosition());
        scrollCheckTimer.start();

        frame.setVisible(true);
    }

    private void navigateTo(String service) {
        JOptionPane.showMessageDialog(frame, "Navigating to " + service + " booking page...");
    }

    private void scrollToTop() {
        SwingUtilities.invokeLater(() -> {
            JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
            verticalBar.setValue(0); // Smooth scrolling simulation
        });
    }

    private void checkScrollPosition() {
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        scrollTopBtn.setVisible(verticalBar.getValue() > 300);
    }
}
