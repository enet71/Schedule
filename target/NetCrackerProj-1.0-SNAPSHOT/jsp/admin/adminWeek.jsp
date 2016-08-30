<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Trial Services</title>
    <link href="/css/week.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<jsp:include page="/menu"/>
<div id="panel">
    <div id="topPanel">
        <div id="Mo">
            <table id='test'>
                <tr>
                    <th>
                        Monday
                    </th>
                </tr>
                <c:forEach var="i" begin="0" end="5">
                    <tr>
                        <td>
                            Lesson #${i + 1}<br>
                            <c:forEach var="var" items="${requestScope.listMo[i]}">
                                ${var.subject}<br>
                                ${var.audience}<br>
                                ${var.begin} - ${var.end}<br>
                                ${var.teacher}<br>
                                ${var.star}
                                <div class="coupleBtn">
                                    <form action="/removeCouple" method="get">
                                        <input type="hidden" name="id" value="${var.id}">
                                        <input type="hidden" name="group" value="${id}">
                                        <input type="submit" value="Remove">
                                    </form>
                                </div>
                                <br><br>
                                <hr/>
                            </c:forEach>
                            <form action="/createCouple" method="get">
                                <input type="hidden" name="dayWeek" value="2">
                                <input type="hidden" name="id" value="${id}">
                                <input type="hidden" name="number" value="${i+1}">
                                <input type="submit" value="Add">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div id="Tu">
            <table>
                <tr>
                    <th>
                        Tuesday
                    </th>
                </tr>
                <c:forEach var="i" begin="0" end="5">
                    <tr>
                        <td>
                            Lesson #${i + 1}<br>
                            <c:forEach var="var" items="${requestScope.listTu[i]}">
                                ${var.subject}<br>
                                ${var.audience}<br>
                                ${var.begin} - ${var.end}<br>
                                ${var.teacher}<br>
                                ${var.star}
                                <div class="coupleBtn">
                                    <form action="/removeCouple" method="get">
                                        <input type="hidden" name="id" value="${var.id}">
                                        <input type="hidden" name="group" value="${id}">
                                        <input type="submit" value="Remove">
                                    </form>
                                </div>
                                <br><br>
                                <hr/>
                            </c:forEach>
                            <form action="/createCouple" method="get">
                                <input type="hidden" name="dayWeek" value="3">
                                <input type="hidden" name="id" value="${id}">
                                <input type="hidden" name="number" value="${i+1}">
                                <input type="submit" value="Add">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="We">
            <table>
                <tr>
                    <th>
                        Wednesday
                    </th>
                </tr>
                <c:forEach var="i" begin="0" end="5">
                    <tr>
                        <td>
                            Lesson #${i + 1}<br>
                            <c:forEach var="var" items="${requestScope.listWe[i]}">
                                ${var.subject}<br>
                                ${var.audience}<br>
                                ${var.begin} - ${var.end}<br>
                                ${var.teacher}<br>
                                ${var.star}
                                <div class="coupleBtn">
                                    <form action="/removeCouple" method="get">
                                        <input type="hidden" name="id" value="${var.id}">
                                        <input type="hidden" name="group" value="${id}">
                                        <input type="submit" value="Remove">
                                    </form>
                                </div>
                                <br><br>
                                <hr/>
                            </c:forEach>
                            <form action="/createCouple" method="get">
                                <input type="hidden" name="dayWeek" value="4">
                                <input type="hidden" name="id" value="${id}">
                                <input type="hidden" name="number" value="${i+1}">
                                <input type="submit" value="Add">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="Th">
            <table>
                <tr>
                    <th>
                        Thursday
                    </th>
                </tr>
                <c:forEach var="i" begin="0" end="5">
                    <tr>
                        <td>
                            Lesson #${i + 1}<br>
                            <c:forEach var="var" items="${requestScope.listTh[i]}">
                                ${var.subject}<br>
                                ${var.audience}<br>
                                ${var.begin} - ${var.end}<br>
                                ${var.teacher}<br>
                                ${var.star}
                                <div class="coupleBtn">
                                    <form action="/removeCouple" method="get">
                                        <input type="hidden" name="id" value="${var.id}">
                                        <input type="hidden" name="group" value="${id}">
                                        <input type="submit" value="Remove">
                                    </form>
                                </div>
                                <br><br>
                                <hr/>
                            </c:forEach>
                            <form action="/createCouple" method="get">
                                <input type="hidden" name="dayWeek" value="5">
                                <input type="hidden" name="id" value="${id}">
                                <input type="hidden" name="number" value="${i+1}">
                                <input type="submit" value="Add">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="Fr">
            <table>
                <tr>
                    <th>
                        Friday
                    </th>
                </tr>
                <c:forEach var="i" begin="0" end="5">
                    <tr>
                        <td>
                            Lesson #${i + 1}<br>
                            <c:forEach var="var" items="${requestScope.listFr[i]}">
                                ${var.subject}<br>
                                ${var.audience}<br>
                                ${var.begin} - ${var.end}<br>
                                ${var.teacher}<br>
                                ${var.star}
                                <div class="coupleBtn">
                                    <form action="/removeCouple" method="get">
                                        <input type="hidden" name="id" value="${var.id}">
                                        <input type="hidden" name="group" value="${id}">
                                        <input type="submit" value="Remove">
                                    </form>
                                </div>
                                <br><br>
                                <hr/>
                            </c:forEach>
                            <form action="/createCouple" method="get">
                                <input type="hidden" name="dayWeek" value="6">
                                <input type="hidden" name="id" value="${id}">
                                <input type="hidden" name="number" value="${i+1}">
                                <input type="submit" value="Add">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div id="Sa">
            <table>
                <tr>
                    <th>
                        Saturday
                    </th>
                </tr>
                <c:forEach var="i" begin="0" end="5">
                    <tr>
                        <td>
                            Lesson #${i + 1}<br>
                            <c:forEach var="var" items="${requestScope.listSa[i]}">
                                ${var.subject}<br>
                                ${var.audience}<br>
                                ${var.begin} - ${var.end}<br>
                                ${var.teacher}<br>
                                ${var.star}
                                <div class="coupleBtn">
                                    <form action="/removeCouple" method="get">
                                        <input type="hidden" name="id" value="${var.id}">
                                        <input type="hidden" name="group" value="${id}">
                                        <input type="submit" value="Remove">
                                    </form>
                                </div>
                                <br><br>
                                <hr/>
                            </c:forEach>
                            <form action="/createCouple" method="get">
                                <input type="hidden" name="dayWeek" value="7">
                                <input type="hidden" name="id" value="${id}">
                                <input type="hidden" name="number" value="${i+1}">
                                <input type="submit" value="Add">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>


        </div>
    </div>
</div>

</body>
</html>

