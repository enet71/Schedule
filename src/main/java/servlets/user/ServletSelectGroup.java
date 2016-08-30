package servlets.user;

import factory.FactoryDB;
import factory.concreteFactories.FactoryGroup;
import table.Group;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletSelectGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String faculty = request.getParameter("faculty");

        FactoryDB commandFactory = new FactoryGroup();
        ArrayList<Group> listSub = commandFactory.tableSelect().getList("idFaculty = " + "'" + faculty + "'");
        request.setAttribute("listSub", listSub);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/user/selectGroup.jsp");
        dispatcher.forward(request, response);
    }
}
