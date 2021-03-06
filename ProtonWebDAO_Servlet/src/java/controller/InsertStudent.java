package controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Proton;
import dao.ProtonDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
public class InsertStudent extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    PrintWriter out;
    out = response.getWriter();
    int std,fee;
    long mobile;
    String name,fname,dob,city;
    name = request.getParameter("txtName");
    fname = request.getParameter("txtFname");
    std = Integer.parseInt(request.getParameter("txtStd"));
    dob = request.getParameter("txtDob");
    mobile = Long.parseLong(request.getParameter("txtMobile"));
    fee = Integer.parseInt(request.getParameter("txtFee"));
    city = request.getParameter("txtAddress");
    Proton P = new Proton();
    P.setName(name);
    P.setFname(fname);
    P.setStd(std);
    P.setDob(dob);
    P.setMobile(mobile);
    P.setFee(fee);
    P.setCity(city);
    ProtonDAO pd = new ProtonDAO();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Insert Data | Proton Pre School</title>");
    out.println("<link rel=\"stylesheet\" href=\"css/header.css\">");
    out.println("<script type=\"text/javascript\">var documentTitle = document.title + \" - \";(function titleMarquee(){document.title = documentTitle = documentTitle.substring(1) + documentTitle.substring(0,1);setTimeout(titleMarquee,200);})();</script>");
    out.println("<link rel=stylesheet href=css/bootstrap.min.css>");
    out.println("<link rel=\"shortcut icon\" href=\"image/proton_logo.png\" />");
    out.println("<script src=js/bootstrap.min.js></script>");
    out.println("<script src=js/jquery-3.3.1.min.js></script>");
    out.println("<style>h1,h2,code{font-weight:bold;cursor:pointer;}table{cursor:pointer;}</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class=\"header\">");
    out.println("<div style=\"padding:5px;\">");
    out.println("<a href=\"SignOut.jsp\"><b>Log-out!</b></a>");
    out.println("</div>");
    out.println("<div class=\"text-center\">");
    out.println("<img src=\"image/proton_logo.png\" alt=\"\" width=\"15%\" style=\" padding:10px;\"/>");
    out.println("</div>");
    out.println("<div class=\"progress-container\">");
    out.println("<div class=\"progress-bar\" id=\"myBar\"></div>");
    out.println("</div>");
    out.println("</div>");
    out.println("<div class=\"content\">");
    out.println("<div class=container text-center>");
    try 
    {
        if(pd.insertProton(P))
        {
            out.println("<h2 class=\"text-left\" style=\"cursor:pointer;\"><code>Record Inserted!!!</code></h2>");
            out.println("<table class=\"table table-striped table-bordered table-hover\">");
            out.println("<tr>");
            out.println("<th>Student Id</th>");
            out.println("<th>Student Name</th>");
            out.println("<th>Father's Name</th>");
	    out.println("<th>Standard</th>");
            out.println("<th>Date of Birth</th>");	
            out.println("<th>Contact</th>");		
            out.println("<th>Fee</th>");		
            out.println("<th>Address</th>");
            out.println("</tr>");
            try 
            {
                Proton P2 = new Proton();
                P2 = pd.searchByIdProtonMax();
                if(P2==null)
                {
                    out.println("<h2 class=\"text-left\" style=\"cursor:pointer;\"><code>Record not Inserted!!!</code></h2>");
                }
                else
                {
                    out.println("<tr>");
                    out.println("<td>"+P2.getId()+"</td>");
                    out.println("<td>"+P2.getName()+"</td>");
                    out.println("<td>"+P2.getFname()+"</td>");
                    out.println("<td>"+P2.getStd()+"</td>");
                    out.println("<td>"+P2.getDob()+"</td>");
                    out.println("<td>"+P2.getMobile()+"</td>");
                    out.println("<td>"+P2.getFee()+"</td>");
                    out.println("<td>"+P2.getCity()+"</td>");
                    out.println("</tr>");
                    out.println("</table>");
                }
            }
            catch (Exception e) 
            {
                out.println(e);
            }                
	}
        else
            out.println("<h2 class=\"text-left\" style=\"cursor:pointer;\"><code>Record Inserted!!!</code></h2>");
    }
    catch (Exception e) 
    {
        out.println(e);
    }
    Proton P3 = new Proton();
    try 
    {
        P3 = pd.searchByIdProtonMax();
    }
    catch (Exception ex) 
    {
        Logger.getLogger(InsertStudent.class.getName()).log(Level.SEVERE, null, ex);
    }
    out.println("<h1 class=\"text-center\" style=\"cursor:pointer;\">Auto-Generated Id : <code>"+P3.getId()+"</code> for <code>"+P3.getName()+" <sup>S</sup>/o "+P3.getFname()+"</code>.</h1>");
    out.println("</div>");
    out.println("<hr>");
    out.println("<center><CODE><A href=ProtonPreSchool>Go to index page</A></CODE>&nbsp;&nbsp;&nbsp;<CODE><A href=InsertData>Add more / Go to back</A></CODE></center>");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
  }
}