<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Categoria> categoriasProducto = (List<Categoria>) request.getAttribute("categorias");
%>

<html>
<head>
    <title>Create Product</title>
    <link rel="stylesheet" href="crearProducto.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 20px;
        }
        .product-container {
            max-width: 600px;
            margin: 0 auto;
            background: #fff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        .header {
            background-color: #F37CD099;
            color: #fff;
            text-align: center;
            padding: 15px;
            font-size: 1.5em;
        }
        .product-details {
            padding: 20px;
        }
        .product-row {
            display: flex;
            justify-content: space-between;
            padding: 8px 0;
            border-bottom: 1px solid #ddd;
        }
        .product-row:last-child {
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
<form action="/products/create" method="post">
    <div class="product-form">
        <div class="header">¡CREATE YOUR PRODUCTS!</div>
        <div class="product-details">
            <div class="product-row">
                <label class="label" for="gtin">product gtin: </label>
                <div class="value"><input type="text" id="gtin" name="gtin" required></div>
            </div>
            <div class="product-row">
                <label class="label" for="nombre">product name: </label>
                <div class="value"><input type="text" id="nombre" name="nombre" required></div>
            </div>
            <div class="product-row">
                <label class="label" for="thumbnail">product thumbnail: </label>
                <div class="value"><input type="text" id="thumbnail" name="thumbnail" step="0.01" required> €</div>
            </div>
            <div class="product-row">
                <label class="label" for="category">Categories: </label>
                <select id="category" name="category" class="label">
                <%for(Categoria c:categoriasProducto){%>
                <option value="categoria.getID()" class="value"><%=c.getNombre()%></option>
                <%}%>
                </select>
            </div>
        </div>
        <button type="submit">CREATE</button>
    </div>
</form>
</body>
</html>