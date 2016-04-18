<%@page import="com.cookbook.DTO.DanieDTO"%>
<jsp:useBean id="danieService" type="com.cookbook.Service.DanieService" scope="request" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="link" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>             
        <h1>Przepisy z kategori <%=request.getAttribute("kat")%></h1>
        <% String k=request.getAttribute("kat").toString();
        //out.print(k);
        for(DanieDTO d:danieService.findAllDaniaByKategoria(k))
        {
            %>
            <a href="${link}/Pages/przepisy/<%=k%>/<%=d.getNazwa()%>"><%=d.getNazwa()%></a>
        <%
        }
        %>
    </body>
</html>
