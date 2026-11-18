<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>

<c:forEach items="${chicks}" var="chick">
id = ${chick.id} | name = ${chick.name} |
<a href="${pageContext.request.contextPath}/getChick?id=${chick.id}">
    show full chick
</a>
<a href="${pageContext.request.contextPath}/deleteChick?id=${chick.id}">
    delete chick
</a>
<a href="${pageContext.request.contextPath}/updateChick?id=${chick.id}">
    update chick
</a>
</c:forEach>

<a href = ${pageContext.request.contextPath}/createChick>
    CREATE NEW CHICK
</a>


</body>
</html>