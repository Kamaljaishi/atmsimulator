package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    Button deposit,back;
    JTextField textField;
    String pin;
    Deposit(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));

        Image i2=i1.getImage().getScaledInstance(700,770,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,700,770);
        add(label);
        label.setLayout(null);

        JLabel text=new JLabel("Enter the amount you want to deposit");
        text.setBounds(130,260,400,15);
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        text.setForeground(Color.WHITE);
        label.add(text);

         textField=new JTextField();
        textField.setBounds(130,290,250,17);
        textField.setFont(new Font("Raleway", Font.BOLD, 15));
        label.add(textField);

        deposit=new Button("Deposit");
        deposit.setBounds(270,420,125,22);
        deposit.setFont(new Font("Raleway",Font.BOLD,15));
        deposit.addActionListener(this);
        label.add(deposit);

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
        if (ae.getSource() == deposit) {
            String amount = textField.getText();
            Date date =new Date();
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount");
                }
                else{
                    try {
                        Conn conn=new Conn();
                        String query="insert into bank values ('"+pin+"','"+date+"','Depost','"+amount+"')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs "+amount+" Deposited Successfully");
                        setVisible(false);
                        new Transaction(pin).setVisible(true);

                    }
                    catch(Exception e){

                    }

                }

        }
        else if (ae.getSource() == back){
                setVisible(false);
                new Transaction(pin).setVisible(true);
            }
        }




    public static void main(String[] args) {
        new Deposit("");
    }
}
