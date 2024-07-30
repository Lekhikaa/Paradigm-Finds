<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/f900e1803b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/Css/login.css">
    <title>Log In</title>
</head>
<body>
    <div class="container">
        <div class="section1">
            <img src="IMAGE/camera.jpg" alt="">
        </div>
                     <form action="<%=request.getContextPath()%>/login" method="post">
        <div class="section2">
           <div class="block1">
                <h1>Log In</h1>

           </div>
           <div class="block2">
            <i class="fas fa-user"></i>
            <input type="text" name="username" placeholder="Enter Username">
           </div>
           <div class="block3">
            <i class="fas fa-lock"></i>
            <input type="text" name="password" placeholder="Enter Password">
           </div>
           <div class="block4" style="
           margin-top: -15px;margin-left: 160px;">
            <a href="#">Forgot Password?</a>
           </div>
           <div class="block5">
            <button type="submit" name="submit" >Log In</button>
           </div>
           <div class="block6">
            <h3>Don't have an account? </h3><a href="<%=request.getContextPath()%>/register">Register</a>
           </div>
           <div class="block7">
            <h3>Or Sign In with social platform</h3>
           </div>
           <div class="block8">
            <i class="fa-brands fa-facebook"></i>
            <i class="fa-brands fa-twitter"></i>
            <i class="fa-brands fa-instagram"></i>
            <i class="fa-brands fa-linkedin"></i>
           </div>

        </div>
        </form>
    </div>
</body>
</html>