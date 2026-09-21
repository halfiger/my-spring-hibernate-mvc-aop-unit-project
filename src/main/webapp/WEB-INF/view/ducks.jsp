<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>

<c:forEach items = "${ducks}" var = "duck">
    id = ${duck.id} | name = ${duck.name} |
    <a href = "${pageContext.request.contextPath}/getDuck?id=${duck.id}">
    show full duck
    </a> |

    <a href = "${pageContext.request.contextPath}/deleteDuck?id=${duck.id}">
    delete duck
    </a> |

    <a href = "${pageContext.request.contextPath}/updateDuck?id=${duck.id}">
    update duck
    </a>

    <br>
</c:forEach>

<br>

<a href = "${pageContext.request.contextPath}/createDuck">
    CREATE NEW DUCK
<a>


</body>
</html>
