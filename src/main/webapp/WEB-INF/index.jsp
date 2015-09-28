<%@page import="com.cookbook.DTO.AccountDTO"%>
<%@page import="com.cookbook.DTO.AddressDTO"%>
<%@page import="com.cookbook.DTO.PersonDTO"%>
<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="personService" type="com.cookbook.Service.PersonService" scope="request" />
<jsp:useBean id="accountService" type="com.cookbook.Service.AccountService" scope="request" />
<jsp:useBean id="addressService" type="com.cookbook.Service.AddressService" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>CookingBook</title>

    </head>

    <body>
         
            </br>
            Persons by id 1
            </br>
            <%PersonDTO x = personService.getPersonById(1);%>
            <%= x%>
            <hr />
            
            Adresy osoby o id 1 Criteria
            </br>
            <ol>
                <% for (AddressDTO p : addressService.getPersonAddress(x)) {%>
            <li> <%= p%> </li>
                <% } %> 
             </ol>
            <hr />
            
            Konta z bazy
            </br>
            <ol>
            <% for (AccountDTO a : accountService.getUsersList()) {%>
            <li> <%= a%> </li>
                <% }%> 
            </ol>
            <hr />
    </body>
</html>