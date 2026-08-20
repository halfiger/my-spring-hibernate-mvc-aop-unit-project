<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL BOOKS</title>
</head>
<body>

<c:forEach var = "book" items = "${books}">
    id = ${book.id}, title = ${book.title}, author = ${book.author}, price = ${book.price}
    <a href = "${pageContext.request.contextPath}/updateBook?id=${book.id}"> | update </a>
    <a href = "${pageContext.request.contextPath}/deleteBookByID?id=${book.id}"> | delete </a>
    <br>
</c:forEach>

<br><br><a href = "${pageContext.request.contextPath}/createBook"> Create new book </a>
</body>
</html>