<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cat by id or new cat</title>
</head>
<body>

<h1>cat description, Cat by id or new Cat</h1>
Cat id = ${cat.id} <br>
Cat name = ${cat.name} <br>
Cat color = ${cat.color} <br>
Cat age = ${cat.age} <br>

<a href = "${pageContext.request.contextPath}/cat-home">
    return home </a> <br>

</body>
</html>
