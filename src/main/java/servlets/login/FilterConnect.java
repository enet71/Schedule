package servlets.login;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterConnect implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    /**
     * ��������� ���������� �� ������. ���� ���� �� �������������� �� �������� �����.
     * ���� ���� �� ��������� ��������� �� ����� � ������. ���� ��������� �� ��������������
     * �� ������ ��������, ����� �������������� �� �������� �����.
     * @throws IOException
     * @throws ServletException
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getSession().getAttribute("name") == null) {
                res.sendRedirect("login");
        } else {
            String userName = (String) req.getSession().getAttribute("name");
            String userPassword = (String) req.getSession().getAttribute("password");
            if (userName.equals("admin") && userPassword.equals("admin")){
                chain.doFilter(request, response);
            }else {
                req.getSession().invalidate();
                res.sendRedirect("login");
            }
        }
    }

    public void destroy() {

    }
}
