

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    Sandwich condiments
</h1>
<h2>
    <c:forEach var="condiment" items="${condiment}">
        ${condiment} <br>
    </c:forEach>
</h2>
</body>
</html>
