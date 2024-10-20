package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class   Balance extends JFrame implements ActionListener {
    Button back;
    String pin;
    int balance = 0;
    Balance(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));

        Image i2=i1.getImage().getScaledInstance(700,770,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,700,770);
        add(label);
        label.setLayout(null);
        try{
            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery("select * from bank where val='" + pin + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Depost")) {
                    balance = balance + Integer.parseInt(rs.getString("amount"));
                } else {
                    balance = balance - Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str="Your balance is "+balance;
        JLabel text=new JLabel(str);
        text.setBounds(130,260,400,15);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        text.setForeground(Color.WHITE);
        label.add(text);



        back=new Button("Exit");
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
             setVisible(false);
            new Transaction(pin).setVisible(true);
    }





    public static void main(String[] args) {
        new Balance("");
    }
}
