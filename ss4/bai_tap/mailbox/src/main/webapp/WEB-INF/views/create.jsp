<%--
  Created by IntelliJ IDEA.
  User: T470s
  Date: 5/5/2022
  Time: 10:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create email box</title>
</head>
<body>
<form:form action="/create" method="post" modelAttribute="mail">
    Languages: <form:select path="languages" items="${languages}"/> <br>
    Page size: show <form:select path="pageSizes" items="${pageSizes}" /> <br>
    Spams filter: <form:checkbox path="spamsFilter" value="emails per page"/> emails per page <br>
    Signature: <form:textarea path="signature"/> <br>
    <input type="submit" value="save">
</form:form>

</body>
</html>
