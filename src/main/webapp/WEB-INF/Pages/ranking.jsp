<%@page import="com.cookbook.DTO.RankingDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="ocenaService" type="com.cookbook.Service.OcenaService" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <h1>Ranking potraw</h1>
        <table align="center" border="1">
            <thead>
            <td>Numer</td><td>Nazwa potrawy</td><td>Polubienia</td><td>Negatywy</td><td>wynik</td>
        </thead>
        <%  int i = 0;
            for (RankingDTO r : ocenaService.ranking()) {
                i++;
        %>
        <tr>
            <td><%=i%></td>
            <td id="nazwa<%=i%>"><%=r.getNazwaDania()%></td>
            <td><%=r.getPozytywne()%></td>
            <td><%=r.getNegatywne()%></td>
            <td id="suma<%=i%>"><%=r.getSuma()%></td>
        </tr>
        <%}%>
    </table> 
    <div id="chartContainer" style="height: 300px; width: 100%;"></div>

    <script src="http://canvasjs.com/assets/script/canvasjs.min.js"></script>
    <script type="text/javascript">
        window.onload = function () {
              
            var chart = new CanvasJS.Chart("chartContainer",
                    {
                        animationEnabled: true,
                        title: {
                            text: "Wykres najlepszych dań"
                        },
                        data: [
                            {
                                type: "column", //change type to bar, line, area, pie, etc
                                dataPoints: [
                                    {label: document.getElementById("nazwa1").innerText , y: parseInt(document.getElementById("suma1").innerText)},
                                    {label: document.getElementById("nazwa2").innerText, y: parseInt(document.getElementById("suma2").innerText)},
                                    {label: document.getElementById("nazwa3").innerText, y: parseInt(document.getElementById("suma3").innerText)}
                                ]
                            }
                        ]
                    });

            chart.render();
        };
    </script>
</body>
</html>
