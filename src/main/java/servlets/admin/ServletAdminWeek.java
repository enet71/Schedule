package servlets.admin;

import db.Connect;
import factory.FactoryDB;
import factory.concreteFactories.*;
import table.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ServletAdminWeek extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Если параметр "id" в request пуст то он берется из cookies
     * Берет информацию из базы данных и создает коллецкии для каждого дня недели
     * Добавляет в request параметры дней недели и id группы
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Couple> list;
        FactoryDB factoryDB = new FactoryCouple();
        String id = request.getParameter("id");

        if(id == null) {
            Cookie cookies[] = request.getCookies();
            Cookie myCookie = null;
            if (cookies != null) {
                for (Cookie cooky : cookies) {
                    if (cooky.getName().equals("id")) {
                        myCookie = cooky;
                        break;
                    }
                }
            }
            assert myCookie != null;
            id = myCookie.getValue();
        }

        Connect connect = new Connect();

        list = factoryDB.tableSelect().getFullList("dayWeek = 2 and idGroup = " + id,connect);
        ArrayList<Couple>[] listMo = getList(list);

        list = factoryDB.tableSelect().getFullList("dayWeek = 3 and idGroup = " + id,connect);
        ArrayList<Couple>[] listTu = getList(list);

        list = factoryDB.tableSelect().getFullList("dayWeek = 4 and idGroup = " + id,connect);
        ArrayList<Couple>[] listWe = getList(list);

        list = factoryDB.tableSelect().getFullList("dayWeek = 5 and idGroup = " + id,connect);
        ArrayList<Couple>[] listTh = getList(list);

        list = factoryDB.tableSelect().getFullList("dayWeek = 6 and idGroup = " + id,connect);
        ArrayList<Couple>[] listFr = getList(list);

        list = factoryDB.tableSelect().getFullList("dayWeek = 7 and idGroup = " + id,connect);
        ArrayList<Couple>[] listSa = getList(list);

        connect.closeConnect();

        request.setAttribute("listMo", listMo);
        request.setAttribute("listTu", listTu);
        request.setAttribute("listWe", listWe);
        request.setAttribute("listTh", listTh);
        request.setAttribute("listFr", listFr);
        request.setAttribute("listSa", listSa);
        request.setAttribute("id", id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/adminWeek.jsp");
        dispatcher.forward(request, response);
    }


    /**
     * Групирует весь список по номеру пары
     * @param mainList Список пар
     * @return Массив списков типа "Couple"
     */
    private ArrayList<Couple>[] getList(ArrayList<Couple> mainList) {
        ArrayList<Couple>[] reList = new ArrayList[6];

        for (int i = 0; i < 6; i++) {
            ArrayList<Couple> l = new ArrayList<Couple>();
            for (int j = 0; j < mainList.size(); j++) {
                if (mainList.get(j).getNumber() == (i + 1)) {
                    l.add(mainList.get(j));
                }
                reList[i] = l;
            }
        }
        return reList;
    }
}
