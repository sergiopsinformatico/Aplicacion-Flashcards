<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Flashcards - Administrador Modifica Perfil de ${usuarioModificar.getUsername()}</title>

  <!-- Custom fonts for this template-->
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
  <link href="resources/css/view_All.css" rel="stylesheet">
  <link href="resources/css/configuracion.css" rel="stylesheet">
  
  <!-- Bootstrap core CSS -->
  <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  
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
      <li class="nav-item active" id="adminSidebar" style="display: none;">
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
            <li class="nav-item active dropdown no-arrow">
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
        <div class="container-fluid" ng-app="AppAdminModificaPerfil" ng-controller="AdminModificaPerfilCtrl">
        	<div class="row">
        		<br>
        	</div>
        	<div class="row">
        		<div class="col-md-1"></div>
        		<div class="col-md-4">
        			<form action="gestionUsuariosAdmin.html">
	        			<button type="submit" class="btn" style="width:100%;height:50px;background-color:#0ED5FF;color:#FFFFA1;">
	        				<i class="fa fa-arrow-left" aria-hidden="true" style="margin-right:5px;"></i>
	        				Volver a la P�gina de Gesti�n de Usuarios
	        			</button>
	        		</form>
        		</div>
        		<div class="col-md-7"></div>
        	</div>
        	<div class="row">
        		<br>
        	</div>
        	<div class="row">
        		<div class="col-md-2"></div>
        		<div class="col-md-8">
        			<div class="row" style="background-color:white;">
        				<div class="col-md-1"></div>
        				<div class="col-md-10">
        					<br>
			    				<h4 class="title" align="center">Modificar Perfil de ${usuarioModificar.getUsername()}</h4>
			    			<br>
	        				<form action="modificaUsuarioAdministrador.do" method="post" id="Registro" name="Registro">            
				           		<br>
				           		<!-- <div class="form-group">
						            <input type="text" class="form-control" id="inputUsername" ng-model="username" ng-change="validateUsername($event, username)" name="inputUsername" placeholder="Username" required>
						        </div>
						        <small id="msgUsername">{{messageUsername}}</small>	
						        <h6 style="font-size:10px; color:#808080">El campo Username solo puede contener n�meros y letras, y tiene que tener una longitud de entre 5 y 15 caracteres.</h6>			        
						        <br>-->
						        
						        <h6 style="color:#808080">Username: ${usuarioModificar.getUsername()}</h6>
						        <input type="hidden" class="form-control" id="inputUsername" ng-model="username" name="inputUsername" value="${usuarioModificar.getUsername()}">
						  		<br>
						        <div class="form-group">
						            <input type="email" class="form-control" id="inputEmail" ng-model="email" ng-change="validateEmail($event, email)" name="inputEmail" placeholder="Email" required>
						        </div>
						        <small id="msgEmail">{{messageEmail}}</small>
						        <h6 style="font-size:10px; color:#808080">Direcci�n de email peteneciente al usuario.</h6>			        
						        <br>
						        <div class="form-group">
						            <input type="password" class="form-control" id="inputClave" ng-model="clave" ng-change="validateClave($event, clave, repClave)" name="inputClave" placeholder="Clave" required>
						        </div>
						        <small id="msgClave">{{messageClave}}</small>
						        <h6 style="font-size:10px; color:#808080">Solo puede contener n�meros y letras, y tiene que tener una longitud de entre 5 y 20 caracteres.</h6>
						        <br>
						        <div class="form-group">
						            <input type="password" class="form-control" id="inputRepiteClave" ng-model="repClave" ng-change="validateRepClave($event, clave, repClave)" name="inputRepiteClave" placeholder="Repetir Clave" required>
						        </div>
						        <small id="msgRepClave">{{messageRepClave}}</small>
						        <h6 style="font-size:10px; color:#808080">Deben coincidir los campos Clave y Repetir Clave.</h6>
						        <br>
						        <div class="form-group">
						            <input type="text" class="form-control" id="inputNyA" name="inputNyA" ng-model="nombreApellidos" placeholder="Nombre y Apellidos">
						        </div>
						        <div class="form-group">
						            <input type="text" class="form-control" id="inputCiudad" name="inputCiudad" ng-model="ciudad" placeholder="Ciudad">
						        </div>
						        <div class="form-group">
						            <input type="text" class="form-control" id="inputPais" name="inputPais" ng-model="pais" placeholder="Pais">
						        </div>
						        <div class="form-group">
						        	<p class="infoFotoPerfil"><strong>Foto de Perfil (con GRAVATAR)</strong></p>
						        	<label style="text-align:justify;"><strong>GRAVATAR </strong>es un servicio que ofrece un avatar �nico globalmente a trav�s de tu email. Si no est�s registrado, accede <a href="https://es.gravatar.com/" target="_blank">aqu�</a> para registrarte y elige que foto de perfil. Indica en el siguiente campo, el email con el que te has registrado.</label>
									<br>
									<input type="text" class="form-control" id="inputEmailAvatar" name="inputEmailAvatar" ng-model="fotoPerfil" value="" placeholder="">
									<br>
									<label style="text-align:justify;">Si no deseas incluir una foto de perfil, se te asignar� una foto de perfil por defecto.</label>
								</div>
								
						        <small id="msgError">{{messageError}}</small>
						        <div class="row">
						        	<div class="col-md-12" align="center" style="text-align:center;">
						        		<br>
						        		<button type="submit" class="btn" style="color:#FFFFA1;background-color:#4BD469;" id="btnGuardaCambios" name="btnGuardaCambios">
						        			<i class="fa fa-pencil-alt" aria-hidden="true"></i>
						        			Guardar Cambios
						        		</button>
						        	</div>
						        </div>	
						        <br><br>
							</form>
						</div>
						<div class="col-md-1"></div>
        			</div>
        			<br><br><br>
        		</div>
        		<div class="col-md-2"></div>
        		
        	</div>
        	
        	<div class="row">
        		<div class="col-md-12">
		        	<div class="row">
		        		<br><br>
		        	</div>
		        </div>
		    </div>
        </div>
        <!-- /.container-fluid -->
        
        <script>
			'use strict'
		    var app = angular.module('AppAdminModificaPerfil', []);
		    app.controller('AdminModificaPerfilCtrl', function($scope, $http) {
		    	$scope.messageUsername = "";
	        	$scope.messageEmail = "";
	        	$scope.messageClave = "";
	        	$scope.messageRepClave = "";
	        	$scope.messageError = "";
	        	
	        	var listaUsernames = [];
	        	var listaEmails = [];
	        	var indice = 0;
	        	
	        	var checkUsername = true;
	        	var checkExistUsername = false;
	        	var checkLongUsername = false;
	    		var checkCaracterUsername = true;
	        	
	        	var checkEmail = true;
	        	var existEmail = false;
	        	var checkCaracterEmail = false;
	        	
	        	var checkClave = true;
	        	var checkLongClave = false;
	        	var checkCaracterClave = false;
	        	
	        	var checkRepClave = true;
	        	
	        	$http({
	    	        method: 'GET',
	    	        url: 'getUsernames.do',
	                headers : {
	                	'Accept': 'application/json'
	                }
	    	    }).then(function mySuccess(response) {
	    	    	for(indice=0; indice<response.data.length; indice++){
	    	    		listaUsernames.push(response.data[indice]);
	    	    	}
	    	    }, function myError(response) {
	    	    	listaUsernames = [];
	    	    });
	        	
						        	
	        	$http({
	    	        method: 'GET',
	    	        url: 'getEmails.do',
	                headers : {
	                	'Accept': 'application/json'
	                }
	    	    }).then(function mySuccess(response) {
	    	    	for(indice=0; indice<response.data.length; indice++){
	    	    		listaEmails.push(response.data[indice]);
	    	    	}
	    	    }, function myError(response) {
	    	    	listaEmails = [];
	    	    });        	
	        	
	        	function enableBtnModificar(){
	        		if(checkUsername==true && checkEmail==true && checkClave==true && checkRepClave==true){
	        			if($scope.username=="" || $scope.clave=="" || $scope.repClave=="" || $scope.email==""){
	        				document.getElementById("btnGuardaCambios").disabled = true;
	        				document.getElementById("msgError").style.color="#E33A3A"
	        				$scope.messageError="Existen campos vac�os o err�neos. Por favor, rev�salos para continuar con el registro.";
	        			}else{
	        				$scope.messageError="";
	        				document.getElementById("btnGuardaCambios").disabled = false;
	        			}
	        		}else{
	        			document.getElementById("btnGuardaCambios").disabled = true;
	        			document.getElementById("msgError").style.color="#E33A3A"
	        			$scope.messageError="Existen campos vac�os o err�neos. Por favor, rev�salos para continuar con el registro.";
	        		}
	        	}
	        	
	        	
	        	$scope.validateEmail = function(event, email){
	        		checkEmail = false;
	        		existEmail = false;
		        	checkCaracterEmail = true;
		        	email = email.toLowerCase();
	        		
	        		for(indice=0; indice<listaEmails.length; indice++){
	        			if((listaEmails[indice]!="${usuarioModificar.getEmail()}") && (email == listaEmails[indice])){
	        				existEmail = true;
	        				document.getElementById("msgEmail").style.color="#E33A3A"
	        				$scope.messageEmail = "El email "+ email +" existe.";
	        				break;
	        			}
	        		}
	        		
	        		if(existEmail==false){
		        		for(indice=0; indice<email.length; indice++){
		        			if(email.charAt(indice)==' '){
		        				checkCaracterEmail = false;
		        				document.getElementById("msgEmail").style.color="#E33A3A"
		        				$scope.messageEmail = "La direccion de email no puede contener espacios.";
		        				break;
		        			}
		        		}
	        		}
	        		
	        		if(existEmail==false && checkCaracterEmail==true){
	        			document.getElementById("msgEmail").style.color="#5CC300"
	        			$scope.messageEmail = "El email "+ email + " est� disponible.";
	        			checkEmail = true;
	        		}
	        		
	        		enableBtnModificar();
		        }
	        	
	        	$scope.validateClave = function(event, clave, repClave){
	        		
	        		checkClave = false;
	        		checkLongClave = false;
	        		checkCaracterClave = true;
	        		
	        		if(clave.length>=5 && clave.length<=20){
	        			checkLongClave = true;
	        			for(indice=0; indice<clave.length; indice++){
	        				if(clave.charAt(indice)==' '){
	        					checkCaracterClave=false;
	        					document.getElementById("msgClave").style.color="#E33A3A"
		    		        	$scope.messageClave = "Error. La clave no puede contener espacios.";
	        					break;
	        				}else if((!(clave.charAt(indice)>='a' && clave.charAt(indice)<='z')) &&
	        				   (!(clave.charAt(indice)>='A' && clave.charAt(indice)<='Z')) &&
	        				   (!(clave.charAt(indice)>='0' && clave.charAt(indice)<='9'))){
	        					checkCaracterClave=false;
	        					document.getElementById("msgClave").style.color="#E33A3A"
	    		        		$scope.messageClave = "Error. El caracter "+clave.charAt(indice)+" no es valido.";
	        					break;
	        				}
	        			}
	        		}else{
	        			document.getElementById("msgClave").style.color="#E33A3A"
	        			$scope.messageClave = "Error. La longitud de la clave debe de ser entre 5 y 20 caracteres.";
	        		}
	        		
	        		if(checkLongClave==true && checkCaracterClave==true){
	        			document.getElementById("msgClave").style.color="#5CC300"
		        		$scope.messageClave = "La clave es v�lida.";
	        			checkClave = true;
	        		}
	        		
	        		$scope.validateRepClave(event, clave, repClave);
	        	}
	        	
	        	$scope.validateRepClave = function(event, clave, repClave){
	        		checkRepClave = false;
	        		if(clave==repClave){
	        			checkRepClave = true;
	        			document.getElementById("msgRepClave").style.color="#5CC300"
			        	$scope.messageRepClave = "Los campos Clave y Repite Clave coinciden.";
	        		}else{
	        			document.getElementById("msgRepClave").style.color="#E33A3A"
		        		$scope.messageRepClave = "Error. No coinciden los campos Clave y Repite Clave.";
	        		}
	        		enableBtnModificar();
	        	}
	        	
	        	$scope.username = "${usuarioModificar.getUsername()}";
				$scope.clave = "${usuarioModificar.getClave()}";
				$scope.repClave = "${usuarioModificar.getClave()}";
				$scope.email = "${usuarioModificar.getEmail()}";
				$scope.nombreApellidos = "${usuarioModificar.getNombreApellidos()}";
				$scope.ciudad = "${usuarioModificar.getCiudad()}";
				$scope.pais= "${usuarioModificar.getPais()}";
				$scope.fotoPerfil = "${usuarioModificar.getEmailFoto()}";
	        	
	        	enableBtnModificar();
	        	
	        });
		</script>

    	<script>
       		if("${usuario.getRol()}" === 'Administrador'){
       			document.getElementById("adminSidebarDivider").style.display="block";
       			document.getElementById("adminSidebarTitle").style.display="block";
       			document.getElementById("adminSidebar").style.display="block";
       		}
       	</script>  

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