<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items = "${yodas}" var = "yoda">

    id = ${yoda.id} | name = ${yoda.name} |
    <a href="${pageContext.request.contextPath}/getYoda?id=${yoda.id}">view</a>
    <a href="${pageContext.request.contextPath}/updateYoda?id=${yoda.id}">update</a>
    <a href="${pageContext.request.contextPath}/deleteYoda?id=${yoda.id}">delete</a>

</c:forEach>



</body>
</html>
