<!-- Vista Principal -->
<%


%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Management</title>
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

<!-- Enlace para ir a la vista de creación de producto -->
<a href="/products/create" class="btn-create">Create New Product</a>

<!-- Lista de productos -->
<div class="product-list">
  <h2>Product List</h2>
  <c:forEach var="product" items="${products}">
    <div class="product-item">
      <div>
        <strong>${product.name}</strong> - ${product.description} - $${product.price}
      </div>
      <div>
        <a href="/products/edit/${product.id}">Edit</a> |
        <a href="/products/delete/${product.id}" onclick="return confirm('Are you sure you want to delete this product?')">Delete</a>
      </div>
    </div>
  </c:forEach>
</div>
</body>
</html>
