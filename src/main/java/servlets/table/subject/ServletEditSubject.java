package servlets.table.subject;

import factory.FactoryDB;
import factory.concreteFactories.FactorySubject;
import factory.concreteFactories.FactoryTeacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletEditSubject extends HttpServlet {

    /**
     * Берет данные из параметров request
     * Редактирует предмет
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        FactoryDB factoryDB = new FactorySubject();
        factoryDB.tableEdit().updateTable(id,name);
        response.sendRedirect("/createSubject");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
