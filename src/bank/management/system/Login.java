package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame  {
    JButton button,button1,button2;
    JTextField textfieild;
    JPasswordField textfield1;
    public Login(){


        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource(
                "icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        JLabel label1=new JLabel("WELCOME TO ATM");
        label1.setFont(new Font("Osward",Font.BOLD,28));
        label1.setBounds(300,20,300,100);
        add(label1);
        JLabel label2=new JLabel("ATM Number:");
        label2.setFont(new Font("Raleway",Font.BOLD,18));
        label2.setBounds(150,140,150,30);
        add(label2);
         textfieild=new JTextField();
        textfieild.setBounds(300,140,300,35);
        add(textfieild);

        JLabel label3=new JLabel("Enter PIN:");
        label3.setFont(new Font("Raleway",Font.BOLD,18));
        label3.setBounds(150,180,150,30);
        add(label3);
        textfield1=new JPasswordField();
        textfield1.setBounds(300,180,300,35);
        add(textfield1);
         button = new JButton("Sign in");
         button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 Conn conn=new Conn();
                 String card=textfieild.getText();
                 String Pin=textfield1.getText();

                 String query="select * from login where card_number='"+card+"' and pin='"+Pin+"'";
                 ResultSet resultSet;
                 try {
                     resultSet = conn.s.executeQuery(query);
                     if(resultSet.next()){
                         setVisible(false);
                         new Transaction(Pin).setVisible(true);
                     }
                     else {
                         JOptionPane.showMessageDialog(null,"Incorrect card or pin");
                     }
                 }
                 catch (Exception ae){
                     System.out.println(ae);
                 }

             }
         });

       button.setBackground(Color.BLACK);
       button.setForeground(Color.WHITE);
        button.setBounds(300,230,100,40);
        add(button);

         button1 = new JButton("Clear");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    textfieild.setText("");
                    textfield1.setText("");


            }
        });
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(500,230,100,40);
        add(button1);

         button2 = new JButton("Sign Up");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    setVisible(false);
                    new SignupOne().setVisible(true);


            }
        });

        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setBounds(300,290,300,40);
        add(button2);




        getContentPane().setBackground(Color.WHITE);
        setSize(800,450);
        setVisible(true);
        setLocation(340,200);
    }


    public static void main(String[] args) {
        new Login();
    }
}
