<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${url}</title>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/${url}"
           modelAttribute="book" method="POST">

    <form:hidden path="id"/>
    Title = <form:input path="title"/><br>
    Author = <form:input path="author"/><br>
    Price = <form:input path="price"/><br>
    <input type="submit" value="ok">

</form:form>

</body>
</html>
