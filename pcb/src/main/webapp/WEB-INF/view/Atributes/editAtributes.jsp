<%@ page import="es.pcb.pcbgrupo16.Entities.Atributo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Atributo atributo = (Atributo) request.getAttribute("atributo");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EDIT ATRIBUTES</title>
    <link rel="stylesheet" href="styleCreateAtributes.css">
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
        .atributes-details {
            padding: 20px;
        }
        .atributes-row {
            display: flex;
            justify-content: space-between;
            padding: 8px 0;
            border-bottom: 1px solid #ddd;
        }
        .atributes-row:last-child {
            border-bottom: none;
        }
        .label {
            font-weight: bold;
            color: #555;
        }
        .value {
            color: #333;
            text-align: right;
        }
        .thumbnail img {
            display: block;
            max-width: 100%;
            margin: 10px auto;
        }
    </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<main>
    <form action="/atributes/edit" method="post">
        <div class="atributes-form">
            <div class="header">¡EDIT YOUR ATRIBUTE!</div>
            <div class="atributes-details">
                <div class="atributes-row">
                    <label class="label" for="nombre">Atribute Name: </label>
                    <div class="value"><input type="text" id="nombre" name="nombre"></div>
                </div>
                <div class="atributes-row">
                    <label class="label" for="tipo">Atribute type: </label>
                    <div class="value"><input type="text" id="tipo" name="tipo" required></div>
                </div>
                <div class="atributes-row">
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