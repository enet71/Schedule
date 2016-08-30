package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletMenu extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("name") == null){
            request.setAttribute("login","<li><a href=\"/admin\">Login</a></li>");
        }else {
            request.setAttribute("login","<li><a href=\"/admin\">Edit</a></li><li><a href=\"javascript:document.form.submit();\">Logout</a></li>");
        }
        request.getRequestDispatcher("jsp/menu.jsp").include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("name") == null){
            request.setAttribute("login","<li><a href=\"/admin\">Login</a></li>");
        }else {
            request.setAttribute("login","<li><a href=\"/admin\">Edit</a></li><li><a href=\"javascript:document.form.submit();\">Logout</a></li>");
        }
        request.getRequestDispatcher("jsp/menu.jsp").include(request, response);
    }
}
