package controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Proton;
import dao.ProtonDAO;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class RestoreDataD extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    try 
    {
        PrintWriter out;
        out = response.getWriter();
        List<Proton> Datalist = new ArrayList<Proton>();
        ProtonDAO pd = new ProtonDAO();
        Datalist = pd.searchDeletedProtonD();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Restore Data | Proton Pre School</title>");
        out.println("<link rel=\"stylesheet\" href=\"css/header.css\">");
        out.println("<link rel=\"shortcut icon\" href=\"image/proton_logo.png\" />");
        out.println("<script type=\"text/javascript\">var documentTitle = document.title + \" - \";(function titleMarquee(){document.title = documentTitle = documentTitle.substring(1) + documentTitle.substring(0,1);setTimeout(titleMarquee,200);})();</script>");
        out.println("<link rel=stylesheet href=css/bootstrap.min.css>");
        out.println("<script src=js/bootstrap.min.js></script>");
        out.println("<script src=js/jquery-3.3.1.min.js></script>");
        out.println("<style>h4,h3,code,td{font-weight: bold;}input{cursor:pointer;}</style>");
        out.println("<script src=js/order.js></script>");
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
        out.println("<div class=\"text-center\">");
        out.println("<div class=\"col-sm-2\">");
        out.println("<CODE><A href=\"ProtonPreSchool\">Go to Index Page</A></CODE></div>");
        out.println("<div class=\"col-sm-2\">");
        out.println("<CODE><A href=\"InsertData\">Insert Data</A></CODE></div>");
        out.println("<div class=\"col-sm-2\">");
        out.println("<CODE><A href=\"UpdateById.html\">Update Data</A></CODE></div>");
        out.println("<div class=\"col-sm-2\">");
        out.println("<CODE><A href=\"DeleteById.html\">Delete Data</A></CODE></div>");         
        out.println("<div class=\"col-sm-2\">");       
        out.println("<CODE><A href=\"SearchById.html\">Searching Data</A></CODE></div>");
        out.println("<div class=\"col-sm-2\">");
        out.println("<CODE><A href=\"SearchAllStudentA\">View Data</A></CODE></div>");        
        out.println("</div>");
        out.println("<h2 class=\"text-center\" style=\"cursor:pointer;\"><u><b>Search All Deleted Data - Student</b></u></h2>");        
        out.println("<div class=\"text-center\">");        
        out.println("<div class=\"alert alert-info\">");
        out.println("<div>");
        Proton P1 = null;
        int id;
        id = Integer.parseInt(request.getParameter("txtId"));
        try 
        {
            P1 = pd.searchByIdProtonDeleted(id);
        }
        catch (Exception ex) 
        {
            Logger.getLogger(RestoreDataA.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(P1==null)    
        {
            out.println("<h3 class=\"text-center\" style=\"cursor:pointer;\"><code>Record not Found in Deleted Record File!!!</code></h3>");
            out.println("<a href=\"SearchAllDeletedD\"><h5 class=\"text-center\" style=\"cursor:pointer;\"><code>Refresh</code></h5></a>");
        }
        else
        {
            out.println("<h3 class=\"text-center\" style=\"cursor:pointer;\"><code>Record Found in Database!!!</code></h3>");
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
            out.println("<td>"+P1.getId()+"</td>");
            out.println("<td>"+P1.getName()+"</td>");
            out.println("<td>"+P1.getFname()+"</td>");
            out.println("<td>"+P1.getStd()+"</td>");
            out.println("<td>"+P1.getDob()+"</td>");
            out.println("<td>"+P1.getMobile()+"</td>");
            out.println("<td>"+P1.getFee()+"</td>");
            out.println("<td>"+P1.getCity()+"</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<center>");
            out.println("<table>");
            out.println("<tr align=\"center\">");
            out.println("<td width=\"150px\">");
            out.println("<form method=\"POST\" action=\"RestoreDataD1\">");
            out.println("<input class=\"btn btn-sm btn-primary\" type=\"submit\" value=\"Restore Data\">");
            out.println("</form>");
            out.println("</td>");
            out.println("<td width=\"150px\">");
            out.println("<form method=\"GET\" action=\"SearchAllDeletedD\">");
            out.println("<input class=\"btn btn-sm btn-success\" type=\"submit\" value=\"Back Safely\">");
            out.println("</form>");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</center>");    
        }    
        out.println("<label for=\"filterId1\">Search By Id:</label>");
        out.println("<input type=\"radio\" onchange=\"orderAId_del()\" name=\"txtId1\" disabled>Ascending</input>");
        out.println("<input type=\"radio\" onchange=\"orderDId_del()\" name=\"txtId1\" checked>Descending</input>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for=\"filterStd1\">Search By Standard:</label>");
        out.println("<input type=\"radio\" onchange=\"orderAStd_del()\" name=\"txtStd1\" disabled>Ascending</input>");
        out.println("<input type=\"radio\" onchange=\"orderDStd_del()\" name=\"txtStd1\" disabled>Descending</input>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=container text-center>");
        int count = Datalist.size();
        out.println("<h3><code>Record's found :"+count+" </code></h3>");
        out.println("<table class=\"table table-striped table-bordered table-hover\" style=\"cursor:pointer;\">");
        out.println("<tr>");
        out.println("<th style=\"background-color:wheat;\">Student Id</th>");
        out.println("<th>Student Name</th>");
        out.println("<th>Father's Name</th>");
        out.println("<th>Standard</th>");
        out.println("<th>Date of Birth</th>");
        out.println("<th>Contact</th>");
        out.println("<th>Fee</th>");
        out.println("<th>Address</th>");
        out.println("</tr>");
        for(Proton P : Datalist)
        {
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
        }
        out.println("</table>");
        out.println("<div class=\"text-center\">");
        out.println("<div class=\"alert alert-info\">");
        out.println("<div>");
        out.println("<label for=\"filterId2\">Search By Id:</label>");
        out.println("<input type=\"radio\" onchange=\"orderAId_del()\" name=\"txtId2\">Ascending</input>");
        out.println("<input type=\"radio\" onchange=\"orderDId_del()\" name=\"txtId2\" checked>Descending</input>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for=\"filterStd1\">Search By Standard:</label>");
        out.println("<input type=\"radio\" onchange=\"orderAStd_del()\" name=\"txtStd2\">Ascending</input>");
        out.println("<input type=\"radio\" onchange=\"orderDStd_del()\" name=\"txtStd2\">Descending</input>");
        out.println("</div>");
        out.println("<CODE><A href=\"ProtonPreSchool\">Go to index page</A></CODE>");
        out.println("</div>");
        out.println("</div>");
    }
    catch (Exception ex)
    {
          Logger.getLogger(SearchAllStudentA.class.getName()).log(Level.SEVERE, null,ex);
    }
  }
}