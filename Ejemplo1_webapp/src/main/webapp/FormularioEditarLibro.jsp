<%@ page import="com.joseoliveros.Libro" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Joliveros
  Date: 07/11/2016
  Time: 04:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Libro libro = Libro.buscarPorClave(request.getParameter("isbn"));
    List<String> listaDeCategorias = Libro.buscarTodasLasCategoria();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="SalvarLibro.jsp" id="formularioEdicion">
    <fieldset>
        <legend>Formulario alta libro</legend>
        <p>
            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" value="<%=libro.getIsbn()%>">
        </p>
        <p>
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" value="<%=libro.getCategoria()%>">
        </p>
        <p>
            <label for="categoria">Categoría:</label>
            <input type="text" id="categoria" name="categoria" value="<%=libro.getCategoria()%>">
        <select name="categoria">
        <%
            for (String categoria : listaDeCategorias) {
                if (libro.getCategoria().equals(categoria)) { %>
            <option value="<%=categoria%>" selected="selected"><%=categoria%></option>
            <%  } else { %>
            <option value="<%=categoria%>"><%=categoria%></option>
           <% }
            }
        %>
        </select>
        <br>
        </p>
        <p><input type="submit" value="Salvar"></p>
    </fieldset>
</form>
</body>
</html>