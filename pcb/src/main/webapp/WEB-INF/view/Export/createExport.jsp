<%@ page import="es.pcb.pcbgrupo16.Entities.Atributo" %>
<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Categoria" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Producto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SELECT ATRIBUTE</title>
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

        .atributes-list {
            margin: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .atributes-item {
            margin: 15px 0;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            display: flex;
            align-items: center;
            background-color: #f5f5f5;
            transition: background-color 0.3s ease;
        }

        .atributes-item:hover {
            background-color: #e9f5fe;
        }

        .atributes-item input[type="radio"],
        .atributes-item input[type="checkbox"] {
            margin-right: 10px;
            accent-color: #007bff;
        }

        .atributes-item label {
            font-size: 1em;
            color: #333;
            margin: 5px 0;
        }

        button {
            display: block;
            margin: 30px auto;
            padding: 12px 20px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1.1em;
            width: 200px;
        }

        button:hover {
            background-color: #0056b3;
        }

        /* Additional style for the forms */
        form {
            max-width: 600px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<main>
    <!-- Form for selecting an attribute -->
    <form action="/exports/filter" method="post">
        <div class="atributes-list">
            <div class="header">SELECT AN ATRIBUTE</div>
            <% if (categorias != null && !categorias.isEmpty()) { %>
            <% for (Categoria categoria : categorias) { %>
            <div class="atributes-item">
                <input type="radio" id="atributo_<%= categoria.getId() %>" name="atributoId" value="<%= categoria.getId() %>" required>
                <label for="atributo_<%= categoria.getId() %>">
                    Name: <%= categoria.getNombre() %> | Number of elements: <%= categoria.getNumProductos()%>
                </label>
            </div>
            <% } %>
            <% } else { %>
            <p>No hay atributos disponibles para seleccionar.</p>
            <% } %>
        </div>
        <button type="submit">FILTER</button>
    </form>

    <!-- Form for selecting products -->
    <form action="/exports/create" method="post">
        <div class="atributes-list">
            <% if (productos != null && !productos.isEmpty()) { %>
            <% for (Producto producto : productos) { %>
            <div class="atributes-item">
                <label>
                    <input type="checkbox" name="productosSeleccionados" value="<%=producto.getId()%>">
                    <%= producto.getNombre() %>
                </label>
            </div>
            <% } %>
            <% } else { %>
            <p>No hay productos disponibles para seleccionar.</p>
            <% } %>
        </div>
        <button type="submit">EXPORT</button>
    </form>

</main>
</body>
</html>
