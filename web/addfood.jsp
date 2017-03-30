<%@page import="Model.Ingredient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>კერძის დამატება</title>
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
        <form align="center"  action="addFoodServlet" name="addFoodForm" method="post"><
            <div class="add">
                <h1>კერძის დამატება</h1>
                <h2>სახელი</h2>
                <input type="text" name="name"/> <br>
                <h2>სურათი</h2> 
                <input type='file' id="imgInp" />
                <h2>სახეობა</h2>
                <select name="type" class="styled-select">
                    <option value="Food">საჭმელი</option>
                    <option value="Beverage">სასმელი</option>
                </select>
                <div id='div'>
                    <h2>ინგრედიენტები</h2>
                    <button onclick="addBoxes()" id="btn">ახალი ინგრედიენტი</button>
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
                        document.getElementsByName("quantity").value = counter;
                        addBoxes = function () {

                            document.getElementById("btn").disabled = true;
                            for (var i = 0; i < getSelectedValue(); i++) {

                                var name = document.createElement("input");
                                var quantity = document.createElement("input");
                                var type = document.createElement("select");
                                var comment = document.createElement("textarea");


                                var opt1 = document.createElement("option");
                                var opt2 = document.createElement("option");
                                var br = document.createElement("br");

                                name.name = "name_" + counter;
                                quantity.name = "quantity_" + counter;
                                type.name = "type_" + counter;
                                comment.name = "comment_" + counter;

                                name.placeholder = document.getElementsByName("quantity").value;
                                quantity.placeholder = "რაოდენობა";
                                comment.placeholder = "კომენტარი";

                                opt1.value = "by_weight";
                                opt2.value = "by_retail";

                                opt1.innerHTML = "წონით";
                                opt2.innerHTML = "ცალობით";

                                type.appendChild(opt1);
                                type.appendChild(opt2);

                                document.getElementById("div").appendChild(name);
                                document.getElementById("div").appendChild(quantity);
                                document.getElementById("div").appendChild(type);
                                document.getElementById("div").appendChild(comment);
                                document.getElementById("div").appendChild(br);

                                name.style.marginRight = "5px";
                                quantity.style.marginRight = "5px";
                                type.style.marginRight = "5px";
                                comment.style.marginRight = "5px";
                                comment.style.marginTop = "5px";
                                comment.style.marginBottom = "15px";

                                br.style.marginBottom = "5px";
                                comment.cols = "60";

                                counter++;
                            }


                            return counter;
                        }
                        
                    </script>

                </div>
                <h2>რეცეპტი</h2>

                <textarea name="cookingway" rows="6" cols="60" id="text" placeholder="მომზადების წესი"></textarea>
                <button>დამატება</button>
            </div>
        </form>
    </body>
</html>
