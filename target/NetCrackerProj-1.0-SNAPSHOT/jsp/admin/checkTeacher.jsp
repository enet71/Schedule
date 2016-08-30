<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="css/admin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<jsp:include page="/menu"/>
<div class="main">
    At this time, the teacher has a lesson<br>

    <form action="createCouple" method="post">
        <input value="${subject}" type="hidden" name="subject">
        <input value="${group}" type="hidden" name="group">
        <input value="${number}" type="hidden" name="number">
        <input value="${audience}" type="hidden" name="audience">
        <input value="${begin}" type="hidden" name="begin">
        <input value="${end}" type="hidden" name="end">
        <input value="${dayWeek}" type="hidden" name="dayWeek">
        <input value="${star}" type="hidden" name="star">
        <input value="${teacher}" type="hidden" name="teacher">
        <input value="${type}" type="hidden" name="type">
        <input value="true" type="hidden" name="teacherCheck">
        <input class="btn" type="submit" value="Continue">
    </form>
    <input class="btn" onclick="window.history.back();" type="button" value="Return"/>

</div>
</body>
</html>
