package servlets.table.group;

import factory.FactoryDB;
import factory.concreteFactories.FactoryFaculty;
import factory.concreteFactories.FactoryGroup;
import table.Faculty;
import table.Group;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletCreateGroup extends HttpServlet {


    /**
     * Беред данные из параметров request
     * Создает новую группу
     *
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        String faculty = request.getParameter("faculty");
        FactoryDB factoryDB = new FactoryGroup();
        factoryDB.tableCreate().insert(name, course, faculty);
        response.sendRedirect("/createGroup");
    }

    /**
     * Берет данные о группах и факультетах из базы добавляя их в коллекцию.
     * Добавляет коллекции в атрибуты request
     *
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FactoryDB commandFactory = new FactoryGroup();
        ArrayList<Group> listSub = commandFactory.tableSelect().getList();
        commandFactory = new FactoryFaculty();
        ArrayList<Faculty> listFac = commandFactory.tableSelect().getList();
        request.setAttribute("listSub", listSub);
        request.setAttribute("listFac", listFac);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/admin/createGroup.jsp");
        dispatcher.forward(request, response);
    }
}
