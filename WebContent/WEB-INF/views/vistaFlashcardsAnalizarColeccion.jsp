<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Flashcards - Evaluar Flashcard: ${flashcard.getNombreColeccion()}</title>

  <!-- Custom fonts for this template-->
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
  <link href="resources/css/view_All.css" rel="stylesheet">
  <link href="resources/css/cardFlip.css" rel="stylesheet">
  
  <!-- Bootstrap core CSS -->
  <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  
  <!-- Font-Awesome -->
  <link rel="stylesheet" href="resources/font-awesome/css/font-awesome.min.css">
  
  <!-- Angular JS -->
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

</head>

<body id="page-top">
	
  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
    	
	   	<div class="row">
	   		<br><br>
	   	</div>
      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="inicio.html">
      	<div class="sidebar-brand-icon middle">
        	<img class="logoFlashcards" src="resources/imagenes/logoFlashcards.JPG" alt=""/>
        </div>
      </a>
      
      <div class="row">
	  	<br><br>
	  </div>

      <!-- Divider-->
      <hr class="sidebar-divider my-0">

      <li class="nav-item">
        <a class="nav-link" href="inicio.html">
          <i class="fa fa-home" aria-hidden="true"></i>
          <span>Pagina Principal</span></a>
      </li>      
      
      <li class="nav-item">
        <a class="nav-link" href="desarrolloProyecto.html">
          <i class="fa fa-sitemap" aria-hidden="true"></i>
          <span>Wiki del Proyecto</span></a>
      </li>
      
      <hr class="sidebar-divider" id="adminSidebarDivider" style="display: none;">
      <div class="sidebar-heading" id="adminSidebarTitle" style="display: none;">
        Administrador
      </div>
      <li class="nav-item" id="adminSidebar" style="display: none;">
        <a class="nav-link" href="panelAdministrador.html">
          <i class="fa fa-universal-access" aria-hidden="true"></i>
          <span>Panel Administrador</span></a>
      </li>
      
      <hr class="sidebar-divider">
      <div class="sidebar-heading">
        Flashcards
      </div>
      <li class="nav-item active">
        <a class="nav-link" href="flashcards.html">
          <i class="fa fa-clone" aria-hidden="true"></i>
          <span>Panel Flashcards</span></a>
      </li>
      
      <hr class="sidebar-divider">
      
      <!-- Heading -->
      <div class="sidebar-heading">
        Usuarios
      </div>
      <li class="nav-item">
        <a class="nav-link" href="verGente.html">
          <i class="fa fa-users" aria-hidden="true"></i>
          <span>Gente</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="verClubes.html">
          <i class="fa fa-star" aria-hidden="true"></i>
          <span>Clubes</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="panelMensajes.html">
          <i class="fa fa-envelope" aria-hidden="true"></i>
          <span>Panel Mensajes</span>
        </a>
      </li>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Bienvenido ${usuario.getUsername()}</span>
                <img class="img-profile rounded-circle" src="${usuario.getFoto()}">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="verPerfil.html?usuarioPerfil=${usuario.getUsername()}">
                  <!-- <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>-->
                  <i class="fa fa-id-card" aria-hidden="true"></i>
                  Ver Mi Perfil
                </a>
                <a class="dropdown-item" href="configuracion.html">
                  <!-- <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>-->
                  <i class="fa fa-cog" aria-hidden="true"></i>
                  Configuraci�n
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" data-toggle="modal" onclick="dialogCS()">
                  <i class="fa fa-power-off" aria-hidden="true"></i>
                  <!-- <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>-->
                  Cerrar Sesi�n
                </a>
              </div>
            </li>

          </ul>

        </nav>
        
        <script>
	        function dialogCS(){
		    	bootbox.confirm({ 
	    		  size: "small",
	    		  message: "�Desea salir del sistema?", 
	    		  callback: function(result){ 
	    			if(result){
	    				window.location.href = "cerrarSesion.do";
	    			}  
	    		  }
	    		})
		    }
        </script>
        
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        
        <script>        	
	        var app = angular.module('AppAnalizarColeccion', []);
	        app.controller('AnalizarColeccionCtrl', function($scope, $http) {
				
	        	$scope.colTarjetas = [];
	        	
	        	$http.get("getTarjetasColeccion.do?id="+"${flashcard.getIdColeccion()}")
       			.then(function(response) {
       				$scope.colTarjetas = response.data;
       				
       				$('#carouselColeccionFlashcard').carousel({});
					$(document).ready(function(){
						  $('.carousel').each(function(){
						    $(this).find('.carousel-item').eq(0).addClass('active');
						  });
						});
       				
       		  	});
	        		        	
	        	$scope.checkTipoCompartir = function(value){
	        		
	        		return "${flashcard.getTipoCompartir()}" === value;
	        		
	        	}
	        	
	        	$scope.evaluacionPositiva = function(){
	        		
	        		bootbox.confirm({ 
	  	    		  size: "small",
	  	    		  message: "�Confirma que la Evaluacion para "+"${flashcard.getNombreColeccion()}"+" es positiva?", 
	  	    		  callback: function(result){ 
	  	    			if(result){
	  	    				window.location.href = "evaluacionPositiva.do?id=${flashcard.getIdColeccion()}";
	  	    			}  
	  	    		  }
	  	    		});
	  	    		
	        	}
	        	
				$scope.evaluacionNegativa = function(){
					
					bootbox.confirm({ 
	  	    		  size: "small",
	  	    		  message: "�Confirma que la Evaluacion para "+"${flashcard.getNombreColeccion()}"+" es negativa?", 
	  	    		  callback: function(result){ 
	  	    			if(result){
	  	    				window.location.href = "evaluacionNegativa.do?id=${flashcard.getIdColeccion()}";
	  	    			}  
	  	    		  }
	  	    		});
					
	        	}
				
	        });
        </script>
        
        <div class="container-fluid" ng-app="AppAnalizarColeccion" ng-controller="AnalizarColeccionCtrl">
        	
        	<div class="row">
        		<div class="col-md-12">
        			<div class="row">
        				<div class="col-md-1"></div>
        				<div class="col-md-10">
        					<div class="row">
        						<div class="col-md-4 container" style="border-style:solid;border-width:5px;border-color:#EE0E0E;background:#53FFDC;">
        							<br><br><br>
        							<strong>Nombre de la Colecci�n: </strong>${flashcard.getNombreColeccion()}
        							<br><br>
        							<strong>Autor: </strong>${flashcard.getAutorColeccion()}
        							<br>
        							<strong>Tema: </strong>${flashcard.getTemaColeccion()}
        							<br>
        							<strong>Fecha de Creaci�n: </strong>${flashcard.getFechaCreacion()}
        							<br><br>
        							<div ng-if="checkTipoCompartir('publico')==true">
			                    		<strong>Para todos los usuarios</strong>
			                    	</div>
			                    	<div ng-if="checkTipoCompartir('privado')==true">
			                    		<strong>Solo el usuario creador (Privado)</strong>
			                    	</div>
			                    	<div ng-if="checkTipoCompartir('usuario')==true">
			                    		<strong>Para el Usuario</strong>
			                    		<br>${flashcard.getCompartirCon()}
			                    	</div>
			                    	<div ng-if="checkTipoCompartir('club')==true">
			                    		<strong>Para los Miembros del Club</strong>
			                    		<br>${flashcard.getCompartirCon()}
			                    	</div>
        							<br><br><br>
        						</div>
        						<div class="col-md-8" align="center">
        							<div id="carouselColeccionFlashcard" class="carousel slide" style="width:400px;height:500px;">
								        <div class="container" style="width:400px;height:550px;">
								            <div class="carousel-inner row w-100 mx-auto" style="width:400px;height:500px;">
												<div class="carousel-item" ng-repeat="eTarjeta in colTarjetas">
										            <div class="flip-card-container" style="width:400px;height:500px;text-align:center;">
														<div class="flip-card">
													    	<div class="flip-card-front" style="background:#FFB550;">
													        	<br><br><br><br><br>
										                    	{{eTarjeta.anverso}}
															</div>
													 		<div class="flip-card-back" style="background:#86D4FF;">
													 			<br><br><br><br><br>
										                    	{{eTarjeta.reverso}}
														    </div>
													    </div>
													</div>					
								                </div>
								            </div>
									        <a class="carousel-control-prev" style="color:black;font-weight:bold;font-size:30px;padding-right:110px" href="#carouselColeccionFlashcard" role="button" data-slide="prev">
										      <i class="fa fa-angle-left" aria-hidden="true"></i>
										      <span class="sr-only">Anterior</span>
										    </a>
										    <a class="carousel-control-next" style="color:black;font-weight:bold;font-size:30px;padding-left:110px" href="#carouselColeccionFlashcard" role="button" data-slide="next">
										      <i class="fa fa-angle-right" aria-hidden="true"></i>
										      <span class="sr-only">Siguiente</span>
										    </a>
									    </div>
									</div>
        						
        						</div>
        					</div>
        				</div>
        				<div class="col-md-1"></div>
        			</div>
        		</div>
        	</div>
        	<div class="row">
        		<br><br><br>
        	</div>
        	<div class="row">
        		<div class="col-md-3"></div>
        		<div class="col-md-3">
        			<button class="btn btn-success" ng-click="evaluacionPositiva()">
        				<i class="fa fa-thumbs-up" aria-hidden="true"></i>
        				Evaluaci�n Positiva
        			</button>
        		</div>
        		<div class="col-md-3">
        			<button class="btn" style="background:#FF0000;color:white;" ng-click="evaluacionNegativa()">
        				<i class="fa fa-thumbs-down" aria-hidden="true"></i>
        				Evaluaci�n Negativa
        			</button>
        		</div>
        		<div class="col-md-3"></div>
        	</div>
        	
        	<div class="row">
        		<div class="col-md-12">
		        	<div class="row">
		        		<br>
		        	</div>
		        </div>
		    </div>
		    
		    <div class="row">
        		<div class="col-md-12">
		        	<div class="row">
		        		<div class="col-md-3"></div>
		        		<div class="col-md-6">
		        			<form action="evaluarColecciones.html">
			        			<button type="submit" class="btn" style="width:100%;height:50px;background-color:#0ED5FF;color:#FFFFA1;">
			        				<i class="fa fa-arrow-left" aria-hidden="true" style="margin-right:5px;"></i>
			        				Volver a la P�gina de Evaluar Colecciones de Flashcards
			        			</button>
			        		</form>
		        		</div>
		        		<div class="col-md-3"></div>
		        	</div>
		        </div>
		    </div>
		    
		    <div class="row">
        		<div class="col-md-12">
		        	<div class="row">
		        		<br>
		        	</div>
		        </div>
		    </div>
        	
        	<script>
        		if("${usuario.getRol()}" === 'Administrador'){
        			document.getElementById("adminSidebarDivider").style.display="block";
        			document.getElementById("adminSidebarTitle").style.display="block";
        			document.getElementById("adminSidebar").style.display="block";
        		}
        	</script>        	
        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

     </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fa fa-angle-up"></i>
  </a>

  <!-- Custom scripts for all pages-->
  <script src="resources/js/sb/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="resources/js/sb/chart-area-demo.js"></script>
  <script src="resources/js/sb/chart-pie-demo.js"></script>
  
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