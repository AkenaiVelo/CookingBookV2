
<%@page import="com.cookbook.DTO.SkladnikiDTO"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="link" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    </head>
    <body>
        <h1>Skladnik</h1>
        <%Object o = request.getAttribute("Skladnik");
            SkladnikiDTO s = null;
            String nazwa = "";
            String opis = "";
            String jednostka = "";
            String zdjecie = "";
            if (o != null) {
                s = (SkladnikiDTO) o;
                nazwa = s.getNazwa();
                opis = s.getOpis();
                jednostka = s.getJednostka();
                zdjecie = s.getZdjecie();
            }
            String old="";
            if(s!=null)
            old=s.getNazwa();
        %>
        <form action="${link}/Pages/updateSkladnik.jsp" method="Post" accept-charset="utf-8">
            Nazwa:<input type="text" name="nazwa" value="<%=nazwa%>" pattern="[A-Za-zĄąĘęÓóŚśŁłŻżŹźĆćŃń ]+" required="true" minlength="3" title="Nazwa składa sie z a-z minimum 3 litery"/></br>
            Opis:<textarea name="opis"><%=opis%></textarea></br>
            Jednostka: <input type="text" name="jednostka" value="<%=jednostka%>" pattern="[A-Za-zĄąĘęÓóŚśŁłŻżŹźĆćŃń ]+" required="true" minlength="4" title="Nazwa składa sie z a-z minimum 4 litery"/></br>
            Zdjecie:
            <div id="image-holder">
                <img src="${link}/<%=zdjecie%>" id="zdjecie" alt="Brak zdjecia"/>
            </div></br>
            <!--<input id="fileUpload" type="file"  name="PlikZdjecie"/><br /> -->
            <input type="hidden" value="<%=old%>" name="old"/>
            <input type="hidden" value="${co}" name="co"/>
            <input type="submit" value="Zapisz"/>
        </form>

        <script type="text/javascript" >
            $("#fileUpload").on('change', function () {

                if (typeof (FileReader) != "undefined") {

                    var image_holder = $("#image-holder");
                    image_holder.empty();

                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $("<img />", {
                            "src": e.target.result,
                            "id": "zdjecie",
                            "alt": "Brak Zdjecia"
                        }).appendTo(image_holder);

                    }
                    image_holder.show();
                    reader.readAsDataURL($(this)[0].files[0]);
                } else {
                    alert("This browser does not support FileReader.");
                }
            });
        </script>    
    </body>
</html>
