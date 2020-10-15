package controller;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Proton;
import dao.ProtonDAO;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DeleteById extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    try 
    {
        PrintWriter out;
        out = response.getWriter();
        int id;
        id = Integer.parseInt(request.getParameter("txtId"));
        HttpSession session = request.getSession(true);
        session.setAttribute("txtId",id);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Delete Data | Proton Pre School</title>");
        out.println("<link rel=\"stylesheet\" href=\"css/header.css\">");
        out.println("<script src=js/order.js></script>");        
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
        if(P==null)
        {
            Proton P2;
            P2 = pd.searchByIdProtonDeleted(id);
            if(P2!=null)
            {
                out.println("<h2 class=\"text-left\" style=\"cursor:pointer;\"><code>Record Already Deleted from Database!!!</code></h2>");
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
                out.println("<h4 class=\"text-left\" style=\"cursor:pointer;\"><code>This record is only a backup of the recently deleted data.</code></h4>");
            }
            else
            {
                out.println("<div class=\"text-center\"><h2 style=\"cursor:pointer;\"><code>Id "+id+" is not created yet in database!!!</code></h2></div>");
            }
        }
        else
        {
            out.println("<h2 class=\"text-left\" style=\"cursor:pointer;\"><code>Record found in database!!!</code></h2>");
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
            out.println("<center>");
            int i,lenght = 4;
            String NUMBERS = "0123456789";
            Random random = new Random();
            char[] password = new char[lenght];
            int index = 0;
            for(i=0; i<lenght; i++)
            {
                password[i] = NUMBERS.charAt(random.nextInt(NUMBERS.length()));
            }
            int passcode,code,code1,code2,code3,code4;
            passcode = Integer.parseInt(String.valueOf(password));
            code1 = Character.getNumericValue(password[0]);
            code2 = Character.getNumericValue(password[1]);
            code3 = Character.getNumericValue(password[2]);
            code4 = Character.getNumericValue(password[3]);
            //code = code1*1000+code2*100+code3*10+code4*1;
            out.println("<style>");
            out.println("#txtId1,#txtId2,#txtId3,#txtId4{background-color:aliceblue;border:none;border-color:transparent;color:midnightblue;width:30px;height:50px;font-size:35px;cursor:no-drop;}");
            out.println("#txtCode{color:indigo;font-family:agency fb;font-weight:bold;letter-spacing:15px;cursor:pointer;width:150px;height:50px;font-size:35px;}");
            out.println("#txtId1{font-family:Colonna MT;font-style:italic;font-weight:bolder;text-decoration:underline;}");
            out.println("#txtId2{font-family:Bernard MT Condensed;font-style:oblique;text-decoration:overline;}");
            out.println("#txtId3{font-family:Jokerman;text-decoration:line-through;}");
            out.println("#txtId4{font-family:Snap ITC;font-weight:bolder;text-indent:0px;}");
            out.println("</style>"); //chiller Edwardian Script ITC Curlz MT broadway 
            out.println("<table border=\"1\">");
            out.println("<tr align=\"center\">");
            out.println("<strong style=\"font-size:45px;\">");
            out.println("<code style=\"font-size:20px;\"> Enter Right Captcha Code </code>");
            out.println("<td width=\"150px\" style=\"cursor:no-drop;background-color:aliceblue;\">");
            out.println("<input form=\"coder\" class=\"text-center\" type=\"text\" id=\"txtId1\" name=\"txtId1\" value"
                    + "=\""+code1+"\" disabled/></input>");
            out.println("<input form=\"coder\" class=\"text-center\" type=\"text\" id=\"txtId2\" name=\"txtId2\" value"
                    + "=\""+code2+"\" disabled/></input>");
            out.println("<input form=\"coder\" class=\"text-center\" type=\"text\" id=\"txtId3\" name=\"txtId3\" value"
                    + "=\""+code3+"\" disabled/></input>");
            out.println("<input form=\"coder\" class=\"text-center\" type=\"text\" id=\"txtId4\" name=\"txtId4\" value"
                    + "=\""+code4+"\" disabled/></input>");
            out.println("</td>");
            out.println("<td width=\"150px\">");
            out.println("<input form=\"coder\" maxlength=\"4\" id=\"txtCode\" class=\"text-center\" type=\"tel\" name=\"txtCode\"  autofocus autocomplete=\"off\"></input>");
            out.println("</td>");
            out.println("</strong>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<br>");
            out.println("<div id=\"alert_box\"><h4 id=\"alert_box\"><code style=\"color:blue;\" id=\"alert\">Captcha-Code is for security purpose.</code></h4></div>");
            out.println("<br>");
            out.println("<table>");
            out.println("<tr align=\"center\">");
            out.println("<td width=\"150px\">");
            out.println("<form id=\"coder\" method=\"POST\" action=\"DeleteRecord\" onsubmit=\"return eval()\">");
            out.println("<input class=\"btn btn-danger\" type=\"submit\" value=\"Delete Data\">");
            out.println("</form>");
            out.println("</td>");
            out.println("<td width=\"150px\">");
            out.println("<form method=\"POST\" action=\"DeleteById.html\">");
            out.println("<input class=\"btn btn-success\" type=\"submit\" value=\"Back Safely\">");
            out.println("</form>");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</center>");            
        }
        out.println("</div>");
        out.println("<center><CODE><A href=ProtonPreSchool>Go to index page</A></CODE>&nbsp;&nbsp;&nbsp;<CODE><A href=DeleteById.html>Delete more / Go to back</A></CODE></center>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    catch (Exception ex) 
    {
          Logger.getLogger(DeleteById.class.getName()).log(Level.SEVERE, null,ex);
    }
  }
}