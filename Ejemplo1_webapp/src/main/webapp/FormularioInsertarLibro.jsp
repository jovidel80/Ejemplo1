<%--
  Created by IntelliJ IDEA.
  User: capitanjovi
  Date: 6/11/16
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Libro</title>
    <link rel="stylesheet" type="text/css" href="css/formato.css">
    <script type="text/javascript" src="js/validacion.js"></script>
</head>
<body>
<form action="InsertarLibro.jsp" id="miformulario" onsubmit="return validacion()">
    <fieldset>
        <legend>Formulario Alta Libro</legend>
        <p>
            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn"><br>
        </p>
        <p>
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo">
        </p>
        <p>
            <label for="categoria">Categoría:</label>
            <input type="text" id="categoria" name="categoria">
        </p>
        <p>
            <input type="submit" value="Insertar">
        </p>
    </fieldset>
</form>
</body>
</html>

