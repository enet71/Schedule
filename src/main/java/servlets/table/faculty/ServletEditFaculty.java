package servlets.table.faculty;

import factory.FactoryDB;
import factory.concreteFactories.FactoryFaculty;
import factory.concreteFactories.FactoryGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletEditFaculty extends HttpServlet {

    /**
     * Редактирует факультет
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        FactoryDB factoryDB = new FactoryFaculty();
        factoryDB.tableEdit().updateTable(id,name);
        response.sendRedirect("/createFaculty");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
