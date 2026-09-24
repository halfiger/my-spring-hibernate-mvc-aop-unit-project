<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<h2>Tom's Home Page</h2><br>

<c:forEach items="${toms}" var = "tom">

    | id = ${tom.id} | name = ${tom.name} |
    <a href = "${pageContext.request.contextPath}/getTom?id=${tom.id}">INFO</a> |
    <a href = "${pageContext.request.contextPath}/updateTom">UPDATE</a> |
    <a href = "${pageContext.request.contextPath}/deleteTom?id=${tom.id}">DELETE</a>

    <br>
</c:forEach>
<br>

<a href = "${pageContext.request.contextPath}/createTom">create new tom</a>

<body>

</body>
</html>
