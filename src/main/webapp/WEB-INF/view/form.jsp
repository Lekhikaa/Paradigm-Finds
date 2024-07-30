<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Products</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/form.css"/>
</head>
<body>
    <div class="form-container">
        <h2>Add Products</h2>
        <form id="myForm" action="add" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="productName" class="form-label">Product Name:</label>
                <input type="text" id="productName" name="productName" class="form-input" placeholder="Enter product name">
            </div>
            <div class="form-group">
                <label for="productCategory" class="form-label">Product Category:</label>
                <input type="text" id="productCategory" name="productCategory" class="form-input" placeholder="Enter product category">
            </div>
            <div class="form-group">
                <label for="productPrice" class="form-label">Product Price:</label>
                <input type="number" id="productPrice"  name="productPrice" class="form-input" placeholder="Enter product price">
            </div>
            <div class="form-group">
                <input type="file" name="image" accept="image/*">
        		<input type="submit" value="Upload">
            </div><br>
            <div class="form-group">
                <label for="productDescription" class="form-label">Product Description:</label>
                <textarea id="productDescription" name="productDescription" class="form-input" placeholder="Enter product description" rows="4"></textarea>
            </div>
            <button type="submit" class="form-submit">Submit</button>
        </form>
    </div>
</body>
</html>
