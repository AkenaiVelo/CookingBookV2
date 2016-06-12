<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String autor="";
            String nazwadania="";
            String opis = request.getParameter("opis");
            String refer=request.getHeader("referer");
            Date data = new Date();
            
            Object d=session.getAttribute("danie");
            if(d!=null)
            nazwadania=d.toString();
            
            Object o=session.getAttribute("login");
            if(o!=null)
            autor=o.toString();
            %>
        <h2><%=opis%></h2>
        <h2><%=data%></h2>
        <h2><%=nazwadania%></h2>
        <h2><%=autor%></h2>
        <h2><%=refer%></h2>
        <% response.sendRedirect(refer);%>
    </body>
</html>
