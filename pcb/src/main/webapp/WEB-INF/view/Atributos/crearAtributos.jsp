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
    <h1>Crear Nuevo Atributo</h1>
    <form>
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre">
        <button type="submit">Aceptar</button>
    </form>
</main>
</body>
</html>