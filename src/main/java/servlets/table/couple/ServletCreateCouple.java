package servlets.table.couple;

import factory.FactoryDB;
import factory.concreteFactories.*;
import other.DateEdit;
import table.Audience;
import table.Couple;
import table.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class ServletCreateCouple extends HttpServlet {
    /**
     * �������� �� request ��������� � ����
     * ��������� ������ �� ����������. ���� �������� �������� �� ������� ����� ����.
     * ���� �� �������� �� ���������� �� �������� ������.
     *
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subject = request.getParameter("subject");
        String group = request.getParameter("group");
        String number = request.getParameter("number");
        String audience = request.getParameter("audience");
        String begin = request.getParameter("begin");
        String dayWeek = request.getParameter("dayWeek");
        String formBegin = DateEdit.formatDate(begin, Integer.parseInt(dayWeek));
        String end = request.getParameter("end");
        String formEnd = DateEdit.formatDate(end, Integer.parseInt(dayWeek));
        String star = request.getParameter("star");
        String teacher = request.getParameter("teacher");
        String type = request.getParameter("type");
        String teacherCheck = request.getParameter("teacherCheck");
        String audienceCheck = request.getParameter("audienceCheck");

        if (teacherCheck == null) {
            teacherCheck = "false";
        }
        if (audienceCheck == null) {
            audienceCheck = "false";
        }

        FactoryDB factoryDB = new FactoryCouple();

        ArrayList<Couple> list = factoryDB.tableSelect().getList("idGroup = " + group + " and dayWeek = " + dayWeek);
        if (checkDate(formBegin, formEnd, list, Integer.parseInt(star), Integer.parseInt(number))) {
            list = factoryDB.tableSelect().getList();
            if (checkTeacher(formBegin, formEnd, list, Integer.parseInt(star), teacher, Integer.parseInt(number), Integer.parseInt(dayWeek)) || teacherCheck.equals("true")) {
                if (checkAudience(formBegin, formEnd, list, Integer.parseInt(star), audience, Integer.parseInt(number),Integer.parseInt(dayWeek)) || audienceCheck.equals("true")) {
                    factoryDB.tableCreate().insert(subject, group, number, audience, formBegin, formEnd, star, dayWeek, teacher, type);
                    Cookie cookie = new Cookie("id", group);
                    cookie.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookie);
                    response.sendRedirect("/adminWeek");
                } else {
                    request.setAttribute("subject", subject);
                    request.setAttribute("group", group);
                    request.setAttribute("number", number);
                    request.setAttribute("audience", audience);
                    request.setAttribute("begin", begin);
                    request.setAttribute("end", end);
                    request.setAttribute("dayWeek", dayWeek);
                    request.setAttribute("star", star);
                    request.setAttribute("teacher", teacher);
                    request.setAttribute("type", type);
                    request.setAttribute("teacherCheck", teacherCheck);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/checkAudience");
                    dispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("subject", subject);
                request.setAttribute("group", group);
                request.setAttribute("number", number);
                request.setAttribute("audience", audience);
                request.setAttribute("begin", begin);
                request.setAttribute("end", end);
                request.setAttribute("dayWeek", dayWeek);
                request.setAttribute("star", star);
                request.setAttribute("teacher", teacher);
                request.setAttribute("type", type);
                RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/checkTeacher.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("/error");
        }
    }


    /**
     * ����� ������ �� ���� ������ � ���������, ����������, �������������� � �������� �� � ��������� � ������� �������� � request
     *
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String dayWeek = request.getParameter("dayWeek");
        String number = request.getParameter("number");

        FactoryDB commandFactory = new FactorySubject();
        ArrayList<Subject> listSub = commandFactory.tableSelect().getList();
        commandFactory = new FactoryAudience();
        ArrayList<Audience> listAudience = commandFactory.tableSelect().getList();
        commandFactory = new FactoryTeacher();
        ArrayList<Audience> listTeacher = commandFactory.tableSelect().getList();


        request.setAttribute("listSub", listSub);
        request.setAttribute("listAudience", listAudience);
        request.setAttribute("listTeacher", listTeacher);
        request.setAttribute("id", id);
        request.setAttribute("dayWeek", dayWeek);
        request.setAttribute("number", number);

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/createCouple.jsp");
        dispatcher.forward(request, response);
    }


    /**
     * ��������� ��������� ����
     *
     * @param begin ���� ������ ����
     * @param end   ���� ��������� ����
     * @param list  ������ ���
     * @param star  ������� ������ (0 - ���������, 1 - ��������, 2 - ������)
     * @return ���� ���� �� ������� �� ������������ �� ���������� true
     */
    private static boolean checkDate(String begin, String end, ArrayList<Couple> list, int star, int number) {
        Calendar dateBegin = DateEdit.stringToDate(begin);
        Calendar dateEnd = DateEdit.stringToDate(end);
        Calendar dateBeginList;
        Calendar dateEndList;
        Boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            dateBeginList = DateEdit.stringToDate(list.get(i).getBegin());
            dateEndList = DateEdit.stringToDate(list.get(i).getEnd());
            if (number != list.get(i).getNumber()) {
                check = true;
            } else if ((dateBegin.getTimeInMillis() > dateEndList.getTimeInMillis() && dateEnd.getTimeInMillis() > dateEndList.getTimeInMillis()) || (dateBegin.getTimeInMillis() < dateBeginList.getTimeInMillis() && dateEnd.getTimeInMillis() < dateBeginList.getTimeInMillis())) {
                check = true;
            } else if (list.get(i).getStar() == star) {
                return false;
            } else if (star == 1 && list.get(i).getStar() == 2) {
                check = true;
            } else if (star == 2 && list.get(i).getStar() == 1) {
                check = true;
            } else {
                check = false;
            }

        }
        return check;
    }


    /**
     * ��������� �� ����� �� �������������
     *
     * @param begin   ���� ������ ����
     * @param end     ���� ��������� ����
     * @param list    ������ ���
     * @param star    ������� ������ (0 - ���������, 1 - ��������, 2 - ������)
     * @param teacher ������������� �������� ����� ���������
     * @return ���� ������������� �������� ���������� true
     */
    private boolean checkTeacher(String begin, String end, ArrayList<Couple> list, int star, String teacher, int number, int dayWeek) {
        Calendar dateBegin = DateEdit.stringToDate(begin);
        Calendar dateEnd = DateEdit.stringToDate(end);
        Calendar dateBeginList;
        Calendar dateEndList;
        Boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            dateBeginList = DateEdit.stringToDate(list.get(i).getBegin());
            dateEndList = DateEdit.stringToDate(list.get(i).getEnd());
            if (list.get(i).getTeacher().equals(teacher)) {
                if (dayWeek != list.get(i).getDayWeek()) {
                    check = true;
                } else if (number != list.get(i).getNumber()) {
                    check = true;
                } else if ((dateBegin.getTimeInMillis() > dateEndList.getTimeInMillis() && dateEnd.getTimeInMillis() > dateEndList.getTimeInMillis()) || (dateBegin.getTimeInMillis() < dateBeginList.getTimeInMillis() && dateEnd.getTimeInMillis() < dateBeginList.getTimeInMillis())) {
                    check = true;
                } else if (list.get(i).getStar() == star) {
                    return false;
                } else if (star == 1 && list.get(i).getStar() == 2) {
                    check = true;
                } else if (star == 2 && list.get(i).getStar() == 1) {
                    check = true;
                } else {
                    check = false;
                }
            }

        }
        return check;
    }


    /**
     * ��������� �� ������ �� ���������
     *
     * @param begin    ���� ������ ����
     * @param end      ���� ��������� ����
     * @param list     ������ ���
     * @param star     ������� ������ (0 - ���������, 1 - ��������, 2 - ������)
     * @param audience ��������� ������� ����� ���������
     * @return ���� ��������� ��������, ���������� true
     */
    private boolean checkAudience(String begin, String end, ArrayList<Couple> list, int star, String audience, int number, int dayWeek) {
        Calendar dateBegin = DateEdit.stringToDate(begin);
        Calendar dateEnd = DateEdit.stringToDate(end);
        Calendar dateBeginList;
        Calendar dateEndList;
        Boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            dateBeginList = DateEdit.stringToDate(list.get(i).getBegin());
            dateEndList = DateEdit.stringToDate(list.get(i).getEnd());
            if (list.get(i).getAudience().equals(audience)) {
                if (dayWeek != list.get(i).getDayWeek()) {
                    check = true;
                } else if (number != list.get(i).getNumber()) {
                    check = true;
                } else if ((dateBegin.getTimeInMillis() > dateEndList.getTimeInMillis() && dateEnd.getTimeInMillis() > dateEndList.getTimeInMillis()) || (dateBegin.getTimeInMillis() < dateBeginList.getTimeInMillis() && dateEnd.getTimeInMillis() < dateBeginList.getTimeInMillis())) {
                    check = true;
                } else if (list.get(i).getStar() == star) {
                    return false;
                } else if (star == 1 && list.get(i).getStar() == 2) {
                    check = true;
                } else if (star == 2 && list.get(i).getStar() == 1) {
                    check = true;
                } else {
                    check = false;
                }
            }

        }
        return check;
    }
}
