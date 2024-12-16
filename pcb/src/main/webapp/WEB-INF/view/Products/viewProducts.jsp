<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Producto producto = (Producto) request.getAttribute("producto");
    List<Categoria> categoriasProducto = (List<Categoria>) request.getAttribute("categoriasProducto");
    List<Contenido> contenidos = (List<Contenido>) request.getAttribute("contenidos");
    List<Relacion> relaciones = (List<Relacion>) request.getAttribute("relaciones");

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            background: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        .header {
            background-color: #f37cd0;
            color: #fff;
            text-align: center;
            padding: 15px;
            font-size: 1.8em;
        }

        .product-details {
            padding: 20px;
        }

        .product-row {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 0;
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
        }

        .thumbnail img {
            display: block;
            max-width: 150px;
            height: auto;
            border-radius: 5px;
        }

        .content-container {
            margin-top: 20px;
            background: #f5f5f5;
            padding: 15px;
            border-radius: 5px;
        }

        .content-item {
            margin-bottom: 10px;
            font-size: 0.9em;
        }

        .content-item strong {
            color: #333;
        }

        h3 {
            color: #555;
        }
        .product-item {
            margin-bottom: 15px;
            display: flex;
            align-items: center; /* Align image and text vertically */
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 6px;
            background-color: #fff;
        }

        /* Thumbnail styling */
        .product-item img {
            width: 60px; /* Consistent thumbnail size */
            height: 60px;
            object-fit: cover; /* Ensures the image doesn't stretch */
            margin-right: 15px; /* Space between image and product details */
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        /* Product details next to the image */
        .product-item div {
            flex-grow: 1; /* Let the text take up the remaining space */
        }

        /* Styling for links and actions */
        .product-item a {
            text-decoration: none;
            color: #007BFF;
            font-weight: bold;
        }

        .product-item a:hover {
            text-decoration: underline;
            color: #0056b3;
        }
    </style>
</head>
<body>
<%@ include file="../component/Navbar.jsp" %>
<div class="container">
    <div class="header">Viewing Product Details</div>
    <div class="product-details">
        <div class="product-row">
            <div class="label">Product SKU:</div>
            <div class="value"><%= producto.getId() %></div>
        </div>
        <div class="product-row">
            <div class="label">Product GTIN:</div>
            <div class="value"><%= producto.getGtin() %></div>
        </div>
        <div class="product-row">
            <div class="label">Product Name:</div>
            <div class="value"><%= producto.getNombre() %></div>
        </div>
        <div class="product-row thumbnail">
            <div class="label">Product Thumbnail:</div>
            <div class="value">
                <img src="<%= producto.getThumnail() %>" alt="Product Thumbnail">
            </div>
        </div>
        <div class="product-row">
            <div class="label">Categories:</div>
            <div class="value">
                <% if (categoriasProducto != null && !categoriasProducto.isEmpty()) { %>
                <% for (Categoria c : categoriasProducto) { %>
                <span><%= c.getNombre() %></span>
                <% } %>
                <% } else { %>
                (No categories available)
                <% } %>
            </div>
        </div>
        <div class="product-row">
            <div class="label">Modification Date:</div>
            <div class="value"><%= producto.getFechaModificacion() %></div>
        </div>
        <div class="product-row">
            <div class="label">Creation Date:</div>
            <div class="value"><%= producto.getFechaCreacion() %></div>
        </div>
        <div class="product-row">
            <div class="label">Account:</div>
            <div class="value"><%= producto.getCuenta().getNombre() %></div>
        </div>
    </div>

    <div class="content-container">
        <h3>Attributes and Contents</h3>
        <% if (contenidos != null && !contenidos.isEmpty()) { %>
        <% for (Contenido contenido : contenidos) { %>
        <div class="content-item">
            <strong><%= contenido.getAtributo().getNombre() %>:</strong>
            <%= contenido.getContenido() %>
        </div>
        <% } %>
        <% } else { %>
        <p>No contents available for this product.</p>
        <% } %>
    </div>

    <div class="content-container">
        <h3>Product relationship</h3>
        <% if (relaciones != null && !relaciones.isEmpty()) { %>
            <% for (Relacion relacion : relaciones) { %>
        <%if(relacion.getProd1() == producto){%>
        <h5><%=relacion.getName()%></h5>
        <div class="product-item">
            <img src="<%= relacion.getProd2().getThumnail() %>" alt="Product Image">

            <div>
                <a href="/products/view?id=<%= relacion.getProd2().getId() %>">
                    <strong><%= relacion.getProd2().getNombre() %></strong>
                </a>
                <p>SKU: <%= relacion.getProd2().getId() %> | Account: <%= relacion.getProd2().getCuenta().getNombre() %></p>
            </div>
        </div>
        <%}else{%>
        <h5><%=relacion.getName()%></h5>
        <div class="product-item">
            <img src="<%= relacion.getProd1().getThumnail() %>" alt="Product Image">

            <div>
                <a href="/products/view?id=<%= relacion.getProd1().getId() %>">
                    <strong><%= relacion.getProd1().getNombre() %></strong>
                </a>
                <p>SKU: <%= relacion.getProd1().getId() %> | Account: <%= relacion.getProd1().getCuenta().getNombre() %></p>
            </div>
        </div>
        <%}%>
            <% } %>
        <% } else { %>
            <p>No Relations available for this product.</p>
        <% } %>
    </div>
</div>
</body>
</html>
