<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>
    Calculator
    ${message}
</h1>

<form action="/result" method="get">
    <div>
        <input type="text" name="a">
        <input type="text" name="b">
    </div>
<div>
    <input type="submit" name="cal" value="Addition(+)">
    <input type="submit" name="cal" value="Subtraction(-)">
    <input type="submit" name="cal" value="Multiplication(x)">
    <input type="submit" name="cal" value="Division(/)">
</div>

</form>

<h2>
    Result Division: ${result}
</h2>


</body>
</html>
