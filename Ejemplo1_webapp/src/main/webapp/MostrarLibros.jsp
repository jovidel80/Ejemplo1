<%@ page import="com.joseoliveros.Libro" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: capitanjovi
  Date: 6/11/16
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Libros</title>
</head>
<body>
<select name="categoria">
    <option value="seleccionar">Seleccionar</option>
    <%
        List<String> listaDeCategorias = null;
        listaDeCategorias = Libro.buscarTodasLasCategoria();
        for (String categoria : listaDeCategorias) { %>
    <option value="<%=categoria%>"><%=categoria%>
    </option>
    <% } %>
</select>
<br>
<%
    List<Libro> listaDeLibros = null;
    listaDeLibros = Libro.buscarTodos();
    for (Libro libro : listaDeLibros) { %>
<%=libro.getIsbn()%> -
<%=libro.getTitulo()%> -
<%=libro.getCategoria()%>
<a href="BorrarLibro.jsp?isbn=<%=libro.getIsbn()%>">Borrar</a>
<br>
<% } %>

<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
</body>
</html>
