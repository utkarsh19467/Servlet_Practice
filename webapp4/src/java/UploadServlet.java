

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize=2*1024*1024)
@WebServlet(urlPatterns = {"/upload"})
public class UploadServlet extends HttpServlet {
@Override
 protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
 {
     String sbt=req.getParameter("sbt");
     if(sbt.equals("UPLOAD"))
     {
     String gender=req.getParameter("gender");
     String email=req.getParameter("txt3");
     try
     {
    Part p=req.getPart("file");
    InputStream in=p.getInputStream();
    Class.forName("com.mysql.jdbc.Driver");
    Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/photo-editor","root","123");
    PreparedStatement pst=c.prepareStatement("update users set profilepicture=? where email=?");
    pst.setBinaryStream(1, in);
    pst.setString(2,email);
    pst.executeUpdate();
    pst.close();
    c.close();
         RequestDispatcher rd=getServletContext().getRequestDispatcher("/browse");
         req.setAttribute("gender",gender);
         req.setAttribute("img", "Y");
         rd.forward(req,res);
         
         
    
   }
    catch(Exception e)
    {
        System.out.println(e);
    }
     }
     else if(sbt.equals("NEXT"))
     {
         res.sendRedirect("welcome");
     }
 }
 
}
