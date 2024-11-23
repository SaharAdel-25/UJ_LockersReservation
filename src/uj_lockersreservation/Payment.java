package uj_lockersreservation;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.LocalDate;

public class Payment extends JFrame {

    private JTextField amount;
    private JButton lastSelectedButton = null;
    private String selectedMethod = "";
    private String currentUserID;
    private String lockerKey;
    private String firstName;
    private String lastName;
    JButton lockerButton;
    private boolean isPaymentCompleted = false; // Flag to check if payment is completed

    // Constructor to initialize with user data
    public Payment(String currentUserID, String lockerKey, JButton lockerButton, String firstName, String lastName) {
        this.currentUserID = currentUserID;
        this.lockerKey = lockerKey;
        this.lockerButton = lockerButton;
        this.firstName = firstName;
        this.lastName = lastName;

       page6();
    }

    public void page6() {
        JPanel panel0 = new JPanel();
        panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));

        JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panel15 = new JPanel();
        panel15.setLayout(new BoxLayout(panel15, BoxLayout.Y_AXIS));

        JButton semester1Button = new JButton("Semester 1");
        JButton semester2Button = new JButton("Semester 2");
        styleButton(semester1Button);
        styleButton(semester2Button);
        panel4.add(semester1Button);
        panel4.add(semester2Button);

        semester1Button.addActionListener(e -> amount.setText("40"));
        semester2Button.addActionListener(e -> amount.setText("80"));

        JLabel rs = new JLabel("RS");
        rs.setFont(new Font("Times New Roman", Font.BOLD, 16));
        amount = new JTextField(15);
        amount.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        panel7.add(rs);
        panel7.add(amount);
        panel6.add(panel7);

        JLabel payment = new JLabel("Payment");
        payment.setFont(new Font("Times New Roman", Font.BOLD, 18));
        payment.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        panel8.add(payment);

        JButton visa = createIconButton("C:\\Users\\pc\\Desktop\\visa.jpg");
        JButton mada = createIconButton("C:\\Users\\pc\\Desktop\\Mada.png");
        JButton tamara = createIconButton("C:\\Users\\VIP\\Downloads\\تنزيل (2).jfif");
        JButton pay = createIconButton("C:\\Users\\VIP\\Downloads\\تنزيل (1).png");

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

        JButton backButton = new JButton("Cancel");
        styleButton(backButton);
        panel5.add(cashOnDeliveryButton);
        panel5.add(backButton);

        panel0.add(panel4);
        panel0.add(panel6);
        panel0.add(panel15);
        panel0.add(panel5);

        add(panel0, BorderLayout.CENTER);

        visa.addActionListener(e -> {
            selectedMethod = "Visa";
            confirmAndShowReceipt( firstName,  lastName);
        });
        mada.addActionListener(e -> {
            selectedMethod = "Mada";
            confirmAndShowReceipt(firstName,  lastName);
        });
        tamara.addActionListener(e -> {
            selectedMethod = "Tamara";
            confirmAndShowReceipt(firstName,  lastName);
        });
        pay.addActionListener(e -> {
            selectedMethod = "Pay";
            confirmAndShowReceipt(firstName,  lastName);
        });

        cashOnDeliveryButton.addActionListener(e -> {
            selectedMethod = "Cash on Delivery";
            showCashOnDeliveryMessage(firstName,  lastName);
        });

        backButton.addActionListener(e -> {
            if (!isPaymentCompleted) {
                getContentPane().removeAll();
                cancelReservation();
                Locker Page = new Locker(currentUserID,  firstName,  lastName);
                dispose();
            }
        });
    }

    private void cancelReservation() {
        Locker a = new Locker(currentUserID,  firstName,  lastName);
        a.cancelReservation(lockerKey, lockerButton, currentUserID);
    }

   private void confirmAndShowReceipt(String firstName,String  lastName) {
        Locker a = new Locker(currentUserID,  firstName,  lastName);

   // التحقق مما إذا لم يتم تحديد فصل دراسي
    if (amount.getText().isEmpty() || (!amount.getText().equals("40") && !amount.getText().equals("80"))) {
        JOptionPane.showMessageDialog(this, "Please select a semester before proceeding.", "Selection Required", JOptionPane.WARNING_MESSAGE);
        return; // إيقاف العملية إذا لم يتم تحديد فصل دراسي
    }
          
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to proceed with " + selectedMethod + "?",
                "Confirm Payment", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            isPaymentCompleted = true;
            showReceipt(selectedMethod, amount.getText(),firstName,  lastName);
            a.confirmPayment(lockerKey, lockerButton, currentUserID);
        }
    }

    private void showCashOnDeliveryMessage(String firstName,String  lastName) {
        Locker a = new Locker(currentUserID,  firstName,  lastName);
        JOptionPane.showMessageDialog(this,
                "You have 2 days to complete the payment, or the reservation will be canceled.",
                "Cash on Delivery Notice", JOptionPane.WARNING_MESSAGE);

        isPaymentCompleted = true;
        a.confirmPayment(lockerKey, lockerButton, currentUserID);
        showReceipt("Cash on Delivery", amount.getText(),firstName,  lastName);
    }

  private void showReceipt(String method, String amount, String firstName, String lastName) {
    // إنشاء النص الخاص بالفاتورة
    StringBuilder receipt = new StringBuilder();
    receipt.append("Payment Receipt\n");
    receipt.append("Date: ").append(LocalDate.now()).append("\n");
    receipt.append("User ID: ").append(currentUserID).append("\n");
    receipt.append("Name: ").append(firstName).append(" ").append(lastName).append("\n");
    receipt.append("Locker key: ").append(lockerKey).append("\n");
    receipt.append("Method: ").append(method).append("\n");
    receipt.append("Amount: ").append(amount).append(" RS");

    // إنشاء بيانات الباركود
    String barcodeData = "UserID:" + currentUserID + "||LockerKey:" + lockerKey;

    // إنشاء صورة الباركود
    ImageIcon barcodeIcon = generateBarcode(barcodeData);

    // واجهة الفاتورة
    JTextArea receiptArea = new JTextArea(receipt.toString());
    receiptArea.setEditable(false);
    receiptArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));

    JPanel receiptPanel = new JPanel();
    receiptPanel.setLayout(new BoxLayout(receiptPanel, BoxLayout.Y_AXIS));
    receiptPanel.add(receiptArea);

    if (barcodeIcon != null) {
        JLabel barcodeLabel = new JLabel(barcodeIcon);
        barcodeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        receiptPanel.add(barcodeLabel);
    }

    // عرض الفاتورة في نافذة منبثقة مع زر OK
    int result = JOptionPane.showConfirmDialog(
        this,
        receiptPanel,
        "Receipt",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE
    );

    // تحقق من الضغط على "OK" للانتقال إلى صفحة المباني
    if (result == JOptionPane.OK_OPTION || result == JOptionPane.CLOSED_OPTION) {
        // الانتقال إلى صفحة المباني
        Locker lockerPage = new Locker(currentUserID, firstName, lastName);
        lockerPage.page4(currentUserID, firstName, lastName); // عرض صفحة المباني
        lockerPage.setSize(600, 500);
        lockerPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lockerPage.setLocationRelativeTo(null);
        lockerPage.setVisible(true);
        dispose(); // إغلاق نافذة الدفع
    }
}


    private ImageIcon generateBarcode(String data) {
        try {
            // استخدم QRCodeWriter لإنشاء رمز QR
            QRCodeWriter barcodeWriter = new QRCodeWriter();
            int width = 250; // عرض الباركود
            int height = 250; // ارتفاع الباركود (يفضل أن يكون مربعًا للـ QR)

            BitMatrix bitMatrix = barcodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);

            // إنشاء الصورة وتحويل بيانات QR إلى صورة
            BufferedImage barcodeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    barcodeImage.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
                }
            }

            return new ImageIcon(barcodeImage);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JButton createIconButton(String iconPath) {
        JButton button = new JButton(resizeIcon(iconPath, 50, 50));
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 153, 204), 2, true));
        button.setBackground(Color.WHITE);
        button.setOpaque(true);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 153, 204));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.WHITE);
            }
        });

        return button;
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setPreferredSize(new Dimension(200, 40));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        button.setFocusPainted(false);
    }

    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

}