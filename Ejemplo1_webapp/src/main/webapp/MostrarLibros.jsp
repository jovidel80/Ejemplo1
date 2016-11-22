<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.joseoliveros.aplicacion.bo.Libro" %>
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
<form name="filtroCategoria" action="FiltrarLibrosPorCategoria.do">
<select name="categoria">
    <option value="seleccionar">Seleccionar</option>
    <c:forEach var="categoria" items="${listaDeCategorias}">
        <option value="${categoria}">${categoria}</option>
    </c:forEach>
</select>
    <input type="submit" value="Filtrar">
</form>
    <table border=" 2px black" style="border-collapse: collapse" cellpadding="5 px">
        <tr>
            <th>ISBN</th>
            <th>Título</th>
            <th>Categoría</th>
            <th></th>
            <th></th>
        </tr>
<c:forEach var="libro" items="${listaDeLibros}">
    <tr>
        <td align="center">${libro.isbn}</td>
        <td align="center">${libro.titulo}</td>
        <td align="center">${libro.categoria}</td>
        <td><a href="BorrarLibro.do?isbn=${libro.isbn}"><input type="button" value="Borrar"></a></td>
        <td><a href="FormularioEditarLibro.do?isbn=${libro.isbn}&categoria=${libro.categoria}"><input type="button" value="Editar"></a></td>
    </tr>
</c:forEach>

    </table>
<br>
<a href="FormularioInsertarLibro.do"><input type="button" value="Insertar Libro"></a>
</body>
</html>
