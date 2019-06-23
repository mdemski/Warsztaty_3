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
        <th>Username</th>
        <th>Email</th>
        <th>Solutions</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.email}</td>
        <c:forEach var="usersSolution" items="${usersSolutions}">
            <td>${usersSolution.description}</td>
        </c:forEach>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
