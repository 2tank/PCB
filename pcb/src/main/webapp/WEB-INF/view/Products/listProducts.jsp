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
    /* General styles for the product list */
    .product-list {
      margin-top: 20px;
      padding: 20px;
      background-color: #f9f9f9;
      border-radius: 8px;
      font-family: Arial, sans-serif;
    }

    /* Styling individual product items */
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

    /* Create new product button styling */
    .btn-create {
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      margin-bottom: 20px;
      font-size: 16px;
    }

    .btn-create:hover {
      background-color: #45a049;
    }
  </style>

</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<h1>PRODUCTS</h1>

<a href="/products/create" class="btn-create">Create New Product</a>

<div class="product-list">
  <h2>Product List</h2>
  <% for (Producto p : productos) { %>
  <div class="product-item">
    <img src="<%= p.getThumnail() %>" alt="Product Image">

    <div>
      <a href="/products/view?id=<%= p.getId() %>">
        <strong><%= p.getNombre() %></strong>
      </a>
      <p>SKU: <%= p.getId() %> | Account: <%= p.getCuenta().getNombre() %></p>
    </div>

    <div>
      <a href="/products/edit?id=<%= p.getId() %>">Edit</a> |
      <a href="/products/delete?id=<%= p.getId() %>" onclick="return confirm('Are you sure you want to delete this product?')">Delete</a>
    </div>
  </div>
  <% } %>
</div>
</body>
</html>
