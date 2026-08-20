
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${info}</title>
</head>
<body>

<H2>${info}</H2>

<form:form action="${pageContext.request.contextPath}/${url}" modelAttribute="user" method="POST">

  <form:hidden path="id"/>

  <form:label path="name">Name:</form:label>
  <form:input path="name" />
  <br><br>

  <form:label path="email">Email:</form:label>
  <form:input path="email" />
  <br><br>

  <input type="submit" value="Save"/>
</form:form>

</body>
</html>
