<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Panel</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/adminPanel.css"/>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <a href="admin panel.html"><img src="Images/user.png" width="150px" alt="Admin"></a>
            <ul><br>
                <li><a href="about us.html">Transactions</a></li>
                <li><a href="about us.html">Sales</a></li>
                <li><a href="about us.html">Products</a></li>
                <li><a href="about us.html">Customer Details</a></li>
                <li><a href="about us.html">Manage Users</a></li>
                <li><a href="about us.html">Logout</a></li>
            </ul>
        </div>
        <a href="<%=request.getContextPath()%>/add">Add Products</a>
    </div>
</body>
</html>
