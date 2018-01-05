<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/3
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <style type="text/css">
        *{
            margin: 0 auto;
        }
        .top{
            min-width: 1200px;
            max-width: 1920px;
            height: 70px;
            background-color: #ffffff;
        }

        .father{
            max-width: 1108px;
        }
        .logo>a{
            float: left;
            width: 30px;
            height: 30px;
            padding-top: 15px;
            padding-bottom: 25px;
        }
        .logo>a>img{
            width: 30px;
            height: 30px;
        }
        .tittle{
            float: left;
            margin-top: 19px;
            margin-left: 10px;
            font-size: 20px
        }
        .register{
            min-width: 1200px;
            max-width: 1920px;
            padding-top: 74px;
            background-color: #d9d9d9;
            height:800px;
        }
        #hint1{
            position: relative;
            bottom: 75px;
            left: 280px;
            color: red;
        }
        #hint2{
            position: relative;
            bottom: 28px;
            left: 280px;
            color: red;
        }

    </style>
</head>
<body>
<div class="top">

    <div class="father">
        <div class="logo">
            <a href="#"><img src="img/wyy.png"></a>
            <div class="tittle">用户注册</div>

        </div>
    </div>
</div>


<div class="register">
    <div class="father">
        <form action="register" method="post" class="register_form" style="background-color: white;">
            <div style="margin-left: -200px;margin-bottom: 50px; text-align: center;padding-top: 40px">邮箱注册</div>
            <div style="text-align: center;margin-left: -230px;">
                <label for="email" style="font-size: 15px;">邮箱地址&nbsp;&nbsp;</label>
                <input  onblur="onblurs1(this)" onfocus="onfocus1(this)" type="text" name="username" id="email" placeholder="请输入邮箱地址" style="height: 30px;width: 300px;margin-bottom: 50px">
                <p id="hint1"></p>
            </div>
            <div style="text-align: center;margin-left: -230px; margin-bottom: 20px">
                <label  for="password" style="font-size: 15px">登录密码&nbsp;&nbsp;</label>
                <input onblur="onblurs2(this)" onfocus="onfocus2(this)" type="password" name="password" id="password" placeholder="请输入登录密码" style="height: 30px;width: 300px">
                <p id="hint2"></p>
            </div>
            <div class="checkboox1" style="padding-left: 325px">
                <input checked type="checkbox" name="login" id="sever">
                <label for="sever" style="font-size: 12px">同意并遵守</label>
            </div>
            <button id="but" style="margin: 50px 0 50px 325px;color: white;background-color: #387ee8;width: 325px;height: 50px;font-size: 16px;line-height: 50px;">
                下一步
            </button>






        </form>
    </div>
</div>
</body>
<script type="text/javascript">
    var hint1 = document.getElementById("hint1");
    var hint2 = document.getElementById("hint2");
    function onfocus1(ele) {
        ele.style.fontSize = "20px";
        ele.style.border = "1px solid red";
        hint1.innerText = "请输入邮箱地址";
        hint1.style.fontSize = "15px";
    }

    function onblurs1(ele) {
        ele.style.fontSize = "14px";
        ele.style.border = "1px solid #d9d9d9";
        hint1.innerText = "";
    }
    function onfocus2(ele) {
        ele.style.fontSize = "20px";
        ele.style.border = "1px solid red";
        hint2.innerText = "请输入邮箱地址";
        hint2.style.fontSize = "15px";
    }

    function onblurs2(ele) {
        ele.style.fontSize = "14px";
        ele.style.border = "1px solid #d9d9d9";
        hint2.innerText = "";
    }

    var but = document.getElementById("but");
    but.onmousedown = function () {
        but.style.backgroundColor = '#'+Math.floor(Math.random()*0xffffff).toString(16);
    }


</script>
</html>