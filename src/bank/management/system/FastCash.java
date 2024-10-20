package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {

    JButton hndrd, fvhndrd, thsnd, twntyfvhndrd, fvthsnd, tnthsnd , back, proceed;
    String pin;  // Declare 'amount' as a class variable

    FastCash(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));

        Image i2 = i1.getImage().getScaledInstance(700, 770, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 700, 770);
        add(label);
        label.setLayout(null);
        JLabel text = new JLabel("Please Select the amount");
        text.setBounds(150, 260, 400, 15);
        text.setFont(new Font("Raleway", Font.BOLD, 15));
        text.setForeground(Color.WHITE);
        label.add(text);

        hndrd = new JButton("Rs 100");
        hndrd.setBounds(130, 360, 125, 22);
        hndrd.setFont(new Font("Raleway", Font.BOLD, 15));
        setForeground(Color.WHITE);
        hndrd.addActionListener(this);
        label.add(hndrd);

        fvhndrd = new JButton("Rs 500");
        fvhndrd.setBounds(130, 390, 125, 22);
        fvhndrd.setFont(new Font("Raleway", Font.BOLD, 15));
        setForeground(Color.WHITE);
        fvhndrd.addActionListener(this);
        label.add(fvhndrd);

        thsnd = new JButton("Rs 1000");
        thsnd.setBounds(130, 420, 125, 22);
        thsnd.setFont(new Font("Raleway", Font.BOLD, 15));
        setForeground(Color.WHITE);
        thsnd.addActionListener(this);
        label.add(thsnd);

        twntyfvhndrd = new JButton("Rs 2500");
        twntyfvhndrd.setBounds(270, 360, 125, 22);
        twntyfvhndrd.setFont(new Font("Raleway", Font.BOLD, 15));
        setForeground(Color.WHITE);
        twntyfvhndrd.addActionListener(this);
        label.add(twntyfvhndrd);

        fvthsnd = new JButton("Rs 5000");
        fvthsnd.setBounds(270, 390, 125, 22);
        fvthsnd.setFont(new Font("Raleway", Font.BOLD, 15));
        setForeground(Color.WHITE);
        fvthsnd.addActionListener(this);
        label.add(fvthsnd);

        tnthsnd = new JButton("Rs 10000");
        tnthsnd.setBounds(270, 420, 125, 22);
        tnthsnd.setFont(new Font("Raleway", Font.BOLD, 15));
        setForeground(Color.WHITE);
        tnthsnd.addActionListener(this);
        label.add(tnthsnd);

        back = new JButton("Back");
        back.setBounds(130, 450, 125, 22);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        setForeground(Color.WHITE);
        back.addActionListener(this);
        label.add(back);
//
//        proceed = new Button("Proceeed");
//        proceed.setBounds(270, 450, 125, 22);
//        proceed.setFont(new Font("Raleway", Font.BOLD, 15));
//        setForeground(Color.WHITE);
//        proceed.addActionListener(this);
//        label.add(proceed);

        setSize(700, 730);
        setLocation(400, 30);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        } else {
            try {
                // Debugging: Check which button was clicked
                JButton clickedButton = (JButton) e.getSource();
                String buttonText = clickedButton.getText().trim();

                // Log button text to help with debugging
                System.out.println("Button clicked: " + buttonText);

                // Ensure button text starts with "Rs" and is not too short
                if (buttonText.length() > 3 && buttonText.startsWith("Rs")) {
                    // Extract the amount and trim any extra spaces
                    String amountText = buttonText.substring(3).trim();

                    // Debugging: Log the extracted amount
                    System.out.println("Amount Text extracted: '" + amountText + "'");

                    // Check if amountText is empty
                    if (amountText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Invalid amount selected (empty).");
                        return;
                    }

                    // Parse the amount safely
                    int amount = Integer.parseInt(amountText);
                    System.out.println(amount);

                    Conn conn = new Conn();
                    int balance = 0;
                    ResultSet rs = conn.s.executeQuery("select * from bank where val='" + pin + "'");
                    while (rs.next()) {
                        if (rs.getString("type").equals("Depost")) {
                            balance = balance + Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance = balance - Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (amount > balance) {
                        JOptionPane.showMessageDialog(null, "Insufficient balance");
                        setVisible(false);
                        return;
                    }

                    // Proceed with withdrawal
                    Date date = new Date();
                    String query = "insert into bank values('" + pin + "','" + date + "','Withdraw','" + amount + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdrawn Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);

                } else {
                    // Handle invalid button text format
                    JOptionPane.showMessageDialog(null, "Invalid button text format.");
                    System.out.println("Invalid button text: " + buttonText);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid amount selected (parsing error).");
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }





    public static void main(String[] args) {

        new FastCash("");
    }
}
