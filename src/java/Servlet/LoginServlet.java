package Servlet;

import Dao.UserDAO;
import Dao.UserDAOImpl;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getUser(username, password);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();

        if (user == null) {
            pw.append("სახელი ან პაროლი არასწორია!");
        } else {

            pw.append("გამარჯობა " + user.getName());

        }
    }
}
