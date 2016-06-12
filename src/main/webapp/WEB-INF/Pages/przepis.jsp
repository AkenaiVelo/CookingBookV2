<%@page import="com.cookbook.DTO.DanieDTO"%>
<%@page import="com.cookbook.DTO.SkladnikiDTO"%>
<%@page import="com.cookbook.DTO.GaleriaDanDTO"%>
<%@page import="com.cookbook.DTO.KomentarzDTO"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="danieService" type="com.cookbook.Service.DanieService" scope="request" />
<jsp:useBean id="skladnikiService" type="com.cookbook.Service.SkladnikiService" scope="request" />
<jsp:useBean id="galeriaDanService" type="com.cookbook.Service.GaleriaDanService" scope="request" />
<jsp:useBean id="komentarzService" type="com.cookbook.Service.KomentarzService" scope="request" />
<jsp:useBean id="ocenaService" type="com.cookbook.Service.OcenaService" scope="request" />
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
            Object nazw=request.getAttribute("nazwa");
            String nazwa="";
            if(nazw!=null)
            nazwa = nazw.toString();
            System.out.println();
            DanieDTO danie = danieService.findDanieByName(nazwa);
            session.setAttribute("danie", nazwa);
            Object l = session.getAttribute("login");
            String login;
            if (l != null) {
                login = l.toString();
            } else {
                login = null;
            }
        %>
        <h1><%=danie.getNazwa()%></h1>
        <h4>Kategoria: <%=danie.getKategoria()%></h4>
        <h2>Tabela składników</h2>
        <table align="center" border="1">
            <tr><th>Zdjecie</th><th>Nazwa</th><th>Ilosc</th><th>Jednostka</th></tr>
                    <%
                        for (SkladnikiDTO skladniki : skladnikiService.findIngredientsOfMeal2(nazwa)) {
                    %>
            <tr>
                <td><img src="${link}/<%=skladniki.getZdjecie()%>" style="width:100px;height: 100px;"/></td><td><%=skladniki.getNazwa()%></td>
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
        
            <% if(!ocenaService.czyOceniona(login, nazwa) && login!=null){%>
        <div>
            <h3>Ocen przepis!</h3>
            <form action="${link}/Pages/ocena.jsp" method="POST">
                <input type="hidden" name="nazwa" value="<%=nazwa%>"/>
                <input type="submit" value="Like" name="like" />
                <input type="submit" value="Dont Like" name="dlike"/>
            </form>
        </div>
        <%}%>


        <% if (danie.getFilm() != null && danie.getFilm() != "") {%>
        <h3>Film instruktazowy</h3>
        <video width="400" controls id="przepisVideo">
            <source src="${link}/filmy/<%=danie.getFilm()%>" type="video/mp4">
            Twoja przegladarka nie obsługuje mp4.
        </video>   
        <% }%>
        <h4>Komentarze:</h4>
        <%for (KomentarzDTO d : komentarzService.getDanieCommentsList(nazwa)) {%>
        <h4><%=d.getAutor()%>(<%=d.getDataWystawienia()%>)</h4>
        <form action="${link}/Pages/komentarzEdytuj.jsp">
            <textarea class="Komentarz" readonly="true" name="tresc" id="t<%=d.getIdKomentarz()%>">
                <%=d.getOpis()%>
            </textarea>
            </br>
            <%if (login != null) {%>
            <%if (login.equals(d.getAutor())) {%>
            <div>
                <input type="button" value="edytuj" onclick="edycjaKomentarza(<%=d.getIdKomentarz()%>)" id="e<%=d.getIdKomentarz()%>"/>
                <input type="submit"  value="Zapisz" style="visibility: hidden"  id="z<%=d.getIdKomentarz()%>"/>
                <input type="button"  value="Anuluj" style="visibility: hidden" id="a<%=d.getIdKomentarz()%>" onclick="location.reload()"/>
                <input type="hidden" value="<%=d.getIdKomentarz()%>" name="idKom" />
            </div>
            <% } %>
            <% } %>
        </form>

        <% } %>
        </br>
        </br>
        <%if (login != null) {%>
        <h3>Dodaj Komentarz</h3>
        <form action="${link}/Pages/komentarz.jsp" method="POST">
            <textarea name="opis" required="true">Komentarz</textarea>
            <input type="submit" value="OK"/>
        </form>
        <%} else {%>
        <h3>Aby dodac komentarz musisz się zalogowac.</h3>
        <% }%>
        .

        <script>
            function edycjaKomentarza(numer) {
                document.getElementById("t" + numer).removeAttribute("readonly");
                document.getElementById("e" + numer).style.visibility = 'hidden';
                document.getElementById("z" + numer).style.visibility = 'visible';
                document.getElementById("a" + numer).style.visibility = 'visible';
            }
        </script>
    </body>
</html>
