<%@ page import="es.pcb.pcbgrupo16.Entities.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Categoria categoria = (Categoria) request.getAttribute("categoria");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EDIT CATEGORY</title>
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
<form action="/categories/edit" method="post">
    <input type="hidden" name="id" value="${categoria.id}">
    <div class="category-form">
        <div class="header">¡EDIT YOUR CATEGORIES!</div>
        <div class="category-details">
            <div class="category-row">
                <label class="label" for="nombre">categoria sku (<%=categoria.getId()%>): </label>
                <div class="value"><input type="text" id="nombre" name="nombre"></div>
            </div>
        </div>
        <button type="submit">CREATE</button>
    </div>
</form>
</body>
</html>