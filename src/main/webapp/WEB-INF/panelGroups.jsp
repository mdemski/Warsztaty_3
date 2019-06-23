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
        <th>Name</th>
        <th>Group members</th>
    </tr>
    <c:forEach var="group" items="${groups}">
        <tr>
            <td>${group.id}</td>
            <td>${group.name}</td>
            <td><a href="group?grId=${group.id}">${group.id}</a></td>
        </tr>
    </c:forEach>
</table>

<form action="panelGroups" method="post">
    <label>
        Wybierz opcję:
        <input type="radio" name="option" value="add"> Dodaj
        <input type="radio" name="option" value="edit"> Edytuj
    </label>
    <label>
        Podaj nazwę:
        <input type="text" name="name">
    </label>
    <label>
        Podaj ID grupy:
        <input type="number" name="id">
    </label>
    <input type="submit" value="send">
</form>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
