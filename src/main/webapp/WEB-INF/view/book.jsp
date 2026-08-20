<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show One Book (by id)</title>
</head>
<body>

Book Title ${book.title}
<br>
Book Autor ${book.author}
<br>
Book Price ${book.price}
<br>
Book ID ${book.id}
<br>

<a href="${pageContext.request.contextPath}/showAllBooks">На головну сторінку</a>

</body>
</html>