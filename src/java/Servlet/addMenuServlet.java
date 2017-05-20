package Servlet;

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
        
        String name = request.getParameter("name");
        String sType = request.getParameter("type");
        MenuType type = MenuType.valueOf(sType);
        
        if(name.isEmpty()){
            request.setAttribute("addMenuFailed", true);
            RequestDispatcher rd = request.getRequestDispatcher("addmenu.jsp");
            rd.forward(request, response);
        }
    
    }
}
