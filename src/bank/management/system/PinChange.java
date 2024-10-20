package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
    Button change,back;
    JTextField textField;
    String pin;
    PinChange(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));

        Image i2=i1.getImage().getScaledInstance(700,770,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,700,770);
        add(label);
        label.setLayout(null);

        JLabel text=new JLabel("Enter new PIN");
        text.setBounds(130,260,400,15);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        text.setForeground(Color.WHITE);
        label.add(text);

        textField=new JTextField();
        textField.setBounds(130,290,250,17);
        textField.setFont(new Font("Raleway", Font.BOLD, 15));
        label.add(textField);
        change=new Button("Enter");
       change.setBounds(270,420,125,22);
        change.setFont(new Font("Raleway",Font.BOLD,15));
        change.addActionListener(this);
        label.add( change);

        back=new Button("Back");
        back.setBounds(270,450,125,22);
        back.setFont(new Font("Raleway",Font.BOLD,15));
        back.addActionListener(this);
        label.add(back);





        setSize(700, 730);

        setLocation(400, 30);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change) {
            String new_pin = textField.getText();
            Date date =new Date();
            if (new_pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the new pin");
            }
            else{
                try {
                    Conn conn=new Conn();
                    String query="update login set pin='"+new_pin+"' where pin='"+pin+"'";
                    conn.s.executeUpdate(query);
                    String query1="update signupthree set pin='"+new_pin+"' where pin='"+pin+"'";
                    conn.s.executeUpdate(query1);
                    String query2="update bank set val='"+new_pin+"' where val='"+pin+"'";
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Pin change successfully");
                    setVisible(false);
                    new Transaction(new_pin).setVisible(true);

                }
                catch(Exception e){
                    e.printStackTrace();

                }

            }

        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }





    public static void main(String[] args) {
        new PinChange("");
    }
}