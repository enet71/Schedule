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
        <form action="createAudience" method="post">
            <fieldset>
                <legend>Create group</legend>
                Building:<br>
                <input maxlength="25" type="text" name="building" required><br>
                Number:<br>
                <input pattern="[0-9]{1,4}" maxlength="4" type="text" name="number" required><br><br>
                <input type="submit" value="Create">
            </fieldset>
        </form>
    </div>
    <div class="table">
        <c:forEach var="var" items="${requestScope.listSub}">
            <a href="#" class="list-group-item">${var.number}</a>

            <div id="${var.id}" class="bord">
                <form action="/editAudience" method="post">
                    ID:<br>
                    <input value="${var.id}" type="text" name="id" readonly><br>
                    Building:<br>
                    <input maxlength="25" value="${var.building}" type="text" name="building" required><br>
                    Number:<br>
                    <input pattern="[0-9]{1,4}" maxlength="4" value="${var.number}" type="text" name="number"
                           required><br><br>
                    <input type="submit" value="Edit">
                </form>
                <form action="/removeAudience" method="get">
                    <input value="${var.id}" type="hidden" name="id"><br>
                    <input type="submit" value="Delete">
                </form>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
