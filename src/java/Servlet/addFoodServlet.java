package Servlet;

import Enum.FoodType;
import Enum.QuantityType;
import Model.Ingredient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addFoodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name1");
//image
//        String ftype = request.getParameter("type");
//        FoodType type = FoodType.valueOf(ftype);
//        String cookingWay = request.getParameter("cookingway");

        String quantity = request.getParameter("v");

//        if (quantity == 1) {
//            String Inname = request.getParameter("name1");
//            String IntypeStr = request.getParameter("type1");
//            int Inquantity = Integer.parseInt(request.getParameter("quantity1"));
//            QuantityType Intype = QuantityType.valueOf(IntypeStr);
//            String InComment = request.getParameter("comment1");
//
//            Ingredient in = new Ingredient(Inname, Inquantity, Intype, InComment);
//
//        } else if (quantity == 2) {
//            String Inname = request.getParameter("name2");
//            String IntypeStr = request.getParameter("type2");
//            int Inquantity = Integer.parseInt(request.getParameter("quantity2"));
//            String InComment = request.getParameter("comment2");
//            QuantityType Intype = QuantityType.valueOf(IntypeStr);
//
//            Ingredient in = new Ingredient(Inname, Inquantity, Intype, InComment);
//
//        }
        PrintWriter pw = response.getWriter();
        pw.append(quantity + " " + name);
    }
}
