package Servlet;

import Dao.FoodDAO;
import Dao.FoodDAOImpl;
import Model.Food;
import Model.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import processor.MenuProcessor;

public class searchMenusServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String search = request.getParameter("search");

        
        ArrayList<Menu> menus = MenuProcessor.getMenusByName(search);
        request.setAttribute("searchList", menus);

        RequestDispatcher rd = request.getRequestDispatcher("chooseMenus.jsp");
        rd.forward(request, response);

    }

}
