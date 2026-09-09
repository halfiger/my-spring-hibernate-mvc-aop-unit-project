<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>

id = ${bird.id} <br>
name = ${bird.name} <br>
color = ${bird.color} <br>
age = ${bird.age} <br>

<a href = "${pageContext.request.contextPath}/getBirds">go to home page</a>

</body>
</html>
