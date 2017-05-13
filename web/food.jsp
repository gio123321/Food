<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <form action="interfaceServlet" method="post">
                <div class="interface_1">
                    <button type="submit" class="button_1" name="action" value="button1" formaction="Interface.jsp">მთავარი გვერდი</button>
                    <button type="submit" class="button_1" name="action" value="button1" formaction="addfood.jsp">კერძის დამატება</button>
                    <button type="submit" class="button_1" name="action" value="button1" formaction="addmenu.jsp">მენიუს დამატება</button>
                    <button type="submit" class="button_1" name="action" value="button1" formaction="addfood.jsp">მენიუს შერჩევა</button>
                    <input class="search" style="float:right" type="submit" value="ძებნა">
                    <input class="search_1" style="float:right;font-size: 12px;" type="search" name="search">
                </div>
        </form>
        <div class="interface_2">
            <img src="Public/photos/A2u0Ixo1377474908.jpg" class="food_photo">
            <h1 style="display: inline-block">saxeli</h1>
        </div>
        
    </body>
</html>
