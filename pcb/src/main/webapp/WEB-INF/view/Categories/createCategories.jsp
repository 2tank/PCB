<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CREATE NEW CATEGORY</title>
    <link rel="stylesheet" href="styleCreateCategory.css">

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 20px;
        }
        .header {
            background-color: #F37CD099;
            color: #fff;
            text-align: center;
            padding: 15px;
            font-size: 1.5em;
        }
        .category-details {
            padding: 20px;
        }
        .category-row {
            display: flex;
            justify-content: space-between;
            padding: 8px 0;
            border-bottom: 1px solid #ddd;
        }
        .category-row:last-child {
            border-bottom: none;
        }
        .label {
            font-weight: bold;
            color: #555;
        }
        .value {
            color: #333;
            text-align: right;
        }
        .thumbnail img {
            display: block;
            max-width: 100%;
            margin: 10px auto;
        }
    </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<main>
    <form action="products/createProduct/" method="post">
        <div class="catergory-form">
            <div class="header">¡CREATE YOUR CATEGORY!</div>
            <div class="category-details">
                <div class="category-row">
                    <label class="label" for="name">category name: </label>
                    <div class="value"><input type="text" id="name" name="sku" required></div>
                </div>
            </div>
            <button type="submit">CREATE</button>
        </div>
    </form>
</main>
</body>
</html>