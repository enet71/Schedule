package servlets.table.faculty;

import factory.FactoryDB;
import factory.concreteFactories.FactoryAudience;
import factory.concreteFactories.FactoryFaculty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletRemoveFaculty extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        FactoryDB factoryDB = new FactoryFaculty();
        factoryDB.tableRemove().deleteTable(id);

        response.sendRedirect("/createFaculty");
    }
}
