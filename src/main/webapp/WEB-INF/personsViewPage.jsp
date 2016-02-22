




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
            <% for (int i=0;i<10;i++) {%>
            <tr>
                <td> <%=  1%></td>
                <td> <%=  2 %></td>
                 <td> <%=  3%></td>
            </tr>
            <% }%>
        </table>





    </body>

</html>
