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
    <title>Home Page</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>

<table>
    <tr>
        <th>Id</th>
        <th>Exercise Id</th>
        <th>Description</th>
        <th>Created</th>
        <th>Detalis</th>
    </tr>
<c:forEach var="solution" items="${solutions}">
    <tr>
        <td>${solution.id}</td>
        <td>${solution.exercise_id}</td>
        <td>${solution.description}</td>
        <td>${solution.created}</td>
        <td><a href="details?solId=${solution.id}">${solution.id}</a></td>
    </tr>
</c:forEach>
</table>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
