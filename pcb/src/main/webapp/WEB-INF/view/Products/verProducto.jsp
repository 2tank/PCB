<%@ page import="es.pcb.pcbgrupo16.Entities.Producto" %><%
    Producto producto = (Producto) request.getAttribute("producto");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #e5e5e5;
        }

        .container {
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
            background-color: #d6c2de;
            border-radius: 10px;
        }

        .product-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .product-image {
            border: 2px solid #a674a1;
            width: 100%;
            height: 300px;
            background-color: #fff;
            margin-bottom: 20px;
        }

        .product-info {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .price {
            background-color: #f9b7d9;
            color: white;
            padding: 10px 20px;
            border-radius: 50%;
            font-size: 18px;
            font-weight: bold;
        }

        .attributes {
            margin-top: 20px;
            background-color: #a674a1;
            color: white;
            padding: 15px;
            border-radius: 5px;
        }

        .tabs {
            margin-top: 20px;
            display: flex;
            gap: 10px;
        }

        .tabs button {
            background-color: #f9b7d9;
            border: none;
            padding: 10px 15px;
            border-radius: 20px;
            color: white;
            cursor: pointer;
        }

        .rating {
            margin-top: 20px;
            background-color: #a674a1;
            padding: 10px;
            border-radius: 5px;
            color: white;
            text-align: center;
        }

        .rating span {
            font-size: 20px;
        }
    </style>
</head>
<body>

<%@ include file = "../component/Navbar.jsp" %>

<div class="container">
    <div class="product-title">producto.getNombre()</div>
    <div class="product-image"></div>
    <div class="product-info">
        <div class="price">Price </div>
    </div>
    <div class="attributes">Attribute 1</div>
    <div class="tabs">
        <button>Description</button>
        <button>Categories</button>
        <button>Attributes</button>
    </div>
    <div class="rating">
        <span>★★★★★</span>
    </div>
</div>
</body>
</html>
