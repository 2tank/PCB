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
        <%for (Atributo att: atributos) {%>
        <li>
            <div>
                <a href="/<%=att.getNombre() + att.getTipo()%>"> <%=att.getNombre()%> </a>
            </div>

            <div>tipo: <%=att.getTipo()%></div>

            <%if(Objects.equals(att.getTipo(), "IMAGE")){%>
            <img src="${pageContext.request.contextPath}/images/<%=att.getContenido()%>" alt="<%="imagen"%>"> <!-- si quiero meter una imagen ocmo contenido debo de crear un nuevo tipo de imagen y almacenar el id -->
            <%}else{%>
            <div>contenido: <%=att.getTipo()%></div>
            <%}%>
            <div class="buttons">
                <button class="delete" >DELETE</button>
                <button class="edit">EDIT</button>
            </div>
        </li>
        <%}%>
    </ul>
</div>
</body>
</html>