package servlets.table.teacher;

import factory.FactoryDB;
import factory.concreteFactories.FactoryGroup;
import factory.concreteFactories.FactoryTeacher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletEditTeacher extends HttpServlet {
    /**
     * Берет данные из параметров request
     * Редактирует преподавателя
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String middleName = request.getParameter("middleName");
        FactoryDB factoryDB = new FactoryTeacher();
        factoryDB.tableEdit().updateTable(id,name,surname,middleName);
        response.sendRedirect("/createTeacher");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
