<%@page import="com.cookbook.DTO.SkladnikiDTO"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="skladnikiService" type="com.cookbook.Service.SkladnikiService" scope="request" />
<c:set var="link" value="${pageContext.servletContext.contextPath}"/>

<%
            Object o=session.getAttribute("poziom");
            int poziom=0;
            if(o!=null)
            poziom=Integer.parseInt(o.toString());
        %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabela Składników</h1>
        <table>
            <thead>
            <td>Zdjecie</td><td>Nazwa</td><td>Opis</td><td>Jednostka</td>
            </thead>
        <%for(SkladnikiDTO s:skladnikiService.findAllSkladniki())
        {%>
        <tr>
        <form action="${link}/Pages/edytujSkladnik.jsp" method="POST">
            <input type="hidden" value="<%=s.getNazwa()%>" name="nazwa"/>
            <td><img src="${link}/<%=s.getZdjecie()%>" width="100px" height="100px"/></td>
            <td><%=s.getNazwa()%></td>
            <td><%=s.getOpis()%></td>
            <td><%=s.getJednostka()%></td>
            <%if ((session.getAttribute("login") != null) && (session.getAttribute("login") != "")&& poziom>=3) {%>
            <td><input type="submit" value="usuń" name="delete"/></td><td><input type="submit" value="edytuj" name="edytuj"/></td>
            <%}%>
            </form>
        </tr>
        <%}%>
        </table>
        <%if(poziom>=3){ %>
        <form action="${link}/Pages/edytujSkladnik.jsp" method="POST">
            <input type="submit" value="Dodaj Skladnik" name="dodaj"/>
        </form>
        <% }%>
        </br>
        </br>
        .
    </body>
</html>
