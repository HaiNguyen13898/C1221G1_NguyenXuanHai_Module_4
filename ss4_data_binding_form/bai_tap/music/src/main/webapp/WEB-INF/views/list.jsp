<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new song</title>
</head>
<body>
<center>
    <h1>
        List Song
    </h1>
    <h3>
        <a href="/create">Create song</a>
    </h3>
    <table border="1">
        <tr>
            <td>Name Song</td>
            <td>Name Singer</td>
            <td>kind Of Music</td>
        </tr>
        <c:forEach var="songs" items="${song}">
            <tr>
                <td>${songs.nameSong}</td>
                <td>${songs.nameSinger}</td>
                <td>${songs.kindOfMusic}</td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
