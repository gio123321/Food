<%@page import="javax.websocket.OnError"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="org.apache.catalina.ha.backend.CollectedInfo"%>
<%@page import="Model.Ingredient"%>
<%@page import="org.apache.jasper.JasperException"%>
<%@page import="java.io.IOException"%>
<%@page import="Dao.FoodDAOImpl"%>
<%@page import="Dao.FoodDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Food"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>მთავარი გვერდი</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="Public/css/style.css" type="text/css"/>
        <link rel="icon" type="image/png" href="Public/foto/icon2.png" />
        <style>
            body{
                background: url("Public/foto/bg2.jpg");
            }
        </style>
    </head>
    <body>
        <div>
            <form>
                <div class="interface_main">
                    <button type="submit" class="button_1" name="action" value="button1" formaction="Interface.jsp">მთავარი გვერდი</button>
                    <button type="submit" class="button_1" name="action" value="button1" formaction="addfood.jsp">კერძის დამატება</button>
                    <button type="submit" class="button_1" name="action" value="button1" formaction="addmenu.jsp">მენიუს დამატება</button>
                    <button type="submit" class="button_1" name="action" value="button1" formaction="chooseMenus.jsp">მენიუს შერჩევა</button>
                </div>
            </form>
            <form action="searchServlet" method="post" class="search_form">
                <input style="float:right" class="search_button" type="submit" value="ძებნა">
                <input class="search_1" style="float:right;font-size: 12px;" type="search" name="search" placeholder="კერძის ძებნა">
            </form>
            <div class="interface_2">
                <img src="Public/foto/interface.jpg" style="width:100%; height:250px;">
                <%
                    ArrayList<Food> searchFoods = (ArrayList) request.getAttribute("searchList");

                    if (searchFoods == null) {
                        ArrayList<Food> foods = new ArrayList<Food>();
                        FoodDAO dao = new FoodDAOImpl();
                        foods = dao.getAllFoods();
                        Collections.shuffle(foods);

                        for (int i = 0; i < 6; i++) {
                            int size = foods.size();
                            if (i >= size) {
                                break;
                            }
                            Food food = foods.get(i);

                            out.write("<form class=\"square_1\" action=\"interfaceServlet\" method=\"post\">");
                            out.write("<img src= \"" + "Public/photos/" + food.getImagePath() + "\" class=\"photo\" onerror=\"this.src='Public/foto/icon2.png'\">");

                            out.write("<p class=\"head\"> " + food.getName().toString() + " </p>");

                            out.write("<p class=\"text_div\">" + "ტიპი: " + food.getFoodtype().toString() + " </p>");
                            String ingredient_names = "";
                            ArrayList<Ingredient> ins = food.getIngredients();
                            for (Ingredient in : ins) {
                                ingredient_names += in.getName() + ",";
                            }
                            ingredient_names = ingredient_names.substring(0, ingredient_names.length() - 1);
                            out.write("<p class=\"text_div2\" display:inline>" + "ინგრედიენტები: " + ingredient_names + "</p>");
                            out.write("<input name=\"foodId\" type=\"hidden\" value=\"" + food.getId() + "\"/>");
                            out.write("<button class=\"div_button\" maxlength=\"10\"  >ვრცლად</button>");
                            out.write("</form>");
                        }
                    } else if (searchFoods != null) {
                        if (searchFoods.isEmpty()) {
                            out.write("<p class=\"foodnotfoundlabel\">კერძი ვერ მოიძებნა</p>");
                        }
                        for (int i = 0; i < searchFoods.size(); i++) {
                            int size = searchFoods.size();
                            if (i >= size) {
                                break;
                            }
                            Food food = searchFoods.get(i);

                            out.write("<form class=\"square_1\" action=\"interfaceServlet\" method=\"post\">");
                            out.write("<img src= " + "Public/photos/" + food.getImagePath() + " class=\"photo\" onerror=\"this.src='Public/foto/icon2.png'\" >");
                            out.write("<p class=\"head\"> " + food.getName() + " </p>");

                            out.write("<p class=\"text_div\">" + "ტიპი: " + food.getFoodtype().toString() + " </p>");
                            String ingredient_names = "";
                            ArrayList<Ingredient> ins = food.getIngredients();
                            for (Ingredient in : ins) {
                                ingredient_names += in.getName() + ",";
                            }
                            ingredient_names = ingredient_names.substring(0, ingredient_names.length() - 1);
                            out.write("<p class=\"text_div2\" display:inline>" + "ინგრედიენტები: " + ingredient_names + "</p>");
                            out.write("<input name=\"foodId\" type=\"hidden\" value=\"" + food.getId() + "\"/>");
                            out.write("<button class=\"div_button\" maxlength=\"10\"  >ვრცლად</button>");
                            out.write("</form>");
                        }
                    }
                %>
            </div>
        </div>
    </body>
</html>