<%--
  Created by IntelliJ IDEA.
  User: capitanjovi
  Date: 6/11/16
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.joseoliveros.Libro" %>
<%@ page import="com.joseoliveros.DataBaseException" %>

<%
    try {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoria = request.getParameter("categoria");

        Libro libro = new Libro(isbn, titulo, categoria);
        libro.insertar();

        response.sendRedirect("MostrarLibros.jsp");
    } catch (DataBaseException e) { %>
<%=e.getMessage()%>
<%=e.getCause().getMessage()%>
<% } %>

%>
<html>
<head>
    <title>Insertar Libros</title>
</head>
<body>

</body>
</html>
