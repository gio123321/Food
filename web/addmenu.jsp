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
        <form align="center"  action="addMenuServlet" name="addMenuForm" method="post"><
            <div class="add">
                <h1>მენიუს დამატება</h1>
                <h2>სახელი</h2>
                <input type="text" name="name"/>
                <br>
                <h2>მენიუს ტიპი</h2>
                <select name="type" class="styled-select">
                    <option value="test">test</option>
                </select>
                <div id='div'>
                    <h2>კერძები</h2>
                    რაოდენობა
                    <select id="inQuantity" name="quantity"> 
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                    <br>
                    <br>
                    <script>
                        
                        function getSelectedValue() {
                            var selector = document.getElementById("inQuantity");
                            var value = selector[selector.selectedIndex].value;
                            return value;
                        }
                        
                        var counter = 1;

                        addBoxes = function () {

                            document.getElementById("btn").disabled = true;
                            for (var i = 0; i < getSelectedValue(); i++) {

                            }

                        }

                    </script>

                </div>
                <button>დამატება</button>
                <%
                    if (request.getAttribute("addFoodFailed") != null && request.getAttribute("addFoodFailed") == Boolean.TRUE) {
                        out.write("<p style=\"color:red;\">გთხოვთ შეავსოთ ყველა ველი!</p>");
                    }
                %>
            </div>
        </form>
    </body>
</html>
