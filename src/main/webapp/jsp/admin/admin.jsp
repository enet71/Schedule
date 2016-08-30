<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="/menu"/>
<div id="cnt">
    <form action="/adminSelectFaculty" method="get">
        <input class="btn" type="submit" value="Edit Timetable">
    </form>
    <a href="jsp/admin/selectTable.jsp">
        <div class="btn">
            Add information
        </div>
    </a>
</div>
</body>
</html>
