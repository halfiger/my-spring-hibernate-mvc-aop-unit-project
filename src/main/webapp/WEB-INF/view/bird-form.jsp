<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>

<form:form action = "${pageContext.request.contextPath}${url}" modelAttribute="bird" method = "POST">
    <form:hidden path = "id"/>
    name = <form:input path = "name"/> <br>
    color = <form:input path = "color"/> <br>
    age = <form:input path = "age"/> <br>
    <input type = "submit" value = "ok">
</form:form>
</body>
</html>
