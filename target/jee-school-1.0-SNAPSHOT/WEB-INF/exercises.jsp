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
    <title>Group</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>

<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Solution Description</th>
        <th>User ID</th>
    </tr>
    <c:forEach var="exercise" items="${exercises}">
        <tr>
            <td>${exercise.id}</td>
            <td>${exercise.title}</td>
            <td>${exercise.description}</td>
            <c:forEach var="solution" items="${solutions}">
                <td>${solution.description}</td>
                <td>${solution.user_id}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
