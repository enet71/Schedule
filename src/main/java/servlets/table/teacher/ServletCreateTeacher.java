package servlets.table.teacher;

import factory.FactoryDB;
import factory.concreteFactories.FactoryTeacher;
import table.Group;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletCreateTeacher extends HttpServlet {
    /**
     * Беред данные из параметров request
     * Создает нового преподавателя
     *
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String middleName = request.getParameter("middleName");
        FactoryDB factoryDB = new FactoryTeacher();
        factoryDB.tableCreate().insert(name, surname, middleName);
        response.sendRedirect("/createTeacher");
    }

    /**
     * Берет данные о преподавателях из базы добавляя их в коллекцию.
     * Добавляет коллекции в атрибуты request
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FactoryDB commandFactory = new FactoryTeacher();
        ArrayList<Group> listSub = commandFactory.tableSelect().getList();
        request.setAttribute("listSub", listSub);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/createTeacher.jsp");
        dispatcher.forward(request, response);
    }
}
