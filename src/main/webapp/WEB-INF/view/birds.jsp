<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>

<c:forEach items="${birds}" var="bird">

    id=${bird.id} | name = ${bird.name} |
    <a href="${pageContext.request.contextPath}/updateBird?id=${bird.id}">update</a> |
    <a href="${pageContext.request.contextPath}/getBird?id=${bird.id}">view</a> |
    <a href="${pageContext.request.contextPath}/deleteBird?id=${bird.id}">delete</a> |

</c:forEach>

<br>
<a href="${pageContext.request.contextPath}/saveBird"> CREATE </a>

</body>
</html>
