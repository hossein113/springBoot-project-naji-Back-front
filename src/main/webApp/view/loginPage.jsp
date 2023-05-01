<%--
  Created by IntelliJ IDEA.
  User: Hossein
  Date: 10/27/2022
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../assets/css/loginPage.css">

</head>
</head>

<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"> Sign In </h2>


        <!-- Login Form -->
        <form method="post" action="/login">
            <input type="text" id="login" class="fadeIn second" name="username" placeholder="username">
            <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Log In">
            <h2 class="active"> ${message} </h2>

        </form>

        <!-- SIGN UP -->
        <div id="formFooter">
            <a class="underlineHover" href="/user/sign-up">Create Account</a>
        </div>

    </div>
</div>
<div class="wrapper fadeInDown">
    <div>
        <!-- Tabs Titles -->
        <h2 class="active"> Sign In </h2>
        <h2 class="inactive underlineHover">Sign Up </h2>


    </div>
</div>
</body>
</html>
