<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cat home</title>
</head>
<body>

<c:forEach items = "${cats}" var = "cat">
    ${cat.name}
    | <a href = "${pageContext.request.contextPath}/cat-find?id=${cat.id}" > show more </a>
    | <a href = "${pageContext.request.contextPath}/cat-update?id=${cat.id}"> update </a>
    | <a href = "${pageContext.request.contextPath}/cat-delete?id=${cat.id}"> remove </a>
    <br>

</c:forEach>

<a href = "${pageContext.request.contextPath}/cat-save"> CREATE NEW CAT</a>
</body>
</html>
