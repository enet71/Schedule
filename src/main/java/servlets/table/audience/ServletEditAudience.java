package servlets.table.audience;

import factory.FactoryDB;
import factory.concreteFactories.FactoryAudience;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletEditAudience extends HttpServlet {
    /**
     * Получает из request параметры с информацией о аудитории
     * Редактирует аудиторию
     *
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String building = request.getParameter("building");
        String number = request.getParameter("number");
        FactoryDB factoryDB = new FactoryAudience();
        factoryDB.tableEdit().updateTable(id, building, number);
        response.sendRedirect("/createAudience");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
