package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton btn1,btn2,btn3,btn4;
    JCheckBox box1,box2,box3,box4,box5,box6,box7;
    Button btn,btnn;
    long card;
    int pin;
    String value;
    SignupThree(String value){
        this.value=value;
        setLayout(null);
        JLabel page=new JLabel("Page 3 : Account details");
        page.setFont(new Font("Raleway", Font.BOLD, 20));
        page.setBounds(350, 40, 400, 25);
        add(page);

        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 18));
        type.setBounds(100, 90, 200, 20);
        add(type);
         btn1=new JRadioButton("Saving Account");
        btn1.setBounds(100,120,300,20);
        btn1.setFont(new Font("Raleway",Font.BOLD,15));
        btn1.setBackground(Color.WHITE);
        add(btn1);
         btn2=new JRadioButton("Fixed Deposit Account");
        btn2.setBounds(450,120,300,20);
        btn2.setFont(new Font("Raleway",Font.BOLD,15));
        btn2.setBackground(Color.WHITE);
        add(btn2);
        btn3=new JRadioButton("Current Account");
        btn3.setBounds(100,160,300,20);
        btn3.setFont(new Font("Raleway",Font.BOLD,15));
        btn3.setBackground(Color.WHITE);
        add(btn3);
        btn4=new JRadioButton("Recurring Deposit Account");
        btn4.setBounds(450,160,300,20);
        btn4.setFont(new Font("Raleway",Font.BOLD,15));
        btn4.setBackground(Color.WHITE);
        add(btn4);
        ButtonGroup btngrp=new ButtonGroup();
        btngrp.add(btn1);
        btngrp.add(btn2);
        btngrp.add(btn3);
        btngrp.add(btn4);

        JLabel label1=new JLabel("Card Number");
        label1.setBounds(100,210,400,20);
        label1.setFont(new Font("Raleway",Font.BOLD,18));
        add(label1);
        JLabel label2=new JLabel("Your 16-digit card number");
        label2.setBounds(100,240,200,15);
        label2.setFont(new Font("Raleway",Font.BOLD,12));
        add(label2);
        JLabel label3=new JLabel("XXXX-XXXX-XXXX-4813");
        label3.setBounds(350,220,400,15);
        label3.setFont(new Font("Raleway",Font.BOLD,18));
        add(label3);

        JLabel label4=new JLabel("PIN:");
        label4.setBounds(100,290,400,20);
        label4.setFont(new Font("Raleway",Font.BOLD,18));
        add(label4);
        JLabel label5=new JLabel("Your 4-digit password");
        label5.setBounds(100,320,200,15);
        label5.setFont(new Font("Raleway",Font.BOLD,12));
        add(label5);
        JLabel label6=new JLabel("XXXX");
        label6.setBounds(350,300,200,15);
        label6.setFont(new Font("Raleway",Font.BOLD,18));
        add(label6);

        JLabel label7=new JLabel("Services Required:");
        label7.setFont(new Font("Raleway", Font.BOLD, 18));
        label7.setBounds(100, 360, 200, 20);
        add(label7);
        box1=new JCheckBox("ATM Card");
        box1.setFont(new Font("Raleway", Font.BOLD, 14));
        box1.setBounds(100, 400, 200, 17);
        box1.setBackground(Color.WHITE);
        add(box1);
        box2=new JCheckBox("Mobile Banking");
        box2.setFont(new Font("Raleway", Font.BOLD, 14));
        box2.setBounds(100, 440, 200, 17);
        box2.setBackground(Color.WHITE);
        add(box2);
        box3=new JCheckBox("Cheque Book");
        box3.setFont(new Font("Raleway", Font.BOLD, 14));
        box3.setBounds(100, 480, 200, 17);
        box3.setBackground(Color.WHITE);
        add(box3);
        box4=new JCheckBox("Internet Banking");
        box4.setFont(new Font("Raleway", Font.BOLD, 14));
        box4.setBounds(350, 400, 200, 17);
        box4.setBackground(Color.WHITE);
        add(box4);
        box5=new JCheckBox("EMAIL & SMS Alerts");
        box5.setFont(new Font("Raleway", Font.BOLD, 14));
        box5.setBounds(350, 440, 200, 17);
        box5.setBackground(Color.WHITE);
        add(box5);
        box6=new JCheckBox("E-Statement");
        box6.setFont(new Font("Raleway", Font.BOLD, 14));
        box6.setBounds(350, 480, 200, 17);
        box6.setBackground(Color.WHITE);
        add(box6);
        box7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        box7.setFont(new Font("Raleway", Font.BOLD, 12));
        box7.setBounds(100, 540, 600, 17);
        box7.setBackground(Color.WHITE);
        add(box7);
        btn=new Button("Submit");
        btn.setBounds(250,580,100,23);
        btn.setFont(new Font("Raleway", Font.BOLD, 15));
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.addActionListener(this);
        add(btn);
        btnn=new Button("Cancel");
        btnn.setBounds(400,580,100,23);
        btnn.setFont(new Font("Raleway", Font.BOLD, 15));
        btnn.setBackground(Color.BLACK);
        btnn.setForeground(Color.WHITE);
        btnn.addActionListener(this);
        add(btnn);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,700);
        setVisible(true);
        setLocation(340,10);
    }
    public void actionPerformed(ActionEvent e){
      if(e.getSource()==btn){
        String account=null;
        if(btn1.isSelected()){
            account="Saving Account";
        } else if (btn2.isSelected()) {
            account="Fixed Deposit Account";

        }else if (btn3.isSelected()) {
            account="Current Account";

        } else if (btn4.isSelected()) {
            account="Recurring Deposit Account";

        }

          Random random=new Random();
           card = 5461228400000000L + random.longs(0, 90000000L).findFirst().getAsLong();
           pin=1000+random.nextInt(9000);
           String pins=pin+"";

           String checked="";
           if(box1.isSelected()){
               checked+="ATM Card";
           }
            if(box2.isSelected()){
               checked+="Mobile Banking";
           }
            if(box3.isSelected()){
               checked+="Checque Book";
           }
            if(box4.isSelected()){
               checked+="Internet Banking";
           }
            if(box5.isSelected()){
               checked+="E-mail & SMS alert";
           }
            if(box6.isSelected()){
               checked+="E-statement";
           }
           String finalcheck=null;
           if(box7.isSelected()){
               finalcheck="all right";
           }

           try{
               if(account==null){
                   JOptionPane.showMessageDialog(null, "Please select account type");
               }
               else if(checked==""){
                   JOptionPane.showMessageDialog(null, "Please select the service you need");
               }
               else if(finalcheck==null){
                   JOptionPane.showMessageDialog(null, "Please click on the declaration");

               }
               else{
                   Conn conn=new Conn();
                   String query="insert into signupthree values ('"+value+"','"+account+"','"+card+"','"+pin+"','"+checked+"')";
                   conn.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null,"Your card number:"+card +" \n PIN: "+pin);
                   String query2="insert into login values ('"+value+"','"+card+"','"+pin+"')";
                   conn.s.executeUpdate(query2);
                   setVisible(false);
                   new Deposit(pins).setVisible(true);
               }

           } catch (Exception ex) {
               ex.printStackTrace();
           }

      }
      else if(e.getSource()==btnn){


      }
    }
    public static void main(String[] args) {
        new SignupThree("");
    }
}
