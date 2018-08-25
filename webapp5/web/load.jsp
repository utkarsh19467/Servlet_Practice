<%@page import="java.io.FileInputStream"%>
<%
    String fn=request.getParameter("filename");
    FileInputStream fin=new FileInputStream(application.getRealPath("/")+"images/"+fn);
    int len=fin.available();
    byte b[]=new byte[len];
    fin.read(b);
    response.setContentType("multipart/form-data");
    response.setHeader("Content-disposition","attachment;filename="+fn);
    ServletOutputStream ou=response.getOutputStream();
    ou.write(b);
    ou.close();
    %>
    
    

