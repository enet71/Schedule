package servlets.table.subject;

import factory.FactoryDB;
import factory.concreteFactories.FactorySubject;
import factory.concreteFactories.FactoryTeacher;
import table.Group;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletCreateSubject extends HttpServlet {

    /**
     * Беред данные из параметров request
     * Создает новый предмет
     *
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        FactoryDB factoryDB = new FactorySubject();
        factoryDB.tableCreate().insert(name);
        response.sendRedirect("/createSubject");
    }


    /**
     * Берет данные о предметах из базы добавляя их в коллекцию.
     * Добавляет коллекции в атрибуты request
     *
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FactoryDB commandFactory = new FactorySubject();
        ArrayList<Group> listSub = commandFactory.tableSelect().getList();
        request.setAttribute("listSub", listSub);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/createSubject.jsp");
        dispatcher.forward(request, response);
    }
}
