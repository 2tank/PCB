<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Obtener el contenido del CSV del modelo
    String csv = (String) request.getAttribute("csv");

    // Dividir las líneas del CSV en un array
    String[] lines = csv != null ? csv.split("\\r?\\n") : new String[0];

    // Verificar que hay contenido
    boolean hasContent = lines.length > 0;
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CSV Viewer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>CSV Viewer</h1>
<% if (hasContent) { %>
<table>
    <thead>
    <tr>
        <%
            // Mostrar encabezados (primera línea del CSV)
            String[] headers = lines[0].split(",");
            for (String header : headers) {
        %>
        <th><%= header.trim() %></th>
        <% } %>
    </tr>
    </thead>
    <tbody>
    <%
        // Mostrar filas (a partir de la segunda línea)
        for (int i = 1; i < lines.length; i++) {
            String[] cells = lines[i].split(",");
    %>
    <tr>
        <% for (String cell : cells) { %>
        <td><%= cell.trim() %></td>
        <% } %>
    </tr>
    <% } %>
    </tbody>
</table>
<% } else { %>
<p>No hay contenido en el CSV para mostrar.</p>
<% } %>
</body>
</html>
