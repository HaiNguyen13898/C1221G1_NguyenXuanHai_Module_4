<%--
  Created by IntelliJ IDEA.
  User: T470s
  Date: 5/4/2022
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich list</title>
</head>
<body>
<form action="/save" method="get">
    <div>
        <input type="checkbox" name="condiment" value="lettuce"> Lettuce

        <input type="checkbox" name="condiment" value="tomato"> Tomato

        <input type="checkbox" name="condiment" value="mustard"> Mustard

        <input type="checkbox" name="condiment" value="sprouts"> Sprouts
    </div>
    <input type="submit" value="Save">
</form>
</body>
</html>
