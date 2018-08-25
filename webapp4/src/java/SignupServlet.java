
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import com.user.User;
import java.io.IOException;
import java.sql.Connection;
import java.io.PrintWriter;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.DriverManager;
import javax.mail.Transport;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        try
        {
        String s1=req.getParameter("txt1");
        String s2=req.getParameter("txt2");
        String s3=req.getParameter("txt3");
        String s4=req.getParameter("txt5");
        String s5=req.getParameter("rad");
        String s6=req.getParameter("cnt");
        String s7=req.getParameter("pic");
        User u=new User(s1,s2,s3,s5,s6);
            HttpSession ses=req.getSession();
            ses.setAttribute("obj", u);
         Class.forName("com.mysql.jdbc.Driver");
         Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/photo-editor","root","123");
            Statement st= c.createStatement();
            otp=getOTP();
            st.executeUpdate("insert into users(f_name,l_name,email,password,gender,country,verified,profilepic,otp) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','N','"+s7+"','"+otp+"')");
            sendMail(s3);
             PrintWriter pw=res.getWriter();
            pw.println("values saved");
            
        } 
        catch (Exception e)
        {
       res.sendRedirect("demo.jsp");
    }

}
    int otp;
    public int getOTP()
    {
        int num=(int)(1000000*Math.random());
        if(num<100000)
        {
            getOTP();
        }
        return num;
    }
    
    public void sendMail(String email)throws Exception
    {
        Properties props=new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user","zabaish12345@gmail.com");
        props.put("mail.smtp.password","v@r@rgs@123");
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.auth",true);
        Session ses=Session.getDefaultInstance(props);
        MimeMessage message=new MimeMessage(ses);
        message.setSubject("Confirmation Mail From Utkarsh Shukla's Photo Editing Team");
        message.setSender(new InternetAddress("zabaish12345@gmail.com"));
  message.setRecipient(Message.RecipientType.TO,
                new InternetAddress(email));
        message.setContent("Dear Sir/Ma'am,<br><br>Thank you for choosing our company to get your work done<br><br>We promise you for same service to be provide in future.Your otp for complete verification is<br><span style='font-size:25px'>"+otp+"</span><br>Please click on the below provided link to complete your registration process<br>http://localhost:29002/webapp4/verify?email="+email+"<br><br>We hope the same trust to be shown by you as shown this time<br>Thanking with regards!! <br> Team Utkarsh","text/html");
        Transport trans=ses.getTransport("smtps");
        trans.connect("smtp.gmail.com","zabaish12345@gmail.com","v@r@rgs@123");
        trans.sendMessage(message,message.getAllRecipients());
    }
    
        }
