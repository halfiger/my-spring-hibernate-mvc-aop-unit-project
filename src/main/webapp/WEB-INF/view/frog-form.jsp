<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<H1>${title}</H1> <br>
<form:form
        action="${pageContext.request.contextPath}${url}"
        modelAttribute="frog"
        method="POST" >

    <form:hidden path="id"/> <br>
    Name = <form:input path="name"/><br>
    Color = <form:input path="color"/><br>
    Age = <form:input path="age"/><br>
    <input type="submit" value="ok"> <br>
</form:form>

<a href="${pageContext.request.contextPath}/getFrogs">go home</a>

</body>
</html>
