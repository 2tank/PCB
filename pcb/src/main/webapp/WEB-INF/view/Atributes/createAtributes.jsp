<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Nuevo Atributo</title>
    <link rel="stylesheet" href="styleCreateAtributes.css">
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<main>
    <form action="/products/create" method="post">
        <div class="product-form">
            <div class="header">¡CREATE YOUR ATRIBUTE!</div>
            <div class="product-details">
                <div class="product-row">
                    <label class="label" for="nombre">Atribute Name: </label>
                    <div class="value"><input type="text" id="nombre" name="nombre"></div>
                </div>
                <div class="product-row">
                    <label class="label" for="tipo">Atribute type: </label>
                    <div class="value"><input type="text" id="tipo" name="tipo" required></div>
                </div>
                <div class="product-row">
                    <label class="label" for="contenido">Atribute contenido: </label>
                    <div class="value"><input type="text" id="contenido" name="contenido" step="0.01" required></div>
                </div>
            </div>
            <button type="submit">CREATE</button>
        </div>
    </form>
</main>
</body>
</html>