<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL BOOKS</title>
</head>
<body>

<c:forEach var = "car" items = "${cars}">

    ID = ${car.id} |
    BRAND = ${car.brand} |
    MODEL = ${car.model} |
    YEAR = ${car.year} |
    PRICE = ${car.price} |
    <a href = "${pageContext.request.contextPath}/deleteCarById?id=${car.id}">DELETE</a> |
    <a href = "${pageContext.request.contextPath}/updateExistedCar?id=${car.id}">UPDATE</a>
    <br>

</c:forEach>

<a href = "${pageContext.request.contextPath}/createNewCar">
    create new car
</a>
</body>
</html>
