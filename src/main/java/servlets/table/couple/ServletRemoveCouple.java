package servlets.table.couple;

import factory.FactoryDB;
import factory.concreteFactories.FactoryCouple;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletRemoveCouple extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    /**
     * Удаляет пару по id взятого из параметра request
     *
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String group = request.getParameter("group");
        System.out.println(group);
        FactoryDB factoryDB = new FactoryCouple();
        factoryDB.tableRemove().deleteTable(id);
        Cookie cookie = new Cookie("id", group);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        response.sendRedirect("/adminWeek");
    }
}
