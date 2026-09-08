<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<c:forEach items="${mice}" var="mouse">

    ${mouse.id} | ${mouse.name}
     | <a href ="${pageContext.request.contextPath}/showMouse?id=${mouse.id}">SHOW MOUSE</a>
     | <a href ="${pageContext.request.contextPath}/updateMouse?id=${mouse.id}">UPDATE MOUSE</a>
     | <a href ="${pageContext.request.contextPath}/deleteMouse?id=${mouse.id}">DELETE MOUSE</a>

</c:forEach>
<br>
<br>
<br>
<a href ="${pageContext.request.contextPath}/createMouse">CREATE NEW MOUSE</a>

</body>
</html>
