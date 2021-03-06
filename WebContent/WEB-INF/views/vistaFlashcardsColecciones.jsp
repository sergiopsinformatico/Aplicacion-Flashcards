<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Flashcards - Colecciones de Flashcards</title>

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
	        var app = angular.module('AppMostrarColecciones', []);
	        app.controller('MostrarColeccionesCtrl', function($scope, $http) {
	        	
	        	$scope.colecciones = 'todas';
	        	
	        	$scope.listaColecciones = [];
	        	
	        	$scope.listaVisibles = [];
	        	$scope.listaCreadasEvaluadas = [];
	        	$scope.listaCreadasPendientes = [];
	        	
	        	$scope.listaClubes = [];
	        	$scope.arrayClubes = new Array();
	        	
	        	$scope.listaCargada = false;
	        	
	        	var indice = 0;
	        	
				$scope.cargaClubes = function(){
	        		
	        		$http.get("clubesFlashcards.do")
		       			.then(function(response) {
		       				$scope.listaClubes = response.data;
		       				
		       				for(indice=0; indice<$scope.listaClubes.length; indice++){
		       					$scope.arrayClubes[$scope.listaClubes[indice].idClub] = $scope.listaClubes[indice].nombreClub;
		       				}
		       				
		       				$scope.visiblesParaMi();
		       		  	}, function myError(response) {
		       		  		$scope.listaClubes = [];
		       		  		$scope.visiblesParaMi();
			       	    }
		       		);
	        		
	        	}
	        	
	        	$scope.visiblesParaMi = function(){
	        		
	        		$http.get("coleccionesVisiblesParaMi.do")
		       			.then(function(response) {
		       				$scope.listaVisibles = response.data;
		       				$scope.creadasEvaluadas();
		       		  	}, function myError(response) {
		       		  		$scope.listaVisibles = [];
		       		  		$scope.creadasEvaluadas();
			       	    }
		       		);
	        		
	        	}
	        	
				$scope.creadasEvaluadas = function(){
	        		
	        		$http.get("coleccionesCreadasEvaluadas.do")
		       			.then(function(response) {
		       				$scope.listaCreadasEvaluadas = response.data;
		       				$scope.creadasPendiente();
		       		  	}, function myError(response) {
		       		  		$scope.listaCreadasEvaluadas = [];
		       		  		$scope.creadasPendiente();
			       	    }
		       		);
	        		
	        	}
	        	
	        	$scope.creadasPendiente = function(){
	        		$http.get("coleccionesCreadasPendienteEvaluar.do")
		       			.then(function(response) {
		       					$scope.listaCreadasPendientes = response.data;
			       				$scope.listaColecciones = $scope.listaVisibles;
			       				$scope.refreshCarrousel();
			       				$scope.listaCargada = true;
			       		  	}, function myError(response) {
			       		  		$scope.listaCreadasPendientes = [];
			       		  		$scope.listaColecciones = $scope.listaVisibles;
			       		  		$scope.refreshCarrousel();
			       		  		$scope.listaCargada = true;
				       	    }
			       		);
	        	}
	        	
	        	$scope.cargaClubes();
	        	
	        	$scope.refreshCarrousel = function(){
					$('#carouselFlashcardsVer').carousel({});
					$(document).ready(function(){
						  $('.carousel').each(function(){
						    $(this).find('.carousel-item').eq(0).addClass('active');
						  });
						});
				};
				
				$scope.cambioVer = function(valueColeccion){
					if(valueColeccion == 'todas'){
						$scope.listaColecciones = $scope.listaVisibles;
	       		  		$scope.refreshCarrousel();
					}else if(valueColeccion == 'creadasEvaluadas'){
						$scope.listaColecciones = $scope.listaCreadasEvaluadas;
	       		  		$scope.refreshCarrousel();
					}else{
						$scope.listaColecciones = $scope.listaCreadasPendientes;
	       		  		$scope.refreshCarrousel();
					}
				};
				
				$scope.clickDiv = function(isColeccionEvaluada, idColeccion){
					if(isColeccionEvaluada){
						window.location.href = "verColeccion.html?id="+idColeccion;
					}
				}
				
	        });
        </script>
        <div class="container-fluid" ng-app="AppMostrarColecciones" ng-controller="MostrarColeccionesCtrl">
        	
        	<div class="row">
        		<div class="col-md-12" align="center">
        			<h4 align="center" style="color:black;font-weight:bold;">Colecciones de Flashcards</h4>
		        	<br>
        		</div>
        	</div>
        	<div class="row">
        		<div class="col-md-1"></div>
        		<div class="col-md-10">
        			<div class="row">
        				<div class="col-md-4">
        					<input type="radio" ng-model="colecciones" ng-change="cambioVer(colecciones)" value="todas"> Colecciones Visibles para Mi<br>
        					<input type="radio" ng-model="colecciones" ng-change="cambioVer(colecciones)" value="creadasEvaluadas"> Colecciones Creadas por Mi (Evaluadas)<br>
        					<input type="radio" ng-model="colecciones" ng-change="cambioVer(colecciones)" value="creadasSinEvaluar"> Colecciones Creadas por Mi (Sin Evaluar)<br>
        					<br><br><br>
		        			<form action="flashcards.html">
			        			<button type="submit" class="btn" style="width:100%;height:50px;background-color:#0ED5FF;color:#FFFFA1;">
			        				<i class="fa fa-arrow-left" aria-hidden="true" style="margin-right:5px;"></i>
			        				Volver a la P�gina de Flashcards
			        			</button>
			        		</form>
        				</div>
        				<div class="col-md-8">
        					<div class="row" ng-if="listaCargada == false">
		        				<div class="col-md-12">
		        					<h6 align="center" style="color:black;">Cargando colecciones....</h6>
		        				</div>
		        			</div>
		        			<div class="row" ng-if="(listaCargada == true) && (listaColecciones.length > 0)">
		        				<div class="col-md-12" align="center">
		        					<div class="input-group">
						            	<input type="text" ng-model="filterColecciones" ng-change="refreshCarrousel()" class="form-control" placeholder="Filtrar colecciones" />
						            </div>
						            <br>
		        					<div id="carouselFlashcardsVer" class="carousel slide" style="width:400px;height:500px;">
								        <div class="container" style="width:400px;height:550px;">
								            <div class="carousel-inner row w-100 mx-auto" style="width:400px;height:500px;">
												<div class="carousel-item" ng-repeat="eColeccion in listaColecciones | filter:filterColecciones">
										            <div class="flip-card-container" style="width:400px;height:500px;text-align:center;">
														<div class="flip-card">
													    	<div class="flip-card-front" style="color:#FFFFA1;background-color:#4BD469;">
													        	<br><br><br><br><br>
										                    	<strong>{{eColeccion.nombreColeccion}}</strong>
										                    	<br><br><br><br>
										                    	<strong>Autor:</strong> {{eColeccion.autorColeccion}}
										                    	<br><br><br><br>
										                    	<div ng-if="(eColeccion.tipoCompartir == 'publico')">
										                    		<strong>Para todos los usuarios</strong>
										                    	</div>
										                    	<div ng-if="(eColeccion.tipoCompartir == 'privado')">
										                    		<strong>Solo para ti</strong>
										                    	</div>
										                    	<div ng-if="(eColeccion.tipoCompartir == 'usuario')">
										                    		<strong>Para el Usuario
										                    		<br>{{eColeccion.compartirCon}}</strong>
										                    	</div>
										                    	<div ng-if="(eColeccion.tipoCompartir == 'club')">
										                    		<strong>Para los Miembros del Club
										                    		<br>
										                    		{{arrayClubes[eColeccion.compartirCon]}} </strong>
										                    	</div>
										                    	<br><br>
										                    	<div ng-if="eColeccion.autorColeccion == '${usuario.getUsername()}'">
										                    		<div ng-if="eColeccion.evaluada == true">
										                    			Colecci�n Evaluada
										                    		</div>
										                    		<div ng-if="eColeccion.evaluada == false">
										                    			Colecci�n Pendiente de Ser Evaluada
										                    		</div>
										                    	</div>
															</div>
													 		<div class="flip-card-back" style="color:#FFFFA1;background-color:#FFB864;" ng-click="clickDiv(eColeccion.evaluada, eColeccion.idColeccion)">
													 			<br><br><br><br><br><br>
													 			<div ng-if="eColeccion.evaluada == true">
									                    			<i class="fa fa-eye fa-5x" aria-hidden="true" style="color:#FFFFA1"></i>
				       									 			<br><br>
														 			<span style="color:#FFFFA1;">Ver Coleccion</span>
									                    		</div>
									                    		<div ng-if="eColeccion.evaluada == false">
									                    			Pendiente de Evaluar
									                    		</div>
													 			
														    </div>
													    </div>
													</div>					
								                </div>
								            </div>
									        <a class="carousel-control-prev" style="color:black;font-weight:bold;font-size:30px;padding-right:110px" href="#carouselFlashcardsVer" role="button" data-slide="prev">
										      <i class="fa fa-angle-left" aria-hidden="true"></i>
										      <span class="sr-only">Anterior</span>
										    </a>
										    <a class="carousel-control-next" style="color:black;font-weight:bold;font-size:30px;padding-left:110px" href="#carouselFlashcardsVer" role="button" data-slide="next">
										      <i class="fa fa-angle-right" aria-hidden="true"></i>
										      <span class="sr-only">Siguiente</span>
										    </a>
									    </div>
									</div>
		        				</div>
		        			</div>
		        			<div class="row" ng-if="(listaCargada == true) && (listaColecciones.length == 0)">
		        				<div class="col-md-12">
		        					<h6 align="center" style="color:black;">No hay colecciones para mostrar</h6>
		        				</div>
		        			</div>
        				</div>
        			</div>
        		</div>
        		<div class="col-md-1"></div>
        	</div>
        	
        	<script>
        		if("${usuario.getRol()}" === 'Administrador'){
        			document.getElementById("divPanelAdministrador").style.display="block";
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