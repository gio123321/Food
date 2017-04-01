package Servlet;

import Dao.FoodDAO;
import Dao.FoodDAOImpl;
import Enum.FoodType;
import Enum.QuantityType;
import Model.Food;
import Model.Ingredient;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addFoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String fname = request.getParameter("name");
            //image
            String ftype = request.getParameter("type");
            FoodType type = FoodType.valueOf(ftype);
            String cookingWay = request.getParameter("cookingway");

            String quantity1 = request.getParameter("quantity");
            int quantity = Integer.parseInt(quantity1);
            ArrayList<Ingredient> ins = new ArrayList<>();
            Ingredient in = null;

            for (int i = 1; i < quantity + 1; i++) {

                String iname = request.getParameter("name_" + i);
                String iquantitystr = request.getParameter("quantity_" + i);
                int iquantity = Integer.parseInt(iquantitystr);
                String itype = request.getParameter("type_" + i);
                String icomment = request.getParameter("comment_" + i);

                QuantityType intype = QuantityType.valueOf(itype);

                in = new Ingredient(iname, iquantity, intype, icomment);
                ins.add(in);
            }
            if (fname.isEmpty() || cookingWay.isEmpty()) {
                request.setAttribute("addFoodFailed", true);
                RequestDispatcher rd = request.getRequestDispatcher("addfood.jsp");
                rd.forward(request, response);
            } else {
                Food d = new Food(ins, fname, type, cookingWay);
                FoodDAO dao = new FoodDAOImpl();
                dao.addFood(d);
            }
        } catch (NumberFormatException ex) {
            request.setAttribute("addFoodFailed", true);
            RequestDispatcher rd = request.getRequestDispatcher("addfood.jsp");
            rd.forward(request, response);
        }
    }
}
