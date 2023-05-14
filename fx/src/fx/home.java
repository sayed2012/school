package fx;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import fx.Admin;
class home extends JFrame {
    public JButton b1,b2,b3,b4;
    JPanel p1;
    public home(){
      b1=new JButton("Admin page");
      b2=new JButton("Instructor page");
      b3=new JButton("Student page");
      b4=new JButton("Course page");
     p1=new JPanel();
    this.setTitle("Home Page");
    this.setSize(400,538);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setResizable(false);
    this.setLocation(200,50);
    p1.setLayout(null);
    p1.setSize(400,538);
    b1.setBounds(0, 0, 385, 125);
    b2.setBounds(0, 125, 385, 125);
    b3.setBounds(0, 250, 385, 125);
    b4.setBounds(0, 375, 385, 125);
     b1.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {
       new Admin();
       dispose();
    }
  }); 
     b2.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {
         new teacher();
        dispose();
    }
  }); 
     b3.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {
         new student();
        dispose();
    }
  }); 
     b4.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {
        new courses();
        dispose();
    }
  }); 
    p1.add(b1);
    p1.add(b2);
    p1.add(b3);
    p1.add(b4);
    add(p1);
    
    
    }
    
}
