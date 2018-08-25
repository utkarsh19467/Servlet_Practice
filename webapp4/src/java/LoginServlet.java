
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
       
    @Override
    protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException
    {
        try
        {
        String s1=req.getParameter("txt3");
        String s2=req.getParameter("txt4");
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/photo-editor","root","123");
        //PreparedStatement pst=c.prepareStatement("select * from users where email=? and password=?");
       // pst.setString(1, s1);
           // pst.setString(2, s2);
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery("select * from users where email='"+s1+"' and password='"+s2+"'");
          //ResultSet rs = pst.executeQuery();
        if(rs.next())
        {
            String v=rs.getString(7);
            String gender=rs.getString("gender");
            String fname=rs.getString("f_name");
            String lname=rs.getString("l_name");
            Cookie ck=new Cookie("name",fname+" "+lname);
            res.addCookie(ck);
            Blob b=rs.getBlob("profilepicture");
            String isPicAvailable;
            if(b==null)
            isPicAvailable="N";
            else
                isPicAvailable="Y";
            if(v.equals("N"))
            {
                res.sendRedirect("loginver.html");
            }
            else
            {
                if(b==null)
                {
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/browse");
                req.setAttribute("gender",gender);
                req.setAttribute("img", isPicAvailable);
                rd.forward(req,res);
                }
                else
                {
                    HttpSession ses=req.getSession();
                    ses.setAttribute("email",s1 );
                    res.sendRedirect("welcome");
                }
            }
        } 
            else
            {
                res.sendRedirect("loginerr.html");
                    }
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
   }
