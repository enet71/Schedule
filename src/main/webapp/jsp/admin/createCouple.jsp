<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <link href="css/create.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="/menu"/>
<div class="create">
    <div class="form">
        <form action="createCouple" method="post">
            <fieldset>
                <legend>Create couple</legend>
                Subject:<br>
                <select name="subject">
                    <c:forEach var="var" items="${requestScope.listSub}">
                        <option value="${var.id}">${var.name}</option>
                    </c:forEach>
                </select>
                <br>
                <input type="hidden" name="group" value="${id}">
                <input type="hidden" name="number" value="${number}">
                Audience:<br>
                <select name="audience">
                    <c:forEach var="var" items="${requestScope.listAudience}">
                        <option value="${var.id}">${var.number}</option>
                    </c:forEach>
                </select><br>
                Teacher:<br>
                <select name="teacher">
                    <c:forEach var="var" items="${requestScope.listTeacher}">
                        <option value="${var.id}">${var.name} ${var.surName}</option>
                    </c:forEach>
                </select><br>
                Type:<br>
                <select name="type">
                    <option value="passed">Passed</option>
                    <option value="Exam">Exam</option>
                </select><br>
                Begin:<br>
                <input type="week" name="begin" oninput="end.min=this.value"><br>
                End:<br>
                <input type="week" name="end" oninput="begin.max=this.value"><br>
                The parity:<br>
                <select name="star">
                    <option value="0">none</option>
                    <option value="1">odd</option>
                    <option value="2">even</option>
                </select><br><br>
                <input type="hidden" name="dayWeek" value="${dayWeek}">
                <input type="submit" value="Create">
            </fieldset>
        </form>
    </div>
</div>
<script src="/js/show.js"></script>
</body>
</html>

