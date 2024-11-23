<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Categoria" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Producto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Producto producto = (Producto) request.getAttribute("producto");
//    List<Categoria> categoriasProducto = (List<Categoria>) request.getAttribute("categoriasProducto");
    Categoria categoria = (Categoria) request.getAttribute("categoriasProducto");
    List<Categoria> categoriasProducto = new java.util.ArrayList<>();
    categoriasProducto.add(categoria);
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
    </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<div class="product-form">
    <div class="header">¡VIEWING YOUR PRODUCTS!</div>
    <div class="product-details">
        <div class="product-row">
            <div class="label">product sku: </div>
            <div class="value">(<%=producto.getId()%>)</div>
        </div>
        <div class="product-row">
            <div class="label">product gtin: </div>
            <div class="value">(<%=producto.getGtin()%>)</div>
        </div>
        <div class="product-row">
            <div class="label">product name: </div>
            <div class="value">(<%=producto.getNombre()%>)</div>
        </div>
        <div class="product-row">
            <div class="label">product thumbnail: </div>
            <div class="value">(<%=producto.getThumnail()%>)</div>
        </div>
        <div class="product-row">
            <div class="label">Categories: (</div>
            <%for(Categoria c:categoriasProducto){%>
            <div class="value"><%=c.getNombre()%>, </div>
            <%}%>
            <div class="label">)</div>
        </div>
        <div class="product-row">
            <div class="label">product modification day: </div>
            <div class="value">(<%=producto.getFechaModificacion()%>)</div>
        </div>
        <div class="product-row">
            <div class="label">product creation day: </div>
            <div class="value">(<%=producto.getFechaCreacion()%>)</div>
        </div>
        <div class="product-row">
            <div class="label">product account: </div>
            <div class="value">(<%=producto.getCuenta().getNombre()%>)</div>
        </div>
    </div>
</div>
</body>
</html>