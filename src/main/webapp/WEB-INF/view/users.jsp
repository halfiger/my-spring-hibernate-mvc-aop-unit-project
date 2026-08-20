<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>

<HTML>

<head>
    <title>ALL USERS</title>
</head>

<BODY>
<H2>ALL USERS</H2>
<br>

    <c:forEach var="user" items = "${users}">

        user id = ${user.id}
        <br>
        user name = ${user.name}
        <br>
        user email = ${user.email}
        <br>
        <a href="${pageContext.request.contextPath}/update?id=${user.id}">update user</a>
        <br>
        <a href="${pageContext.request.contextPath}/delete?id=${user.id}">delete user</a>
        <br>

    </c:forEach>
<br>
    <a href="${pageContext.request.contextPath}/create">CREATE NEW USER</a>

</BODY>

</HTML>
