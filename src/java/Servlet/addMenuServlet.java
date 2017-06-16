package Servlet;

import Enum.BeverageType;
import Enum.MenuType;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addMenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String sType = request.getParameter("type");
        String beverage = request.getParameter("beverage");

        if (name.isEmpty()) {
            request.setAttribute("addMenuFailed", true);
            RequestDispatcher rd = request.getRequestDispatcher("addmenu.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("name", name);
            request.setAttribute("type", sType);
            request.setAttribute("beverage", beverage);
            RequestDispatcher rd = request.getRequestDispatcher("chooseFoods.jsp");
            rd.forward(request, response);
        }
    }
}
