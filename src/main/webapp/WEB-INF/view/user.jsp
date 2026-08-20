<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML>

<HTML>

<head>
    <title>find by id</title>
</head>

<BODY>

<H2>find by id</H2>

    user id ${user.id}
    <br>
    user name ${user.name}
    <br>
    user email ${user.email}
    <br>

    <a href="${pageContext.request.contextPath}/home">go to home</a>

</BODY>

</HTML>