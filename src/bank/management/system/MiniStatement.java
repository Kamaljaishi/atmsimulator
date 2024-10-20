package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pin;

    MiniStatement(String pin) {
        this.pin = pin;  // Assigning the pin correctly.
        setLayout(null);

        JLabel label = new JLabel("Indian Bank");
        label.setBounds(140, 30, 200, 20);
        label.setFont(new Font("Raleway", Font.BOLD, 15));
        add(label);

        JLabel card = new JLabel();
        card.setBounds(50, 60, 400, 13);
        card.setFont(new Font("Raleway", Font.BOLD, 15));
        add(card);

        JLabel stmt = new JLabel();
        stmt.setBounds(50, 90, 600, 200);  // Increased the height to handle larger text.
        stmt.setFont(new Font("Raleway", Font.BOLD, 12));
        stmt.setText("<html>");  // Initialize with <html> to support HTML
        add(stmt);

        try {
            Conn conn = new Conn();

            String query = "select * from login where pin='" + pin + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                String cardno = rs.getString("card_number");
                card.setText("Your card number is " + cardno.substring(0, 4) + "XXXXXXXX" + cardno.substring(12));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            Conn conn = new Conn();

            String query = "select * from bank where val='" + pin + "'";
            ResultSet rs = conn.s.executeQuery(query);

            // Instead of using StringBuilder, directly append to the label's text.
            while (rs.next()) {
                // Get current label text and append the new row of HTML.
                stmt.setText(stmt.getText() +
                        rs.getString("type") + "&nbsp;&nbsp;&nbsp;" +
                        rs.getString("amount") + "&nbsp;&nbsp;&nbsp;" +
                        rs.getString("date").substring(0, 10) + "<br><br>"
                );
            }

            // Finalize the HTML by appending the closing tag
            stmt.setText(stmt.getText() + "</html>");

        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 600);
        setTitle("Mini Statement");
        setLocation(20, 30);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("1234");  // Pass a sample pin value
    }
}
