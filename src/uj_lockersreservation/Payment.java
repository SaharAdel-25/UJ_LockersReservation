
package uj_lockersreservation;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame {

    private JTextField amount; // Text field to display the amount
    // Class-level variable to store the previously selected button
private JButton lastSelectedButton = null;

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
        amount = new JTextField(15); // Input field for amount
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

        // Add ActionListener for semester buttons
        semester1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amount.setText("40"); // Set amount to 40 for Semester 1
            }
        });

        semester2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amount.setText("80"); // Set amount to 80 for Semester 2
            }
        });
        visa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButtonColor(visa);  // Update color of the clicked button
                JOptionPane.showMessageDialog(null, "Visa selected!", "Payment", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        mada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButtonColor(mada);  // Update color of the clicked button
                JOptionPane.showMessageDialog(null, "Mada selected!", "Payment", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        tamara.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateButtonColor(tamara);  // Update color of the clicked button
                JOptionPane.showMessageDialog(null, "Tamara selected!", "Payment", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Add ActionListener for pay button
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                        updateButtonColor(pay);  // Update color of the clicked button

                JOptionPane.showMessageDialog(null, "Payment selected!", "Payment", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Add ActionListener for cash on delivery
        cashOnDeliveryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Payment Successful", "Payment", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
            // Method to handle the color change logic
        private void updateButtonColor(JButton selectedButton) {
            // If there was a previously selected button, change its color back to blue
            if (lastSelectedButton != null) {
                lastSelectedButton.setBackground(new Color(0, 153, 204)); // Set it back to blue
            }

            // Change the color of the newly selected button to green
            selectedButton.setBackground(new Color(76, 175, 80)); // Set it to green

            // Update the last selected button reference
            lastSelectedButton = selectedButton;
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
