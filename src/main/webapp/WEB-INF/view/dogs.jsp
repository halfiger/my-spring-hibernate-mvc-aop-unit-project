<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>

<c:forEach items="${dogs}" var="dog">
    id = ${dog.id}
    | name = ${dog.name}
    | color = ${dog.color}
    | age = ${dog.age}
    | <a href="${pageContext.request.contextPath}/update-dog?id=${dog.id}" >UPDATE DOG</a>
    | <a href="${pageContext.request.contextPath}/delete-dog?id=${dog.id}" >DELETE DOG</a>
    <br>
    <br>
    <br>

</c:forEach>
NEW DOG <a href = "${pageContext.request.contextPath}/create-dog"> CREATE </a>
</body>
</html>
