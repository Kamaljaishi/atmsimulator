package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Transaction extends JFrame implements ActionListener {

    Button deposit,fastC,pinC,cashW,miniS,balanceE,exit;
    String pin;
    Transaction(String pin) {
        this.pin=pin;

        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));

       Image i2=i1.getImage().getScaledInstance(700,770,Image.SCALE_DEFAULT);
//        BufferedImage bufferedImage = new BufferedImage(700, 770, BufferedImage.TYPE_INT_ARGB);
//      Graphics2D g2d = bufferedImage.createGraphics();
//        g2d.drawImage(i1.getImage(), 0, 0, 700, 770, null);
////       g2d.setFont(new Font("Arial", Font.BOLD, 36));
////        g2d.setColor(Color.RED);
////        g2d.drawString("Welcome to ATM", 100, 100); // Example text at position (100, 100)
//
//        // Dispose the Graphics object
//       g2d.dispose();

        ImageIcon i3 = new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0,0,700,770);
        add(label);
    label.setLayout(null);

       JLabel text=new JLabel("Please Select Your Transaction");
       text.setBounds(150,260,400,15);
       text.setFont(new Font("Raleway", Font.BOLD, 15));
       text.setForeground(Color.WHITE);
       label.add(text);

       deposit=new Button("Deposit");
       deposit.setBounds(130,360,125,22);
       deposit.setFont(new Font("Raleway",Font.BOLD,15));
       setForeground(Color.WHITE);
       deposit.addActionListener(this);
        label.add(deposit);

         fastC=new Button("Fast Cash");
        fastC.setBounds(130,390,125,22);
        fastC.setFont(new Font("Raleway",Font.BOLD,15));
        setForeground(Color.WHITE);
        fastC.addActionListener(this);
        label.add(fastC);

         pinC=new Button("PIN Change");
        pinC.setBounds(130,420,125,22);
        pinC.setFont(new Font("Raleway",Font.BOLD,15));
        setForeground(Color.WHITE);
        pinC.addActionListener(this);
        label.add(pinC);

         cashW=new Button("Cash Withdrawl");
        cashW.setBounds(270,360,125,22);
        cashW.setFont(new Font("Raleway",Font.BOLD,15));
        setForeground(Color.WHITE);
        cashW.addActionListener(this);
        label.add(cashW);

        miniS=new Button("Mini Statement");
        miniS.setBounds(270,390,125,22);
        miniS.setFont(new Font("Raleway",Font.BOLD,15));
        setForeground(Color.WHITE);
        miniS.addActionListener(this);
        label.add(miniS);

         balanceE=new Button("Balance Enquiry");
        balanceE.setBounds(270,420,125,22);
        balanceE.setFont(new Font("Raleway",Font.BOLD,15));
        setForeground(Color.WHITE);
        balanceE.addActionListener(this);
        label.add(balanceE);

         exit=new Button("Exit");
        exit.setBounds(270,450,125,22);
        exit.setFont(new Font("Raleway",Font.BOLD,15));
        setForeground(Color.WHITE);
        exit.addActionListener(this);
        label.add(exit);








        setSize(700, 730);

        setLocation(400, 30);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit){
            System.exit(0);
        }
        else if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(e.getSource()==cashW){
            setVisible(false);
            new Withdraw(pin).setVisible(true);
        }
        else if(e.getSource()==fastC){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (e.getSource()==pinC) {
            setVisible(false);
            new PinChange(pin).setVisible(true);

        } else if (e.getSource()==balanceE) {
            setVisible(false);
            new Balance(pin).setVisible(true);

        } else if (e.getSource()==miniS) {

            new MiniStatement(pin).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Transaction("");
    }
}
