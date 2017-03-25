<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>შესვლა</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="Public/css/style.css" type="text/css"/>
        <link rel="icon" type="image/png" href="Public/foto/icon2.png" />
        <style>
            body{
                background: url("Public/foto/bg1.png");
            }
        </style>
    </head>
    <body>
        <div class="add">
            <h2>სახელი</h2>
            <input type="text" name="name" /> <br>
            <h2>სურათი</h2>
            <input type='file' id="imgInp" />
            <h2>სახეობა</h2>
            <select name="gender" class="styled-select">
                    <option value="Food">საჭმელი</option>
                    <option value="Beverage">სასმელი</option>
            </select>
            <h2>ინგრედიენტები</h2>
            
            <h2>რეცეპტი</h2>
            <textarea rows="6" cols="60">მომზადების წესი</textarea>
            <button>დამატება</button>
        </div>
    </body>
</html>
