package servlets.table.group;

import factory.FactoryDB;
import factory.concreteFactories.FactoryFaculty;
import factory.concreteFactories.FactoryGroup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ServletRemoveGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        FactoryDB factoryDB = new FactoryGroup();
        factoryDB.tableRemove().deleteTable(id);

        response.sendRedirect("/createGroup");
    }
}
