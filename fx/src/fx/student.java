package fx;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class student extends JFrame {
   JPanel p;
   JButton b8,b1,b2,b3;
   JTextField t1,t2,t3,t4,t5,t6;
       JLabel l1,l2,l3,l4,l5,l6;
    static Connection k;
    static Statement s;
    static String query;
    public student(){
        DB c1 = new DB();
      l1=new JLabel("ID");
      l2=new JLabel("Name");
      l3=new JLabel("Gender");
      l4=new JLabel("Year");
      l5=new JLabel("Address");
      l6=new JLabel("Email");
      t1=new JTextField();
      t2=new JTextField();
      t3=new JTextField();
      t4=new JTextField();
      t5=new JTextField();
      t6=new JTextField();
    b8=new JButton("Home Page");
    b1=new JButton("Save");
    b2=new JButton("Courses");
    b3=new JButton("Results");
    p=new JPanel();
    this.setTitle("Student Page");
    this.setSize(400,538);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setResizable(false);
    this.setLocation(200,50);
    p.setSize(400, 538);
    p.setLayout(null);
    l1.setBounds(50, 41, 50, 15);
    t1.setBounds(100, 41, 170, 20);
    l2.setBounds(50, 71, 50, 15);
    t2.setBounds(100, 71, 170, 20);
    l3.setBounds(50, 101, 50, 15);
    t3.setBounds(100, 101, 170, 20);
    l4.setBounds(50, 131, 50, 15);
    t4.setBounds(100, 131, 170, 20);
    l5.setBounds(50, 161, 50, 15);
    t5.setBounds(100, 161, 170, 20);
    l6.setBounds(50, 191, 50, 15);
    t6.setBounds(100, 191, 170, 20);  
    b8.setBounds(0, 0, 150, 20);
    b1.setBounds(125, 251, 120, 20);
    b2.setBounds(180,221 , 120, 20);
    b3.setBounds(50, 221, 120, 20);
    p.add(b8);
    p.add(t1);
    p.add(l1);
    p.add(t2);
    p.add(l2);
    p.add(t3);
    p.add(l3);
    p.add(t4);
    p.add(l4);
    p.add(t5);
    p.add(l5);
    p.add(t6);
    p.add(l6);
    p.add(b1);
    p.add(b2);
    p.add(b3);
    
     b8.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {
       new home();
       dispose();
    }
  }); 
     b1.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent ee) {
       //INSERT INTO `student`(`Id`, `Name`, `Gender`, `Year`, `Address`, `Email`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]','[value-5]','[value-6]')//
        try {
            k = c1.connect();
            s = k.createStatement();
            query = "INSERT INTO `student`(`Id`, `Name`, `Gender`, `Year`, `Address`, `Email`) VALUES ('"+Integer.parseInt(t1.getText())+"','"+t2.getText()+"','"+t3.getText()+"','"+Integer.parseInt(t4.getText())+"','"+t5.getText()+"','"+t6.getText()+"')";
            s.execute(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                k.close();
                s.close();
            } catch (SQLException e) {

            }
        }
    }
  }); 
     b2.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent ee) {
       //show the courses of the student//
    }
  }); 
     b3.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent ee) {
       //print the result of the student//
    }
  }); 
     
      add(p);
    }
}
