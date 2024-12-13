<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Producto" %>
<!-- Vista Principal -->
<%
  List<Producto> productos = (List<Producto>) request.getAttribute("productos");
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product List</title>
  <style>
    .product-list {
      margin-top: 20px;
      padding: 20px;
      background-color: #f9f9f9;
    }
    .product-item {
      margin-bottom: 15px;
      display: flex;
      justify-content: space-between;
      align-items: center;
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
  </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<!-- Enlace para ir a la vista de creación de producto -->
<h1>PRODUCTS</h1>
<a href="/products/create" class="btn-create">Create New Product</a>

<!-- Lista de productos -->
<div class="product-list">
  <h2>Product List</h2>
  <%for(Producto p:productos){%>
  <div class="product-item">
    <div>
      <a href="/products/view?id=<%=p.getId()%>"> <strong> <%=p.getNombre()%></strong></a> | GTIN: <%=p.getGtin()%>  | AccountName: <%=p.getCuenta().getNombre()%>
    </div>
    <div>
      <a href="/products/edit?id=<%=p.getId()%>">Edit</a> |
      <a href="/products/delete?id=<%=p.getId()%>" onclick="return confirm('Are you sure you want to delete this product?')">Delete</a>
    </div>
  </div>
  <%}%>
</div>
</body>
</html>
