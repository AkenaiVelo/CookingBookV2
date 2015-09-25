<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            Login: <input type="text" name="LoginField" value="${login}" /><input type="submit" name="statusCheck" value="CheckLogin"/> status:${status} </br>
            Password:<input type="text" name="PasswordField" />
            <input type="submit" name="LogIn" value="Register" />
        </form>
        <h2>${komunikat}</h2>    

    </body>
</html>
