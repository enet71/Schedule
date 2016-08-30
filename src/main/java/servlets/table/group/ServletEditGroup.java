package servlets.table.group;

import factory.FactoryDB;
import factory.concreteFactories.FactoryGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletEditGroup extends HttpServlet {
    /**
     * Берет данные из параметров request
     * Редактирует группу
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        String faculty = request.getParameter("faculty");
        FactoryDB factoryDB = new FactoryGroup();
        factoryDB.tableEdit().updateTable(id,name,course,faculty);
        response.sendRedirect("/createGroup");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
