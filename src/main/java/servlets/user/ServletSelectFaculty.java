package servlets.user;

import db.FindPort;
import factory.FactoryDB;
import factory.concreteFactories.FactoryFaculty;
import table.Faculty;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServletSelectFaculty extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            FactoryDB factoryDB = new FactoryFaculty();
            ArrayList<Faculty> list = factoryDB.tableSelect().getList();
            request.setAttribute("list", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/user/selectFaculty.jsp");
            dispatcher.forward(request, response);
        }catch (Exception e){
            System.out.println("Connection Error");
            FindPort.start();
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/error/errorConnection.jsp");
            dispatcher.forward(request, response);
        }
    }
}
