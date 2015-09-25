<%@page import="com.cookbook.DTO.PersonDTO"%>
<jsp:useBean id="personService" type="com.cookbook.Service.PersonService" scope="request" />




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>    
        <h1>Persons </h1>  

        <table border="3">
            <tr>
                <td>Persons List</td>   
            </tr>
            <% for (PersonDTO p : personService.usersList()) {%>
            <tr>
                <td> <%=  p.getPersonId()%></td>
                <td> <%=  p.getFirstname() %></td>
                 <td> <%=  p.getSurname()%></td>
            </tr>
            <% }%>
        </table>





    </body>

</html>
