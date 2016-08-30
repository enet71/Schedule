<jsp:useBean id="mapToday" scope="request" type="java.util.Map"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <link href="/css/userWeek.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<jsp:include page="/menu" />
<div id="mainPanel">
    <form action="/allWeek" method="get">
        <input value="${id}" type="hidden" name="id">
        <input class="btn" type="submit" value="For a semester">
    </form>
    <div class="tablePanel">
        <table id='test'>
            <tr>
                <th class="${mapToday["2"]}">
                    Monday
                </th>
            </tr>
            <c:forEach var="i" begin="0" end="5">
                <tr>
                    <td>
                        <span class="coupleText">Lesson №${i + 1}</span><br>
                        <c:forEach var="var" items="${requestScope.listMo[i]}">
                            Subject: ${var.subject}<br>
                            Audience: ${var.audience}<br>
                            Teacher: ${var.teacher}<br>
                            <br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="tablePanel">
        <table>
            <tr>
                <th class="${mapToday["3"]}">
                    Tuesday
                </th>
            </tr>
            <c:forEach var="i" begin="0" end="5">
                <tr>
                    <td>
                        <span class="coupleText">Lesson №${i + 1}</span><br>
                        <c:forEach var="var" items="${requestScope.listTu[i]}">
                            Subject: ${var.subject}<br>
                            Audience: ${var.audience}<br>
                            Teacher: ${var.teacher}<br>
                            <br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="tablePanel">
        <table>
            <tr>
                <th class="${mapToday["4"]}">
                    Wednesday
                </th>
            </tr>
            <c:forEach var="i" begin="0" end="5">
                <tr>
                    <td>
                        <span class="coupleText">Lesson №${i + 1}</span><br>
                        <c:forEach var="var" items="${requestScope.listWe[i]}">
                            Subject: ${var.subject}<br>
                            Audience: ${var.audience}<br>
                            Teacher: ${var.teacher}<br>
                            <br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="tablePanel">
        <table>
            <tr>
                <th class="${mapToday["5"]}">
                    Thursday
                </th>
            </tr>
            <c:forEach var="i" begin="0" end="5">
                <tr>
                    <td>
                        <span class="coupleText">Lesson №${i + 1}</span><br>
                        <c:forEach var="var" items="${requestScope.listTh[i]}">
                            Subject: ${var.subject}<br>
                            Audience: ${var.audience}<br>
                            Teacher: ${var.teacher}<br>
                            <br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="tablePanel">
        <table>
            <tr>
                <th class="${mapToday["6"]}">
                    Friday
                </th>
            </tr>
            <c:forEach var="i" begin="0" end="5">
                <tr>
                    <td>
                        <span class="coupleText">Lesson №${i + 1}</span><br>
                        <c:forEach var="var" items="${requestScope.listFr[i]}">
                            Subject: ${var.subject}<br>
                            Audience: ${var.audience}<br>
                            Teacher: ${var.teacher}<br>
                            <br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="tablePanel">
        <table>
            <tr>
                <th class="${mapToday["7"]}">
                    Saturday
                </th>
            </tr>
            <c:forEach var="i" begin="0" end="5">
                <tr>
                    <td>
                        <span class="coupleText">Lesson №${i + 1}</span><br>
                        <c:forEach var="var" items="${requestScope.listSa[i]}">
                            Subject: ${var.subject}<br>
                            Audience: ${var.audience}<br>
                            Teacher: ${var.teacher}<br>
                            <br>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
        </table>


    </div>
</div>
</body>
</html>

