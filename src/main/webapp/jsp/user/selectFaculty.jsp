<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="/menu" />
<div class="main">
    SELECT FACULTY<br>
    <c:forEach var="var" items="${requestScope.list}">
        <form action="/selectGroup" method="get">
            <input value="${var.id}" type="hidden" name="faculty">
            <input class="btn" type="submit" value="${var.name}">
        </form>
    </c:forEach>
</div>
</body>
</html>
