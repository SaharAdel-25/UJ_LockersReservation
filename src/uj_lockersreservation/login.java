package uj_lockersreservation;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import uj_lockersreservation.UserData.CurrentUserData;
// Main class for Login System

public class login extends JFrame {

      private CardLayout cardLayout; // CardLayout for managing multiple pages
    private JPanel cardPanel; // Panel to hold pages
    private static List<UserData> usersDataList = new ArrayList<>(); // List to store user data

    // Static block to load user data when the program starts
    static {
        loadUserData();
    }
    // Constructor: Initializes the login interface

    public login() {
        setTitle("UJ Lockers Reservation System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

      cardLayout = new CardLayout(); // Initialize CardLayout
        cardPanel = new JPanel(cardLayout); // Create panel with CardLayout

        // Add different pages to the card panel
        cardPanel.add(createPage1(), "Page 1"); // Welcome page
        cardPanel.add(createPage2(), "Page 2"); // Registration page
        cardPanel.add(createPage3(), "Page 3"); // Login page

        add(cardPanel); // Add card panel to frame

        setVisible(true); // Make the frame visible
    }
    // Page 1: Welcome page

 private JPanel createPage1() {
    JPanel page1Panel = new JPanel(new GridBagLayout());
    page1Panel.setBackground(new Color(245, 245, 245));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between components
    gbc.fill = GridBagConstraints.HORIZONTAL;

        // Welcome message
    JLabel welcomeLabel = new JLabel("Welcome to UJ Lockers Reservation System", SwingConstants.CENTER);
    welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
    welcomeLabel.setForeground(new Color(0, 102, 204));
    gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
    page1Panel.add(welcomeLabel, gbc);

        // Add logo image
    JPanel imagePanel = new JPanel(new GridBagLayout());
    GridBagConstraints imageGbc = new GridBagConstraints();
    imageGbc.anchor = GridBagConstraints.CENTER; 
    imageGbc.insets = new Insets(10, 10, 10, 10);  // Add spacing between components
    JLabel imageLabel = new JLabel();
    ImageIcon icon = new ImageIcon("C:\\Users\\s4ooo\\Downloads\\UJ_LockersReservation-main\\UJ_LockersReservation-main\\UJ_LockersReservation\\src\\uj_lockersreservation\\UJ.png");
    Image img = icon.getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH);  
    icon = new ImageIcon(img);
    imageLabel.setIcon(icon);
    imagePanel.add(imageLabel, imageGbc);
    gbc.gridx = 0;  
    gbc.gridy++;  
    gbc.gridwidth = 2;  
    page1Panel.add(imagePanel, gbc);  

        // Login button
    JButton loginButton = new JButton("Log in");
    styleButton(loginButton);
    gbc.gridy++;  
    loginButton.addActionListener(e -> cardLayout.show(cardPanel, "Page 3"));
    page1Panel.add(loginButton, gbc);

        // Register button
    JButton registerButton = new JButton("Register");
    styleButton(registerButton);
    gbc.gridy++;  
    registerButton.addActionListener(e -> cardLayout.show(cardPanel, "Page 2"));
    page1Panel.add(registerButton, gbc);

    return page1Panel;
}
    // Page 2: Registration page

private JPanel createPage2() {
    JPanel page2Panel = new JPanel(new GridBagLayout());
    page2Panel.setBackground(new Color(245, 245, 245));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JLabel signUpLabel = new JLabel("Create a New Account", SwingConstants.CENTER);
    signUpLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
    signUpLabel.setForeground(new Color(0, 102, 204));
    gbc.gridwidth = 2;
    gbc.gridx = 0; gbc.gridy = 0;
    page2Panel.add(signUpLabel, gbc);

    JTextField firstNameField = new JTextField(15);
    JTextField lastNameField = new JTextField(15);
    JTextField emailField = new JTextField(15);
    JTextField idField = new JTextField(15);
    JPasswordField passwordField = new JPasswordField(15);

    addField(page2Panel, "First Name:", firstNameField, gbc, 1);
    addField(page2Panel, "Last Name:", lastNameField, gbc, 2);
    addField(page2Panel, "Email:", emailField, gbc, 3);
    addField(page2Panel, "ID Number:", idField, gbc, 4);
    addField(page2Panel, "Password:", passwordField, gbc, 5);
    

        // Register button

    JButton signUpSubmitButton = new JButton("Register");
    styleButton(signUpSubmitButton);
    signUpSubmitButton.setPreferredSize(new Dimension(300, 40)); 
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 2;
    signUpSubmitButton.addActionListener(e -> {
        String id = idField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (isValidInput(id, firstName, lastName, email, password)) {
            saveData(new UserData(id, firstName, lastName, email, password));
            JOptionPane.showMessageDialog(this, "Account created successfully!");
            CurrentUserData.setFirstName(firstName);
            CurrentUserData.setLastName(lastName);
            cardLayout.show(cardPanel, "Page 3");
}
    });
    page2Panel.add(signUpSubmitButton, gbc);
        // Back button

    JButton backButton = new JButton("Back");
    styleButton(backButton);
    gbc.gridy++;
    backButton.addActionListener(e -> cardLayout.show(cardPanel, "Page 1"));
    page2Panel.add(backButton, gbc);

    return page2Panel;
}

