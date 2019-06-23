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
        <th>Title</th>
        <th>Description</th>
    </tr>
    <c:forEach var="exercise" items="${exercises}">
        <tr>
            <td>${exercise.id}</td>
            <td>${exercise.title}</td>
            <td>${exercise.description}</td>
        </tr>
    </c:forEach>
</table>

<form action="panelExercises" method="post">
    <label>
        Wybierz opcję:
        <input type="radio" name="option" value="add"> Dodaj
        <input type="radio" name="option" value="edit"> Edytuj
    </label>
    <label>
        Podaj tytuł:
        <input type="text" name="title">
    </label>
    <label>
        Podaj opis:
        <input type="text" name="description">
    </label>
    <label>
        Podaj ID:
        <input type="number" name="id">
    </label>
    <input type="submit" value="send">
</form>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
