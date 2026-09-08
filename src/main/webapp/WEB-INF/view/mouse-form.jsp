<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>

<form:form action = "${pageContext.request.contextPath}${url}" modelAttribute="mouse" method = "POST">

    <form:hidden path = "id"/>
    <br>
    NAME =
    <form:input path = "name"/>
    <br>
    CHEESE =
    <form:input path = "cheese"/>
    <br>
    AGE =
    <form:input path = "age"/>
    <br>
    <input type="submit" value = "ok">
    <br>

</form:form>

    </body>
</html>