<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Frog id = ${frog.id} <br>
Frog name = ${frog.name} <br>
Frog color = ${frog.color} <br>
Frog age = ${frog.age} <br>
<br>
<a href="${pageContext.request.contextPath}/getFrogs">
    return home
</a>

</body>
</html>
