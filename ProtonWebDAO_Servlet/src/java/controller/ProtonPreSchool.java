package controller;
import dao.ProtonDAO;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Proton;
public class ProtonPreSchool extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    PrintWriter out;
    out = response.getWriter();
    try 
    {
        List<Proton> DatalistSearchAll = new ArrayList<Proton>();
        List<Proton> DatalistSearchAllDeleted = new ArrayList<Proton>();
        ProtonDAO pd = new ProtonDAO();
        DatalistSearchAll = pd.searchAllProton();
        int DataSearchAll = DatalistSearchAll.size();
        DatalistSearchAllDeleted = pd.searchDeletedProton();
        int DataSearchAllDeleted = DatalistSearchAllDeleted.size();
        out.println("<HTML>");
        out.println("<head>");
        out.println("<TITLE>Proton Pre School | Indore</TITLE>");
        out.println("<script type=\"text/javascript\">var documentTitle = document.title + \" - \";(function titleMarquee(){document.title = documentTitle = documentTitle.substring(1) + documentTitle.substring(0,1);setTimeout(titleMarquee,200);})();</script>");
        out.println("<link rel=\"stylesheet\" href=\"css/header.css\">");
        out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
        out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
        out.println("<link rel=\"shortcut icon\" href=\"image/proton_logo.png\" />");
        out.println("<script src=\"js/bootstrap.min.js\"></script>");
        out.println("<script src=\"js/jquery-3.3.1.min.js\"></script>");
        out.println("<style>h3,code{font-weight:bold;cursor:pointer;}p:hover{font-weight:bold;}</style>");
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
        out.println("<br>");
        out.println("<div class=\"content\">");
        out.println("<div class=\"container\">");
        out.println("<div class=\"jumbotron text-center\">");
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-sm-4\">");
        out.println("<a  style=\"text-decoration:none;\" href=\"InsertData\">");
        out.println("<h3><code>Insert Data</code></h3>");
        out.println("<p>Click to open</p>");
        out.println("</a>");
        out.println("</div>");
        out.println("<div class=\"col-sm-4\">");
        out.println("<a style=\"text-decoration:none;\" href=\"UpdateById.html\">");
        out.println("<h3><code>Update Data</code></h3>");
        out.println("<p>Click to open</p>");
        out.println("</a>");
        out.println("</div>");
        out.println("<div class=\"col-sm-4\">");                    
        out.println("<a style=\"text-decoration:none;\" href=\"DeleteById.html\">");                
        out.println("<h3><code>Delete Data</code></h3>");                    
        out.println("<p>Click to open</p>");                
        out.println("</a>");                    
        out.println("</div>");                
        out.println("</div>");                
        out.println("<hr>");                    
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-sm-4\">");
        out.println("<a style=\"text-decoration:none;\" href=\"SearchAllStudentA\">");
        out.println("<h3><code>Search All Data <span class=\"badge badge-primary\" title=\""+DataSearchAll+" record's found.\">"+DataSearchAll+"</span></code></h3>");
        out.println("<p>Click to open</p>");
        out.println("</a>");
        out.println("</div>");
        out.println("<div class=\"col-sm-4\">");
        out.println("<a style=\"text-decoration:none;\" href=\"SearchById.html\">");   
        out.println("<h3><code>Search By Id</code></h3>");
        out.println("<p>Click to open</p>");   
        out.println("</a>");
        out.println("</div>");   
        out.println("<div class=\"col-sm-4\">");
        out.println("<a style=\"text-decoration:none;\" href=\"SearchAllDeletedA\">");   
        out.println("<h3><code>Deleted Backup Data <span class=\"badge badge-primary\" title=\""+DataSearchAllDeleted+" backup record's found.\">"+DataSearchAllDeleted+"</span></code></h3>");
        out.println("<p>Click to open</p>");   
        out.println("</a>");
        out.println("</div>");   
        out.println("</div>");
        out.println("</div>");   
        out.println("</div>");
        out.println("<a class=\"text-center\" style=\"text-decoration:none;cursor:pointer;\" href=\"index.html\"><h4><b>Log-out !!!</b></h4></a>");   
        out.println("</div>");
        out.println("</body>");                
        out.println("</HTML>");                
        out.println("");                    
        out.println("");                        
        out.println("");                        
        out.println("");
        out.println("");
        out.println("");
    }
    catch (Exception e) 
    {
        out.println(e);
    }
  }
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    PrintWriter out;
    out = response.getWriter();
    try 
    {
        List<Proton> DatalistSearchAll = new ArrayList<Proton>();
        List<Proton> DatalistSearchAllDeleted = new ArrayList<Proton>();
        ProtonDAO pd = new ProtonDAO();
        DatalistSearchAll = pd.searchAllProton();
        int DataSearchAll = DatalistSearchAll.size();
        DatalistSearchAllDeleted = pd.searchDeletedProton();
        int DataSearchAllDeleted = DatalistSearchAllDeleted.size();
        out.println("<HTML>");
        out.println("<head>");
        out.println("<TITLE>Proton Pre School | Indore</TITLE>");
        out.println("<script type=\"text/javascript\">var documentTitle = document.title + \" - \";(function titleMarquee(){document.title = documentTitle = documentTitle.substring(1) + documentTitle.substring(0,1);setTimeout(titleMarquee,200);})();</script>");
        out.println("<link rel=\"stylesheet\" href=\"css/header.css\">");
        out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">");
        out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
        out.println("<link rel=\"shortcut icon\" href=\"image/proton_logo.png\" />");
        out.println("<script src=\"js/bootstrap.min.js\"></script>");
        out.println("<script src=\"js/jquery-3.3.1.min.js\"></script>");
        out.println("<style>h3,code{font-weight:bold;cursor:pointer;}p:hover{font-weight:bold;}</style>");
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
        out.println("<br>");
        out.println("<div class=\"content\">");
        out.println("<div class=\"container\">");
        out.println("<div class=\"jumbotron text-center\">");
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-sm-4\">");
        out.println("<a  style=\"text-decoration:none;\" href=\"InsertData\">");
        out.println("<h3><code>Insert Data</code></h3>");
        out.println("<p>Click to open</p>");
        out.println("</a>");
        out.println("</div>");
        out.println("<div class=\"col-sm-4\">");
        out.println("<a style=\"text-decoration:none;\" href=\"UpdateById.html\">");
        out.println("<h3><code>Update Data</code></h3>");
        out.println("<p>Click to open</p>");
        out.println("</a>");
        out.println("</div>");
        out.println("<div class=\"col-sm-4\">");                    
        out.println("<a style=\"text-decoration:none;\" href=\"DeleteById.html\">");                
        out.println("<h3><code>Delete Data</code></h3>");                    
        out.println("<p>Click to open</p>");                
        out.println("</a>");                    
        out.println("</div>");                
        out.println("</div>");                
        out.println("<hr>");                    
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-sm-4\">");
        out.println("<a style=\"text-decoration:none;\" href=\"SearchAllStudentA\">");
        out.println("<h3><code>Search All Data <span class=\"badge badge-primary\" title=\""+DataSearchAll+" record's found.\">"+DataSearchAll+"</span></code></h3>");
        out.println("<p>Click to open</p>");
        out.println("</a>");
        out.println("</div>");
        out.println("<div class=\"col-sm-4\">");
        out.println("<a style=\"text-decoration:none;\" href=\"SearchById.html\">");   
        out.println("<h3><code>Search By Id</code></h3>");
        out.println("<p>Click to open</p>");   
        out.println("</a>");
        out.println("</div>");   
        out.println("<div class=\"col-sm-4\">");
        out.println("<a style=\"text-decoration:none;\" href=\"SearchAllDeletedA\">");   
        out.println("<h3><code>Deleted Backup Data <span class=\"badge badge-primary\" title=\""+DataSearchAllDeleted+" backup record's found.\">"+DataSearchAllDeleted+"</span></code></h3>");
        out.println("<p>Click to open</p>");   
        out.println("</a>");
        out.println("</div>");   
        out.println("</div>");
        out.println("</div>");   
        out.println("</div>");
        out.println("<a  class=\"text-center\" style=\"text-decoration:none;cursor:pointer;\" href=\"index.html\"><h4><b>Log-out !!!</b></h4></a>");   
        out.println("</div>");
        out.println("</body>");                
        out.println("</HTML>");                
        out.println("");                    
        out.println("");                        
        out.println("");                        
        out.println("");
        out.println("");
        out.println("");
    }
    catch (Exception e) 
    {
        out.println(e);
    }
  }
}