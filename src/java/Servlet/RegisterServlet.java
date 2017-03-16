package Servlet;

import Dao.UserDAO;
import Dao.UserDAOImpl;
import Enum.Gender;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String s = request.getParameter("gender");
        Gender g = null;
 
        if (s.equals("male")) {
            g = Gender.male;
        } else if(s.equals("female")){
            g = Gender.female;
        }

        User user = null;

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();

        if (name.isEmpty() || surname.isEmpty() || username.isEmpty() || password.isEmpty()) {
            pw.append("შეავსეთ ყველა ველი!");
        } else if (!name.isEmpty() || !surname.isEmpty() || !username.isEmpty() || !password.isEmpty()) {
            
            user = new User(name, surname, username, password, g);
            UserDAO userDao = new UserDAOImpl();
            userDao.addUser(user);
            pw.append("added");
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
           
            rd.forward(request, response);
        }
        
        }
      

}
