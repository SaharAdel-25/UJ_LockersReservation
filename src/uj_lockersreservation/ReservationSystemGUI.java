package uj_lockersreservation;

import java.awt.*;
import javax.swing.*;

public class ReservationSystemGUI extends JFrame {

    // Constructor to set up the main JFrame
    public ReservationSystemGUI() { 
        super("UJ Lockers Reservation");
        setSize(600, 500); // Set the window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        setLocationRelativeTo(null); // Center the window on the screen

//        page1();
//        page2();
//        page3();
//        page4();
//        page5();
        page6(); 
    }

    // Page 1: Starting page with login and register options
    public void page1() {
        setLayout(new BorderLayout()); // Use BorderLayout for main layout

        JPanel loginPanel = new JPanel(); // Create a panel for login
        loginPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for flexible positioning
        loginPanel.setBackground(new Color(245, 245, 245)); // Set background color

        GridBagConstraints gbc = new GridBagConstraints(); // For positioning components
        gbc.insets = new Insets(10, 10, 10, 10); // Set margins between components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome to UJ Lockers Reservation System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set font style
        welcomeLabel.setForeground(new Color(0, 102, 204)); // Set text color
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; // Positioning
        loginPanel.add(welcomeLabel, gbc); // Add label to panel

        // Log in Button
        JButton loginButton = new JButton("Log in");
        styleButton(loginButton); // Apply style
        gbc.gridy++; // Move to next row
        loginPanel.add(loginButton, gbc); // Add button to panel

        // Register button
        JButton registerButton = new JButton("Register");
        styleButton(registerButton); // Apply style
        gbc.gridy++; // Move to next row
        loginPanel.add(registerButton, gbc); // Add button to panel

        add(loginPanel, BorderLayout.CENTER); // Add panel to frame
        
        setVisible(true); // Make frame visible
    }

