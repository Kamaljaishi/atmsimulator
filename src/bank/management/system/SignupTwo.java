package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignupTwo extends JFrame implements ActionListener{
    JTextField panField,aadharField;
    JComboBox chooseRel,chooseCat,chooseInc,chooseQuali,chooseOccu;
    JRadioButton yes,no,yes1,no1;
    Button btn;
    String formno;

SignupTwo(String formno) {
    setLayout(null);
    this.formno=formno;

    JLabel page = new JLabel("Page2 : Additional detail");
    page.setFont(new Font("Raleway", Font.BOLD, 15));
    page.setBounds(350, 40, 400, 20);
    add(page);
    JLabel religion = new JLabel("Religion");
    religion.setFont(new Font("Raleway", Font.BOLD, 15));
    religion.setBounds(100, 90, 150, 20);
    add(religion);
    String [] relarray={"Hindu","Muslim","Christian","Sikh","Other"};
     chooseRel=new JComboBox(relarray);
    chooseRel.setFont(new Font("Raleway", Font.BOLD, 14));
    chooseRel.setBounds(300, 90, 400, 20);
    add(chooseRel);

    JLabel category = new JLabel("Category");
    category.setFont(new Font("Raleway", Font.BOLD, 15));
    category.setBounds(100, 130, 150, 20);
    add(category);
    String [] catArray={"General","OBC","SC","ST","Other"};
     chooseCat=new JComboBox(catArray);
    chooseCat.setFont(new Font("Raleway", Font.BOLD, 14));
    chooseCat.setBounds(300, 130, 400, 20);
    add(chooseCat);



    JLabel income = new JLabel("Income");
    income.setFont(new Font("Raleway", Font.BOLD, 15));
    income.setBounds(100, 170, 150, 20);
    add(income);
    String [] IncArray={"<1.5 lakh","<2.5 lakh","<5 lakh","upto 10 lakh","Above 10 lakh"};
     chooseInc=new JComboBox(IncArray);
    chooseInc.setFont(new Font("Raleway", Font.BOLD, 14));
    chooseInc.setBounds(300, 170, 400, 20);
    add(chooseInc);


    JLabel quali = new JLabel("Educational Qualification");
    quali.setFont(new Font("Raleway", Font.BOLD, 15));
    quali.setBounds(100, 210, 150, 20);
    add(quali);
    String [] qualiArray={"Non-graduation","Undergraduate","Graduate","Post Graduate","Other"};
     chooseQuali=new JComboBox(qualiArray);
    chooseQuali.setFont(new Font("Raleway", Font.BOLD, 12));
    chooseQuali.setBounds(300, 210, 400, 20);
    add(chooseQuali);



    JLabel Occuptaion = new JLabel("Occupation");
    Occuptaion.setFont(new Font("Raleway", Font.BOLD, 15));
    Occuptaion.setBounds(100, 250, 150, 20);
    add(Occuptaion);
    String [] occuArray={"Salaried","Self Employed","Student","Business Owner","Retired"};
     chooseOccu=new JComboBox(occuArray);
    chooseOccu.setFont(new Font("Raleway", Font.BOLD, 14));
    chooseOccu.setBounds(300, 250, 400, 20);
    add(chooseOccu);

    JLabel pan = new JLabel("PAN Number");
    pan.setFont(new Font("Raleway", Font.BOLD, 15));
    pan.setBounds(100, 290, 150, 20);
    add(pan);
    panField=new JTextField();
    panField.setFont(new Font("Raleway", Font.BOLD, 15));
    panField.setBounds(300,290,400,20);
    add(panField);

    JLabel aadhar = new JLabel("Aadhar Number");
    aadhar.setFont(new Font("Raleway", Font.BOLD, 15));
    aadhar.setBounds(100, 330, 150, 20);
    add(aadhar);
    aadharField = new JTextField();
    aadharField.setFont(new Font("Raleway", Font.BOLD, 14));
    aadharField.setBounds(300, 330, 400, 20);
    add(aadharField);

    JLabel citizen = new JLabel("Senior Citizen");
    citizen.setFont(new Font("Raleway", Font.BOLD, 15));
    citizen.setBounds(100, 370, 150, 20);
    add(citizen);
    yes=new JRadioButton("Yes");
    yes.setFont(new Font("Raleway", Font.BOLD, 14));
    yes.setBounds(300, 370, 150, 20);
    add(yes);
    no=new JRadioButton("No");
    no.setFont(new Font("Raleway", Font.BOLD, 14));
    no.setBounds(550, 370, 150, 20);
    add(no);
    ButtonGroup grp=new ButtonGroup();
    grp.add(yes);
    grp.add(no);

    JLabel account = new JLabel("Existing Account");
    account.setFont(new Font("Raleway", Font.BOLD, 15));
    account.setBounds(100, 410, 150, 20);
    add(account);
    yes1=new JRadioButton("Yes");
    yes1.setFont(new Font("Raleway", Font.BOLD, 14));
    yes1.setBounds(300, 410, 150, 20);
    add(yes1);
    no1=new JRadioButton("No");
    no1.setFont(new Font("Raleway", Font.BOLD, 14));
    no1.setBounds(550, 410, 150, 20);
    add(no1);
    ButtonGroup grp1=new ButtonGroup();
    grp1.add(yes1);
    grp1.add(no1);

    btn = new Button("Next");
    btn.setBackground(Color.BLACK);
    btn.addActionListener(this);
    btn.setForeground(Color.WHITE);

    btn.setBounds(620, 480, 80, 25);

    add(btn);


    getContentPane().setBackground(Color.WHITE);
    setSize(850, 700);
    setVisible(true);
    setLocation(340, 10);
}
    public void actionPerformed(ActionEvent e) {
//        JTextField panField,aadharField;
//        JComboBox chooseRel,chooseCat,chooseInc,chooseQuali,chooseOccu;
//        JRadioButton yes,no,yes1,no1;
//        Button btn;

        String religion = (String)chooseRel.getSelectedItem();
        String category = (String)chooseCat.getSelectedItem();
        String income=(String)chooseInc.getSelectedItem();
        String qualification=(String)chooseQuali.getSelectedItem();
        String occupation=(String)chooseOccu.getSelectedItem();
        String panNo=panField.getText();
        String aadharNo=aadharField.getText();
        String senior=null;
        if(yes.isSelected()){
            senior="Yes";
        }
        else if(no.isSelected()) {
            senior="No";
        }

        String existing=null;
        if(yes1.isSelected()){
            existing="Yes";
        }
        else if(no1.isSelected()) {
            existing="No";
        }






        try {
            if (religion.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter religion");
            } else if (category.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter Ctegory");
            } else if (income.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter income");
            } else if (qualification.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter qualification");
            } else if (senior == null) {
                JOptionPane.showMessageDialog(null, "Please select senior citizen or not");
            } else if (existing == null) {
                JOptionPane.showMessageDialog(null, "Please select if existing user or not");
            } else if (occupation.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter Occupation type");
            } else if (panNo.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter PAN number");
            } else if (aadharNo.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter Aadhar number");
            }  else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + qualification + "','" + occupation + "','" + panNo + "','" + aadharNo + "','" + senior + "','" + existing + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details submitted successfully.");
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

public static void main(String [] args){
    new SignupTwo("");
}
}
