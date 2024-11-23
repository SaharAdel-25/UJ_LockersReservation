package uj_lockersreservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

// Main class for the locker reservation system
public class Locker extends JFrame {

    private String selectedBuilding = ""; // Selected building
    private String currentUserID; // Current user ID
    String firstName; 
    String lastName;
    private Map<String, ReservationData> lockerStatus; // Locker status (reserved/available)
    private Map<String, Boolean> userHasReserved = new HashMap<>(); // Track if the user has already reserved

    // Constructor: Initializes the locker system and loads building selection page
    public Locker(String currentUserID, String firstName, String lastName) {
        this.currentUserID = currentUserID;
        this.firstName = firstName;
        this.lastName = lastName;

        setTitle("Locker Reservation");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lockerStatus = loadLockerStatus(); // Load locker data from file
        page4(currentUserID, firstName, lastName); // Load building selection page
    }

    // Page 4: Displays available buildings for the user to select
    public void page4(String currentUserID, String firstName, String lastName) {
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
                    if (userHasReserved.getOrDefault(currentUserID, false)) {
                        JOptionPane.showMessageDialog(null, "You have already reserved a locker and cannot reserve another.");
                        return;
                    }

                    selectedBuilding = building;
                    lockerStatus = loadLockerStatus(); // Reload locker data
                    page5(currentUserID, firstName, lastName); // Load locker selection page
                }
            });

            buildingPanel.add(buildingButton);
        }

        JScrollPane scrollPane = new JScrollPane(buildingPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back to Login");
        styleButton(backButton);
        backButton.addActionListener(e -> {
            getContentPane().removeAll();
            login loginPage = new login(); // Navigate back to login page
            dispose();
            revalidate();
            repaint();
        });
        add(backButton, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }

    // Page 5: Displays available lockers in the selected building
    public void page5(String currentUserID,String firstName,String lastName) {
    getContentPane().removeAll();
    setLayout(new BorderLayout(10, 10));


    JLabel buildingLabel = new JLabel(selectedBuilding + " - Locker Availability", SwingConstants.CENTER);
    buildingLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
    buildingLabel.setForeground(new Color(0, 102, 204));
    add(buildingLabel, BorderLayout.NORTH);
    
    
        JButton backButton = new JButton("Back to Buildings");
        styleButton(backButton); 
        backButton.addActionListener(e -> page4(  currentUserID,firstName,lastName)); // العودة إلى صفحة المباني عند الضغط على الزر
        add(backButton, BorderLayout.SOUTH);



   
    String reservedLockerKey = userHasReservationInBuilding(currentUserID, selectedBuilding);
    if (reservedLockerKey != null) {
        String[] parts = reservedLockerKey.split(":"); 
        String reservedLockerName = parts[1];

        JLabel reservationInfoLabel = new JLabel("You already have a reservation for " + reservedLockerName + " in " + selectedBuilding + ".", SwingConstants.CENTER);
        reservationInfoLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        reservationInfoLabel.setForeground(Color.RED);
       
         
            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new BorderLayout());  
            bottomPanel.add(reservationInfoLabel, BorderLayout.NORTH); 
            bottomPanel.add(backButton, BorderLayout.SOUTH); 

        
            styleButton(backButton);
            backButton.addActionListener(e -> page4(  currentUserID,firstName,lastName));        

         
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
    reservedLockerKey = userHasReservationInBuilding(currentUserID, selectedBuilding);

    
    if (reservedLockerKey != null) {
        lockerButton.setBackground(new Color(128, 128, 128)); // لون رمادي للخزانات المحجوزة
        lockerButton.setForeground(Color.WHITE);
        lockerButton.setEnabled(false); 
    } else if (isAvailable) {
        lockerButton.setBackground(new Color(46, 204, 113)); // لون أخضر للخزانات المتاحة
        lockerButton.setForeground(Color.WHITE);
        lockerButton.addActionListener(e -> reserveLocker(lockerKey, lockerButton, currentUserID, firstName, lastName));
    } else {
        lockerButton.setBackground(new Color(231, 76, 60)); // لون أحمر للخزانات المحجوزة
        lockerButton.setForeground(Color.WHITE);
        lockerButton.setEnabled(false); 
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
    private void reserveLocker(String lockerKey, JButton lockerButton, String currentUserID, String firstName, String lastName) {
        if (userHasReserved.getOrDefault(currentUserID, false)) {
            JOptionPane.showMessageDialog(null, "You have already reserved a locker and cannot reserve another.");
            return;
        }
        String building = lockerKey.split(":")[0];

        int reservedCount = countReservedLockersInDifferentBuildings(currentUserID);
        if (reservedCount >= 2) {
            JOptionPane.showMessageDialog(this, "You can only reserve lockers in up to two different buildings.");
            return;
        }

        String reservedLockerKey = userHasReservationInBuilding(currentUserID, building);
        if (reservedLockerKey != null) {
            JOptionPane.showMessageDialog(this, "You already have a reservation in " + building + ". You cannot reserve another locker in the same building.");
            return;
        }

        Payment paymentPage = new Payment(currentUserID, lockerKey, lockerButton, firstName, lastName);
        paymentPage.setSize(600, 500);
        paymentPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paymentPage.setLocationRelativeTo(null);
        paymentPage.setVisible(true);
    }

    // Counts lockers reserved by the user across different buildings
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

    // Checks if the user has a reservation in the current building
    private String userHasReservationInBuilding(String userID, String building) {
        for (Map.Entry<String, ReservationData> entry : lockerStatus.entrySet()) {
            if (!entry.getValue().isAvailable() && entry.getValue().getUserID().equals(userID) &&
                entry.getKey().startsWith(building + ":")) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Loads locker data from the file
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
                        String userID = parts[4];
                        status.put(lockerKey, new ReservationData(isAvailable, userID));
                 } else {
                  
                    System.out.println("Data error: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }

    // Saves locker data to the file
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

    // Confirms locker payment
    void confirmPayment(String lockerKey, JButton lockerButton, String currentUserID) {
        lockerStatus.put(lockerKey, new ReservationData(false, currentUserID));
        lockerButton.setBackground(new Color(231, 76, 60));
        saveLockerStatus();
        JOptionPane.showMessageDialog(this, "Payment successful! Locker reserved.");
        userHasReserved.put(currentUserID, true);
    }

    // Cancels locker reservation
    void cancelReservation(String lockerKey, JButton lockerButton, String currentUserID) {
        lockerStatus.put(lockerKey, new ReservationData(true, ""));
        saveLockerStatus();
        JOptionPane.showMessageDialog(this, "Payment canceled. Locker is now available.");
        dispose();
    }
     // Setter for currentUserID to be called after successful login
    public void setCurrentUserID(String userID) {
        this.currentUserID = userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Styles buttons for a consistent UI
    private void styleButton(JButton button) {
        button.setFont(new Font("Times New Roman", Font.BOLD, 18));
        button.setBackground(new Color(0, 153, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 153, 204), 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(200, 50));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 122, 204));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 153, 204));
            }
        });
    }
}

// ReservationData: Stores information about locker reservations
  class ReservationData {
    private boolean isAvailable;
    private String userID,building,lockerName;
      
    public ReservationData(boolean isAvailable, String userID) {
        this.isAvailable = isAvailable;
        this.userID = userID;
    }
      public ReservationData(boolean isAvailable, String userID, String building, String lockerName) {
        this.isAvailable = isAvailable;
        this.userID = userID;
        this.building = building;
        this.lockerName = lockerName;
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