<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Categoria" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Producto" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Contenido" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Producto producto = (Producto) request.getAttribute("producto");
    List<Categoria> categoriasProducto = (List<Categoria>) request.getAttribute("categoriasProducto");
    List<Contenido> contenidos = (List<Contenido>) request.getAttribute("contenidos");
%>

<html>
<head>
    <title>View Product</title>
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
        .content-container {
            margin-top: 20px;
            background: #f5f5f5;
            padding: 15px;
            border-radius: 5px;
        }
        .content-item {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<div class="product-form">
    <div class="header">¡VIEWING YOUR PRODUCTS!</div>
    <div class="product-details">
        <div class="product-row">
            <div class="label">Product SKU: </div>
            <div class="value"><%= producto.getId() %></div>
        </div>
        <div class="product-row">
            <div class="label">Product GTIN: </div>
            <div class="value"><%= producto.getGtin() %></div>
        </div>
        <div class="product-row">
            <div class="label">Product Name: </div>
            <div class="value"><%= producto.getNombre() %></div>
        </div>
        <div class="product-row">
            <div class="label">Product Thumbnail: </div>
            <div class="value"><img src="<%= producto.getThumnail() %>" alt="thumbnail"></div>
        </div>
        <div class="product-row">
            <div class="label">Categories: </div>
            <div class="value">
                <% if (categoriasProducto != null && !categoriasProducto.isEmpty()) { %>
                <% for (Categoria c : categoriasProducto) { %>
                <%= c.getNombre() %>
                <% } %>
                <% } else { %>
                (No categories available)
                <% } %>
            </div>
        </div>
        <div class="product-row">
            <div class="label">Modification Date: </div>
            <div class="value"><%= producto.getFechaModificacion() %></div>
        </div>
        <div class="product-row">
            <div class="label">Creation Date: </div>
            <div class="value"><%= producto.getFechaCreacion() %></div>
        </div>
        <div class="product-row">
            <div class="label">Account: </div>
            <div class="value"><%= producto.getCuenta().getNombre() %></div>
        </div>
    </div>

    <!-- Contenidos -->
    <div class="content-container">
        <h3>Attributes and Contents</h3>
        <% if (contenidos != null && !contenidos.isEmpty()) { %>
        <% for (Contenido contenido : contenidos) { %>
        <div class="content-item">
            <strong><%= contenido.getAtributo().getNombre() %>:</strong> <%= contenido.getContenido() %>
        </div>
        <% } %>
        <% } else { %>
        <p>No contents available for this product.</p>
        <% } %>
    </div>
</div>
</body>
</html>
