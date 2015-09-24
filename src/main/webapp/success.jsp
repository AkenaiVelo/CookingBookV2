<%
    if ((session.getAttribute("login") == null) || (session.getAttribute("login") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("login")%>
<a href='logout.jsp'>Log out</a>
<%
    }
%>