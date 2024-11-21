<%@ page import="es.pcb.pcbgrupo16.Entities.Cuenta" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

  Cuenta cuenta = (Cuenta) request.getAttribute("cuenta");

%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Bienvenido</title>

  <!-- Enlace al CDN de Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEJp3L6/7P3vLh4gJl6D7Me4kxhKpn0X9gH74YyCx8I7K3zqQkXgtjcSYp03v" crossorigin="anonymous">

  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f0f0;
      margin: 0;
      padding: 0;
    }
  </style>
</head>
<body>
<%@ include file = "../component/Navbar.jsp" %> <!-- Incluimos el navbar -->

<!-- Contenedor de bienvenida -->
<div class="container d-flex flex-column justify-content-center align-items-center" style="min-height: 100vh;">
  <!-- Cartel de bienvenida -->
  <h1 class="text-center my-4">Bienvenido a <%= cuenta.getNombre() %></h1> <!-- Nombre de la empresa -->

  <!-- Logo centrado -->
  <div class="text-center">
   <!-- <img src="path_to_logo/sony_logo.png" alt="Logo de Sony" class="img-fluid" style="max-width: 200px; height: auto;"> -->
  </div>
</div>

<!-- Enlace a la versión minificada de JS de Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pzjw8f+ua7Kw1TIq0o6Jk14/1hZnW4wIl1l9Vg5zYZiPbC01w8l08Ewkh78D0D2i" crossorigin="anonymous"></script>
</body>
</html>
