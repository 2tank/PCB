<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Categoria" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Producto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
    Producto producto = (Producto) request.getAttribute("producto");
    List<Categoria> categoriasProducto = (List<Categoria>) request.getAttribute("categoriasProducto");
%>

<html>
<head>
    <title>Edit Product</title>
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
<form action="/products/edit" method="post">
    <div class="product-form">
        <div class="header">¡EDIT YOUR PRODUCTS!</div>
        <div class="product-details">
            <div class="product-row">
                <label class="label" for="id">product sku (<%=producto.getId()%>): </label>
                <div class="value"><input type="text" id="id" name="id" value="<%=producto.getId()%>" required></div>
            </div>
            <div class="product-row">
                <label class="label" for="gtin">product gtin (<%=producto.getGtin()%>): </label>
                <div class="value"><input type="text" id="gtin" name="gtin" value="<%=producto.getGtin()%>" required></div>
            </div>
            <div class="product-row">
                <label class="label" for="nombre">product name (<%=producto.getNombre()%>): </label>
                <div class="value"><input type="text" id="nombre" name="nombre" value="<%=producto.getNombre()%>" required></div>
            </div>
            <div class="product-row">
                <label class="label" for="thumbnail">product thumbnail (<%=producto.getThumnail()%>): </label>
                <div class="value"><input type="text" id="thumbnail" name="thumbnail" step="0.01" value="<%=producto.getThumnail()%>" required> €</div>
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