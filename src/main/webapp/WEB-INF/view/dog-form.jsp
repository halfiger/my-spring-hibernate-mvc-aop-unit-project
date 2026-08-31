<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dog form, create or change data</title>
</head>
<body>

<form:form action = "${pageContext.request.contextPath}${url}" modelAttribute="dog" method = "POST">

    <h2> Dog values </h2>

    <form:hidden path = "id"/> <br>
    <form:label path = "name"/>
    <form:input path = "name"/> <br>
    <form:label path = "color"/>
    <form:input path = "color"/> <br>
    <form:label path = "age"/>
    <form:input path = "age"/> <br>
    <input type = "submit" value = "ok">

</form:form>

<a href = ${pageContext.request.contextPath}/show-dogs> go to main page </a>

</body>
</html>