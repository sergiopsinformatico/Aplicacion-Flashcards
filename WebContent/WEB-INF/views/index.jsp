<!DOCTYPE html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Flashcards - Página de Inicio</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="resources/css/accesoFlashcards.css"/>

    <!-- Custom styles for this template -->
    <link href="resources/css/freelancer.min.css" rel="stylesheet">
    
    <!-- Angular JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    
    <style>
    	body {
		  background: #F1F3FA;
		}
    </style>
  </head>

  <body id="page-top">
  
  	<%@ page import="main.java.aplicacionflashcards.dto.UsuarioDTO" %>
	<% 
		UsuarioDTO user = ((UsuarioDTO)(session.getAttribute("usuario")));
		if(user!=null && user.getUsername()!=null && (!(user.getUsername().equals("")))){
			response.sendRedirect("inicio.html");
		}
	%>
		
	<!-- Navigation -->
    <header class="header">
	    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
	      <div class="container">
	        <a class="navbar-brand js-scroll-trigger" href="inicio.html">
	        	<img class="logoFlashcards" src="resources/img/logoFlashcards.JPG" alt=""/>
	        </a>
	        <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	          Menu
	          <i class="fas fa-bars"></i>
	        </button>
	        <div class="collapse navbar-collapse" id="navbarResponsive">
	          <ul class="navbar-nav ml-auto">
	          	<li class="nav-item mx-0 mx-lg-1">
	              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="iniciarSesion.html"><i class="fas fa-sign-in-alt" style="padding-right:10px;"></i>Iniciar Sesión</a>
	            </li>
	            <li class="nav-item mx-0 mx-lg-1">
	              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="registro.html"><i class="fas fa-user-plus" style="padding-right:10px;"></i>Registrate</a>
	            </li>
	          </ul>
	        </div>
	      </div>
	    </nav>
	</header>
	<!-- <article style="background-color:white">
		<br><br><br><br><br><br><br><br>
    	<img style="display:block;margin-left:auto;margin-right:auto;width:500px;height:auto;" src="resources/imagenes/pageBuilding.jpg" alt="Imagen no Disponible">
    	<br><br>
	</article>-->
    <article style="background-color:#BFEA8B">
    	<br><br><br><br><br><br><br><br>
    	<div class="row">
    		<div class="col-md-3"></div>
    		<div class="col-md-3">
    		<br>
    			<h5 style="color:white" align="center">Si quieres saber cómo se ha desarrollado este proyecto, pincha sobre la imagen</h5>
    		</div>
    		<div class="col-md-3">
    			<a href="https://www.google.es"><img style="display:block;margin-left:auto;margin-right:auto;width:150px;height:auto;" src="resources/imagenes/wikiDesarrollo.jpg" alt="Imagen no Disponible"></a>
    		</div>
    		<div class="col-md-3"></div>
    	</div>
    	<br>
	</article>
    <article>
	    <div class="copyright py-4 text-center text-white">
	      <div class="container">
	       	<small>Desarrollado por Sergio Pérez Sanchez para el Trabajo Fin de Grado (TFG). Curso 2019/2020</small>
	      </div>
	    </div>
	</article>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-to-top d-lg-none position-fixed ">
      <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
        <i class="fa fa-angle-up"></i>
      </a>
    </div>
    
    <!-- Bootstrap core JavaScript -->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="resources/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="resources/js/jqBootstrapValidation.js"></script>
    <script src="resources/js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="resources/js/freelancer.min.js"></script>
    
    <!-- Alert de Bootbox -->
    <script src="resources/js/bootbox.min.js"></script>
	
	<script>
		if("${mensaje}" != ""){
			bootbox.alert("${mensaje}");
		}
	</script>
		
  </body>

</html>