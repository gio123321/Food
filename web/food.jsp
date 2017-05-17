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
        <title>rame</title>
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
        <div class="interface_2">
            <%
                out.write("<img src=\"" + "Public/photos/" + food.getImagePath() + " \"class=\"food_photo\"");
                out.write("<h1 style=\"display: inline-block\">" + food.getName() + "</h1");
            %>
        </div>

    </body>
</html>
