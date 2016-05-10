<%@page import="com.cookbook.DTO.DanieDTO"%>
<%@page import="com.cookbook.DTO.SkladnikiDTO"%>
<%@page import="com.cookbook.DTO.GaleriaDanDTO"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="danieService" type="com.cookbook.Service.DanieService" scope="request" />
<jsp:useBean id="skladnikiService" type="com.cookbook.Service.SkladnikiService" scope="request" />
<jsp:useBean id="galeriaDanService" type="com.cookbook.Service.GaleriaDanService" scope="request" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="link" value="${pageContext.servletContext.contextPath}"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> <!-- 33 KB -->
<!-- fotorama.css & fotorama.js. -->
<link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.4/fotorama.js"></script> <!-- 16 KB -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nazwa = request.getAttribute("nazwa").toString();
            DanieDTO danie = danieService.findDanieByName(nazwa);
        %>
        <h1><%=danie.getNazwa()%></h1>
        <h4>Kategoria: <%=danie.getKategoria()%></h4>
        <h2>Tabela składników</h2>
        <table align="center" border="1">
            <tr><th>Zdjecie</th><th>Nazwa</th><th>Ilosc</th><th>Jednostka</th></tr>
                    <%
                        for (SkladnikiDTO skladniki : skladnikiService.findIngredientsOfMeal(nazwa)) {
                    %>
            <tr>
                <td><%=skladniki.getZdjecie()%></td><td><%=skladniki.getNazwa()%></td>
                <td><%=skladniki.getIlosc()%></td><td><%=skladniki.getJednostka()%></td> 
            </tr>
            <% }%>
        </table>
        <h2>Przepis:</h2>
        <%=danie.getOpis()%>
        <h3>Galeria</h3>

        <div class="fotorama" data-allowfullscreen="true"  data-nav="thumbs" data-keyboard="true">
            <%
                for (GaleriaDanDTO g : galeriaDanService.galeriaDaniaByName(nazwa)) {
            %>
            <img src="${link}/Gallery/<%=g.getZdjecie()%>" />
            <%}%>
        </div>


        <% if (danie.getFilm() != null && danie.getFilm() != "") {%>
        <h3>Film instruktazowy</h3>
        <video width="400" controls id="przepisVideo">
            <source src="${link}/filmy/<%=danie.getFilm()%>" type="video/mp4">
            Twoja przegladarka nie obsługuje mp4.
        </video>   
        <% }%>
        <h4>Komentarze:</h4>
    </body>
</html>
