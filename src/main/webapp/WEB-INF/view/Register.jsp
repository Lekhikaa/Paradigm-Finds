<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/f900e1803b.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Css/Register.css">
    <title>Register</title>
</head>

<body>
        <div class="container">
        <div class="section1">
            <img src="./images/camera.jpg" alt="">
        </div>
       <form action="<%=request.getContextPath() %>/register" method="post">
        <div class="section2">
            <div class="block1">
                <h1>Register</h1>
            </div>
            <div class="frame1">
                <div class="blcontextPathock2">
                    <i class="fas fa-user"></i>
                    <input type="text" name="firstName" placeholder="Enter Firstname">
                </div>
                <div class="block3">
                    <i class="fas fa-lock"></i>
                    <input type="text" name="lastName" placeholder="Enter Lastname">
                </div>
            </div>
            <div class="frame2">
                <div class="block4">
                    <i class="fas fa-user"></i>
                    <input type="text" name="username" placeholder="Enter Username">
                </div>
                <div class="block5">
                    <i class="fas fa-user"></i>
                    <input type="date" name="birthday" placeholder="Enter Birthday">
                </div>
            </div>
            <div class="frame3">
                <div class="block6">
                    <i class="fas fa-user"></i>
                    <select name="gender" style="
                    margin-right: 10px;border-radius: 20px;height:40px;width:250px;">
                        <option value="Female">Male</option>
                        <option value="Female">Female</option>    
                    </select>   
                </div>
                <div class="block7">
                    <i class="fa-regular fa-envelope"></i>
                    <input type="text" name="email" placeholder="Email">
                </div>
            </div>    
            <div class="frame4">
                <div class="block8">
                    <i class="fa-solid fa-phone"></i>
                    <input type="text" name="phonenumber" placeholder="Phonenumber">
                        </div>
                <div class="block9">
                    <i class="fa-solid fa-location-dot"></i>
                    <input type="text" name="address" placeholder="Address">
                </div>
            </div>    
            <div class="frame5">
                    <div class="block10">
                        <i class="fa-solid fa-lock"></i>
                         <input type="text" name="password" placeholder="Password">
                            </div>
                    <div class="block11">
                        <i class="fa-solid fa-lock"></i>
                        <input type="text" name="confirmpassword" placeholder="Confirm Password">
                    </div>
            </div>        
            <div class="frame6">
                    <div class="block12">
                         <input type="checkbox">
                         <h6> I agree the Terms & Conditions</h6>
                        </div>
                    <div class="block13">
                        <button >Register</button>
                    </div>
                </div>    
            <div class="frame7">
               <h3> Don't have an account?</h3> <a href="login.html">Log In</a>
            </div>
                    
                
            </div>
            </form>
        </div>
        
    </div>
</body>

</html>