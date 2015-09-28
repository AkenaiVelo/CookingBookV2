<%@page import="com.cookbook.Other.Loger"%>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<jsp:useBean id="accountService" type="com.cookbook.Service.AccountService" scope="request" />

<%
    String login = request.getParameter("login");    
    String password = request.getParameter("password");
    
    String logged;
    
    if(!accountService.checkLogin(login))
    {
        if(accountService.CheckPassword(login, password))
        {
            logged = "Poprawny login, poprawne haslo";
             session.setAttribute("login", login);
             response.sendRedirect("index.jsp");
        }
        else
        {
            logged = "Poprawny login, Niepoprawne haslo";
            response.sendRedirect("failure.jsp");
        }
    }
    else
    {
        logged = "Wszystko zle";
        response.sendRedirect("failure.jsp");
    }
    
    Loger.logger.error(login + "    " + password);
    Loger.logger.error(logged);

%>