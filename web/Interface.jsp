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
            <form action="interfaceServlet" method="post">
        <div class="interface_1">
            <button type="submit" class="button_1" name="action" value="button1" formaction="addfood.jsp">კერძის დამატება</button>
            <button type="submit" class="button_1" name="action" value="button1" formaction="addmenu.jsp">მენიუს დამატება</button>
            <button type="submit" class="button_1" name="action" value="button1" formaction="addfood.jsp">მენიუს შერჩევა</button>
            <input class="search" style="float:right" type="submit" value="ძებნა">
            <input class="search_1" style="float:right;font-size: 12px;" type="search" name="search">
        </div>
            </form>
        <div class="interface_2">
            <img src="Public/foto/interface.jpg" style="width:100%;">
            <div class="square_1" style="display: inline-block"></div>
            <div class="square_1" style="display: inline-block"></div>
            <div class="square_1" style="display: inline-block"></div>
            <div class="square_1" style="display: inline-block"></div>
            <div class="square_1" style="display: inline-block"></div>
            <div class="square_1" style="display: inline-block"></div>
            <div class="square_1" style="display: inline-block"></div>
            <div class="square_1" style="display: inline-block"></div>
        </div>
        </div>
    </body>
</html>
