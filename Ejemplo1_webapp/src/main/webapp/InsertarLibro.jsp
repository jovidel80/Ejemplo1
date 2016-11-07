<%--
  Created by IntelliJ IDEA.
  User: capitanjovi
  Date: 6/11/16
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.joseoliveros.DataBaseHelper" %>
<%@ page import="com.joseoliveros.Libro" %>

<%
    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");

    Libro libro = new Libro(isbn, titulo, categoria);
    libro.insertar();

    response.sendRedirect("MostrarLibros.jsp");
%>
<html>
<head>
    <title>Insertar Libros</title>
</head>
<body>

</body>
</html>
