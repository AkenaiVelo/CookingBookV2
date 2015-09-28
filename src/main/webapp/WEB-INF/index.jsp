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
         
            </br>
            
            Persons by id 1
            </br>
            <%EnginePersons x = personViewDAO.getPersonById(1);%>
            <%= x%>
            <hr />
            
            Adresy osoby o id 1 Criteria
            </br>
            <ol>
            <% for (EngineAddress p : addressViewDAO.CRITERIA_getAddressOfPerson(1)) {%>
            <li> <%= p%> </li>
                <% } %> 
             </ol>
            <hr />

            Adres osoby z pola
            </br>
            <ol>
            <% for (EngineAddress p :x.getAddressList()) {%>
            <li> <%= p%> </li>
                <% } %> 
            </ol>
            <hr />
            
            Konta z bazy
            </br>
            <ol>
            <% for (EngineAccount p : accountViewDAO.findAllAccounts()) {%>
            <li> <%= p%> </li>
                <% }%> 
            </ol>
            <hr />
    </body>
</html>