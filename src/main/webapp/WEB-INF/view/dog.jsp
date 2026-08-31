<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dog by id</title>
</head>
<body>

<h2>dog</h2>

id = ${dog.id} <br>
name = ${dog.name} <br>
color = ${dog.color} <br>
age = ${dog.age} <br>

<a href = "${pageContext.request.contextPath}/show-dogs"> back to main page </a>

</body>
</html>
