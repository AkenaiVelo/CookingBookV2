<%@page import="com.cookbook.ENGINE.EngineOcena"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.net.URLClassLoader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.File"%>
<%@page import="com.cookbook.DTO.GaleriaDanDTO"%>
<%@page import="com.cookbook.DTO.DanieDTO"%>
<%@page import="com.cookbook.DTO.KomentarzDTO"%>
<%@page import="com.cookbook.DTO.KontoDTO"%>
<%@page import="com.cookbook.DTO.SkladnikiDTO"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="kontoService" type="com.cookbook.Service.KontoService" scope="request" />
<jsp:useBean id="komentarzService" type="com.cookbook.Service.KomentarzService" scope="request" />
<jsp:useBean id="danieService" type="com.cookbook.Service.DanieService" scope="request" />
<jsp:useBean id="galeriaService" type="com.cookbook.Service.GaleriaDanService" scope="request" />
<jsp:useBean id="skladnikiService" type="com.cookbook.Service.SkladnikiService" scope="request" />
<jsp:useBean id="ocenki" type="com.cookbook.DAO.OcenaDAO" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>CookingBook</title>
    </head>
    <body>
        Konta z bazy</br>
        <ol>
            <% for (KontoDTO a : kontoService.getUsersList()) {%>
            <li> 
                <%= a%> 
                <%for (KomentarzDTO b : komentarzService.getUserCommentsList(a.getLogin())) {%>
                <%=b%>
                <% }%>

                <%for (DanieDTO c : danieService.findAllDaniaByLogin(a.getLogin())) {%>
                <%=c%>
                
                <%for (GaleriaDanDTO d : galeriaService.galeriaDania(c.getIdDania())) {%>
                <%=d%>
                <% }%>
                <% }%>
            </li>
            <% }%> 
        </ol>

        <ol>
            <%for (SkladnikiDTO e : skladnikiService.findAllSkladniki()) {%>
            <li>
                <%= e.getNazwa()%>
                <%=e%>  
            </li>
            <% }%>
        </ol>
        <%= skladnikiService.getilosc(2, "Cebula")%>
        <ol>
            <%for (EngineOcena e : ocenki.findAllOceny()) {%>
            <li>
              
                <%=e%>  
            </li>
            <% }%>
        </ol>
        <hr />
    </body>
</html>