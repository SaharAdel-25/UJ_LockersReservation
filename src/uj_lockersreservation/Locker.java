package uj_lockersreservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Locker extends JFrame {

    private String selectedBuilding = "";
    private String currentUserID;
    private Map<String, ReservationData> lockerStatus; // حالة كل خزانة (محجوزة أو متاحة)

    public Locker() {
        setTitle("Locker Reservation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lockerStatus = loadLockerStatus(); // تحميل حالة الخزائن من الملف
        page4();
    }
    
    // Setter for currentUserID to be called after successful login
    public void setCurrentUserID(String userID) {
        this.currentUserID = userID;
    }

    public void page4() {
        getContentPane().removeAll();
        setLayout(new BorderLayout(10, 10));

        JLabel questionLabel = new JLabel("Which building do you want?", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        questionLabel.setForeground(new Color(0, 102, 204));
        add(questionLabel, BorderLayout.NORTH);

        JPanel buildingPanel = new JPanel();
        buildingPanel.setLayout(new GridLayout(0, 2, 15, 15));
        buildingPanel.setBackground(new Color(245, 245, 245));

        String[] buildingNumbers = {
            "Building 11", "Building 17", "Building 5", "Building 12",
            "Building 3", "Building 14", "Building 6", "Building 7",
            "Building 8", "Building 15", "Building 2", "Building 9",
            "Building 10", "Building 4", "Building 18", "Building 20"
        };

        for (String building : buildingNumbers) {
            JButton buildingButton = new JButton(building);
            buildingButton.setFont(new Font("Arial", Font.BOLD, 16));
            buildingButton.setBackground(new Color(220, 220, 220));
            buildingButton.setForeground(new Color(50, 50, 50));

            buildingButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    selectedBuilding = building;
                    lockerStatus = loadLockerStatus(); // تحميل حالة الخزائن للمبنى المحدد فقط
                    page5(currentUserID);
                }
            });

            buildingPanel.add(buildingButton);
        }

        JScrollPane scrollPane = new JScrollPane(buildingPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

      
        // زر العودة إلى صفحة تسجيل الدخول
        JButton backButton = new JButton("Back to Login");
        styleButton(backButton); // تطبيق التنسيق على الزر
        backButton.addActionListener(e -> {
            // العودة إلى صفحة تسجيل الدخول
            getContentPane().removeAll();
            login loginPage = new login();
            dispose(); // إغلاق الـ JFrame الحالي
            revalidate();
            repaint();
        });
        add(backButton, BorderLayout.SOUTH); // إضافة الزر في أسفل الصفحة

        revalidate();
        repaint();
    }


    public void page5(String currentUserID) {
    getContentPane().removeAll();
    setLayout(new BorderLayout(10, 10));

    JLabel buildingLabel = new JLabel(selectedBuilding + " - Locker Availability", SwingConstants.CENTER);
    buildingLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
    buildingLabel.setForeground(new Color(0, 102, 204));
    add(buildingLabel, BorderLayout.NORTH);
    
    
        // إضافة زر العودة إلى صفحة المباني
        JButton backButton = new JButton("Back to Buildings");
        styleButton(backButton); // تطبيق التنسيق على الزر
        backButton.addActionListener(e -> page4()); // العودة إلى صفحة المباني عند الضغط على الزر
        add(backButton, BorderLayout.SOUTH);



    // تحقق مما إذا كان لدى المستخدم حجز
    String reservedLockerKey = userHasReservationInBuilding(currentUserID, selectedBuilding);
    if (reservedLockerKey != null) {
        String[] parts = reservedLockerKey.split(":"); // تقسيم المفتاح
        String reservedLockerName = parts[1]; // اسم اللوكر

        JLabel reservationInfoLabel = new JLabel("You already have a reservation for " + reservedLockerName + " in " + selectedBuilding + ".", SwingConstants.CENTER);
        reservationInfoLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        reservationInfoLabel.setForeground(Color.RED);
       
            // إنشاء JPanel لتجميع النص وزر العودة معًا
            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new BorderLayout());  // استخدم BorderLayout لترتيب النص والزر
            bottomPanel.add(reservationInfoLabel, BorderLayout.NORTH); // إضافة النص في الشمال
            bottomPanel.add(backButton, BorderLayout.SOUTH); // إضافة الزر في الجنوب

            // تطبيق التنسيق على الزر
            styleButton(backButton);
            backButton.addActionListener(e -> page4()); // العودة إلى صفحة المباني عند الضغط على الزر

            // إضافة JPanel (bottomPanel) إلى الجزء السفلي من الواجهة
            add(bottomPanel, BorderLayout.SOUTH);
        }

    JPanel lockerPanel = new JPanel();
    lockerPanel.setLayout(new GridLayout(5, 5, 5, 5));
    lockerPanel.setBackground(new Color(245, 245, 245));

    for (int i = 1; i <= 50; i++) {
    String lockerName = "Locker " + i;
    String lockerKey = selectedBuilding + ":" + lockerName;
    JButton lockerButton = new JButton(lockerName);
    lockerButton.setFont(new Font("Arial", Font.BOLD, 14));

    ReservationData reservationData = lockerStatus.get(lockerKey);
    boolean isAvailable = (reservationData == null || reservationData.isAvailable());

    // تحقق إذا كان المستخدم لديه حجز في هذا المبنى
    if (reservedLockerKey != null) {
        lockerButton.setBackground(new Color(128, 128, 128)); // لون رمادي للخزانات المحجوزة
        lockerButton.setForeground(Color.WHITE);
        lockerButton.setEnabled(false); // تعطيل الزر
    } else if (isAvailable) {
        lockerButton.setBackground(new Color(46, 204, 113));
        lockerButton.setForeground(Color.WHITE);
        lockerButton.addActionListener(e -> reserveLocker(lockerKey, lockerButton, currentUserID, lockerName));
    } else {
        lockerButton.setBackground(new Color(231, 76, 60));
        lockerButton.setForeground(Color.WHITE);
        lockerButton.setEnabled(false); // تعطيل الزر إذا كانت محجوزة
    }

    lockerPanel.add(lockerButton);
}


    JScrollPane scrollPane = new JScrollPane(lockerPanel);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    add(scrollPane, BorderLayout.CENTER);

    revalidate();
    repaint();
}

    // Method to reserve a locker
