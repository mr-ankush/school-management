package dao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;
import myconnection.MyCon;

public class AdminDAO 
{
    public static boolean checkLogin(String username, String password)
    {
        try 
        {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            //Admin A = new Admin();
            String sql;
            con = MyCon.getConnection();
            sql = "select * from admin where username=? && password=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next())  
                return true;
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
