<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String nombreUsuario = (String) request.getAttribute("nombreCuenta");
    int numProductos = (int) request.getAttribute("numeroProductos");
    int numAtributos = (int) request.getAttribute("numeroAtributos");
    int numCategorias = (int) request.getAttribute("numeroCategorias");
    int numRelaciones = (int) request.getAttribute("numeroRelaciones");
    int sub = (int)request.getAttribute("tipoSuscripcion") ; //TODO: DAVID MARICON
    String tipoSuscripcion = "";
    switch (sub) {
        case 1 : tipoSuscripcion = "BASIC"; break;
        case 2 : tipoSuscripcion = "MEDIUM";break;
        case 3 : tipoSuscripcion = "ENTERPRISE";break;
        default : tipoSuscripcion = "SUBCRIPTION INVALID";break;
    };
%>

<html>
<head>
    <title>View Product</title>
    <link rel="stylesheet" href="account.css">

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
        .account-details {
            padding: 20px;
        }
        .account-row {
            display: flex;
            justify-content: space-between;
            padding: 8px 0;
            border-bottom: 1px solid #ddd;
        }
        .account-row:last-child {
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
        .content-container {
            margin-top: 20px;
            background: #f5f5f5;
            padding: 15px;
            border-radius: 5px;
        }
        .content-item {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<div class="account-form">
    <div class="header">¡VIEWING YOUR ACCOUNT INFO!</div>
    <div class="account-details">
        <div class="account-row">
            <div class="label">Account Name: </div>
            <div class="value"><%= nombreUsuario %></div> <!-- MOSTRAR EL NOMBRE DE LA CUENTA -->
        </div>
        <div class="account-row">
            <div class="label">Num Products Associated: </div>
            <div class="value"><%= numProductos %></div> <!-- MOSTRAR EL NUMERO DE PRODUCTOS QUE HAY -->
        </div>
        <div class="account-row">
            <div class="label">Num Atributes Associated: </div>
            <div class="value"><%= numAtributos %></div> <!-- MOSTRAR EL NUMERO DE ATRIBUTOS QUE HAY -->
        </div>
        <div class="account-row">
            <div class="label">Num Categories Associated: </div>
            <div class="value"><%= numCategorias %></div> <!-- MOSTRAR EL NUMERO DE CATEGORIAS QUE HAY -->
        </div>
        <div class="account-row">
            <div class="label">Num Relations Associated: </div>
            <div class="value"><%= numRelaciones %></div> <!-- MOSTRAR EL NUMERO DE RELACIONES QUE HAY -->
        </div>
        <div class="account-row">
            <div class="label">Account Subscription Type: </div>
            <div class="value"><%= tipoSuscripcion %></div> <!-- MOSTRAR EL TIPO DE SUSCRIPCION -->
        </div>
    </div>
    <a href="/account/export"><button>EXPORT</button></a>
</div>
</body>
</html>
