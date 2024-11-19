<%@ page import="es.pcb.pcbgrupo16.Entities.Categoria" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Categories</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        .title {
            text-align: center;
            margin-bottom: 20px;
        }
        .title h1 {
            margin: 0;
            font-size: 24px;
        }
        .content h1 {
            text-align: center;
        }
        .create-button {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #57e357;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .category-list {
            max-width: 600px;
            margin: 0 auto;
            list-style: none;
            padding: 0;
        }
    </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<div class="title">
    <h1>CATEGORIES</h1>
    <div class="create-button">
        <button>CREATE</button>
    </div>
    <ul class="category-list">
        <%-- Iterar sobre las categorías desde el backend --%>
        <%
            for (Categoria category : categorias) {%>
        <li>
            <div>
                <a href="/<%=category.getId()%>"> <%=category.getNombre()%> </a>
            </div>

            <div>cantidad: <%=category.getNumProductos()%></div>

            <div class="buttons">
                <button class="delete">DELETE</button>
                <button class="edit">EDIT</button>
            </div>
        </li>
        <%}%>
    </ul>
</div>
</body>
</html>