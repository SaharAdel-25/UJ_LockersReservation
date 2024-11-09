package uj_lockersreservation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame {

    private CardLayout cardLayout; // تعريف CardLayout
    private JPanel cardPanel; // تعريف لوحة تحتوي على الصفحات

    // Constructor to set up the initial frame
    public login() {
        setTitle("UJ Lockers Reservation System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        cardLayout = new CardLayout(); // إعداد CardLayout
        cardPanel = new JPanel(cardLayout); // إعداد اللوحة التي تحتوي على الصفحات

        // إضافة الصفحات إلى اللوحة
        cardPanel.add(createPage1(), "Page 1");
        cardPanel.add(createPage2(), "Page 2");
        cardPanel.add(createPage3(), "Page 3");

        // إضافة اللوحة إلى الإطار
        add(cardPanel);

        setVisible(true);
    }

    // Page 1: Starting page with login and register options
    private JPanel createPage1() {
        JPanel page1Panel = new JPanel();
        page1Panel.setLayout(new GridBagLayout());
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
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Page 3"); // Go to the login page (Page 3)
            }
        });
        page1Panel.add(loginButton, gbc);

        JButton registerButton = new JButton("Register");
        styleButton(registerButton);
        gbc.gridy++;
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Page 2"); // Go to the register page (Page 2)
            }
        });
        page1Panel.add(registerButton, gbc);

        return page1Panel;
    }

 private JPanel createPage2() {
    JPanel page2Panel = new JPanel();
    page2Panel.setLayout(new GridBagLayout());
    page2Panel.setBackground(new Color(245, 245, 245));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.WEST; // لضبط المكونات لتكون في الجهة اليسرى

    // عنوان الصفحة
    JLabel signUpLabel = new JLabel("Create a New Account", SwingConstants.CENTER);
    signUpLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
    signUpLabel.setForeground(new Color(0, 102, 204));
    gbc.gridwidth = 2; // اتساع كامل للعنوان
    gbc.gridx = 0;
    gbc.gridy = 0;
    page2Panel.add(signUpLabel, gbc);

    // First Name label and text field
    gbc.gridy++;
    gbc.gridwidth = 1;
    JLabel firstNameLabel = new JLabel("First Name:");
    firstNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    page2Panel.add(firstNameLabel, gbc);

    gbc.gridx = 1;
    JTextField firstNameField = new JTextField(15);
    firstNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    page2Panel.add(firstNameField, gbc);

    // Last Name label and text field
    gbc.gridx = 0;
    gbc.gridy++;
    JLabel lastNameLabel = new JLabel("Last Name:");
    lastNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    page2Panel.add(lastNameLabel, gbc);

    gbc.gridx = 1;
    JTextField lastNameField = new JTextField(15);
    lastNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    page2Panel.add(lastNameField, gbc);

    // Email label and text field
    gbc.gridx = 0;
    gbc.gridy++;
    JLabel emailLabel = new JLabel("Email:");
    emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    page2Panel.add(emailLabel, gbc);

    gbc.gridx = 1;
    JTextField emailField = new JTextField(15);
    emailField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    page2Panel.add(emailField, gbc);

    // ID Number label and text field
    gbc.gridx = 0;
    gbc.gridy++;
    JLabel idLabel = new JLabel("ID Number:");
    idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    page2Panel.add(idLabel, gbc);

    gbc.gridx = 1;
    JTextField idField = new JTextField(15);
    idField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    page2Panel.add(idField, gbc);

    // Password label and text field
    gbc.gridx = 0;
    gbc.gridy++;
    JLabel passwordLabel = new JLabel("Password:");
    passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    page2Panel.add(passwordLabel, gbc);

    gbc.gridx = 1;
    JPasswordField passwordField = new JPasswordField(15);
    passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    page2Panel.add(passwordField, gbc);

    // Register button
    gbc.gridx = 0;
    gbc.gridy++;
    gbc.gridwidth = 2;
    JButton signUpSubmitButton = new JButton("Register");
    styleButton(signUpSubmitButton);
    signUpSubmitButton.setBackground((new Color(0, 153, 204)));
    signUpSubmitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cardPanel, "Page 3"); // Go back to the first page
        }
    });
    page2Panel.add(signUpSubmitButton, gbc);

    // Back button (placing it on the bottom with proper alignment)
    gbc.gridy++;
    JButton backButton = new JButton("Back");
    styleButton(backButton);
    backButton.setBackground(new Color(233, 87, 63));
    backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardLayout.show(cardPanel, "Page 1"); // Go back to the first page
        }
    });
    page2Panel.add(backButton, gbc);

    return page2Panel;
}

private JPanel createPage3() {
    JPanel page3Panel = new JPanel();
    page3Panel.setLayout(new GridBagLayout());
    page3Panel.setBackground(new Color(245, 245, 245));

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10); // تحديد الهوامش
    gbc.fill = GridBagConstraints.HORIZONTAL; // ملء العرض بالكامل

    // عنوان الصفحة (Log in)
    JLabel loginLabel = new JLabel("Log in", SwingConstants.CENTER);
    loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
    loginLabel.setForeground(new Color(0, 102, 204));
    gbc.gridwidth = 2; // عنوان الصفحة يشغل المساحة بالكامل
    gbc.gridx = 0;
    gbc.gridy = 0;
    page3Panel.add(loginLabel, gbc);

    // ID Number label and text field
    gbc.gridy++; // الانتقال إلى الصف التالي
    gbc.gridwidth = 1; // تأكيد عرض الحقل في عمود واحد
    JLabel idLabel = new JLabel("ID Number:");
    idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    page3Panel.add(idLabel, gbc);

    gbc.gridx = 1; // الانتقال إلى العمود الثاني
    JTextField idField = new JTextField(15);
    idField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    page3Panel.add(idField, gbc);

    // First Name label and text field
    gbc.gridx = 0; // العودة إلى العمود الأول
    gbc.gridy++; // الانتقال إلى الصف التالي
    JLabel firstNameLabel = new JLabel("First Name:");
    firstNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    page3Panel.add(firstNameLabel, gbc);

    gbc.gridx = 1; // الانتقال إلى العمود الثاني
    JTextField firstNameField = new JTextField(15);
    firstNameField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    page3Panel.add(firstNameField, gbc);

    // Login button
    gbc.gridx = 0;
    gbc.gridy++; // الانتقال إلى الصف التالي
    gbc.gridwidth = 2; // زر تسجيل الدخول يشغل المساحة بالكامل
    JButton loginButton = new JButton("Login");
    styleButton(loginButton);
    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); // إغلاق نافذة تسجيل الدخول الحالية

            Locker lockerFrame = new Locker();
            lockerFrame.page4(); // فتح صفحة الخزائن
            lockerFrame.setSize(600, 500);
            lockerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            lockerFrame.setLocationRelativeTo(null);
            lockerFrame.setVisible(true);
        }
    });
    page3Panel.add(loginButton, gbc);

    return page3Panel;
}


    // Method to style buttons
    private void styleButton(JButton button) {
        button.setFont(new Font("Times New Roman", Font.BOLD, 18));
        button.setBackground(new Color(0, 153, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
    }

}
