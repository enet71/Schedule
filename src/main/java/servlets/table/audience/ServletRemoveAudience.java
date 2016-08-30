package servlets.table.audience;

import factory.FactoryDB;
import factory.concreteFactories.FactoryAudience;
import factory.concreteFactories.FactoryCouple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletRemoveAudience extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        FactoryDB factoryDB = new FactoryAudience();
        factoryDB.tableRemove().deleteTable(id);

        response.sendRedirect("/createAudience");
    }
}
