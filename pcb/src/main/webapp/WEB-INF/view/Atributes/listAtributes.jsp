<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Atributo" %>
<%@ page import="java.util.Objects" %>

<%
    List<Atributo> atributos = (List<Atributo>) request.getAttribute("atributos");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Atributes</title>
    <style>
        .atribute-list {
            margin-top: 20px;
            padding: 20px;
            background-color: #f9f9f9;
        }
        .atribute-item {
            margin-bottom: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .btn-create {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            margin-bottom: 20px;
        }
        .btn-create:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<div class="title">
    <h1>ATRIBUTES</h1>
    <a href="/atributes/create" class="btn-create">Create New Product</a>
    <div class="atribute-list">
        <h2>ATRIBUTES LIST</h2>
        <%for(Atributo a:atributos){%>
        <div class="atribute-item">
            <div>
                <a href="/atributes/view?id=<%=a.getId()%>"> <strong> <%=a.getNombre()%></strong></a> | Tipo: <%=a.getTipo()%>| Contenido: <%=a.getContenido().getContenido()%>
            </div>
            <div>
                <a href="/atributes/edit?id=<%=a.getId()%>">Edit</a> |
                <a href="/atributes/delete?id=<%=a.getId()%>" onclick="return confirm('Are you sure you want to delete this product?')">Delete</a>
            </div>
        </div>
        <%}%>
    </div>
</div>
</body>
</html>