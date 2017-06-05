<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                   
                </div>
            </form>
            <form action="searchMenusServlet" method="post" class="search_form">
                <input class="search" style="float:right" type="submit" value="ძებნა">
                <input class="search_1" style="float:right;font-size: 12px;" type="search" name="search" placeholder="მენიუს ძებნა">
            </form>
            <div class="interface_2">
                <img src="Public/foto/interface.jpg" style="width:100%; height:250px;">
            </div>
            
        </div>
    </body>
</html>