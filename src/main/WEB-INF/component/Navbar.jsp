<style>
    header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #b09cc5;
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
</style>

<header>
    <div class="logo">
        <img src="../iconos/logo.png" alt="Logo">
        <span>Productos</span>
    </div>
    <nav>
        <a href="#" class="active">PRODUCTS</a>
        <a href="#">CATEGORIES</a>
        <a href="#">ATRIBUTES</a>
    </nav>
    <div class="profile-icon"></div>
</header>