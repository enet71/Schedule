package servlets.table.faculty;

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

public class ServletCreateFaculty extends HttpServlet {
    /**
     * Создает новый факультет
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        FactoryDB factoryDB = new FactoryFaculty();
        factoryDB.tableCreate().insert(name);
        response.sendRedirect("/createFaculty");
    }


    /**
     * Берет данные из базы данних о факультетах и добавляет их в коллекцию.
     * Создает атрибут request с коллекцией.
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FactoryDB commandFactory = new FactoryFaculty();
        ArrayList<Faculty> listSub = commandFactory.tableSelect().getList();
        request.setAttribute("listSub", listSub);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/createFaculty.jsp");
        dispatcher.forward(request, response);
    }
}
