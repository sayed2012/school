package fx;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class courses extends JFrame {
   JPanel p;
   JLabel l1;
   JTextField t1;
   JButton b8,b1;
    static Connection k;
    static Statement s;
    static String query;
    static ResultSet h;
   Object[] c={"Name","Instructor","Lectures","Marks","Hours"};
    String data[][];
    public courses()  {
        DB c1 = new DB();
        l1=new JLabel("Enter ID");
        t1=new JTextField();
    b8=new JButton("Home Page");
    b1=new JButton("Enter");
    p=new JPanel();
    DefaultTableModel model=new DefaultTableModel();
      model.setColumnIdentifiers(c);
      JTable ta=new JTable();
       Font f=new Font(" ",1,12);
      ta.setModel(model);
      ta.setFont(f);
      ta.setRowHeight(30);
      JScrollPane tas=new JScrollPane(ta);
    this.setTitle("Course Page");
    this.setSize(400,538);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setResizable(false);
    this.setLocation(200,50);
    p.setSize(400, 538);
        p.setLayout(null);
    l1.setBounds(100, 61, 80, 20);
    t1.setBounds(150, 61, 120, 20);
    b8.setBounds(0, 0, 150, 20);
    b1.setBounds(150, 101, 100, 20);
    tas.setBounds(2, 150, 383, 70);
    p.add(b8);
     p.add(b1);
     p.add(l1);
      p.add(t1);
        p.add(tas);
       Object[] row=new  Object[5];
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
//
//    @    SELECT `Id`, `Name`, `Instructor`, `Lectures`, `Marks`, `Hours` FROM `course` WHERE t1.getText()'"+t1.getText()+"'

        try {
            k= c1.connect();
            s=k.createStatement();
            int i=Integer.parseInt(t1.getText());
            query="SELECT  `Name`, `Instructor`, `Lectures`, `Marks`, `Hours` FROM `course` WHERE Id= '"+i+"'";
           h= s.executeQuery(query);
           while (h.next()) {
               row[0] = h.getString("Name");
               row[1] = h.getString("Instructor");
               row[2] = h.getInt("Lectures");
               row[3] = h.getInt("Marks");
               row[4] = h.getInt("Hours");
               model.addRow(row);
           }
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
      add(p);
    }
}
