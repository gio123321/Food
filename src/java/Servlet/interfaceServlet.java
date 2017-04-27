package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class interfaceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("1");
        PrintWriter p = resp.getWriter();
        if ("კერძის დამატება".equals(action)) {
            p.append("1");
        } else if ("მენიუს დამატება".equals(action)) {
            p.append("2");
        } else if ("მენიუს შერჩევა".equals(action)) {
            p.append("3");
        }
    }

}
