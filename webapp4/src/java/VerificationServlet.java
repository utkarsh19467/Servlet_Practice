

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/verify"})
public class VerificationServlet extends HttpServlet {
    String otp,email;
    String err="";
    @Override
    protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
    {
        otp=req.getParameter("txt");
        email=req.getParameter("email");
        err="";
         if(otp!=null)
        {
        try{
       
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/photo-editor","root","123");
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from users where email='"+email+"'and otp='"+otp+"'");
           if(rs.next())
           {
               st.executeUpdate("update users set verified='Y' where email='"+email+"'");
               res.sendRedirect("login.html");
           }
           else
           {
               err="INVALID OTP ENTERED";
           }
              rs.close();
              st.close();
              c.close();
               }
        
        catch(Exception e)
        {
            System.out.println(e);
        }}
      PrintWriter pw=res.getWriter();
      pw.println("<html>");
      pw.println("<center>");
      pw.println("<form action=' '>");
      pw.println("<table>");
      pw.println("<tr>");
      pw.println("<td>ENTER OTP HERE</td>");
       pw.println("<td><input type=password name=txt><input type=hidden name=email value="+email+"></td>");
        pw.println("<td><input type=submit value=OK></td>");
      pw.println("</tr>");
      pw.println("</table>");
      pw.println("<tr>");
      pw.println("<td colspan=3 style='color:red'>"+err+"</td>");
      pw.println("</td>");
      pw.println("</form>");
      pw.println("</center>");
      pw.println("</html>");
      
      
    }

}
