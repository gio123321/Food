package Servlet;

import Dao.UserDAO;
import Dao.UserDAOImpl;
import Enum.Gender;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gen = request.getParameter("gender");
        Gender gender = Gender.valueOf(gen);;
        if (name.isEmpty() || surname.isEmpty() || username.isEmpty() || password.isEmpty()) {
            request.setAttribute("registrationFailed", true);
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        } else if (!name.isEmpty() || !surname.isEmpty() || !username.isEmpty() || !password.isEmpty()) {
            User user = new User(name, surname, username, password, gender);
            UserDAO userDao = new UserDAOImpl();
            userDao.addUser(user);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}