<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chick by id</title>
</head>
<body>
id = ${chick.id} <br>
name = ${chick.name} <br>
color = ${chick.color} <br>
age = ${chick.age} <br>
<br>
<a href="${pageContext.reaquest.contextPath}/getAllChicks">go home</a>
</body>
</html>