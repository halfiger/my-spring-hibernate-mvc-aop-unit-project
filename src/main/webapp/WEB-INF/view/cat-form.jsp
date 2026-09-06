<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form for new cat or cat updating</title>
</head>
<h1>form for new cat or cat updating</h1>
<body>

<form:form action = "${pageContext.request.contextPath}${url}" modelAttribute="cat" method="POST">

<form:hidden path = "id"/> <br>
name = <form:input path = "name"/> <br>
color = <form:input path = "color"/> <br>
age <form:input path = "age"/> <br>
<input type = "submit" value ="oki"> <br>
</form:form>

<a href = "${pageContext.request.contextPath}/cat-home"> return </a>

</body>
</html>
