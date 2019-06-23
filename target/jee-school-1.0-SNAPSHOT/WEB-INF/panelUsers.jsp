<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MarDem
  Date: 2019-05-25
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Solution details</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>

<table>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Email</th>
        <th>Group ID</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td>${user.userGroupId}</td>
        </tr>
    </c:forEach>
</table>

<form action="panelUsers" method="post">
    <label>
        Wybierz opcję:
        <input type="radio" name="option" value="add"> Dodaj
        <input type="radio" name="option" value="edit"> Edytuj
    </label>
    <label>
        Podaj nazwę:
        <input type="text" name="username">
    </label>
    <label>
        Podaj email:
        <input type="text" name="email">
    </label>
    <label>
        Podaj password:
        <input type="text" name="password">
    </label>
    <label>
        Podaj ID:
        <input type="number" name="id">
    </label>
    <label>
        Podaj ID grupy:
        <input type="number" name="userGroupId">
    </label>
    <input type="submit" value="send">
</form>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
