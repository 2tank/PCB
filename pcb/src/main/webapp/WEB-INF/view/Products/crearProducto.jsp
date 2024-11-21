<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>

<html>
<head>
    <title>Create Product</title>
    <link rel="stylesheet" href="crearProducto.css"> </head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<form action="products/createProduct/" method="post">
    <div class="product-form">
        <h2>¡Crea tu producto!</h2>
        <label for="sku">Código del producto:</label>
        <input type="text" id="sku" name="sku" required>

        <label for="gtin">Código de barras:</label>
        <input type="text" id="gtin" name="gtin" required>

        <label for="productTitle">Nombre de tu producto:</label>
        <input type="text" id="productTitle" name="productTitle" required>

        <label for="thumbnail">Imagen principal:</label>
        <input type="text" id="thumbnail" name="thumbnail" step="0.01" required> €

        <label for="category">Categoría:</label>
        <select id="category" name="category">
            <%for(Categoria c:categorias){%>
                <option value="categoria.getID()"><%=c.getNombre()%></option>
            <%}%>
        </select>

        <button type="submit">CREATE</button>
    </div>
</form>
</body>
</html>