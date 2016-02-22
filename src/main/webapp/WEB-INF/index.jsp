<%@page import="com.cookbook.DTO.KontoDTO"%>
<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="kontoService" type="com.cookbook.Service.KontoService" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>CookingBook</title>

    </head>

    <body>
         
            Konta z bazy
            </br>
            <ol>
            <% for (KontoDTO a : kontoService.getUsersList()) {%>
            <li> <%= a%> </li>
                <% }%> 
            </ol>
            <hr />
    </body>
</html>