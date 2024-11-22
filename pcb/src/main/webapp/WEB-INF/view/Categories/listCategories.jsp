<%@ page import="es.pcb.pcbgrupo16.Entities.Categoria" %>
<%@ page import="java.util.List" %>

<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CATEGORIES</title>
    <style>
        .category-list {
            margin-top: 20px;
            padding: 20px;
            background-color: #f9f9f9;
        }
        .btn-create {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            margin-bottom: 20px;
        }
        .btn-create:hover {
            background-color: #45a049;
        }
        .category-item {
            margin-bottom: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
    </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<div class="title">
    <h1>CATEGORIES</h1>
    <a href="/categories/create" class="btn-create">Create New Product</a> <!-- TODO porque no es como el create de product???, a esta no se le puede poner el categories delante porque lo añade x2-->
    <div class="category-list">
        <h2>Categories List</h2>
        <%for(Categoria c:categorias){%>
        <div class="category-item">
            <div>
                <a href="/categories/view?id=<%=c.getId()%>"> <strong> <%=c.getNombre()%></strong></a> | NumProductos: <%=c.getNumProductos()%>|
            </div>
            <div>
                <a href="/categories/edit?id=<%=c.getId()%>">Edit</a> |
                <a href="/categories/delete?id=<%=c.getId()%>" onclick="return confirm('Are you sure you want to delete this product?')">Delete</a>
            </div>
        </div>
        <%}%>
    </div>
</div>
</body>
</html>