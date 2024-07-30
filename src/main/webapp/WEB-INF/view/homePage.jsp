<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Paradigm finds</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Js/homePage.js"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Css/homePage.css"/>

</head>
<style></style>

<body>
    <header>
        <!-- putting a header -->

        <img src="IMAGE/Logo1.png" alt="" height="80px">
        <!--<h1 class="logo name">Paradigm finds</h1>-->
        <div class="search">
            <input type="text" id="search" placeholder=" Search in Paradigm">
        </div>

        <!-- creating a navigation bar -->


    </header>
    <nav>
        <ul>
            <li><a href="Home.html">Home</a></li>
            <li><a href="Product.html">Product</a></li>
            <li><a href="About Us.html">About us</a></li>
            <li><a href="User profile.html">User profile</a></li>
            <li><a href="Log out.html">Log out</a></li>

        </ul>
    </nav>
    <main>
        </div>
        <!-- creating a contaniner -->
        <!-- creating the container3 to make the slider -->
        <div class=" container1">
            <h2>Best selling products</h2>
            <div class="slide-container">

                <div class="slide">
                    <img src="IMAGE/nordwood-themes-F3Dde_9thd8-unsplash.jpg" alt="" height="600px" width="1300px">

                </div>

                <div class="slide">
                    <img src="IMAGE/robin-mcskelly-E_eRX8Phnto-unsplash.jpg" alt="" height="600px" width="1300px">

                </div>

                <div class="slide">
                    <img src="IMAGE/slider3.jpg" alt="" height="600px" width="1300px">

                </div>

                <div class="slide">
                    <img src="IMAGE/slider4.jpg" alt="" height="600px" width="1300px">

                </div>

                <div class="slide">
                    <img src="IMAGE/slider1.jpg" alt="" height="600px" width="1300px">

                </div>
                <div class="slide">
                    <img src="IMAGE/sharegrid-N10auyEVst8-unsplash.jpg" alt="" height="600px" width="1300px">

                </div>


                <span class="arrow1 prev" onclick="controller(-1)">&#10094;</span>
                <span class="arrow2 next" onclick="controller(1)">&#10095;</span>


            </div>
        </div>
        <div class="container2">
            <!-- using the span tag to change the color of particular words -->
            <h2><span style="color:#800f0f;">Paradigm Finds </span> offers varieties of camera with reliable price</h2>
            <!-- creatring the class to display differtent types of Camera  -->
            <div class="card">
                <c:forEach var="image" items="${listOfProducts }">
                <img src="data:image/jpeg;base64,${image.base64ImageData}" height="400px" width="400px"  alt="Uploaded Image">
    			<c:out value="${image.image_name }"></c:out>
  
    			</c:forEach>

            </div>
            
                



                
            </div>
        </div>

    </main>
    <footer>
        <div class="container4">

            <div class="link">

                <a href="About us.html">About us</a>
                <a href="Contact .html">Contact Us</a>
            </div>



        </div>
    </footer>


    <!-- <script src="script.js"></script> -->



</body>

</html>