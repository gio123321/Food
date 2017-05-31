<%@page import="Dao.FoodDAOImpl"%>
<%@page import="java.util.Collections"%>
<%@page import="Dao.FoodDAO"%>
<%@page import="Model.Food"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>მენიუს შერჩევა</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="Public/css/style.css" type="text/css"/>
        <link rel="icon" type="image/png" href="Public/foto/icon2.png" />
        <style>
            body{
                background: url("Public/foto/bg1.jpg");
            }
        </style>
    </head>
    <body>
        <div class="interface_2">
                <img src="Public/foto/interface.jpg" style="width:100%;">
                <%
                    ArrayList<Food> searchFoods = (ArrayList) request.getAttribute("searchList");

                    if (searchFoods == null) {
                        ArrayList<Food> foods = new ArrayList<Food>();
                        FoodDAO dao = new FoodDAOImpl();
                        foods = dao.getAllFoods();
                        Collections.shuffle(foods);

                        for (int i = 0; i < 20; i++) {
                            int size = foods.size();
                            if (i >= size) {
                                break;
                            }
                            Food food = foods.get(i);

                            out.write("<form class=\"square_3\">");
                            out.write("<img src= \"" + "Public/photos/" + food.getImagePath() + "\" class=\"photo_2\" >");
                            out.write("<h2 class=\"choosefoods_name\"> " + food.getName().toString() + " </h2>");
                            out.write("<input type=\"checkbox\" class=\"checkbox_1\">");
                            out.write("</form>");
                        }
                    }
                %>
                <button class="button_choose">არჩევა</button>
        </div>
    </body>
</html>
