<?xml version="1.0" encoding="UTF-8" ?>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
            <title>Cooking Book</title>

            <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/decorators/css/style.css">


                </head>

                <body>		

                    <header id="header">
                        <div class="innertube">

                        </div>
                    </header>

                    <div id="wrapper">

                        <main>
                            <div id="content">
                                <div class="innertube">
                                    <h1>CookingBook</h1>
                                    <decorator:body/>
                                </div>

                            </div>
                        </main>

                        <nav id="nav">
                            <div class="innertube">
                                <h3>Left heading</h3>
                                <ul>
                                    <li><a href="${pageContext.servletContext.contextPath}">HOME</a></li>
                                     <li><a href="${pageContext.servletContext.contextPath}/personsViewPage.jsp">Persons</a></li>
                                    <li><a href="#">Link 3</a></li>                                  
                                    <li><a href="#">Link 4</a></li>
                                    <li><a href="#">Link 5</a></li>
                                </ul>
                                <h3>Left heading</h3>
                                <ul>
                                    <li><a href="#">Link 1</a></li>
                                    <li><a href="#">Link 2</a></li>
                                    <li><a href="#">Link 3</a></li>
                                    <li><a href="#">Link 4</a></li>
                                    <li><a href="#">Link 5</a></li>
                                </ul>
                                <h3>Left heading</h3>
                                <ul>
                                    <li><a href="#">Link 1</a></li>
                                    <li><a href="#">Link 2</a></li>
                                    <li><a href="#">Link 3</a></li>
                                    <li><a href="#">Link 4</a></li>
                                    <li><a href="#">Link 5</a></li>
                                </ul>
                            </div>
                        </nav>

                        <login id="login">
                            <%
                                if ((session.getAttribute("login") == null) || (session.getAttribute("login") == "")) {
                            %>
                            <div class="loginmargin">

                                <h3>Zaloguj sie:</h3>
                                <form method="post" action="login.jsp">

                                    <input type="text" name="login" placeholder="login" style="width: 100px;" >
                                        <br>                                                
                                            <input type="password" name="password" placeholder="haslo" style="width: 100px;">
                                                <br><br>
                                                        <input type="submit" value="Zaloguj!" style="width: 100px;">
                                                            </form>
                                                            <br><br><a href="register.jsp"><img src="${pageContext.request.contextPath}/decorators/img/register.png">

                                                                        </div>
                                                            <% } else {
                                 %>
                                   
                                 <div class="logoutmargin"> <br><br><br><br>Witaj,<br><%=session.getAttribute("login")%> <br>
                                                             <br> <a href="logout.jsp"><img src="${pageContext.request.contextPath}/decorators/img/logout.png">

                                            <% } %>
                                                                        </login>

                                                                        </div>

                                                                        <footer id="footer">

                                                                            <p>Tutaj kiedys bedzie stopka :)...</p>

                                                                        </footer>

                                                                        </body>
                                                                        </html>