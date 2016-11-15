<%@ page import="com.joseoliveros.Libro" %>
<%@ page import="java.util.List" %>
<%@ page import="com.joseoliveros.DataBaseException" %>
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
<form name="filtroCategoria">
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
    <input type="submit" value="Filtrar">
</form>
<%
    List<Libro> listaDeLibros = null;
    if (request.getParameter("categoria") == null || request.getParameter("categoria").equals("seleccionar")) {
        try {
            listaDeLibros = Libro.buscarTodos();
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
    } else {
        try {
            listaDeLibros = Libro.buscarPorCategoria(request.getParameter("categoria"));
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
    }
    for (Libro libro : listaDeLibros) { %>
<%=libro.getIsbn()%> -
<%=libro.getTitulo()%> -
<%=libro.getCategoria()%>
<a href="BorrarLibro.jsp?isbn=<%=libro.getIsbn()%>">Borrar</a>
<a href="FormularioEditarLibro.jsp?isbn=<%=libro.getIsbn()%>">Editar</a>
<br>
<% } %>

<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
</body>
</html>
