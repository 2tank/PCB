<%@ page import="java.util.List" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Producto" %>
<%@ page import="es.pcb.pcbgrupo16.Entities.Relacion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    Relacion relacion = (Relacion) request.getAttribute("relacion");
    String error = (String) request.getAttribute("error");
%>

<html>
<head>
    <title>Edit Relationship</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 20px;
        }
        .relacion-container {
            display: flex; /* Diseño en fila */
            justify-content: space-between; /* Primer select a la izquierda, segundo a la derecha */
            align-items: center; /* Alineación vertical horizontalmente */
            gap: 20px; /* Espacio entre los dos selects */
            margin: 20px 0; /* Margen superior e inferior para separación del resto de la página */
        }

        /* Grupo de cada select */
        .select-group {
            display: flex;
            flex-direction: column; /* Poner el label encima del input */
            flex: 1; /* Toman espacios iguales en el contenedor */
            max-width: 45%; /* Evitar que ocupen todo el ancho disponible */
        }

        /* Label estilizado */
        .select-group label {
            font-size: 16px; /* Tamaño de la fuente del label */
            font-weight: bold; /* Resalta el texto */
            margin-bottom: 8px; /* Separación del label y el select */
            color: #333; /* Color del texto */
        }

        /* Estilo para los selects */
        .select-group select {
            width: 100%; /* Que ocupe todo el ancho del contenedor */
            padding: 8px; /* Espaciado interno confortable */
            font-size: 14px; /* Tamaño del texto */
            border: 1px solid #ccc; /* Borde simple */
            border-radius: 4px; /* Bordes redondeados */
            background-color: #fff; /* Fondo blanco */
            color: #333; /* Color del texto */
            outline: none; /* Quita el borde violeta/azul en clic */
            transition: border-color 0.3s ease; /* Transición fluida */
        }

        /* Estilo para hover y focus */
        .select-group select:hover,
        .select-group select:focus {
            border-color: #007bff; /* Cambia el borde al pasar o enfocar */
            background-color: #f9f9f9; /* Cambia el fondo ligeramente */
        }

        .select-left,
        .select-right {
            flex: 1; /* Asegura que tengan el mismo tamaño relativo (opcional, se puede ajustar) */
            max-width: 45%; /* Asegura que los elementos no ocupen más del 45% del ancho del contenedor */
        }

        .select-left label,
        .select-right label {
            display: block; /* Asegura que el texto de la etiqueta esté encima del select */
            margin-bottom: 5px; /* Espacio entre el label y el select */
        }

        select {
            width: 100%; /* Asegura que los selects ocupen todo el ancho del div contenedor */
            padding: 5px; /* Para agregar un poco de espacio interno */
            font-size: 14px; /* Ajusta el tamaño del texto */
        }
        .header {
            background-color: #F37CD099;
            color: #fff;
            text-align: center;
            padding: 15px;
            font-size: 1.5em;
        }
        .relacion-details {
            padding: 20px;
        }
        .relacion-row {
            display: flex;
            justify-content: space-between;
            padding: 8px 0;
            border-bottom: 1px solid #ddd;
        }
        .relacion-row:last-child {
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
        button {
            display: block;
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %>
<form action="/relationships/edit" method="post">
    <div class="relacion-form">
        <div class="header">¡EDIT YOUR RELATIONSHIP!</div>
        <%if(error != null){%>
        <h5><%=error%></h5>
        <%}%>
        <div class="relacion-details">
            <!-- Product Name -->
            <div class="relacion-row">
                <label class="label" for="nombre">Relationship Name:</label>
                <div class="value"><input type="text" id="nombre" name="nombre" required></div>
            </div>
        </div>
        <div>
            <input type="hidden" name="id" value="<%= relacion.getId() %>">
            <!-- Contenedores de selects -->
            <div class="relacion-container">
                <!-- Contenedor izquierdo -->
                <div class="select-group select-left">
                    <label for="producto1">Product 1:</label>
                    <select id="producto1" name="producto1">
                        <option value="<%=-1%>"> No selected product </option>
                        <%for(Producto p:productos){%>
                        <option value="<%=p.getId()%>"><%=p.getNombre()%></option>
                        <%}%>
                    </select>
                </div>

                <!-- Contenedores de selects -->
                <div class="select-group relacion-container">
                    <!-- Contenedor izquierdo -->
                    <div class="select-right">
                        <label for="producto2">Product 2:</label>
                        <select id="producto2" name="producto2">
                            <option value="<%=-1%>"> No selected product </option>
                            <%for(Producto p:productos){%>
                            <option value="<%=p.getId()%>"><%=p.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
                </div>
            </div>
            <!-- Submit Button -->
            <button type="submit">CREATE</button>
        </div>
    </div>
</form>
</body>