/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class courseAdministration extends JFrame{
     public
       JButton b5,b6,b7,b8;
       JTextField t1,t2,t3,t4,t5,t6;
       JLabel l1,l2,l3,l4,l5,l6;
       JPanel p2;
    static Connection k;
    static Statement s;
    static String query;
    Object[] c={"ID","Name","Instructor","Lectures","Marks","Hours"};
    String data[][];
    public courseAdministration(){
        DB c1 = new DB();
      l1=new JLabel("ID");
      l2=new JLabel("Name");
      l3=new JLabel("Instructor");
      l4=new JLabel("Lectures");
       l5=new JLabel("Marks");
        l6=new JLabel("Hours");
      b5=new JButton("Add");
      b6=new JButton("Delete");
      b7=new JButton("Update");
      b8=new JButton("Back");
      t1=new JTextField();
      t2=new JTextField();
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
    this.setTitle("Courses Administration");
    this.setSize(400,538);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setResizable(false);
    this.setLocation(200,50);
    p2.setLayout(null);p2.setSize(400,538);
    l1.setBounds(30, 41, 50, 15);
    t1.setBounds(110, 41, 150, 20);
    l2.setBounds(30, 61, 70, 15);
    t2.setBounds(110, 61, 150, 20);
    l3.setBounds(30, 81, 50, 15);
    t3.setBounds(110, 81, 150, 20);
    l4.setBounds(30, 101, 50, 15);
    t4.setBounds(110, 101, 150, 20);
    l5.setBounds(30, 121, 50, 15);
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
    p2.add(t2);
    p2.add(l2);
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
    Object[] row=new  Object[6];
  b5.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent ee) {
        row[0]=t1.getText();
        row[1]=t2.getText();
        row[2]=t3.getText();
        row[3]=t4.getText();
        row[4]=t5.getText();
        row[5]=t6.getText();
          model.addRow(row);
        try {
            k= c1.connect();
            s=k.createStatement();
            query="INSERT INTO `course`(`Id`, `Name`, `Instructor`, `Lectures`, `Marks`, `Hours`) VALUES ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"')";
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
   b6.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent ee) {
       int i=ta.getSelectedRow();
       if(i>=0)
           model.removeRow(i);
        try {
            k= c1.connect();
            s=k.createStatement();
            query="DELETE FROM `course` WHERE Id ='"+Integer.parseInt(t1.getText())+"'";
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
          t2.setText(model.getValueAt(i, 1).toString());
          t3.setText(model.getValueAt(i, 2).toString());
          t4.setText(model.getValueAt(i, 3).toString());
          t5.setText(model.getValueAt(i, 4).toString());
          t6.setText(model.getValueAt(i, 5).toString());
          }
          });
   b7.addActionListener((ActionListener) new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent ee) {
          int i= ta.getSelectedRow();
          if(i>=0){
          model.setValueAt(t1.getText(),i, 0);
          model.setValueAt(t2.getText(),i, 1);
          model.setValueAt(t3.getText(),i, 2);
          model.setValueAt(t4.getText(),i, 3);
          model.setValueAt(t5.getText(),i, 4);
          model.setValueAt(t6.getText(),i, 5);

          }
          //put data in database//
        try {
            k= c1.connect();
            s=k.createStatement();
            query="UPDATE `course` SET `Name`='"+t2.getText()+"',`Instructor`='"+t3.getText()+"',`Lectures`='"+Integer.parseInt(t4.getText())+"',`Marks`='"+Integer.parseInt(t5.getText())+"',`Hours`='"+Integer.parseInt(t6.getText())+"' WHERE  Id ='"+Integer.parseInt(t1.getText())+"'";
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
       new Admin();
       dispose();
    }
  });             
    add(p2);
    
    } 
    
}

