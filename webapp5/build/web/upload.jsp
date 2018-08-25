<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>
<%
    InputStream in=request.getInputStream();
    int totalBytes=request.getContentLength();
    byte b[]=new byte[totalBytes];
    int readBytes=0,bytes=0;
    while(readBytes<totalBytes)
    {
        bytes=in.read(b,readBytes,totalBytes);
        readBytes+=bytes;
    }
    String file=new String(b);
    int index1=file.indexOf("filename=\"")+10;
    int index2=file.indexOf("\"",index1);
    String filename=file.substring(index1,index2);
    String content=request.getContentType();
    int boundaryL=content.indexOf("=");
    String boundary=content.substring(boundaryL+1);
    int pos=file.indexOf("filename=\"")+10;
    pos=file.indexOf('\n',pos)+1;
     pos=file.indexOf('\n',pos)+1;
      pos=file.indexOf('\n',pos)+1;
      int end=file.indexOf(boundary,pos)-4;
      FileOutputStream fout=new FileOutputStream(application.getRealPath("/")+"images/"+filename);
      fout.write(b,pos,(end-pos));
      fout.close();
      response.sendRedirect("download.jsp");
    
    
    %>