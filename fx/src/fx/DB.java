package fx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private final String user="root";
    private final String password="";
    private final String add="jdbc:mysql://localhost/java1";
    public Connection connect()throws SQLException{

        return DriverManager.getConnection(add,user,password);
    }

}
