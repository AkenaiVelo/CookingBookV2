<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>

   

<%--  KOMENTARZ --%>
    <body>
        <h1>Wypełnij formularz rejestracyjny</h1>
        </br>
        <form method="POST" action="register.jsp">
            Login: <input type="text" name="LoginField" value="${login}" pattern="[a-zA-Z1-9]+" minlength="4" title="Format [a-zA-Z1-9] minimum 4 znaki"/></br>
            status:${status} <input type="submit" name="statusCheck" value="CheckLogin"/></br>
            Email:<input type="email" name="Email" value="${email}" pattern="^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}$"/></br>
            Password:<input type="password" name="PasswordField" pattern="[a-zA-Z1-9]+" minlength="6" title="Format [a-zA-Z1-9] minimum 6 znaków"/></br>
            <input type="submit" name="LogIn" value="Register" />
        </form>
        <h2>${komunikat}</h2>    

    </body>
</html>
