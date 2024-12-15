<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Repository.ContenidoRepository" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
    Producto producto = (Producto) request.getAttribute("producto");
    List<Categoria> categoriasProducto = (List<Categoria>) request.getAttribute("categoriasProducto");
    List<Atributo> atributos = (List<Atributo>) request.getAttribute("atributos");
    List<Object[]> tuplaAC = (List<Object[]>) request.getAttribute("tuplaAC");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 20px;
        }
        .product-container {
            max-width: 800px;
            margin: 0 auto;
            background: #fff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            padding: 20px;
        }
        .header {
            background-color: #f37cd0;
            color: white;
            text-align: center;
            padding: 15px;
            font-size: 1.5em;
            border-radius: 8px 8px 0 0;
        }
        .product-details {
            margin-top: 20px;
        }
        .product-row {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
        }
        .product-row label {
            font-weight: bold;
            color: #333;
            flex: 1;
        }
        .product-row input, .product-row select {
            flex: 2;
            padding: 5px;
            font-size: 1em;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .button-container {
            text-align: center;
            margin-top: 20px;
        }
        button {
            background-color: #4caf50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 1em;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<%@ include file="../component/Navbar.jsp" %>
<div class="product-container">
    <div class="header">Edit Product</div>
    <form action="/products/edit" method="post">
        <div class="product-details">
            <!-- Fixed fields -->
            <div class="product-row">
                <label for="id">SKU:</label>
                <input type="text" id="id" name="id" value="<%= producto.getId() %>" readonly>
            </div>
            <div class="product-row">
                <label for="gtin">GTIN:</label>
                <input type="text" id="gtin" name="gtin" value="<%= producto.getGtin() %>" required>
            </div>
            <div class="product-row">
                <label for="nombre">Name:</label>
                <input type="text" id="nombre" name="nombre" value="<%= producto.getNombre() %>" required>
            </div>
            <div class="product-row">
                <label for="thumbnail">Thumbnail:</label>
                <input type="text" id="thumbnail" name="thumbnail" value="<%= producto.getThumnail() %>" required>
            </div>
            <div class="product-row">
                <label for="category">Categories:</label>
                <select id="category" name="category" required>
                    <% for (Categoria categoria : categorias) { %>
                    <option value="<%= categoria.getId() %>" <%= categoriasProducto.contains(categoria) ? "selected" : "" %> >
                        <%= categoria.getNombre() %>
                    </option>
                    <% } %>
                </select>
            </div>

            <!-- Dynamic attributes -->
            <h3>Product Attributes</h3>
            <% for (Object[] o : tuplaAC) {
                Atributo atributo = (Atributo) o[0];
                Contenido contenido = (Contenido) o[1];
                String contenidoValor = (contenido != null) ? contenido.getContenido() : null;
            %>
            <div class="product-row">
                <label for="atributo_<%= atributo.getId() %>"><%= atributo.getNombre() %>:</label>
                <input type="text" id="atributo" name="<%= atributo.getId() %>"
                       value="<%= (contenidoValor != null) ? contenidoValor : "" %>">
            </div>
            <% } %>

        </div>
        <div class="button-container">
            <button type="submit">Save Changes</button>
        </div>
    </form>
</div>
</body>
</html>
