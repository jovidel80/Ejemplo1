<%@ page import="com.joseoliveros.Libro" %><%--
  Created by IntelliJ IDEA.
  User: Joliveros
  Date: 07/11/2016
  Time: 05:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");
    Libro libro = new Libro(isbn, titulo, categoria);
    libro.salvar();
    response.sendRedirect("MostrarLibros.jsp");
%>
<html>
<head>
    <title>Salvar Libro</title>
</head>
<body>

</body>
</html>
