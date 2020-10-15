package controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Proton;
import dao.ProtonDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SearchById extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    try 
    {
        PrintWriter out;
        out = response.getWriter();
        int id;
        id = Integer.parseInt(request.getParameter("txtId"));
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Search Data | Proton Pre School</title>");
        out.println("<link rel=\"stylesheet\" href=\"css/header.css\">");
        out.println("<link rel=\"shortcut icon\" href=\"image/proton_logo.png\" />");
        out.println("<script type=\"text/javascript\">var documentTitle = document.title + \" - \";(function titleMarquee(){document.title = documentTitle = documentTitle.substring(1) + documentTitle.substring(0,1);setTimeout(titleMarquee,200);})();</script>");
        out.println("<link rel=stylesheet href=css/bootstrap.min.css>");
        out.println("<script src=js/bootstrap.min.js></script>");
        out.println("<script src=js/jquery-3.3.1.min.js></script>");
        out.println("<style>h2,h4,code{font-weight:bold;cursor:pointer;}table{cursor:pointer;}</style>");
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
        ProtonDAO pd = new ProtonDAO();
        Proton P;
        P = pd.searchByIdProton(id);
        if(P!=null)
        {
            out.println("<h2 class=\"text-left\" style=\"cursor:pointer;\"><code>Record Found in Database!!!</code></h2>");
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
            if(P==null)
            {
                Proton P2;
                P2 = pd.searchByIdProtonDeleted(id);
                if(P2!=null)
                {
                    out.println("<h2 class=\"text-left\" style=\"cursor:pointer;\"><code>Record not Found!!!</code></h2>");
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
                    out.println("<h4 class=\"text-left\" style=\"cursor:pointer;\"><code>Backup of Id "+id+" from deleted record.</code></h4>");
                    out.println("<h4 class=\"text-left\" style=\"cursor:pointer;\"><code>This record is only a backup of the original data.</code></h4>");
                }
                else
                {
                    out.println("<div class=\"text-center\"><h2 style=\"cursor:pointer;\"><code>Id "+id+" is not created yet in database!!!</code></h2></div>");
                }
            }
        }
        out.println("</div>");
        out.println("<center><CODE><A href=ProtonPreSchool>Go to index page</A></CODE>&nbsp;&nbsp;&nbsp;<CODE><A href=SearchById.html>Search Again / Go to back</A></CODE></center>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    catch (Exception ex) 
    {
          Logger.getLogger(SearchById.class.getName()).log(Level.SEVERE, null,ex);
    }
  }
}