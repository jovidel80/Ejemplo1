<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.joseoliveros.aplicacion.bo.Libro" %>
<%@ page import="java.util.List" %>
<%@ page import="com.joseoliveros.aplicacion.bo.DataBaseException" %><%--
  Created by IntelliJ IDEA.
  User: Joliveros
  Date: 07/11/2016
  Time: 04:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Libro libro = null;
        libro = Libro.buscarPorClave(request.getParameter("isbn"));
    List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
%>
<html>
<head>
    <title>Editar Libro</title>
    <link rel="stylesheet" type="text/css" href="css/formato.css">
    <script type="text/javascript" src="js/validacion.js"></script>
</head>
<body>
<form action="SalvarLibro.do" id="formularioEdicion">
    <fieldset>
        <legend>Formulario alta libro</legend>
        <p>
            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" value="${libro.isbn}" readonly="readonly">
        </p>
        <p>
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" value="${libro.titulo}">
        </p>
        <p>
            <label for="categoria">Categoría:</label>
        <select name="categoria" id="categoria">
            <c:forEach var="categoria" items="${listaDeCategorias}">
                <c:choose>
                    <c:when test="${libro.categoria.id eq categoria.id}">
                        <option value="${categoria.id}" selected="selected">${categoria.descripcion}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${categoria.id}">${categoria.descripcion}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <br>
        </p>
        <p><input type="submit" value="Salvar"></p>
    </fieldset>
</form>
<br>
<a href="MostrarLibros.do"><input type="button" value="Mostrar Libros"></a>
</body>
</html>
