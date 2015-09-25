<%@page import="com.cookbook.ENGINE.EngineAccount"%>
<%@page import="com.cookbook.ENGINE.EnginePersons"%>
<%@page import="com.cookbook.ENGINE.EngineAddress"%>
<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:useBean id="personViewDAO" type="com.cookbook.DAO.PersonViewDAO" scope="request" />
<jsp:useBean id="addressViewDAO" type="com.cookbook.DAO.AddressViewDAO" scope="request" />
<jsp:useBean id="accountViewDAO" type="com.cookbook.DAO.AccountViewDAO" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>JPA Guestbook Web Application Tutorial</title>

    </head>

    <body>

        <form method="POST" action="index.html">
            Name: <input type="text" name="name" />
            <input type="submit" value="Add" />
        </form>

        <ol> 
          
          
            
            
            </br></br></br>
            test

            <%EnginePersons x = personViewDAO.getPersonById(1);%>
            <%= x%>
            aaaa
            <br>
            <br>
            MaQ - Test pobierania adresow dla Person z id 1

            <% for (EngineAddress p : addressViewDAO.CRITERIA_getAddressOfPerson(1)) {%>
            <li> <%= p%> </li>
                <% } %>    
            <br>
            <br>
            MaQ - Test pobierania loginow z bazy

            <% for (EngineAccount p : accountViewDAO.findAllAccounts()) {%>
            <li> <%= p%> </li>
                <% }%> 

            <form method="POST" action="index.html">

                <input type="submit" name="button" value="linknowy" />
            </form>

        </ol>
    </body>
</html>