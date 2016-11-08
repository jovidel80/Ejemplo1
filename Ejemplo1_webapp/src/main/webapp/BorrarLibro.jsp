<%@ page import="com.joseoliveros.Libro" %><%--
  Created by IntelliJ IDEA.
  User: capitanjovi
  Date: 6/11/16
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String isbn = request.getParameter("isbn");
    Libro libro = new Libro(isbn);
    libro.borrar();
    response.sendRedirect("MostrarLibros.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
