<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML>
<HEAD>
    <title>home</title>
</HEAD>

<body>

<c:forEach items = "${fishes}" var = "fish">
    - id = ${fish.id} | name = ${fish.name} |
    <a href = "${pageContext.request.contextPath}/showFish?id=${fish.id}">show fish</a> |
    <a href = "${pageContext.request.contextPath}/deleteFish?id=${fish.id}">delete fish</a> |
    <a href = "${pageContext.request.contextPath}/updateFish?id=${fish.id}"> update fish </a> -
<br>
</c:forEach>
<br>
<a href = "${pageContext.request.contextPath}/createFish">Create new fish</a>

</body>

</HTML>