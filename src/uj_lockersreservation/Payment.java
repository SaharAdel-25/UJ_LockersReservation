package uj_lockersreservation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;

public class Payment extends JFrame {

    private JTextField amount; // Text field to display the amount
    private JButton lastSelectedButton = null; // To store the previously selected button
    private String selectedMethod = ""; // To store selected payment method
    private String currentUserID;
    private String lockerName;
    private String selectedBuilding;

    // إضافة البناء الجديد الذي يستقبل معطيات currentUserID, lockerName, selectedBuilding
    public Payment(String currentUserID, String lockerName, String selectedBuilding) {
        this.currentUserID = currentUserID;
        this.lockerName = lockerName;
        this.selectedBuilding = selectedBuilding;
        page6();  // استدعاء دالة الصفحة بعد تعيين المعطيات
    }

    // Page 6: Payment options for reservations
    public void page6() {
        JPanel panel0 = new JPanel();
        panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));

        // Adjust the layout and alignment for the panels
        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // For semester buttons
        JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER)); // For amount input
        JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // For amount label and field
        JPanel panel8 = new JPanel(new FlowLayout(FlowLayout.LEFT)); // For payment header
        JPanel panel15 = new JPanel(); // Main payment panel
        panel15.setLayout(new BoxLayout(panel15, BoxLayout.Y_AXIS));

        // Semester buttons with action to set amount
        JButton semester1Button = new JButton("Semester 1");
        JButton semester2Button = new JButton("Semester 2");
        styleButton(semester1Button);
        styleButton(semester2Button);
        panel4.add(semester1Button);
        panel4.add(semester2Button);

        // Action listeners to set amount based on selected semester
        semester1Button.addActionListener(e -> amount.setText("40"));
        semester2Button.addActionListener(e -> amount.setText("80"));

        JLabel rs = new JLabel("RS");
        rs.setFont(new Font("Times New Roman", Font.BOLD, 16));
        amount = new JTextField(15);
        amount.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        panel7.add(rs);
        panel7.add(amount);
        panel6.add(panel7);

        // Payment header section
        JLabel payment = new JLabel("Payment");
        payment.setFont(new Font("Times New Roman", Font.BOLD, 18));
        payment.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        panel8.add(payment);

        // Payment method buttons with icons only, arranged in 2x2 grid
        JButton visa = createIconButton("C:\\Users\\pc\\Desktop\\visa.jpg");
        JButton mada = createIconButton("C:\\Users\\pc\\Desktop\\Mada.png");
        JButton tamara = createIconButton("C:\\Users\\VIP\\Downloads\\تنزيل (2).jfif");
        JButton pay = createIconButton("C:\\Users\\VIP\\Downloads\\تنزيل (1).png");

        // Panel for buttons, use GridLayout for proper alignment
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.add(visa);
        buttonPanel.add(mada);
        buttonPanel.add(tamara);
        buttonPanel.add(pay);

        panel15.add(panel8);
        panel15.add(buttonPanel);

        JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton cashOnDeliveryButton = new JButton("Cash on Delivery");
        styleButton(cashOnDeliveryButton);
        cashOnDeliveryButton.setBackground(new Color(233, 87, 63));
        
        // Adding "Back" button with the same style
    JButton backButton = new JButton("Back");
    styleButton(backButton);  // Apply the same style as other buttons
    panel5.add(cashOnDeliveryButton);
    panel5.add(backButton);  // Add the "Back" button next to the "Cash on Delivery" button


        // Adding panels to the main panel
        panel0.add(panel4);
        panel0.add(panel6);
        panel0.add(panel15);
        panel0.add(panel5);

        add(panel0, BorderLayout.CENTER);

        // Event listeners and actions for payment buttons
        visa.addActionListener(e -> {
            selectedMethod = "Visa";
            confirmAndShowReceipt();
        });
        mada.addActionListener(e -> {
            selectedMethod = "Mada";
            confirmAndShowReceipt();
        });
        tamara.addActionListener(e -> {
            selectedMethod = "Tamara";
            confirmAndShowReceipt();
        });
        pay.addActionListener(e -> {
            selectedMethod = "Pay";
            confirmAndShowReceipt();
        });

        // ActionListener for cash on delivery
        cashOnDeliveryButton.addActionListener(e -> {
            selectedMethod = "Cash on Delivery";
            showCashOnDeliveryMessage();
        });
        
            styleButton(backButton); // تطبيق التنسيق على الزر
          // Back button action
            backButton.addActionListener(e -> {
            // العودة إلى صفحة تسجيل الدخول
            getContentPane().removeAll();
            Locker Page = new Locker();
            Page.page5(currentUserID);
            dispose(); // إغلاق الـ JFrame الحالي
            revalidate();
            repaint();
        });
    }

    // Method to select a payment method and highlight it
    private void selectPaymentMethod(JButton selectedButton) {
        if (lastSelectedButton != null) {
            lastSelectedButton.setBackground(Color.WHITE);
        }
        selectedButton.setBackground(new Color(76, 175, 80));
        lastSelectedButton = selectedButton;
    }

    // Create a button with only an icon
    private JButton createIconButton(String iconPath) {
        JButton button = new JButton(resizeIcon(iconPath, 50, 50));
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 153, 204), 2, true)); // Rounded border
        button.setBackground(Color.WHITE);
        button.setOpaque(true);

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(new Color(220, 240, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                if (button != lastSelectedButton) {
                    button.setBackground(Color.WHITE);
                }
            }
        });

        return button;
    }

    // Resize icons for buttons
    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
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

    // Method to confirm payment and show receipt
    private void confirmAndShowReceipt() {
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to proceed with " + selectedMethod + "?", 
                "Confirm Payment", JOptionPane.YES_NO_OPTION);
        
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Payment Successful", "Payment", JOptionPane.INFORMATION_MESSAGE);
            showReceipt(selectedMethod, amount.getText());
        }
    }

    // Method to show cash on delivery message and then display the receipt
    private void showCashOnDeliveryMessage() {
        // Show the message about the payment deadline
        JOptionPane.showMessageDialog(this, 
                "You have 2 days to complete the payment, or the reservation will be canceled.", 
                "Cash on Delivery Notice", JOptionPane.WARNING_MESSAGE);
        
        // After showing the message, display the receipt
        showReceipt("Cash on Delivery", amount.getText());
    }

    // Method to show payment receipt
    private void showReceipt(String method, String amount) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Payment Receipt\n");
        receipt.append("Date: ").append(LocalDate.now()).append("\n");
        receipt.append("User ID: ").append(currentUserID).append("\n");
        receipt.append("Locker Number: ").append(lockerName).append("\n");
        receipt.append("Building: ").append(selectedBuilding).append("\n");
        receipt.append("Method: ").append(method).append("\n");
        receipt.append("Amount: ").append(amount).append(" RS\n");
        receipt.append("-------------------------------");

        // Display receipt in a JTextArea within a JOptionPane
        JTextArea receiptArea = new JTextArea(receipt.toString());
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(receiptArea);
        scrollPane.setPreferredSize(new Dimension(250, 150));

        JOptionPane.showMessageDialog(this, scrollPane, "Receipt", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // تمرير المعطيات عند إنشاء الكائن
            Payment paymentFrame = new Payment("UserID123", "Locker1", "Building A");
            paymentFrame.setSize(600, 400);
            paymentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            paymentFrame.setLocationRelativeTo(null);
            paymentFrame.setVisible(true);
        });
    }
}
