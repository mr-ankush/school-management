package dao;
import myconnection.MyCon;
import model.Proton;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ProtonDAO 
{ 
    
    public boolean insertProton(Proton P) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        String sql;
        con = MyCon.getConnection();
        sql = "insert into proton(name,fname,std,dob,mobile,fee,city) values(?,?,?,?,?,?,?)";
        ps = con.prepareStatement(sql);
        ps.setString(1,P.getName());
        ps.setString(2,P.getFname());
        ps.setInt(3,P.getStd());
        ps.setString(4,P.getDob());
        ps.setLong(5,P.getMobile());
        ps.setInt(6,P.getFee());
        ps.setString(7,P.getCity());
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
    
    public List<Proton> searchAllProton() throws Exception
    {
        List<Proton> Mylist = new ArrayList<Proton>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        con = MyCon.getConnection();
        sql = "select * from proton";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next())
        {
            Proton P = new Proton();
            P.setId(rs.getInt(1));
            P.setName(rs.getString(2));
            P.setFname(rs.getString(3));
            P.setStd(rs.getInt(4));
            P.setDob(rs.getString(5));
            P.setMobile(rs.getLong(6));
            P.setFee(rs.getInt(7));
            P.setCity(rs.getString(8));
            Mylist.add(P);
        }
        return Mylist;
    }
    
    public List<Proton> searchAllProtonD() throws Exception
    {
        List<Proton> Mylist = new ArrayList<Proton>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        con = MyCon.getConnection();
        sql = "select * from proton order by id desc";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next())
        {
            Proton P = new Proton();
            P.setId(rs.getInt(1));
            P.setName(rs.getString(2));
            P.setFname(rs.getString(3));
            P.setStd(rs.getInt(4));
            P.setDob(rs.getString(5));
            P.setMobile(rs.getLong(6));
            P.setFee(rs.getInt(7));
            P.setCity(rs.getString(8));
            Mylist.add(P);
        }
        return Mylist;
    }
    
    public List<Proton> searchAllProtonA_Std() throws Exception
    {
        List<Proton> Mylist = new ArrayList<Proton>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        con = MyCon.getConnection();
        sql = "select * from proton order by std asc";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next())
        {
            Proton P = new Proton();
            P.setId(rs.getInt(1));
            P.setName(rs.getString(2));
            P.setFname(rs.getString(3));
            P.setStd(rs.getInt(4));
            P.setDob(rs.getString(5));
            P.setMobile(rs.getLong(6));
            P.setFee(rs.getInt(7));
            P.setCity(rs.getString(8));
            Mylist.add(P);
        }
        return Mylist;
    }
    
    public List<Proton> searchAllProtonD_Std() throws Exception
    {
        List<Proton> Mylist = new ArrayList<Proton>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        con = MyCon.getConnection();
        sql = "select * from proton order by std desc";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next())
        {
            Proton P = new Proton();
            P.setId(rs.getInt(1));
            P.setName(rs.getString(2));
            P.setFname(rs.getString(3));
            P.setStd(rs.getInt(4));
            P.setDob(rs.getString(5));
            P.setMobile(rs.getLong(6));
            P.setFee(rs.getInt(7));
            P.setCity(rs.getString(8));
            Mylist.add(P);
        }
        return Mylist;
    }
    
    public Proton searchByIdProton(int id) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        con = MyCon.getConnection();
        sql = "Select * from proton where id=?";
        ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        rs = ps.executeQuery();
        Proton P = new Proton();
        if(rs.next())
        {
            P.setId(rs.getInt(1));
            P.setName(rs.getString(2));
            P.setFname(rs.getString(3));
            P.setStd(rs.getInt(4));
            P.setDob(rs.getString(5));
            P.setMobile(rs.getLong(6));
            P.setFee(rs.getInt(7));
            P.setCity(rs.getString(8));
        }
        else
            P=null;
        return P;
    }
    
    public Proton searchByIdProtonDeleted(int id) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        con = MyCon.getConnection();
        sql = "Select * from proton_deleted where id=?";
        ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        rs = ps.executeQuery();
        Proton P = new Proton();
        if(rs.next())
        {
            P.setId(rs.getInt(1));
            P.setName(rs.getString(2));
            P.setFname(rs.getString(3));
            P.setStd(rs.getInt(4));
            P.setDob(rs.getString(5));
            P.setMobile(rs.getLong(6));
            P.setFee(rs.getInt(7));
            P.setCity(rs.getString(8));
        }
        else
            P=null;
        return P;
    }
    
    public Proton searchByIdProtonMax() throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        con = MyCon.getConnection();
        sql = "Select * from proton where id=(Select max(id) from proton)";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        Proton P = new Proton();
        if(rs.next())
        {
            P.setId(rs.getInt(1));
            P.setName(rs.getString(2));
            P.setFname(rs.getString(3));
            P.setStd(rs.getInt(4));
            P.setDob(rs.getString(5));
            P.setMobile(rs.getLong(6));
            P.setFee(rs.getInt(7));
            P.setCity(rs.getString(8));
        }
        else
            P=null;
        return P;
    }
    
    public boolean updataByIdProton(Proton P) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        con = MyCon.getConnection();
        String sql;
        sql = "update proton set name=?, fname=?, std=?, dob=?, mobile=?, fee=?, city=? where id=?";
        ps = con.prepareStatement(sql);
        ps.setString(1,P.getName());
        ps.setString(2,P.getFname());
        ps.setInt(3,P.getStd());
        ps.setString(4,P.getDob());
        ps.setLong(5,P.getMobile());
        ps.setInt(6,P.getFee());
        ps.setString(7,P.getCity());
        ps.setInt(8,P.getId());
        if(ps.executeUpdate()>0)
            return true;
        
        return false;
    }
    
    public boolean deleteByIdProton(int id) throws Exception
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con=MyCon.getConnection();
        Proton P =new Proton();
        String sql;
        sql="delete from proton where id=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
    
    public boolean deleteByIdProtonDeleted(int id) throws Exception
    {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        con=MyCon.getConnection();
        Proton P =new Proton();
        String sql;
        sql="delete from proton_deleted where id=?";
        ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
    
    public boolean copyFromProton(Proton P) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        String sql;
        con = MyCon.getConnection();
        sql = "insert into proton_deleted select * from proton where id=?";
        ps = con.prepareStatement(sql);
        ps.setInt(1,P.getId());
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
    
    public boolean copyFromProtonDeleted(Proton P) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        String sql;
        con = MyCon.getConnection();
        sql = "insert into proton select * from proton_deleted where id=?";
        ps = con.prepareStatement(sql);
        ps.setInt(1,P.getId());
        if(ps.executeUpdate()>0)
            return true;
        return false;
    }
    
    public List<Proton> searchDeletedProton() throws Exception
    {
        List<Proton> Mylist = new ArrayList<Proton>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        con = MyCon.getConnection();
        sql = "select * from proton_deleted";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next())
        {
            Proton P = new Proton();
            P.setId(rs.getInt(1));
            P.setName(rs.getString(2));
            P.setFname(rs.getString(3));
            P.setStd(rs.getInt(4));
            P.setDob(rs.getString(5));
            P.setMobile(rs.getLong(6));
            P.setFee(rs.getInt(7));
            P.setCity(rs.getString(8));
            Mylist.add(P);
        }
        return Mylist;
    }
    
    public List<Proton> searchDeletedProtonD() throws Exception
    {
        List<Proton> Mylist = new ArrayList<Proton>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        con = MyCon.getConnection();
        sql = "select * from proton_deleted order by id desc";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next())
        {
            Proton P = new Proton();
            P.setId(rs.getInt(1));
            P.setName(rs.getString(2));
            P.setFname(rs.getString(3));
            P.setStd(rs.getInt(4));
            P.setDob(rs.getString(5));
            P.setMobile(rs.getLong(6));
            P.setFee(rs.getInt(7));
            P.setCity(rs.getString(8));
            Mylist.add(P);
        }
        return Mylist;
    }
    
    public List<Proton> searchDeletedProtonA_Std() throws Exception
    {
        List<Proton> Mylist = new ArrayList<Proton>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        con = MyCon.getConnection();
        sql = "select * from proton_deleted order by std asc";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next())
        {
            Proton P = new Proton();
            P.setId(rs.getInt(1));
            P.setName(rs.getString(2));
            P.setFname(rs.getString(3));
            P.setStd(rs.getInt(4));
            P.setDob(rs.getString(5));
            P.setMobile(rs.getLong(6));
            P.setFee(rs.getInt(7));
            P.setCity(rs.getString(8));
            Mylist.add(P);
        }
        return Mylist;
    }
    
    public List<Proton> searchDeletedProtonD_Std() throws Exception
    {
        List<Proton> Mylist = new ArrayList<Proton>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        con = MyCon.getConnection();
        sql = "select * from proton_deleted order by std desc";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next())
        {
            Proton P = new Proton();
            P.setId(rs.getInt(1));
            P.setName(rs.getString(2));
            P.setFname(rs.getString(3));
            P.setStd(rs.getInt(4));
            P.setDob(rs.getString(5));
            P.setMobile(rs.getLong(6));
            P.setFee(rs.getInt(7));
            P.setCity(rs.getString(8));
            Mylist.add(P);
        }
        return Mylist;
    }

}