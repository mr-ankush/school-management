package controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Proton;
import dao.ProtonDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UpdateStudent extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    try 
    {
        PrintWriter out;
        out = response.getWriter();
        HttpSession session = request.getSession();
        String sid;
        sid = session.getAttribute("txtId").toString();
        int id;
        id = Integer.parseInt(sid);
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
        P.setId(id);
        P.setName(name);
        P.setFname(fname);
        P.setStd(std);
        P.setDob(dob);
        P.setMobile(mobile);
        P.setFee(fee);
        P.setCity(city);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Update Data | Proton Pre School</title>");
        out.println("<link rel=\"stylesheet\" href=\"css/header.css\">");
        out.println("<script type=\"text/javascript\">var documentTitle = document.title + \" - \";(function titleMarquee(){document.title = documentTitle = documentTitle.substring(1) + documentTitle.substring(0,1);setTimeout(titleMarquee,200);})();</script>");
        out.println("<link rel=stylesheet href=css/bootstrap.min.css>");
        out.println("<script src=js/bootstrap.min.js></script>");
        out.println("<script src=js/jquery-3.3.1.min.js></script>");
        out.println("<style>h2,code{font-weight:bold;cursor:pointer;}table{cursor:pointer;}</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"header\">");
        out.println("<div class=\"text-center\">");
        out.println("<img src=\"image/proton_logo.png\" alt=\"\" width=\"15%\" style=\" padding:10px;\"/>");
        out.println("</div>");
        out.println("<div class=\"progress-container\">");
        out.println("<div class=\"progress-bar\" id=\"myBar\"></div>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"content\">");
        out.println("<div class=container text-center>");
        ProtonDAO pd = new ProtonDAO();
        if(pd.updataByIdProton(P))
        {
            out.println("<h2 class=\"text-left\" style=\"cursor:pointer;\"><code>Record Updated!!!</code></h2>");
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
            out.println("<tr>");
            out.println("<td>"+P.getId()+"</td>");
            out.println("<td>"+P.getName()+"</td>");
            out.println("<td>"+P.getFname()+"</td>");
            out.println("<td>"+P.getStd()+"</td>");
            out.println("<td>"+P.getDob()+"</td>");
            out.println("<td>"+P.getMobile()+"</td>");
            out.println("<td>"+P.getFee()+"</td>");
            out.println("<td>"+P.getCity()+"</td>");
            out.println("</tr>");
            out.println("</table>");
        }
        else
        {
            out.println("<h2 class=\"text-center\" style=\"cursor:pointer;\"><code>Record not Updated!!!</code></h2>");
            out.println("<h4 class=\"text-center\" style=\"cursor:pointer;\"><code>Try Again...</code></h4>");
        }
        out.println("</div>");
        out.println("<div style=\"margin:20px;\"><center><CODE><A href=ProtonPreSchool>Go to index page</A></CODE>&nbsp;&nbsp;&nbsp;<CODE><A href=UpdateById.html>Update more / Go to back</A></CODE></center></div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    } 
    catch (Exception ex)
    {
        System.out.println(ex);
    }   
  }
}