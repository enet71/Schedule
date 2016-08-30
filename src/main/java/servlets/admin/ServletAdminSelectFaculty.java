package servlets.admin;

import factory.FactoryDB;
import factory.concreteFactories.FactoryFaculty;
import table.Faculty;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletAdminSelectFaculty extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Добавляет в параметры request список факультетов.
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FactoryDB factoryDB = new FactoryFaculty();
        ArrayList<Faculty> list= factoryDB.tableSelect().getList();
        request.setAttribute("list",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/selectFaculty.jsp");
        dispatcher.forward(request, response);
    }
}
