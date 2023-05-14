package fx;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ahmed
 */
public class teacher extends JFrame{ 
     public
       JButton b5,b6,b7,b8;
       JTextField t1,t3,t4,t5,t6;
       JLabel l1,l3,l4,l5,l6;
       JPanel p2;
    static Connection k;
    static Statement s;
    static String query;
    Object[] c={"Student ID","final","mid term","class work","total"};
    String data[][];
    public teacher(){
        DB c1 = new DB();
      l1=new JLabel("Student ID");
      l3=new JLabel("final");
      l4=new JLabel("mid term");
      l5=new JLabel("class work");
      l6=new JLabel("total");
      b5=new JButton("Add");
      b6=new JButton("Delete");
      b7=new JButton("Update");
      b8=new JButton("Back");
      t1=new JTextField();
      t3=new JTextField();
      t4=new JTextField();
      t5=new JTextField();
      t6=new JTextField();
      p2=new JPanel();
      DefaultTableModel model=new DefaultTableModel();
      model.setColumnIdentifiers(c);
      JTable ta=new JTable();
      ta.setModel(model);
      Font f=new Font(" ",1,12);
      ta.setFont(f);
      ta.setRowHeight(30);
      JScrollPane tas=new JScrollPane(ta);
    this.setTitle("Instructor page");
    this.setSize(400,538);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setResizable(false);
    this.setLocation(200,50);
    p2.setLayout(null);
    p2.setSize(400,538);
    l1.setBounds(30, 61, 90, 15);
    t1.setBounds(110, 61, 150, 20);
    l3.setBounds(30, 81, 90, 15);
    t3.setBounds(110, 81, 150, 20);
    l4.setBounds(30, 101, 50, 15);
    t4.setBounds(110, 101, 150, 20);
    l5.setBounds(30, 121, 90, 15);
    t5.setBounds(110, 121, 150, 20);
    l6.setBounds(30, 141, 50, 15);
    t6.setBounds(110, 141, 150, 20);
    b5.setBounds(50, 200, 95, 20);
    b6.setBounds(150, 200, 95, 20);
    b7.setBounds(250, 200, 95, 20);
    b8.setBounds(0, 0, 150, 20);
    tas.setBounds(2, 250, 383, 200);
  
    p2.add(t1);
    p2.add(l1);
    p2.add(t3);
    p2.add(l3);
    p2.add(t4);
    p2.add(l4);
    p2.add(t5);
    p2.add(l5);
    p2.add(t6);
    p2.add(l6);
    p2.add(b8);
    p2.add(b5);
    p2.add(b6);
    p2.add(b7);
    p2.add(tas);
    Object[] row=new  Object[5];
  b5.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent ee) {
        row[0]=t1.getText();
        row[1]=t3.getText();
        row[2]=t4.getText();
        row[3]=t5.getText();
        row[4]=t6.getText();

          model.addRow(row);
          //put data in database//
        try {
            k = c1.connect();//('"+Integer.parseInt(t1.getText())+"','"+Integer.parseInt(t3.getText())+"','"+Integer.parseInt(t4.getText())+"','"+Integer.parseInt(t5.getText())+"','"+Integer.parseInt(t6.getText())+"'
            s = k.createStatement();
            query = "INSERT INTO `teacher`(`Id`, `final`, `midterm`, `classwork`, `total`) VALUES ('"+Integer.parseInt(t1.getText())+"','"+Integer.parseInt(t3.getText())+"','"+Integer.parseInt(t4.getText())+"','"+Integer.parseInt(t5.getText())+"','"+Integer.parseInt(t6.getText())+"')";
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
   b6.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent ee) {
       int i=ta.getSelectedRow();
       if(i>=0)
           model.removeRow(i);
       //remove data from database//
        try {
            k= c1.connect();
            s=k.createStatement();
            query="DELETE FROM `teacher` WHERE Id ='"+Integer.parseInt(t1.getText())+"'";
            s.execute(query);

        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                k.close();
                s.close();
            } catch (SQLException e) {

            }
        }
    }
  }); 
          ta.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e){
          int i= ta.getSelectedRow();
          t1.setText(model.getValueAt(i, 0).toString());
          t3.setText(model.getValueAt(i, 1).toString());
          t4.setText(model.getValueAt(i, 2).toString());
          t5.setText(model.getValueAt(i, 3).toString());
          t6.setText(model.getValueAt(i, 4).toString());
          }
          });
   b7.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent ee) {
          int i= ta.getSelectedRow();
          if(i>=0){
          model.setValueAt(t1.getText(),i, 0);
          model.setValueAt(t3.getText(),i, 1);
          model.setValueAt(t4.getText(),i, 2);
          model.setValueAt(t5.getText(),i, 3);
          model.setValueAt(t6.getText(),i, 4);
          }
          //put data in database//
        try {
            k= c1.connect();
            s=k.createStatement();
            query="UPDATE `teacher` SET `final`='"+Integer.parseInt(t3.getText())+"',`midterm`='"+Integer.parseInt(t4.getText())+"',`classwork`='"+Integer.parseInt(t5.getText())+"',`total`='"+Integer.parseInt(t6.getText())+"' WHERE  Id ='"+Integer.parseInt(t1.getText())+"'";
            s.execute(query);

        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                k.close();
                s.close();
            } catch (SQLException e) {

            }
        }
    }
  }); 
 b8.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {
       new home();
       dispose();
    }
  });             
    add(p2);
    
    } 
    
}
