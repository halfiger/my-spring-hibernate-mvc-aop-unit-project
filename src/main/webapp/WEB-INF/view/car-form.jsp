<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form for updating or creating of car</title>
</head>
<body>

<form:form action = "${pageContext.request.contextPath}/${url}"
           modelAttribute="car" method = "POST">

    <form:hidden path="id"/>
    BRAND = <form:input path="brand"/><br>
    MODEL = <form:input path="model"/><br>
    YEAR = <form:input path="year"/><br>
    PRICE = <form:input path="price"/><br>
    <input type="submit" value="ok">

</form:form>

</body>
</html>