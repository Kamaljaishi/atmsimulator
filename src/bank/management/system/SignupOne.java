package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;


public class SignupOne extends JFrame implements ActionListener{
    int value;
    JTextField textName,textFname,emailField,addressField,cityField,stateField,pincodeField;
    JDateChooser dateChooser;
    JRadioButton male,female,married,Unmarried,other;

    SignupOne(){
        setLayout(null);
        Random random=new Random();
         value=1000+random.nextInt(9000);
        JLabel label=new JLabel("APPLICATION FORM NO:"+value);
        label.setBounds(250,10,600,20);
         label.setFont(new Font("Arial",Font.BOLD,25));
        add(label);
        JLabel page=new JLabel("Page1 : Personal detail");
        page.setFont(new Font("Raleway", Font.BOLD,15));
        page.setBounds(350,40,400,20);
        add(page);
        JLabel name=new JLabel("Name");
        name.setFont(new Font("Raleway", Font.BOLD,15));
        name.setBounds(100,90,150,20);
        add(name);
         textName=new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,90,400,20);
        add(textName);
        JLabel fname=new JLabel("Father's Name");
        fname.setFont(new Font("Raleway", Font.BOLD,15));
        fname.setBounds(100,130,150,20);
        add(fname);
         textFname=new JTextField();
        textFname.setFont(new Font("Raleway",Font.BOLD,14));
        textFname.setBounds(300,130,400,20);
        add(textFname);

        textName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When Enter is pressed, move focus to the second JTextField
                textFname.requestFocus();
            }
        });
        JLabel dob=new JLabel("Date of birth");
        dob.setFont(new Font("Raleway", Font.BOLD,15));
        dob.setBounds(100,170,150,20);
        add(dob);
         dateChooser=new JDateChooser();
        dateChooser.setBounds(300,170,400,20);
        dateChooser.setBackground(Color.BLACK);
        add(dateChooser);


        JLabel email=new JLabel("Email address");
        email.setFont(new Font("Raleway", Font.BOLD,15));
        email.setBounds(100,210,150,20);
        add(email);
        emailField=new JTextField();
        emailField.setFont(new Font("Raleway",Font.BOLD,14));
        emailField.setBounds(300,210,400,20);
        add(emailField);


        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Raleway", Font.BOLD,15));
        gender.setBounds(100,250,150,20);
        add(gender);
         male=new JRadioButton("Male");
        male.setBounds(300,250,100,20);
        male.setBackground(Color.WHITE);
        add(male);

         female=new JRadioButton("Female");
        female.setBounds(500,250,100,20);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup btngrp=new ButtonGroup();
        btngrp.add(male);
        btngrp.add(female);



        JLabel maritial=new JLabel("Maritial Status");
        maritial.setFont(new Font("Raleway", Font.BOLD,15));
        maritial.setBounds(100,290,150,20);
        add(maritial);
         married=new JRadioButton("Married");
        married.setBounds(300,290,100,20);
        married.setBackground(Color.WHITE);
        add(married);

        Unmarried=new JRadioButton("Single");
        Unmarried.setBounds(450,290,100,20);
        Unmarried.setBackground(Color.WHITE);
        add(Unmarried);


        other=new JRadioButton("Other");
        other.setBounds(600,290,100,20);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup btngrp1=new ButtonGroup();

        btngrp1.add(married);
        btngrp1.add(Unmarried);
        btngrp1.add(other);

        JLabel address=new JLabel("Address");
        address.setFont(new Font("Raleway", Font.BOLD,15));
        address.setBounds(100,330,150,20);
        add(address);
         addressField=new JTextField();
        addressField.setFont(new Font("Raleway",Font.BOLD,14));
        addressField.setBounds(300,330,400,20);
        add(addressField);

        JLabel city=new JLabel("City");
        city.setFont(new Font("Raleway", Font.BOLD,15));
        city.setBounds(100,370,150,20);
        add(city);
        cityField=new JTextField();
        cityField.setFont(new Font("Raleway",Font.BOLD,14));
        cityField.setBounds(300,370,400,20);
        add(cityField);

        JLabel state=new JLabel("State");
        state.setFont(new Font("Raleway", Font.BOLD,15));
        state.setBounds(100,410,150,20);
        add(state);
         stateField=new JTextField();
        stateField.setFont(new Font("Raleway",Font.BOLD,14));
        stateField.setBounds(300,410,400,20);
        add(stateField);
        JLabel pincode=new JLabel("PINCODE");
        pincode.setFont(new Font("Raleway", Font.BOLD,15));
        pincode.setBounds(100,450,150,20);
        add(pincode);
         pincodeField=new JTextField();
        pincodeField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeField.setBounds(300,450,400,20);
        add(pincodeField);
         Button btn=new Button("Next");
         btn.setBackground(Color.BLACK);
         btn.setForeground(Color.WHITE);

         btn.setBounds(620, 480,80,25);
         btn.addActionListener(this);
         add(btn);



        getContentPane().setBackground(Color.WHITE);
        setSize(850,700);
        setVisible(true);
        setLocation(340,10);


    }
    public void actionPerformed(ActionEvent e) {
        String val = "" + value;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) (dateChooser.getDateEditor().getUiComponent())).getText();
        String mail = emailField.getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String maritial = null;
        if (married.isSelected()) {
            maritial = "Married";
        } else if (Unmarried.isSelected()) {
            maritial = "Unmarried";
        } else if (other.isSelected()) {
            maritial = "Other";
        }

        String address = addressField.getText();
        String city = cityField.getText();
        String State = stateField.getText();
        String pincode = pincodeField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter name");
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter Father's name");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter Date of Birth");
            } else if (mail.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter email");
            } else if (gender == null) {
                JOptionPane.showMessageDialog(null, "Please select Gender");
            } else if (maritial == null) {
                JOptionPane.showMessageDialog(null, "Please select marital status");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter Address");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter City");
            } else if (State.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter State");
            } else if (pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter Pincode");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" + val + "','" + name + "','" + fname + "','" + dob + "','" + mail + "','" + gender + "','" + maritial + "','" + address + "','" + city + "','" + State + "','" + pincode + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details submitted successfully.");
                setVisible(false);
                new SignupTwo(val).setVisible(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new SignupOne();

    }

}