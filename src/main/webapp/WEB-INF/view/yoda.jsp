<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yoda by id</title>
</head>
<body>

id = ${yoda.id} <br>
name = ${yoda.name} <br>
color = ${yoda.color} <br>
age = ${yoda.age} <br>

<a href="${pageContext.request.contextPath}/getAllYodas">go home</a>

</body>
</html>
