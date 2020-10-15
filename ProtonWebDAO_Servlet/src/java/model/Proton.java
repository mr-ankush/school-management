package model;
public class Proton
{
    int id,std,fee;
    String name,fname,dob,city;
    long mobile;
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getFname() 
    {
        return fname;
    }
    public void setFname(String fname) 
    {
        this.fname = fname;
    }

    public int getStd() 
    {
        return std;
    }
    public void setStd(int std) 
    {
        this.std = std;
    }

    public int getFee() 
    {
        return fee;
    }
    public void setFee(int fee) 
    {
        this.fee = fee;
    }

    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getDob() 
    {
        return dob;
    }
    public void setDob(String dob) 
    {
        this.dob = dob;
    }

    public String getCity() 
    {
        return city;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public long getMobile() 
    {
        return mobile;
    }
    public void setMobile(long mobile) 
    {
        this.mobile = mobile;
    }
    
}