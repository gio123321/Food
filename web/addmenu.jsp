<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>მენიუს დამატება</title>
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
        <form>
         <div class="interface_1">
                <button type="submit" class="button_1" name="action" value="button1" formaction="Interface.jsp">მთავარი გვერდი</button>
                <button type="submit" class="button_1" name="action" value="button1" formaction="addfood.jsp">კერძის დამატება</button>
                <button type="submit" class="button_1" name="action" value="button1" formaction="addmenu.jsp">მენიუს დამატება</button>
                <button type="submit" class="button_1" name="action" value="button1" formaction="addfood.jsp">მენიუს შერჩევა</button>
            </div>
        </form>
        <form align="center"  action="addMenuServlet" name="addMenuForm" method="post">
            <div class="add">
                <h1>მენიუს დამატება</h1>
                <h2>სახელი</h2>
                <input type="text" name="name"/>
                <br>
                <h2>მენიუს ტიპი</h2>
                <select name="type" class="styled-select">
                    <option value="test">test</option>
                </select>
                <h2>სასმელი</h2>
                <select name="type" class="styled-select">
                    <option value="test">test</option>
                </select>
                <div id='div'>
                    <br>
                    <br>

                </div>
                <button class="button_addfood">კერძების არჩევა</button>
                <br>
                <%
                    if (request.getAttribute("addMenuFailed") != null && request.getAttribute("addMenuFailed") == Boolean.TRUE) {
                        out.write("<p style=\"color:red;\">გთხოვთ შეავსოთ ყველა ველი!</p>");
                    }
                %>
            </div>
        </form>
    </body>
</html>
