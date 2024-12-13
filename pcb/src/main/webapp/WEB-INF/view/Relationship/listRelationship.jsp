<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Relacion" %>
<!-- Vista Principal -->

<%
    List<Relacion> relacions = (List<Relacion>) request.getAttribute("relaciones");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Relationship List</title>
    <style>
        .relacion-list {
            margin-top: 20px;
            padding: 20px;
            background-color: #f9f9f9;
        }
        .relacion-item {
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
<!-- Enlace para ir a la vista de creación de producto -->
<h1>RELATIONSHIP</h1>
<a href="/relationships/create" class="btn-create">Create New Relationship</a>

<!-- Lista de productos -->
<div class="relacion-list">
    <h2>Relationship List</h2>
    <%for(Relacion r:relacions){%>
    <div class="relacion-item">
        <div>
            <%if(r.getProd1() == null && r.getProd2() == null){%>
                <strong> <%=r.getName()%> </strong> | prod1: No selected product  | prod2: No selected product
            <%}else {%>
                <strong> <%=r.getName()%> </strong> | prod1: <%=r.getProd1().getNombre()%>  | prod2: <%=r.getProd2().getNombre()%>
            <%}%>
        </div>
        <div>
            <a href="/relationships/edit?id=<%=r.getId()%>">Asssing products</a> |
            <a href="/relationships/delete?id=<%=r.getId()%>" onclick="return confirm('Are you sure you want to delete this product?')">Delete</a>
        </div>
    </div>
    <%}%>
</div>
</body>
</html>
