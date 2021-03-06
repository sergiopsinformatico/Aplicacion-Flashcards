<!DOCTYPE html>
<html lang="es">

<head>


  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Flashcards - P�gina Principal</title>

  <!-- Custom fonts for this template-->
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
  <link href="resources/css/view_All.css" rel="stylesheet">
  
  <!-- Bootstrap core CSS -->
  <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  
  <!-- Font-Awesome -->
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  
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

      <li class="nav-item active">
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
      <li class="nav-item">
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
        
        <script>        	
	        var app = angular.module('AppPrincipal', []);
	        app.controller('PrincipalCtrl', function($scope, $http) {
	        	
	        	$scope.checkNotificaciones = false;
	        	$scope.listaNotificaciones = [];
	        	
	        	$scope.rankingLoaded = false;
	        	$scope.ranking = [];
	        	
	        	$http({
	    	        method: 'GET',
	    	        url: 'getNotificacionesUsuario.do?usuario='+ "${usuario.getUsername()}",
	                headers : {
	                	'Accept': 'application/json'
	                }
	    	    }).then(function mySuccess(response) {
	    	    	$scope.listaNotificaciones = response.data;
	    	    	$scope.checkNotificaciones = true;
	    	    }, function myError(response) {
	    	    	$scope.listaNotificaciones = [];
	    	    	$scope.checkNotificaciones = true;
	    	    });
	        	
	        	$http({
	    	        method: 'GET',
	    	        url: 'getRanking.do',
	                headers : {
	                	'Accept': 'application/json'
	                }
	    	    }).then(function mySuccess(response) {
	    	    	$scope.ranking = response.data;
	    	    	$scope.rankingLoaded = true;
	    	    }, function myError(response) {
	    	    	$scope.ranking = [];
	    	    	$scope.rankingLoaded = true;
	    	    });
	        	
	        	$scope.eliminaNotificacion = function(indiceNotificacion){
	        		window.location.href = "eliminaNotificacionUsuario.do?usuario=${usuario.getUsername()}&idNotificacion="+indiceNotificacion;
	        	}
	        	
	        	
	        });
        </script>

        <!-- Begin Page Content -->
        <div class="container-fluid" ng-app="AppPrincipal" ng-controller="PrincipalCtrl">
        	<div class="row">
        		<div class="col-md-12">
        			<div class="row">
        				<div class="col-md-1"></div>
        				<div class="col-md-5">
        					<form action="panelMensajes.html" class="btnPaginaPrincipal" method="get">
			        			<button type="submit" class="btn btnPaginaPrincipal" style="color:#FFFFA1;background-color:#FFB864;">
			        				<i class="fa fa-envelope fa-5x" aria-hidden="true"></i>
			        				<br><br>
			       					Panel Mensajes
			       				</button>
			       			</form>
        				</div>
        				<div class="col-md-5">
        					<div style="height:50px;line-height:50px;background-color:#6FDD79;text-align:center;">
			        			<span style="color:#FFFFA1;font-weight:bold;" align="center">Notificaciones</span>
			        		</div>
			        		<div style="height:100px;overflow-y: auto;border: 1px solid #65E9FF;">
			        			<table ng-if="checkNotificaciones == true && listaNotificaciones.length>0">
			        				<tr ng-repeat = "eNotificacion in listaNotificaciones">  
								        <td>
			        						<span ng-click="eliminaNotificacion($index)">
			        							<i class="fa fa-times" style="color:red;" aria-hidden="true"></i>
			        						</span>
			        						<span style="margin-left:5px;">{{eNotificacion}}</span>
			        					</td>  
								    </tr>
			        			</table>
			        			<div ng-if="checkNotificaciones == true && listaNotificaciones.length==0">
			        				<p> No tiene notificaciones</p>
			        			</div>
			        		</div>
        				</div>
        				<div class="col-md-1"></div>
        			</div>
        		</div>
        	</div>
        	
        	<div class="row"></div>
		    <div class="row" id="divPanelAdministrador" style="display: none;">
		    	<br>
        		<div class="col-md-12">
		        	<div class="row">
		        		<div class="col-md-1"></div>
		        		<div class="col-md-10 middle">
		        			<form action="panelAdministrador.html" class="btnPaginaPrincipal" method="get">
			        			<button type="submit" class="btn btnPaginaPrincipal" style="color:#FFFFA1;background-color:#007bff;">
			        				<i class="fa fa-universal-access fa-5x" aria-hidden="true"></i>
			        				<br><br>
			       					Panel Administrador
			       				</button>
			       			</form>
		        		</div>
		        		<div class="col-md-1"></div>
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
		    <div class="row">
        		<div class="col-md-12">
		        	<div class="row">
		        		<div class="col-md-1"></div>
		        		<div class="col-md-10 middle">
		        			<form action="flashcards.html" class="btnPaginaPrincipal" method="get">
			        			<button type="submit" class="btn btnPaginaPrincipal" style="background-color:#80E2EC;color:#FFFFA1">
			        				<i class="fa fa-clone fa-5x" aria-hidden="true"></i>
			        				<br><br>
			       					<span style="font-weight:bold;">Flashcards</span>
			       				</button>
			       			</form>
		        		</div>
		        		<div class="col-md-1"></div>
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
		    <div class="row">
        		<div class="col-md-12">
		        	<div class="row">
		        		<div class="col-md-1"></div>
		        		<div class="col-md-5">
		        			<form action="verGente.html" class="btnPaginaPrincipal" method="get">
			        			<button type="submit" class="btn btnPaginaPrincipal" style="color:#FFFFA1;background-color:#4BD469;">
			       					<i class="fa fa-users fa-5x" aria-hidden="true"></i>
			       					<br><br>
			       					Gente
			       				</button>
			       			</form>
		        		</div>
		        		<div class="col-md-5">
		        			<form action="verClubes.html" class="btnPaginaPrincipal" method="get">
			        			<button type="submit" class="btn btnPaginaPrincipal" style="color:#FFFFA1;background-color:#FFB864;">
			       					<i class="fa fa-star fa-5x" aria-hidden="true"></i>
			       					<br><br>
			       					Clubes
			       				</button>
			       			</form>
		        		</div>
		        		<div class="col-md-1"></div>
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
		    <div class="row">
		    	<div class="col-md-4"></div>
		    	<div class="col-md-4">
	     			<div style="height:50px;line-height:50px;background-color:#0ED5FF;text-align:center;">
	        			<span style="color:#FFFFA1;font-weight:bold;" align="center">Ranking</span>
	        		</div>
	        		<div style="height:100px;overflow-y: auto;border: 1px solid #65E9FF;">
	        			<table ng-if="rankingLoaded == true && ranking.length>0">
	        				<tr ng-repeat = "ePuesto in ranking">  
						        <td>
	        						<span style="margin-left:5px;">{{$index+1}}. {{ePuesto.usuario}} - {{ePuesto.puntos}} puntos</span>
	        					</td>  
						    </tr>
	        			</table>
	        			<div ng-if="rankingLoaded == true && rankingLoaded.length==0">
	        				<p>Actualmente no disponemos de ranking</p>
	        			</div>
	        		</div>
	     		</div>
	     		<div class="col-md-4"></div>
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