    // Page 3: Login page

    public JPanel createPage3() {
    JPanel page3Panel = new JPanel(new GridBagLayout());
    page3Panel.setBackground(new Color(245, 245, 245));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;  

    JLabel loginLabel = new JLabel("Log in", SwingConstants.CENTER);
    loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
    loginLabel.setForeground(new Color(0, 102, 204));
    gbc.gridwidth = 2; gbc.gridx = 0; gbc.gridy = 0;
    page3Panel.add(loginLabel, gbc);

    JTextField idField = new JTextField(15);
    JPasswordField passwordField = new JPasswordField(15);

    addField(page3Panel, "ID Number:", idField, gbc, 1);
    addField(page3Panel, "Password:", passwordField, gbc, 2);

    JButton loginButton = new JButton("Login");
    styleButton(loginButton);
    gbc.gridwidth = 2;  
    gbc.gridx = 0;  
    gbc.gridy++;  
    loginButton.setPreferredSize(new Dimension(300, 40)); 
    loginButton.addActionListener(e -> {
    String userId = idField.getText();
    String password = new String(passwordField.getPassword());
    UserData loggedInUser = getUserIfExists(userId, password);

    if (loggedInUser != null) {
        CurrentUserData.setFirstName(loggedInUser.getFirstName());
        CurrentUserData.setLastName(loggedInUser.getLastName());

        
        dispose();
        Locker lockerFrame = new Locker(userId, loggedInUser.getFirstName(), loggedInUser.getLastName());
        lockerFrame.setSize(600, 500);
        lockerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lockerFrame.setLocationRelativeTo(null);
        lockerFrame.setVisible(true);

    } else {
        JOptionPane.showMessageDialog(this, "Invalid ID or wrong password. Please register first or check the password.");
    }
});

    page3Panel.add(loginButton, gbc);

    
    JButton registerButton = new JButton("Register");
    styleButton(registerButton);
    gbc.gridy++;  
    registerButton.setPreferredSize(new Dimension(300, 40)); 
    registerButton.addActionListener(e -> cardLayout.show(cardPanel, "Page 2"));
    page3Panel.add(registerButton, gbc);

    return page3Panel;
}
    // Styles a button with consistent UI properties

    private void styleButton(JButton button) {
        button.setFont(new Font("Times New Roman", Font.BOLD, 18));
        button.setBackground(new Color(0, 153, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
    }
    // Saves a user data instance to the file

    public void saveData(UserData userData) {
        usersDataList.add(userData);
        saveUserDataToFile();
    }
    // Saves user data to a file

    private static void saveUserDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usersDataList.ser"))) {
            oos.writeObject(usersDataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Loads user data from a file

    private static void loadUserData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usersDataList.ser"))) {
            usersDataList = (List<UserData>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        }
    }
    // Checks if the user exists

   private UserData getUserIfExists(String id, String password) {
    return usersDataList.stream()
            .filter(user -> user.getId().equals(id) && user.getpassword().equals(password))
            .findFirst()
            .orElse(null);
}

    // Validates user input

    private boolean isValidInput(String id, String firstName, String lastName, String email, String password) {
        if (!id.matches("\\d{7}")) {
            JOptionPane.showMessageDialog(this, "ID must be exactly 7 digits.");
            return false;
        }
        if (!firstName.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Names must contain letters only.");
            return false;
        }
        if (!Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches()) {
            JOptionPane.showMessageDialog(this, "Invalid email format.");
            return false;
        }
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(this, "Password must be at least 6 characters long.");
            return false;
        }
           if (isIdExists(id)) { 
            JOptionPane.showMessageDialog(this, "This ID is already taken. Please use a different ID.");
            return false;
        }
        return true;
    }
    // Checks if the ID already exists
    private boolean isIdExists(String id) {
        return usersDataList.stream().anyMatch(user -> user.getId().equals(id));
    }
        // Adds a labeled field to the panel

    private void addField(JPanel panel, String label, JTextField field, GridBagConstraints gbc, int y) {
        gbc.gridx = 0; gbc.gridy = y; gbc.gridwidth = 1;
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        panel.add(jLabel, gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }
}

// UserData class: Represents user information and supports serialization
class UserData implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserData(String id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getpassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
        public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    @Override
    public String toString() {
        return String.format("| %-15s | %-20s | %-20s | %-30s | %-20s |", id, firstName, lastName, email, password);
    }
        // Inner class to store current user's data

    public class CurrentUserData {
        private static String firstName;
        private static String lastName;

        public static void setFirstName(String firstName) {
            CurrentUserData.firstName = firstName;
        }

        public static void setLastName(String lastName) {
            CurrentUserData.lastName = lastName;
        }

        public static String getFirstName() {
            return firstName;
        }

        public static String getLastName() {
            return lastName;
        }
    }

}