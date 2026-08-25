<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form for input data</title>
</head>
<body>

<h2>form for input data</h2>
<br>

<form:form action="/${url}" modelAttribute="animal" method="POST">


id = <form:hidden path="id"/>
<br>
name = <form:input path="name"/>
<br>
age = <form:input path="age"/>
<br>
color = <form:input path="color"/>
<br>

    <a href="${pageContext.request.contextPath}/findAllAnimals">home page</a>


    </form:form>


</body>
</html>
