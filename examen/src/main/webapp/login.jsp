<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.productos.negocio.*" import=" com.productos.datos.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicie sesión</title>
    <link rel="stylesheet" href="css/estilos.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
</head>
<body>
    <div class="container">
        <header>
            <nav class="menu-bar">
                <div class="group">
                  <a class="item-1 title"><img src="img/FCO.png" alt="logo" width="360px"></a>
                </div>
                <div class="group">
                  <a class="item" id="item-1" href="index.jsp">Inicio</a>
                  <a class="item" href="actividades.html">Eventos</a>
                  <a class="item" href="sucesos.html">Acerca de</a>
                  <a href="desarrollador.html" class="item"> Sesión</a>
                </div>
              </nav>
        </header>
        <main class="login-1">
            
                
            <div class="padre">

                <div class="hijo-1-s">
                    <img src="img/im16.jpg" alt="imagen" width="100%">
                </div>
                <div class="hijo-2-s">
        
                    
                        <!--Titulo-->
                        <h3>Inicie sesión</h3>
                        <br>
                
                        <div class="buttons">
                
                            <button class="google-btn">
                                <!--Imagen del logo de google-->
                                <picture>
                                    <img src="img/google.png" alt="Logo de google">
                                </picture>
                                <span>Registrarse con google</span>
                            </button>
                
                            <button class="twitter-btn">
                                <picture>T</picture>
                            </button>
                
                        </div>
                        <br>
                        <div class="separator">
                            <hr>
                            <span>O...</span>
                            <hr>
                        </div>
                        <!--Aqui empieza el formulario-->
                        <form action="verificarLogin.jsp" method="POST">
                            
                            <div class="section-inputs">
                                <!--El FOR hace referencia al id del input-->
                                <!--Esta parte correspone al name-->
                                <label for="name">
                                    <span>Name</span>
                                    <input type="text" name="usuario" id="usuario">
                                </label>
                            </div>
               
                            <!--Esta parte correspone al password-->
                            <label for="password">
                                <span>password</span>
                                <input id="clave" type="password" name="clave" placeholder="6+caracteres">
                            </label>
                            <!--Esta parte correspone al checkbox de aceptar terminos-->
                            <label for="checkbox" class="checkbox-label">
                                <input type="checkbox" name="checkbox" id="checkbox">
                                <span>Acepto las condiciones y el aviso legal</span>
                            </label>
                            <!--Este es el boton de crear cuenta-->
                            <button type="submit" class="submit-btn">Entrar</button>
                        </form>
                        <br>
                        <a href="registrarse.jsp">Crear cuenta</a> 
                        <a href="">Cambiar clave</a>
                    </div>
        
                </div>
        </main>
    </div>
    <footer class="footer">

        <div class="conte-footer">
            <div class="item-footer">
                <div class="cont">
                    <br>
                    <p>Creado por: Sara Quiguango</p>
                    <p>&COPY 2023 FCO | Todos los derechos reservados</p>
                </div>
                <div class="redes">
                  <a href="https://www.instagram.com/"><img src="img/instagram.png" alt="instagram"></a>
                  <a href="https://www.facebook.com/"> <img src="img/facebook.png" alt="facebook"></a>
                 <a href="https://twitter.com/"><img src="img/gorjeo.png" alt="twiter"></a>
                  <a href="https://skype.com/"><img src="img/skype.png" alt="Skype"></a>
                  
                </div>
            </div>

        </div>   
    </footer>
</body>
</html>