package myconnection;
import java.sql.*;
public class MyCon 
{
    static Connection con = null;
    static
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) 
        {
            System.out.println(e);
        }
    }
    public static Connection getConnection()
    {
        try 
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","root");
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return con;
    }
}
