<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Duck by id form</title>
</head>
<body>

id = ${duck.id} <br>
name = ${duck.name} <br>
color = ${duck.color} <br>
age ${duck.age}  <br>

<a href = "${pageContext.request.contextPath}/getAllDucks">
go home
</a>

</body>
</html>
