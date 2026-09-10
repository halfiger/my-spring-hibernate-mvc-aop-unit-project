<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${frogs}" var="frog">

    id = ${frog.id} | ${frog.name} |
    <a href="${pageContext.request.contextPath}/getFrog?id=${frog.id}">
        show frog | </a>
    <a href="${pageContext.request.contextPath}/updateFrog?id=${frog.id}">
        update frog | </a>
    <a href="${pageContext.request.contextPath}/deleteFrog?id=${frog.id}">
        delete frog | </a>
    <br>
</c:forEach>
<br>
<a href = "${pageContext.request.contextPath}/createFrog"> CREATE FROG </a>

</body>
</html>
