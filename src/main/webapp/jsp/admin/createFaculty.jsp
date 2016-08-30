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
        <form action="/createFaculty" method="post">
            <fieldset>
                <legend>Create Faculty</legend>
                Name:<br>
                <input maxlength="100" type="text" name="name" required><br>
                <input type="submit" value="Create">
            </fieldset>
        </form>
    </div>
    <div class="table">
        <c:forEach var="var" items="${requestScope.listSub}">
            <a href="#" class="list-group-item">${var.name}</a>

            <div id="${var.id}" class="bord">
                <form action="/editFaculty" method="post">
                    ID:<br>
                    <input value="${var.id}" type="text" name="id" readonly><br>
                    Name:<br>
                    <input maxlength="100" value="${var.name}" type="text" name="name" required><br>
                    <input type="submit" value="Edit">
                </form>
                <form action="/removeFaculty" method="get">
                    <input value="${var.id}" type="hidden" name="id"><br>
                    <input type="submit" value="Delete">
                </form>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
