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
                <%-- Campo oculto para pasar el ID del atributo --%>
                <input type="hidden" name="id" value="<%= atributo != null ? atributo.getId() : "" %>">

                <div class="atributes-row">
                    <label class="label" for="nombre">Atribute Name: </label>
                    <div class="value">
                        <input type="text" id="nombre" name="nombre" value="<%= atributo != null ? atributo.getNombre() : "" %>" required>
                    </div>
                </div>
                <div class="atributes-row">
                    <label class="label" for="tipo">Atribute Type: </label>
                    <div class="value">
                        <select id="tipo" name="tipo" required>
                            <option value="" disabled <%= atributo == null ? "selected" : "" %>>Select type</option>
                            <option value="String" <%= atributo != null && "String".equals(atributo.getTipo()) ? "selected" : "" %>>String</option>
                            <option value="Integer" <%= atributo != null && "Integer".equals(atributo.getTipo()) ? "selected" : "" %>>Integer</option>
                            <option value="Double" <%= atributo != null && "Double".equals(atributo.getTipo()) ? "selected" : "" %>>Double</option>
                        </select>
                    </div>
                </div>
            </div>
            <button type="submit">EDIT</button>
        </div>
    </form>
</main>
</body>
</html>
