<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show car by id</title>
</head>
<body>

ID = ${car.id} |
BRAND = ${car.brand} |
MODEL = ${car.model} |
YEAR = ${car.year} |
PRICE = ${car.price}
<br>

<a href="${pageContext.request.contextPath}/showAllCars">
    return to main page
</a>

</body>
</html>
