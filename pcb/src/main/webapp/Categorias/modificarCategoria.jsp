<%@ page import="es.pcb.pcbgrupo16.Entities.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Categoria categoria = (Categoria) request.getAttribute("categoria")
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Nueva Categoría</title>
    <link rel="stylesheet" href="styleCreateCategory.css">
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<main>
    <h1><%= categoria.getNombre() %></h1>
    <form>
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre">
        <button type="submit">Aceptar</button>
    </form>
</main>
</body>
</html>