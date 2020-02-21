<!DOCTYPE html>
<html lang="es">

<head>


  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Flashcards - Panel Mensajes</title>

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
      <li class="nav-item active">
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
                  Configuración
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" data-toggle="modal" onclick="dialogCS()">
                  <i class="fa fa-power-off" aria-hidden="true"></i>
                  Cerrar Sesión
                </a>
              </div>
            </li>

          </ul>

        </nav>
        
        <script>
	        function dialogCS(){
		    	bootbox.confirm({ 
	    		  size: "small",
	    		  message: "¿Desea salir del sistema?", 
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
	        var app = angular.module('AppPanelMensajes', []);
	        app.controller('PanelMensajesCtrl', function($scope, $http) {
	        	
	        	$scope.checkMensajesRecibidos = false;
	        	$scope.listaMensajesRecibidos = [];
	        	
	        	$scope.checkMensajesEnviados = false;
	        	$scope.listaMensajesEnviados = [];
	        	
	        	$scope.listaAmigos = [];
    	    	$scope.checkAmigos = false;
	        	
	        	$http({
	    	        method: 'GET',
	    	        url: 'getMensajesRecibidos.do?usuario='+ "${usuario.getUsername()}",
	                headers : {
	                	'Accept': 'application/json'
	                }
	    	    }).then(function mySuccess(response) {
	    	    	$scope.listaMensajesRecibidos = response.data;
	    	    	$scope.checkMensajesRecibidos = true;
	    	    }, function myError(response) {
	    	    	$scope.listaMensajesRecibidos = [];
	    	    	$scope.checkMensajesRecibidos = true;
	    	    });
	        	
	        	$http({
	    	        method: 'GET',
	    	        url: 'getMensajesEnviados.do?usuario='+ "${usuario.getUsername()}",
	                headers : {
	                	'Accept': 'application/json'
	                }
	    	    }).then(function mySuccess(response) {
	    	    	$scope.listaMensajesEnviados = response.data;
	    	    	$scope.checkMensajesEnviados = true;
	    	    }, function myError(response) {
	    	    	$scope.listaMensajesEnviados = [];
	    	    	$scope.checkMensajesEnviados = true;
	    	    });	  
	        	
	        	$http({
	    	        method: 'GET',
	    	        url: 'getAmigosMensajes.do',
	                headers : {
	                	'Accept': 'application/json'
	                }
	    	    }).then(function mySuccess(response) {
	    	    	$scope.listaAmigos = response.data;
	    	    	$scope.checkAmigos = true;
	    	    }, function myError(response) {
	    	    	$scope.listaAmigos = [];
	    	    	$scope.checkAmigos = true;
	    	    });
	        	
	        	$scope.eliminaMensaje = function(idMensaje){
	        		window.location.href = "eliminarMensaje.do?idMensaje="+idMensaje;
	        	}
	        	
	        });
        </script>

        <!-- Begin Page Content -->
        <div class="container-fluid" ng-app="AppPanelMensajes" ng-controller="PanelMensajesCtrl">
        	<div class="row">
        		<div class="col-md-6">
        			<div class="row">
        				<div class="col-md-12">        				
        					<span style="font-weight:bold;">Mensajes Recibidos</span>
        					<br>
        					<div style="overflow-y:scroll;height:200px;">
					   			<table ng-if="listaMensajesRecibidos.length > 0 && checkMensajesRecibidos == true" width=100% border="1">
					   				<tr ng-repeat = "eMensaje in listaMensajesRecibidos">  
								      <td align="left">
								        <span ng-click="eliminaMensaje(eMensaje.idMensaje)">
		        							<i class="fa fa-times" style="color:red;" aria-hidden="true"></i>
		        						</span>
								        <br>
								      	De: {{eMensaje.remitente}}
								      	<br>
								      	Mensaje: {{eMensaje.mensaje}}
								      </td>      
								   </tr>
					   			</table>
					   			<div ng-if="listaMensajesRecibidos.length == 0 && checkMensajesRecibidos == true">
					   				<p>No ha recibido mensajes</p>
					   			</div>
					   		</div>
					   		<br>
					   		<span style="font-weight:bold;">Mensajes Enviados</span>
        					<br>
        					<div style="overflow-y:scroll;height:200px;">
					   			<table ng-if="listaMensajesEnviados.length > 0 && checkMensajesEnviados == true" width=100% border="1">
					   				<tr ng-repeat = "eMensaje in listaMensajesEnviados">  
								      <td align="left">
								        <span ng-click="eliminaMensaje(eMensaje.idMensaje)">
		        							<i class="fa fa-times" style="color:red;" aria-hidden="true"></i>
		        						</span>
								        <br>
								      	Para: {{eMensaje.destinatario}}
								      	<br>
								      	Mensaje: {{eMensaje.mensaje}}
								      </td>   
								  </tr>
					   			</table>
					   			<div ng-if="listaMensajesEnviados.length == 0 && checkMensajesEnviados == true">
					   				<p>No ha enviado mensajes</p>
					   			</div>
					   		</div>
        				
        				</div>
        			</div>
        		</div>
        		<div class="col-md-6">
        			<div class="row">
        				<div class="col-md-12">
        					<form action="enviarMensaje.html" method="post">
        						<input type="hidden" id="remitente" name="remitente" value="${usuario.getUsername()}">
					            <table width=100% border="1">
					   				<tr ng-repeat = "eUsuario in listaAmigos">  
								      <td>
								      	<input type="radio" id="destinatario" name="destinatario" ng-model="valueCompartirCon" ng-change="changeSelectCC(valueCompartirCon)"
								      	value="{{eUsuario}}">{{eUsuario}}
								      </td>    
								   </tr>
					   			</table>
        						<br>
	        					<input type="text" style="width:100%;" id="asunto" name="asunto" placeholder="Asunto del Mensaje" required>
	        					<br><br>
	        					<textarea name="mensaje" id="mensaje" style="width:100%;height:300px;">Tu mensaje...</textarea>
	        					<br><br><br>
	        					<button type="submit" class="btn btn-success middle">
	        						Enviar Mensaje
	        					</button>
	        					<br><br>
	        				</form>
        				</div>
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
		        		<div class="col-md-4"></div>
		        		<div class="col-md-4">
		        			<form action="inicio.html">
			        			<button type="submit" class="btn" style="width:100%;height:50px;background-color:#0ED5FF;color:#FFFFA1;">
			        				<i class="fa fa-arrow-left" aria-hidden="true" style="margin-right:5px;"></i>
			        				Volver a la Página de Inicio
			        			</button>
			        		</form>
		        		</div>
		        		<div class="col-md-4"></div>
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