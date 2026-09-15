<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show fish</title>
</head>

<body>

id = ${fish.id} <br>
name = ${fish.name}  <br>
color = ${fish.color}  <br>
age = ${fish.age}  <br>

<a href = "${pageContext.request.contextPath}/showFishes">go to home page</a>

</body>

</html>