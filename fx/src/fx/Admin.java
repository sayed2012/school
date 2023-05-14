package fx;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

class Admin extends JFrame {
    public JButton b1,b2,b8;
    JPanel p1;
    public Admin(){
      b1=new JButton("Courses Adminstration");
      b2=new JButton("Instructors Adminstration");
      b8=new JButton("Home page");
     p1=new JPanel();
    this.setTitle("Admin Page");
    this.setSize(400,538);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setResizable(false);
    this.setLocation(200,50);
    p1.setLayout(null);
    p1.setSize(400,538);
    b1.setBounds(0, 25, 384, 225);
    b2.setBounds(0, 250,384, 225);
    b8.setBounds(0, 0, 150, 20);
   
     b1.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {
       new courseAdministration();
       dispose();
    }
  }); 
     b2.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {
         new instructorsAdministration();
        dispose();
    }
  }); 
     b8.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {
        new home();
        dispose();
    }
  });  
    p1.add(b1);
    p1.add(b2);
    p1.add(b8);
    add(p1);
    
    
    }
    
}
