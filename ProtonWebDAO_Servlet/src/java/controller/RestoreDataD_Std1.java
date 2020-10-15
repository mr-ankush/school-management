package controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Proton;
import dao.ProtonDAO;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class RestoreDataD_Std1 extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    try 
    {
        PrintWriter out;
        out = response.getWriter();
        List<Proton> Datalist = new ArrayList<Proton>();
        ProtonDAO pd = new ProtonDAO();
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
        HttpSession session = request.getSession();
        String sid;
        sid = session.getAttribute("txtId").toString();
        int id;
        id = Integer.parseInt(sid);
        Proton P1 = new Proton();
        P1 = pd.searchByIdProtonDeleted(id);
        pd.copyFromProtonDeleted(P1);
        if(pd.deleteByIdProtonDeleted(id))
        {
            out.println("<h3 class=\"text-center\" style=\"cursor:pointer;\"><code>Record Restore!!!</code></h3>");
            out.println("<a href=\"SearchAllDeletedD_Std\"><h5 class=\"text-center\" style=\"cursor:pointer;\"><code>Refresh</code></h5></a>");
            out.println("<a href=\"SearchAllStudentD_Std\"><h5 class=\"text-center\" style=\"cursor:pointer;\"><code>View Restored Data</code></h5></a>");
            out.println("<label for=\"filterId1\">Search By Id:</label>");
            out.println("<input type=\"radio\" onchange=\"orderAId_del()\" name=\"txtId1\">Ascending</input>");
            out.println("<input type=\"radio\" onchange=\"orderDId_del()\" name=\"txtId1\">Descending</input>");
            out.println("</div>");
            out.println("<div>");
            out.println("<label for=\"filterStd1\">Search By Standard:</label>");
            out.println("<input type=\"radio\" onchange=\"orderAStd_del()\" name=\"txtStd1\">Ascending</input>");
            out.println("<input type=\"radio\" onchange=\"orderDStd_del()\" name=\"txtStd1\" checked>Descending</input>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=container text-center>");
            Datalist = pd.searchDeletedProtonD_Std();
            int count = Datalist.size();
            out.println("<h3><code>Record's found :"+count+" </code></h3>");
            out.println("<table class=\"table table-striped table-bordered table-hover\" style=\"cursor:pointer;\">");
            out.println("<tr>");
            out.println("<th>Student Id</th>");
            out.println("<th>Student Name</th>");
            out.println("<th>Father's Name</th>");
            out.println("<th style=\"background-color:wheat;\">Standard</th>");
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
        }
        else
        {
            out.println("<h3 class=\"text-center\" style=\"cursor:pointer;\"><code>Record not Restore, Try Again!!!</code></h3>");
            out.println("<a href=\"SearchAllDeletedD_Std\"><h5 class=\"text-center\" style=\"cursor:pointer;\"><code>Refresh</code></h5></a>");
        }       
        out.println("</table>");
        out.println("<div class=\"text-center\">");
        out.println("<div class=\"alert alert-info\">");
        out.println("<div>");
        out.println("<label for=\"filterId2\">Search By Id:</label>");
        out.println("<input type=\"radio\" onchange=\"orderAId_del()\" name=\"txtId2\">Ascending</input>");
        out.println("<input type=\"radio\" onchange=\"orderDId_del()\" name=\"txtId2\">Descending</input>");
        out.println("</div>");
        out.println("<div>");
        out.println("<label for=\"filterStd1\">Search By Standard:</label>");
        out.println("<input type=\"radio\" onchange=\"orderAStd_del()\" name=\"txtStd2\">Ascending</input>");
        out.println("<input type=\"radio\" onchange=\"orderDStd_del()\" name=\"txtStd2\" checked>Descending</input>");
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