<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form for input data</title>
</head>
<body>

<h2>form for input data</h2>
<br>

<form:form action="${pageContext.request.contextPath}/${url}"
           modelAttribute="animal" method="POST">

    <form:hidden path="id"/>
    name = <form:input path="name"/>
    <br>
    age = <form:input path="age"/>
    <br>
    color = <form:input path="color"/>
    <br>
    <input type="submit" value="ok"/>
</form:form>

</body>
</html>
