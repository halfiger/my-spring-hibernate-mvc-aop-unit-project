<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tom info</title>
</head>
<body>

<h2>Tom info</h2> <br>
<br>
id=${tom.id} <br>
name=${tom.name} <br>
color=${tom.color} <br>
age=${tom.age} <br>
<br>
<a href = "${pageContext.request.contextPath}/getToms">go to home page</a>

</body>
</html>
