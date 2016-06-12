<%
session.setAttribute("login", null);
session.invalidate();
//response.sendRedirect("index.jsp");
response.sendRedirect(request.getHeader("referer"));
%>