<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show all</title>
</head>
<body>

<h2>Main page</h2>
<br>

<c:forEach var = "animal" items = "${animals}" >

| id = ${animal.id}
| name = ${animal.name}
| color = ${animal.color}
| age = ${animal.age}
| <a href = "${pageContext.request.contextPath}/updateAnimal?id=${animal.id}"> update </a>
| <a href = "${pageContext.request.contextPath}/deleteAnimal?id=${animal.id}"> delete </a>

</c:forEach>

<br>
<a href = "${pageContext.request.contextPath}/createAnimal"> create new animal </a>

</body>
</html>
