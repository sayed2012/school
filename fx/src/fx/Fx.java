package fx;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Fx {
    static Connection c;
    static Statement s;
    static String query;
    public static void main(String[] args) {
//        DB c1 = new DB();
//        try {
//            c = c1.connect();
//            s=c.createStatement();
//            query="alter table teacher(Id int not null,attendance int not null,final int not null,midterm int not null,classwork int not null,total int not null,constraint pk1 primary key (Id)) ";
//            s.execute(query);//"Student ID","Attendance","final","midterm","classwork","total"//
//
//        } catch (SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }
//        finally {
//            try {
//                c.close();
//                s.close();
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }
        home a=new home();
    }
    
}
