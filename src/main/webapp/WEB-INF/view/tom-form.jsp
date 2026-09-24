<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tom form</title>
</head>
<body>
<h2>Tom form</h2> <br>

<form:form action = "${pageContext.request.contextPath}${url}" modelAttribute="tom" method = "POST">

    <form:hidden path="id"/>

    name = <form:input path="name"/> <br>
    color = <form:input path="color"/> <br>
    age = <form:input path="age"/> <br>

    <input type = "submit" value = "save">

</form:form>

</body
</html>
