<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="css/admin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="/menu" />
<div class="main">
    <c:forEach var="var" items="${requestScope.listSub}">
        <form action="/adminWeek" method="get">
            <input value="${var.id}" type="hidden" name="id">
            <input class="btn" type="submit"
                   value="Group: ${var.name} Course: ${var.course}">
        </form>
    </c:forEach>
</div>
</body>
</html>
