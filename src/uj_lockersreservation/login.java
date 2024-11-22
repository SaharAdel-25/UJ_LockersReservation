
package uj_lockersreservation;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import uj_lockersreservation.UserData.CurrentUserData;

public class login extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private static List<UserData> usersDataList = new ArrayList<>(); // ArrayList لتخزين بيانات المستخدمين

    // تحميل البيانات من الملف عند بدء تشغيل البرنامج
    static {
        loadUserData();
    }

    public login() {
        setTitle("UJ Lockers Reservation System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(createPage1(), "Page 1");
        cardPanel.add(createPage2(), "Page 2");
        cardPanel.add(createPage3(), "Page 3");

        add(cardPanel);

        setVisible(true);
    }

    private JPanel createPage1() {
        JPanel page1Panel = new JPanel(new GridBagLayout());
        page1Panel.setBackground(new Color(245, 245, 245));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel welcomeLabel = new JLabel("Welcome to UJ Lockers Reservation System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        page1Panel.add(welcomeLabel, gbc);

        JButton loginButton = new JButton("Log in");
        styleButton(loginButton);
        gbc.gridy++;
        loginButton.addActionListener(e -> cardLayout.show(cardPanel, "Page 3"));
        page1Panel.add(loginButton, gbc);

        JButton registerButton = new JButton("Register");
        styleButton(registerButton);
        gbc.gridy++;
        registerButton.addActionListener(e -> cardLayout.show(cardPanel, "Page 2"));
        page1Panel.add(registerButton, gbc);

        return page1Panel;
    }
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
    


    JButton signUpSubmitButton = new JButton("Register");
    styleButton(signUpSubmitButton);
    signUpSubmitButton.setPreferredSize(new Dimension(300, 40)); // تحديد الحجم هنا
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
                        // حفظ الأسماء في CurrentUserData
            CurrentUserData.setFirstName(firstName);
            CurrentUserData.setLastName(lastName);
            cardLayout.show(cardPanel, "Page 3");
}
    });
    page2Panel.add(signUpSubmitButton, gbc);

    JButton backButton = new JButton("Back");
    styleButton(backButton);
    gbc.gridy++;
    backButton.addActionListener(e -> cardLayout.show(cardPanel, "Page 1"));
    page2Panel.add(backButton, gbc);

    return page2Panel;
}


    public JPanel createPage3() {
    JPanel page3Panel = new JPanel(new GridBagLayout());
    page3Panel.setBackground(new Color(245, 245, 245));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;  // إضافة هذه لضبط أبعاد المكونات

    // إضافة عنوان الدخول
    JLabel loginLabel = new JLabel("Log in", SwingConstants.CENTER);
    loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
    loginLabel.setForeground(new Color(0, 102, 204));
    gbc.gridwidth = 2; gbc.gridx = 0; gbc.gridy = 0;
    page3Panel.add(loginLabel, gbc);

    // حقول النص مع ضبط الأبعاد
    JTextField idField = new JTextField(15);
    JPasswordField passwordField = new JPasswordField(15);

    // إضافة الحقول مع التسميات
    addField(page3Panel, "ID Number:", idField, gbc, 1);
    addField(page3Panel, "Password:", passwordField, gbc, 2);
   // عرض الاسم الأول والاسم الأخير في صفحة الدخول
//    String firstName = CurrentUserData.getFirstName();
//    String lastName = CurrentUserData.getLastName();
    // زر الدخول
    JButton loginButton = new JButton("Login");
    styleButton(loginButton);
    gbc.gridwidth = 2;  // تأكيد أن الزر يمتد عبر العمودين
    gbc.gridx = 0;  // ضبط الزر في عمود 0
    gbc.gridy++;  // الانتقال للصف التالي
    loginButton.setPreferredSize(new Dimension(300, 40)); // تحديد حجم الزر
    loginButton.addActionListener(e -> {
    String userId = idField.getText();
    String password = new String(passwordField.getPassword());
    UserData loggedInUser = getUserIfExists(userId, password);

    if (loggedInUser != null) {
        // تعيين البيانات للمستخدم الحالي
        CurrentUserData.setFirstName(loggedInUser.getFirstName());
        CurrentUserData.setLastName(loggedInUser.getLastName());

        // فتح واجهة اللوكر
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

    // زر التسجيل
    JButton registerButton = new JButton("Register");
    styleButton(registerButton);
    gbc.gridy++;  // الانتقال للصف التالي
    registerButton.setPreferredSize(new Dimension(300, 40)); // تحديد حجم الزر
    registerButton.addActionListener(e -> cardLayout.show(cardPanel, "Page 2"));
    page3Panel.add(registerButton, gbc);

    return page3Panel;
}

    private void styleButton(JButton button) {
        button.setFont(new Font("Times New Roman", Font.BOLD, 18));
        button.setBackground(new Color(0, 153, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
    }

    public void saveData(UserData userData) {
        usersDataList.add(userData);
        saveUserDataToFile();
    }
    
    /*
    
    private static void saveUserDataToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("usersDataList.txt", true))) {  // Open in append mode
        // If the file is empty, write the header
        if (new File("usersDataList.txt").length() == 0) {
            // Header formatting with column widths
            String header = String.format("| %-15s | %-20s | %-20s | %-30s | %-20s |", "ID", "First Name", "Last Name", "Email", "Password");
            writer.write(header);
            writer.newLine();

            // Adjust the number of dashes to match the header width
            int dashLength = header.length();
            writer.write(String.join("", Collections.nCopies(dashLength, "-")));  // Draw underline that matches the header width
            writer.newLine();
        }

        // Add user data (appending new users at the end)
        for (UserData user : usersDataList) {
            writer.write(user.toString());  // Write user data formatted as per toString method
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
private static void loadUserData() {
    usersDataList.clear();  // Clear the existing list before loading new data

    try (BufferedReader reader = new BufferedReader(new FileReader("usersDataList.txt"))) {
        String line;
        boolean headerRead = false;

        while ((line = reader.readLine()) != null) {
            // Skip the header and separator line
            if (line.contains("| ID")) {
                headerRead = true;  // Header has been read, skip this line
                continue;
            }
            if (line.contains("-") && headerRead) {
                continue;  // Skip separator line
            }

            // Now, parse each line that represents user data
            String[] parts = line.split("\\|");  // Split based on the pipe symbol "|"
            if (parts.length == 5) {  // Ensures it's the right format
                String id = parts[1].trim();
                String firstName = parts[2].trim();
                String lastName = parts[3].trim();
                String email = parts[4].trim();
                String password = parts[5].trim();

                // Add user data to the list
                usersDataList.add(new UserData(id, firstName, lastName, email, password));
            }
        }
    } catch (IOException e) {
        System.out.println("Error loading user data from file.");
        e.printStackTrace();
    }
}*/


    

    private static void saveUserDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usersDataList.ser"))) {
            oos.writeObject(usersDataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadUserData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usersDataList.ser"))) {
            usersDataList = (List<UserData>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        }
    }

   private boolean isUserExists(String id, String password) {
    return usersDataList.stream().anyMatch(user -> user.getId().equals(id) && user.getpassword().equals(password));
}
   private UserData getUserIfExists(String id, String password) {
    return usersDataList.stream()
            .filter(user -> user.getId().equals(id) && user.getpassword().equals(password))
            .findFirst()
            .orElse(null);
}


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
        return true;
    }

    private void addField(JPanel panel, String label, JTextField field, GridBagConstraints gbc, int y) {
        gbc.gridx = 0; gbc.gridy = y; gbc.gridwidth = 1;
        JLabel jLabel = new JLabel(label);
        jLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        panel.add(jLabel, gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }
}

// UserData class for serialization
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





    // Getters for other fields if needed
}