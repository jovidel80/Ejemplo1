<%--
  Created by IntelliJ IDEA.
  User: joliveros
  Date: 15/11/2016
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<html>
<head>
    <title>Error</title>
</head>
<body>
    Ha ocurrido un error en la aplicación: <%=exception.getMessage()%>
    Error interno: <%=exception.getCause().getMessage()%>
</body>
</html>
