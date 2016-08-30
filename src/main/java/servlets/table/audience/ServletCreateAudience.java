package servlets.table.audience;

import factory.FactoryDB;
import factory.concreteFactories.FactoryAudience;
import table.Audience;
import table.Group;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletCreateAudience extends HttpServlet {

    /**
     * Получает параметры из request
     * Добавляет новую аудиторию в базу данных
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String building = request.getParameter("building");
        String number = request.getParameter("number");
        FactoryDB factoryDB = new FactoryAudience();
        factoryDB.tableCreate().insert(building,number);
        response.sendRedirect("/createAudience");
    }

    /**
     * Получает информацию о аудиториях из базы данных
     * Создает атрибут в request коллекции аудиторий
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FactoryDB factoryDB = new FactoryAudience();
        ArrayList<Audience> listSub = factoryDB.tableSelect().getList();
        request.setAttribute("listSub", listSub);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/admin/createAudience.jsp");
        dispatcher.forward(request, response);
    }
}