private void reserveLocker(String lockerKey, JButton lockerButton, String currentUserID, String lockerName) {
    String building = lockerKey.split(":")[0]; // استخراج رقم المبنى من المفتاح

    // تحقق مما إذا كان المستخدم لديه أكثر من لوكر محجوز في مباني مختلفة
    int reservedCount = countReservedLockersInDifferentBuildings(currentUserID);
    if (reservedCount >= 2) {
        JOptionPane.showMessageDialog(this, "You can only reserve lockers in up to two different buildings.");
        return;
    }

    // تحقق مما إذا كان المستخدم لديه حجز في نفس المبنى
    String reservedLockerKey = userHasReservationInBuilding(currentUserID, building);
    if (reservedLockerKey != null) {
        JOptionPane.showMessageDialog(this, "You already have a reservation in " + building + ". You cannot reserve another locker in the same building.");
        return;
    }

    // إذا لم يكن لدى المستخدم حجز في نفس المبنى، استمر في حجز اللوكر
    lockerButton.setBackground(new Color(231, 76, 60));
    lockerStatus.put(lockerKey, new ReservationData(false, currentUserID)); // تعيين حالة الخزانة كمحجوزة مع معرف المستخدم
    saveLockerStatus(); // حفظ الحالة في الملف

    // فتح نافذة الدفع
    Payment paymentPage = new Payment(currentUserID, lockerName, selectedBuilding);
    paymentPage.page6();
    paymentPage.setSize(600, 500);
    paymentPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    paymentPage.setLocationRelativeTo(null);
    paymentPage.setVisible(true);
}

private int countReservedLockersInDifferentBuildings(String userID) {
    int count = 0;
    for (Map.Entry<String, ReservationData> entry : lockerStatus.entrySet()) {
        if (!entry.getValue().isAvailable() && entry.getValue().getUserID().equals(userID)) {
            String building = entry.getKey().split(":")[0];
            count++;
        }
    }
    return count;
}

private String userHasReservationInBuilding(String userID, String building) {
    for (Map.Entry<String, ReservationData> entry : lockerStatus.entrySet()) {
        if (!entry.getValue().isAvailable() && entry.getValue().getUserID().equals(userID) &&
            entry.getKey().startsWith(building + ":")) {
            return entry.getKey(); // ارجع المفتاح الخاص باللوكر المحجوز
        }
    }
    return null; // لا يوجد حجز في هذا المبنى
}


    private Map<String, ReservationData> loadLockerStatus() {
        Map<String, ReservationData> status = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("userData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Locker:")) {
                    String[] parts = line.split(":");
                    if (parts.length == 5) {
                        String lockerKey = parts[1] + ":" + parts[2];
                        boolean isAvailable = Boolean.parseBoolean(parts[3]);
                        String userID = parts[4]; // معرف المستخدم
                        status.put(lockerKey, new ReservationData(isAvailable, userID));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }

    private void saveLockerStatus() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("userData.txt"))) {
            for (Map.Entry<String, ReservationData> entry : lockerStatus.entrySet()) {
                String[] parts = entry.getKey().split(":");
                String building = parts[0];
                String lockerName = parts[1];
                ReservationData reservation = entry.getValue();
                writer.write("Locker:" + building + ":" + lockerName + ":" + reservation.isAvailable() + ":" + reservation.getUserID() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        // الدالة لتنسيق الأزرار
private void styleButton(JButton button) {
    // تعيين النص والخلفية واللون
    button.setFont(new Font("Times New Roman", Font.BOLD, 18));
    button.setBackground(new Color(0, 153, 204));  // اللون الأزرق
    button.setForeground(Color.WHITE);
    button.setFocusPainted(false);  // إزالة التأثير عند التركيز على الزر
    button.setBorder(BorderFactory.createLineBorder(new Color(0, 153, 204), 2));  // إضافة حدود للزر
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));  // تغيير المؤشر إلى يد عند التمرير
    button.setOpaque(true);  // جعل الزر غير شفاف

    // تحديد الحجم ليكون مستطيل
    button.setPreferredSize(new Dimension(200, 50));  // عرض 200 بكسل وارتفاع 50 بكسل

    // إضافة تأثير عند التمرير
    button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(0, 122, 204));  // تغيير اللون عند التمرير
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setBackground(new Color(0, 153, 204));  // إعادة اللون الأصلي عند الخروج
        }
    });
}

}

class ReservationData {
    private boolean isAvailable;
    private String userID;

    public ReservationData(boolean isAvailable, String userID) {
        this.isAvailable = isAvailable;
        this.userID = userID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getUserID() {
        return userID;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}