    // Page 2: Registration page where users can create an account
    public void page2() {
        getContentPane().removeAll(); // Clear previous components
        setLayout(new BorderLayout()); // Set layout

        JPanel registerPanel = new JPanel(); // Create registration panel
        registerPanel.setLayout(new GridBagLayout()); // Use GridBagLayout
        registerPanel.setBackground(new Color(245, 245, 245)); // Set background color
        GridBagConstraints gbc = new GridBagConstraints(); // For positioning

        gbc.insets = new Insets(10, 10, 10, 10); // Set margins
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.gridx = 0; gbc.gridy = 0; // Start position

        // Sign up label
        JLabel signUpLabel = new JLabel("Create a New Account", SwingConstants.CENTER);
        signUpLabel.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set font style
        signUpLabel.setForeground(new Color(0, 102, 204)); // Set text color
        gbc.gridwidth = 2; // Span across two columns
        registerPanel.add(signUpLabel, gbc); // Add label to panel

        // First Name label and text field
        gbc.gridy++; gbc.gridwidth = 1; // Move to next row and reset width
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        registerPanel.add(firstNameLabel, gbc); // Add label to panel

        gbc.gridx = 1; // Move to next column
        JTextField firstNameField = new JTextField(15); // Text field for first name
        firstNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        registerPanel.add(firstNameField, gbc); // Add text field to panel

        gbc.gridx = 0; // Set the column index to 0 for the next component
        gbc.gridy++; // Move to the next row
        JLabel lastNameLabel = new JLabel("Last Name:"); // Create a label for last name
        lastNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16)); // Set font style for the label
        registerPanel.add(lastNameLabel, gbc); // Add the last name label to the register panel

        gbc.gridx = 1; // Set the column index to 1 for the text field
        JTextField lastNameField = new JTextField(15); // Create a text field for last name input
        lastNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // Set font style for the text field
        registerPanel.add(lastNameField, gbc); // Add the last name text field to the register panel

        gbc.gridx = 0; // Reset the column index to 0 for the next label
        gbc.gridy++; // Move to the next row
        JLabel emailLabel = new JLabel("Email:"); // Create a label for email
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16)); // Set font style for the label
        registerPanel.add(emailLabel, gbc); // Add the email label to the register panel

        gbc.gridx = 1; // Set the column index to 1 for the text field
        JTextField emailField = new JTextField(15); // Create a text field for email input
        emailField.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // Set font style for the text field
        registerPanel.add(emailField, gbc); // Add the email text field to the register panel

        gbc.gridx = 0; // Reset the column index to 0 for the next label
        gbc.gridy++; // Move to the next row
        JLabel idLabel = new JLabel("ID Number:"); // Create a label for ID number
        idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16)); // Set font style for the label
        registerPanel.add(idLabel, gbc); // Add the ID number label to the register panel

        gbc.gridx = 1; // Set the column index to 1 for the text field
        JTextField idField = new JTextField(15); // Create a text field for ID number input
        idField.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // Set font style for the text field
        registerPanel.add(idField, gbc); // Add the ID number text field to the register panel

        gbc.gridx = 0; // Reset the column index to 0 for the next label
        gbc.gridy++; // Move to the next row
        JLabel passwordLabel = new JLabel("Password:"); // Create a label for password
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16)); // Set font style for the label
        registerPanel.add(passwordLabel, gbc); // Add the password label to the register panel

        gbc.gridx = 1; // Set the column index to 1 for the password field
        JPasswordField passwordField = new JPasswordField(15); // Create a password field for secure input
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // Set font style for the password field
        registerPanel.add(passwordField, gbc); // Add the password field to the register panel

        // Register button
        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2; // Reset position
        JButton signUpSubmitButton = new JButton("Register");
        styleButton(signUpSubmitButton); // Apply style
        registerPanel.add(signUpSubmitButton, gbc); // Add button to panel

        // Back button
        gbc.gridy++; // Move to next row
        JButton backButton = new JButton("Back");
        styleButton(backButton); // Apply style
        backButton.setBackground(new Color(233, 87, 63)); // Change background color
        registerPanel.add(backButton, gbc); // Add button to panel

        add(registerPanel, BorderLayout.CENTER); // Add register panel to frame
    }

        // Page 3: Login page for user authentication
        public void page3() {
            setLayout(new BorderLayout()); // Set layout for the main container

            JPanel loginPanel = new JPanel(); // Create a panel for login components
            loginPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for flexible positioning
            loginPanel.setBackground(new Color(245, 245, 245)); // Set background color of the panel
            GridBagConstraints gbc = new GridBagConstraints(); // Create constraints for positioning components

            gbc.insets = new Insets(10, 10, 10, 10); // Set margins around components
            gbc.fill = GridBagConstraints.HORIZONTAL; // Components will fill horizontally
            gbc.gridx = 0; // Start at column 0
            gbc.gridy = 0; // Start at row 0

            // Login label
            JLabel loginLabel = new JLabel("Log in", SwingConstants.CENTER); // Create a centered login label
            loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set font style for the label
            loginLabel.setForeground(new Color(0, 102, 204)); // Set text color to a vibrant blue
            gbc.gridwidth = 2; // Make the label span across two columns
            loginPanel.add(loginLabel, gbc); // Add the login label to the panel

            // ID Number label and text field
            gbc.gridy++; // Move to the next row
            gbc.gridwidth = 1; // Reset grid width to 1 for the next label
            JLabel idLabel = new JLabel("ID Number:"); // Create a label for ID number
            idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16)); // Set font style for the label
            loginPanel.add(idLabel, gbc); // Add ID label to the panel

            gbc.gridx = 1; // Move to the next column for the text field
            JTextField idField = new JTextField(15); // Create a text field for ID number input
            idField.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // Set font style for the text field
            loginPanel.add(idField, gbc); // Add ID text field to the panel

            // First Name label and text field
            gbc.gridx = 0; // Reset column index to 0 for the next label
            gbc.gridy++; // Move to the next row
            JLabel firstNameLabel = new JLabel("First Name:"); // Create a label for first name
            firstNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16)); // Set font style for the label
            loginPanel.add(firstNameLabel, gbc); // Add first name label to the panel

            gbc.gridx = 1; // Move to the next column for the text field
            JTextField firstNameField = new JTextField(15); // Create a text field for first name input
            firstNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // Set font style for the text field
            loginPanel.add(firstNameField, gbc); // Add first name text field to the panel

            // Login button
            gbc.gridx = 0; // Reset column index to 0 for the button
            gbc.gridy++; // Move to the next row
            gbc.gridwidth = 2; // Make the button span across two columns
            JButton loginButton = new JButton("Login"); // Create the login button
            styleButton(loginButton); // Apply styling to the button
            loginPanel.add(loginButton, gbc); // Add button to the panel

            add(loginPanel, BorderLayout.CENTER); // Add the login panel to the center of the frame
        }
    
        // Page 4: Choose a building for locker reservation
        public void page4() {
            // Clear the current content pane
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

            // Loop to create building boxes
            for (String building : buildingNumbers) {
                JPanel buildingBox = new JPanel(new BorderLayout()); // Each building box
                buildingBox.setBackground(new Color(220, 220, 220)); // Set background color
                buildingBox.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0, 153, 204), 2), // Line border
                    BorderFactory.createEmptyBorder(10, 10, 10, 10) // Padding
                ));

                JLabel buildingLabel = new JLabel(building, SwingConstants.CENTER); // Create label for building
                buildingLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style
                buildingLabel.setForeground(new Color(50, 50, 50)); // Set label color
                buildingBox.add(buildingLabel, BorderLayout.CENTER); // Add label to the box

                buildingPanel.add(buildingBox); // Add the building box to the main panel
            }

            // Create a scroll pane for the building panel
            JScrollPane scrollPane = new JScrollPane(buildingPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar

            add(scrollPane, BorderLayout.CENTER); // Add scroll pane to the center of the layout
    }

        // Page 5: Display locker availability
        public void page5() {
            // Clear the current content pane
            getContentPane().removeAll();
            setLayout(new BorderLayout(10, 10)); // Set layout with margins

            // Building label
            JLabel buildingLabel = new JLabel("Building A - Locker Availability", SwingConstants.CENTER);
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

            // Create panels for available lockers
            for (String locker : availableLockers) {
                JPanel panel = new JPanel(new BorderLayout()); // Panel for each locker
                panel.setBackground(new Color(46, 204, 113)); // Green background for available lockers
                panel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(34, 139, 34), 2), // Dark green border
                    BorderFactory.createEmptyBorder(10, 10, 10, 10) // Padding
                ));

                JLabel lockerLabel = new JLabel(locker, SwingConstants.CENTER); // Label for locker
                lockerLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Set font style
                lockerLabel.setForeground(Color.WHITE); // White text for contrast
                panel.add(lockerLabel, BorderLayout.CENTER); // Add label to panel

                lockerPanel.add(panel); // Add locker panel to lockerPanel
            }

            // Create panels for unavailable lockers
            for (String locker : unavailableLockers) {
                JPanel panel = new JPanel(new BorderLayout()); // Panel for each locker
                panel.setBackground(new Color(231, 76, 60)); // Red background for unavailable lockers
                panel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(192, 57, 43), 2), // Dark red border
                    BorderFactory.createEmptyBorder(10, 10, 10, 10) // Padding
                ));

                JLabel lockerLabel = new JLabel(locker, SwingConstants.CENTER); // Label for locker
                lockerLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Set font style
                lockerLabel.setForeground(Color.WHITE); // White text for contrast
                panel.add(lockerLabel, BorderLayout.CENTER); // Add label to panel

                lockerPanel.add(panel); // Add locker panel to lockerPanel
            }

            // Create a scroll pane for the locker panel
            JScrollPane scrollPane = new JScrollPane(lockerPanel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar
            add(scrollPane, BorderLayout.CENTER); // Add scroll pane to the center of the layout
    }

        // Page 6: Payment options for reservations
        public void page6() {
            // Create main panel with a grid layout
            JPanel panel0 = new JPanel(new GridLayout(4, 0, 10, 10));

            // Sub-panels for organizing components
            JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10)); // For semester buttons
            JPanel panel2 = new JPanel(new GridLayout(2, 2, 10, 10)); // For payment buttons
            JPanel panel3 = new JPanel(new BorderLayout()); // Not used, consider removal
            JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // For semester buttons
            JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // For amount input
            JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // For amount label and field
            JPanel panel8 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // For payment header
            JPanel panel15 = new JPanel(new BorderLayout()); // Main payment panel

            // Semester buttons
            JButton semester1Button = new JButton("Semester 1");
            JButton semester2Button = new JButton("Semester 2");
            styleButton(semester1Button); // Apply styles
            styleButton(semester2Button);
            panel.add(semester1Button);
            panel.add(semester2Button);
            panel4.add(panel); // Add semester buttons to panel4
            panel4.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 10)); // Set margins

            // Amount input section
            JLabel rs = new JLabel("RS"); // Currency label
            rs.setFont(new Font("Times New Roman", Font.BOLD, 16)); // Set font
            JTextField amount = new JTextField(15); // Input field for amount
            amount.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK)); // Underline border
            panel7.add(rs);
            panel7.add(amount);
            panel6.add(panel7); // Add amount section to panel6

            // Payment header section with icon
            ImageIcon originalIcon = new ImageIcon("C:\\Users\\s4ooo\\Downloads\\UJ_LockersReservation-main\\UJ_LockersReservation-main\\UJ_LockersReservation\\src\\uj_lockersreservation\\download.png");
            Image scaledImage = originalIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH); 
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel ico = new JLabel(scaledIcon); // Icon label
            JLabel payment = new JLabel("Payment");
            payment.setFont(new Font("Times New Roman", Font.BOLD, 18)); // Set font for payment label
            payment.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10)); // Set margins
            panel8.add(ico);
            panel8.add(payment);

            // Payment method buttons
            JButton visa = new JButton("Visa");
            JButton mada = new JButton("Mada");
            JButton tamara = new JButton("Tamara");
            JButton pay = new JButton("Pay");
            styleButton(visa);
            styleButton(mada);
            styleButton(tamara);
            styleButton(pay);
            panel2.add(visa);
            panel2.add(mada);
            panel2.add(tamara);
            panel2.add(pay);

            // Add payment header and buttons to the main payment panel
            panel15.add(panel8, BorderLayout.NORTH);
            panel15.add(panel2);

            // Cash on delivery button
            JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton cashOnDeliveryButton = new JButton("Cash on Delivery");
            styleButton(cashOnDeliveryButton); // Apply styles
            cashOnDeliveryButton.setBackground(new Color(233, 87, 63)); // Set specific background color
            panel5.add(cashOnDeliveryButton);
            panel5.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 10)); // Set margins

            // Add all panels to the main panel
            panel0.add(panel4);    
            panel0.add(panel6);    
            panel0.add(panel15);
            panel0.add(panel5);    

            panel0.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Set outer margins
            add(panel0, BorderLayout.CENTER); // Add main panel to the center
        }

        // Method to style buttons
        private void styleButton(JButton button) {
            button.setFont(new Font("Times New Roman", Font.BOLD, 18)); // Set font style
            button.setBackground(new Color(0, 153, 204)); // Set background color
            button.setForeground(Color.WHITE); // Set text color
            button.setFocusPainted(false); // Remove focus painting
            button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Set padding
            button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand
            button.setOpaque(true); // Make background opaque
        }

}