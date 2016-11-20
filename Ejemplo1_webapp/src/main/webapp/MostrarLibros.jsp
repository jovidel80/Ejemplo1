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
<form name="filtroCategoria" action="filtrar.do">
<select name="categoria">
    <option value="seleccionar">Seleccionar</option>
    <%
        List<String> listaDeCategorias = null;
        listaDeCategorias = (List<String>) request.getAttribute("listaDeCategorias");
        for (String categoria : listaDeCategorias) {
    if (categoria.equals(request.getParameter("categoria"))) { %>
    <option value="<%=categoria%>"><%=categoria%></option>
    <% } else { %>
    <option value="<%=categoria%>"><%=categoria%></option>
    <%}
        }%>
</select>
    <input type="submit" value="Filtrar">
</form>
<%
    List<Libro> listaDeLibros = (List<Libro>) request.getAttribute("listaDeLibros");
    for (Libro libro : listaDeLibros) { %>
<%=libro.getIsbn()%> -
<%=libro.getTitulo()%> -
<%=libro.getCategoria()%>
<a href="BorrarLibro.do?isbn=<%=libro.getIsbn()%>">Borrar</a>
<a href="FormularioEditarLibro.do?isbn=<%=libro.getIsbn()%>">Editar</a>
<br>
<% } %>
<br>
<a href="FormularioInsertarLibro.do"><input type="button" value="Insertar Libro"></a>
</body>
</html>
