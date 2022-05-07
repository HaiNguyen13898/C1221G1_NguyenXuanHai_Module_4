<%--
  Created by IntelliJ IDEA.
  User: T470s
  Date: 5/7/2022
  Time: 7:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Health form</title>
</head>
<body>
<h2>Heath declaration</h2>
<h3>THIS IS IMPORTANT DOCUMENT, YOUR INFORMATION WILL HELP HEALTH AGENCIES CONTACT WHEN NECESSARY FOR PREVENTION OF
    COMMUNICATION DISEASE</h3>
<h4 style="color: red">Warning: Declaring false information is a violation of Vietnamese law and may result in criminal
    action</h4>

<center>
    <form:form action="create" modelAttribute="form" method="post">
        <fieldset>
        <table>
                <legend>Form heath declaration</legend>
                <tr>
                    <td>Full Name (Ghi in hoa nhé):</td>
                    <td>
                        <form:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>Date birth:</td>
                    <td>
                        <form:input type="date" path="birthDate"/>
                    </td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td>
                        <form:select path="gender" items="${gender}"/>
                    </td>
                </tr>
                <tr>
                    <td>Nationality:</td>
                    <td>
                        <form:select path="nationality" items="${nationality}"/>
                    </td>
                </tr>
                <tr>
                    <td>ID Card:</td>
                    <td>
                        <form:input path="idCard"/>
                    </td>
                </tr>
                <tr>
                    <td>Vehicle đi lại:</td>
                    <td>
                        <form:select path="vehicle" items="${vehicle}"/>
                    </td>
                </tr>
                <tr>
                    <td>Vehicle số hiệu:</td>
                    <td>
                        <form:input path="codeVehicle"/>
                    </td>
                </tr>
                <tr>
                    <td>Seats number:</td>
                    <td>
                        <form:input path="seats"/>
                    </td>
                </tr>
                <tr>
                    <td>Start day:</td>
                    <td>
                        <form:input type="date" path="startDay"/>
                    </td>
                </tr>
                <tr>
                    <td>End day:</td>
                    <td>
                        <form:input type="date" path="endDay"/>
                    </td>
                </tr>
                <tr>
                    <td>Have you gone anywhere in the past 14 days?</td>
                    <td>
                        <form:input path="exposureHistory"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Submit">
                    </td>
                </tr>
            </fieldset>
        </table>
    </form:form>
</center>
</body>
</html>
