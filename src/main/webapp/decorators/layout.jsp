<?xml version="1.0" encoding="UTF-8" ?>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.cookbook.DTO.KategoriaDanDTO"%>
<jsp:useBean id="kategoriaDanService" type="com.cookbook.Service.KategoriaDanService" scope="request" />
<c:set var="link" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Cooking Book</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/decorators/css/style.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
        <link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> 
        <script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> 
    </head>
    <body>	

        <div id="header"></div>

        <div id="wrapper">
            

            <div id="nav">
                <h3>Left heading</h3>
                <ul>
                    <li><a href="${link}">HOME</a></li> 
                    <% for (KategoriaDanDTO a : kategoriaDanService.findAllKategoriaDan()) {%>
                    <li><a href="${link}/Pages/przepisy/<%=a.getNazwa()%>"><%=a.getNazwa()%></a></li>
                    <%}%>
                    <li><a href="${link}/Pages/skladniki">Tabela Składników</a></li>
                    <li><a href="${link}/Pages/ranking">Ranking</a></li>
                </ul>
            </div>

            <div id="login">
                <%if ((session.getAttribute("login") == null) || (session.getAttribute("login") == "")) {%>
                <div id="loginIn">
                    Zaloguj sie:
                    <form method="post" action="${link}/Pages/login">
                        <input type="text" name="login" placeholder="login" style="width: 100px;" />
                        </br>                                                
                        <input type="password" name="password" placeholder="haslo" style="width: 100px;"/>
                        </br>
                        </br>
                        <input type="submit" value="Zaloguj!" style="width: 100px;"/>
                    </form>
                    </br>
                    </br>
                    <a href="${link}/Pages/register"><img src="${pageContext.request.contextPath}/decorators/img/register.png"></a>
                </div>
                <% } else {%>
                <div id="loginIn"> 
                    </br>
                    </br>
                    Witaj,
                    </br>
                    <%=session.getAttribute("login")%> 
                    </br>
                    </br> 
                    <a href="${link}/Pages/logout"><img src="${pageContext.request.contextPath}/decorators/img/logout.png"></a>
                </div>
                <% }%>
            </div>
            <div id="content">
                <decorator:body/>
            </div>
        </div>

        <div id="footer">
            <p>Tutaj kiedys bedzie stopka :)...</p>
        </div>
    </body>
</html>