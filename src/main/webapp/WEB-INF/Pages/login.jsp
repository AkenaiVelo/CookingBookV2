<%@page import="com.cookbook.Other.Loger"%>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<jsp:useBean id="kontoService" type="com.cookbook.Service.KontoService" scope="request" />

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logowanie</title>
    </head>
    <body>
        <%
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            if (!kontoService.checkLogin(login)) {
                if (kontoService.CheckPassword(login, password)) {
                    session.setAttribute("login", login);
                    response.sendRedirect("index.jsp");
                    //request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
        %>
        <h1><br>Nie udało się zalogować! Podałeś nie poprawne hasło. 
            <br><a href='index.jsp'>Powrót do strony głównej</a>
        </h1>
        <%
            }
        } else {
        %>
        <h1><br>Nie udało się zalogować! Take konto nie istnieje. 
            <br><a href='index.jsp'>Powrót do strony głównej</a>
        </h1>
        <%
            }
        %>
    </body>
</html>