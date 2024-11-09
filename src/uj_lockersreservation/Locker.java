package uj_lockersreservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Locker extends JFrame {
    
    private String selectedBuilding = ""; // Variable to store the selected building
    
        // Constructor to initialize the frame
    public Locker() {
        setTitle("Locker Reservation");
        setSize(800, 600); // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application when window is closed
        page4(); // Initial page display
    }

    // Page 4: Choose a building for locker reservation
    public void page4() {
        // Clear the current content pane and set up layout
        getContentPane().removeAll();
        setLayout(new BorderLayout(10, 10)); // Set layout with horizontal and vertical gaps

        // Create and style the question label
        JLabel questionLabel = new JLabel("Which building do you want?", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set font style
        questionLabel.setForeground(new Color(0, 102, 204)); // Set text color
        add(questionLabel, BorderLayout.NORTH); // Add label to the top of the layout

        // Create a panel to hold building options
        JPanel buildingPanel = new JPanel();
        buildingPanel.setLayout(new GridLayout(0, 2, 15, 15)); // 2 columns, with gaps
        buildingPanel.setBackground(new Color(245, 245, 245)); // Set background color

        // Array of building numbers
        String[] buildingNumbers = {
            "Building 11", "Building 17", "Building 5", "Building 12",
            "Building 3", "Building 14", "Building 6", "Building 7",
            "Building 8", "Building 15", "Building 2", "Building 9",
            "Building 10", "Building 4", "Building 18", "Building 20"
        };

        // Loop to create buttons for each building
        for (String building : buildingNumbers) {
            // Create a button for each building
            JButton buildingButton = new JButton(building);
            buildingButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style
            buildingButton.setBackground(new Color(220, 220, 220)); // Set button background color
            buildingButton.setForeground(new Color(50, 50, 50)); // Set button text color

            // Add an ActionListener to handle the selection of a building
            buildingButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    selectedBuilding = building; // Save selected building name
                    System.out.println("Selected Building: " + selectedBuilding); // Debug print
                    page5(); // Display locker availability for the selected building
                }
            });

            buildingPanel.add(buildingButton); // Add the button to the panel
        }

        // Create a scroll pane for the building panel
        JScrollPane scrollPane = new JScrollPane(buildingPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar
        add(scrollPane, BorderLayout.CENTER); // Add scroll pane to the center of the layout

        // Update the frame to reflect changes
        revalidate();
        repaint();
    }

    // Page 5: Show available lockers for the selected building
// Page 5: Show available lockers for the selected building
public void page5() {
    // Clear the current content pane and set up layout
    getContentPane().removeAll();
    setLayout(new BorderLayout(10, 10)); // Set layout with margins

    // Building label
    JLabel buildingLabel = new JLabel(selectedBuilding + " - Locker Availability", SwingConstants.CENTER);
    buildingLabel.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set font style
    buildingLabel.setForeground(new Color(0, 102, 204)); // Set text color
    add(buildingLabel, BorderLayout.NORTH); // Add label to the top of the layout

    // Locker panel
    JPanel lockerPanel = new JPanel();
    lockerPanel.setLayout(new GridLayout(5, 5, 5, 5)); // 5 rows and 5 columns with gaps
    lockerPanel.setBackground(new Color(245, 245, 245)); // Set panel background color

    // Arrays for available and unavailable lockers
    String[] availableLockers = {
        "Locker 1", "Locker 2", "Locker 3", "Locker 4", "Locker 5",
        "Locker 6", "Locker 7", "Locker 8", "Locker 9", "Locker 10",
        "Locker 11", "Locker 12", "Locker 13", "Locker 14", "Locker 15",
        "Locker 16", "Locker 17", "Locker 18", "Locker 19", "Locker 20",
        "Locker 21", "Locker 22", "Locker 23", "Locker 24", "Locker 25"
    };

    String[] unavailableLockers = {
        "Locker 26", "Locker 27", "Locker 28", "Locker 29", "Locker 30",
        "Locker 31", "Locker 32", "Locker 33", "Locker 34", "Locker 35",
        "Locker 36", "Locker 37", "Locker 38", "Locker 39", "Locker 40",
        "Locker 41", "Locker 42", "Locker 43", "Locker 44", "Locker 45",
        "Locker 46", "Locker 47", "Locker 48", "Locker 49", "Locker 50"
    };

    // Create panels for available lockers (Green)
    for (String locker : availableLockers) {
        JButton lockerButton = new JButton(locker); // Create a button for each locker
        lockerButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set font style
        lockerButton.setBackground(new Color(46, 204, 113)); // Green background for available lockers
        lockerButton.setForeground(Color.WHITE); // White text for contrast
        lockerButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(34, 139, 34), 2), // Dark green border
            BorderFactory.createEmptyBorder(10, 10, 10, 10) // Padding
        ));

        // Add an ActionListener to handle locker selection
        lockerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Locker Selected: " + locker); // Debug print
                // Instantiate the Payment class and navigate to the payment page
                Payment paymentPage = new Payment();
                paymentPage.page6(); // Call page6() to show the payment options
                paymentPage.setSize(600, 500);
                paymentPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                paymentPage.setLocationRelativeTo(null);
                paymentPage.setVisible(true); // Make Locker frame visible
            }
        });

        lockerPanel.add(lockerButton); // Add locker button to lockerPanel
    }

    // Create panels for unavailable lockers (Red)
    for (String locker : unavailableLockers) {
        JButton lockerButton = new JButton(locker); // Create a button for each locker
        lockerButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set font style
        lockerButton.setBackground(new Color(231, 76, 60)); // Red background for unavailable lockers
        lockerButton.setForeground(Color.WHITE); // White text for contrast
        lockerButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(192, 57, 43), 2), // Dark red border
            BorderFactory.createEmptyBorder(10, 10, 10, 10) // Padding
        ));

        // Add an ActionListener to show a message when selecting an unavailable locker
        lockerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This locker is already reserved.", "Locker Reserved", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        lockerPanel.add(lockerButton); // Add locker button to lockerPanel
    }

    // Create a scroll pane for the locker panel
    JScrollPane scrollPane = new JScrollPane(lockerPanel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar
    add(scrollPane, BorderLayout.CENTER); // Add scroll pane to the center of the layout

    // Update the frame to reflect changes
    revalidate();
    repaint();
}

    public static void main(String[] args) {
        // Launch the Locker frame
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Locker().setVisible(true);
            }
        });
    }
}
