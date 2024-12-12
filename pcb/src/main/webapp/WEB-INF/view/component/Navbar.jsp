<%@ page import="es.pcb.pcbgrupo16.Entities.Usuario" %>


<%
    Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");

    String ruta = "basic";

    if(usuario.getRol() == 1){
        ruta = "admin";
    }
    else if(usuario.getRol() == 2){
        ruta = "owner";
    }
%>

<style>
    header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: rgba(243, 124, 208, 0.6);
        padding: 10px 20px;
        border-bottom: 3px solid #4a90e2;
    }
    header .logo {
        display: flex;
        align-items: center;
    }
    header .logo img {
        width: 40px;
        height: 40px;
        border-radius: 50%;
        margin-right: 10px;
    }
    header nav {
        display: flex;
        gap: 20px;
    }
    header nav a {
        text-decoration: none;
        color: white;
        font-weight: bold;
        padding: 5px 10px;
        border-radius: 5px;
    }
    header nav a.active {
        background-color: #f37cd0;
    }
    header .profile-icon {
        background-color: #ccc;
        width: 40px;
        height: 40px;
        border-radius: 50%;
    }
    .image-button {
        background-image: url('../icon/logo.png');
        background-size: cover;
        border: none;
        width: 100px;
        height: 50px;
        cursor: pointer;
        z-index: 9999;
    }

</style>
<header>
    <nav>
        <a href="/products/">PRODUCTS</a>
        <a href="/categories/">CATEGORIES</a>
        <a href="/atributes/">ATTRIBUTES</a>
    </nav>
    <div class="col">
            <a href="/account/view?id=<%= usuario.getCuenta().getId() %>"> <button class="image-button profile-icon"></button> </a>
    </div>
</header>