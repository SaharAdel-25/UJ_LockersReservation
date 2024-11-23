
package uj_lockersreservation;

import javax.swing.JFrame;

/*
Suad Anees Alsaadi 2219146
Sahar Adel 2219170
Sara Hamdan 2210190
 */

public class UJ_LockersReservation extends JFrame {

    public static void main(String[] args) {
        // Create and display the login frame
        login frame = new login(); // Create the login frame
        frame.setSize(600, 500); // Set the frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true); // Show the frame
    }
}
