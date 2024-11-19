<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Producto" %>

<%
  List<Producto> productos = (List<Producto>) request.getAttribute("productos");
%>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Productos</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f0f0;
      margin: 0;
      padding: 0;
    }
    main {
      padding: 20px;
      background-color: #d6d6d6;
      min-height: calc(100vh - 60px);
    }
    .title {
      text-align: center;
      margin-bottom: 20px;
    }
    .title h1 {
      margin: 0;
      font-size: 24px;
    }
    .actions {
      text-align: center;
      margin-bottom: 20px;
    }
    .actions button {
      background-color: #4caf50;
      color: white;
      border: none;
      padding: 10px 20px;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
    }
    .product-list {
      list-style: none;
      padding: 0;
    }
    .product-list li {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 10px 15px;
      background-color: white;
      margin-bottom: 10px;
      border-radius: 5px;
    }
    .product-list a {
      text-decoration: none;
      color: #000;
      font-weight: bold;
    }
    .product-list .buttons {
      display: flex;
      gap: 10px;
    }
    .product-list .buttons button {
      padding: 5px 10px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
    .product-list .buttons .delete {
      background-color: #e57373;
      color: white;
    }
    .product-list .buttons .edit {
      background-color: #e0a05f;
      color: white;
    }
  </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<main>
  <div class="title">
    <h1>LIST OF PRODUCTS</h1>
  </div>
  <div class="actions">
    <button>CREATE</button>
  </div>
  <ul class="product-list">
    <%for (Producto product : productos) {%>
    <li class="product-item">
      <!-- Mostrar nombre con enlace -->
      <div>
        <a href="/producto/<%= product.getId()%>"><%= product.getNombre() %></a>
      </div>
      <!-- Mostrar SKU y GTIN -->
      <div>SKU: <%= product.getId() %></div>
      <div>GTIN: <%= product.getGtin() %></div>

      <!-- Botones a la derecha -->
      <div class="buttons">
        <button class="delete">DELETE</button>
        <button class="edit">EDIT</button>
      </div>
    </li>
    <%}%>
  </ul>
</main>
</body>
</html>
