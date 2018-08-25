

import com.mysql.jdbc.util.Base64Decoder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/match"})
public class MatchServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException
{
    String eText="";
    Cookie ck[]=req.getCookies();
    for(int i=0;i<ck.length;i++)
    {
        if(ck[i].getName().equals("captcha"))
            eText=ck[i].getValue();    }
try{
   String p=getServletContext().getRealPath("/")+"key.txt";
    FileInputStream fin=new FileInputStream(p);
    ObjectInputStream oin=new ObjectInputStream(fin);
    SecretKey k=(SecretKey)oin.readObject();
    Cipher cipher=Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE,k);
    Base64Decoder bd=new Base64Decoder();
    byte b[]=bd.decodeBuffer(eText);
    byte dt[]=cipher.doFinal(b);
    String dText=new String(dt);
    String s=req.getParameter("cap");
    if(dText.equals(s))
    {
       String s1=req.getParameter("op");
       String s2=req.getParameter("np");
       String s3=req.getParameter("cp");
       if(s2.equals(s3))
       {
           HttpSession ses=req.getSession();
           String e=ses.getAttribute("email").toString();
            Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/photo-editor","root","123");
        Statement st=c.createStatement();
        int n=st.executeUpdate("update set password='"+s3+"' where email='"+e+"' and password='"+s1+"'");
        st.close();
        c.close();
        res.sendRedirect("change?err=A");
       }
       else
       {
        res.sendRedirect("change?err=B");   
       }
    }
    else
    {
        res.sendRedirect("change?err=C");
    }
}
catch(Exception e)
{
    System.out.println(e);
}
}    
    
    
    
}
