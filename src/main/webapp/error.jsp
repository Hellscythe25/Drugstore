<%--
  Created by IntelliJ IDEA.
  User: GameDev
  Date: 14/10/2022
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1> Ha ocurrido un error: </h1>
<h1> There was a problem with this process </h1>

<h3> There was an error : <%=request.getAttribute("message")%></h3>

</body>
</html>
