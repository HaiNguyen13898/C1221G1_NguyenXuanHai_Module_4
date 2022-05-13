
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create song</title>
</head>
<body>
<h1>Create new song</h1>
<form:form  modelAttribute="song" method="post">
    Name song: <form:input  type="text" path="nameSong" /> <br>
    Name singer: <form:input  type="text" path="nameSinger" /> <br>
    Kind of music: <form:select path="kindOfMusic" items="${kindOfMusic}"/> <br>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
