package controller;
import dao.AdminDAO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CheckLogin extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out;
        out = response.getWriter();
        String username, password;
        username = request.getParameter("txtUsername");
        password = request.getParameter("txtPassword");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Log-in | Proton Pre School</title>");
        out.println("<link rel=\"shortcut icon\" href=\"image/proton_logo.png\" />");
        out.println("<script type=\"text/javascript\">var documentTitle = document.title + \" - \";(function titleMarquee(){document.title = documentTitle = documentTitle.substring(1) + documentTitle.substring(0,1);setTimeout(titleMarquee,200);})();</script>");
        out.println("</head>");
        out.println("<body>"); 
        if(AdminDAO.checkLogin(username,password))
        {
            //out.println("Valid User : "+username+" - "+password);
            response.sendRedirect("ProtonPreSchool");
        }
        else
        {
            //out.println("In-Valid User : "+username+" - "+password);
            response.sendRedirect("index.html");
        }
        out.println("</body>");
        out.println("</html>"); 
    }
}