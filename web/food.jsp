<%@page import="java.util.ArrayList"%>
<%@page import="Model.Ingredient"%>
<%@page import="Dao.FoodDAOImpl"%>
<%@page import="Dao.FoodDAO"%>
<%@page import="Model.Food"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            int id = Integer.parseInt((String) request.getAttribute("id"));
            FoodDAO dao = new FoodDAOImpl();
            Food food = dao.getFoodById(id);
            out.write("<title>" + food.getName() + "</title>");
        %>
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
        <form action="foodServlet" method="post">
            <div class="interface_main">
                <button type="submit" class="button_1" name="action" value="button1" formaction="Interface.jsp">მთავარი გვერდი</button>
                <button type="submit" class="button_1" name="action" value="button1" formaction="addfood.jsp">კერძის დამატება</button>
                <button type="submit" class="button_1" name="action" value="button1" formaction="addmenu.jsp">მენიუს დამატება</button>
                <button type="submit" class="button_1" name="action" value="button1" formaction="addfood.jsp">მენიუს შერჩევა</button>
            </div>
        </form>
        <form action="searchServlet" method="post" class="search_form">
            <input class="search" style="float:right" type="submit" value="ძებნა">
            <input class="search_1" style="float:right;font-size: 12px;" type="search" name="search">
        </form> 
        <%
            out.write("<div class=\"interface_2\">");

            out.write("<img src=\"Public/foto/foodline.jpg\" class=\"photo_food\">");
            out.write("<div style=\"display :inline-block;float: left\"><img src= \"Public/photos/" + food.getImagePath() +" \" class=\"food_photo\"></div>");

            out.write("<div class=\"food_name\" ><h1>" + food.getName() + "</h1>");
            out.write("<h3 style=\"float: left;\">" + "ტიპი: " + food.getFoodtype().toString() + "</h3>");
            out.write("</div>");

            out.write("<table>");
            out.write("<tr>");
            out.write("<th>სახელი</th>");
            out.write("<th>რაოდენობა</th>");
            out.write("<th></th>");
            out.write("<th>აღწერა</th>");
            out.write("</tr>");

            ArrayList<Ingredient> ins = food.getIngredients();
            out.write("<tr>");
            for (Ingredient in : ins) {
                out.write("<td>" + in.getName() + "</td>");
                out.write("<td>" + in.getQuantity() + "</td>");
                out.write("<td>" + in.getType() + "</td>");
                out.write("<td>" + in.getComment() + "</td>");
                out.write("</tr>");
            }
            out.write("</table>");

            out.write("<br>");

            out.write("<h2>მომზადების წესი</h2>");

            out.write("<h3 class=\"cooking_way\">" + food.getCooking_way() + "</h3>");
        %>
    </div>

</body>
</html>
