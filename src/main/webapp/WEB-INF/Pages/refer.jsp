<%-- 
    Document   : refer
    Created on : 2016-05-30, 15:10:36
    Author     : byaku
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% response.sendRedirect(request.getHeader("referer"));%>
    </body>
</html>
