<!DOCTYPE html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


    <title>Flashcards - Registro de Usuarios</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="resources/css/view_Registro.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/view_All.css"/>

    <!-- Custom styles for this template -->
    <link href="resources/css/freelancer.min.css" rel="stylesheet">
    
    <!-- Angular JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    
  </head>

  <body id="page-top">		
		
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
	    
	    <!-- Angular JS -->
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
	
	    <!-- Navigation -->
	    <header class="header">
		    <nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
		      <div class="container">
		        <a class="navbar-brand js-scroll-trigger" href="inicio.html">
		        	<img class="logoFlashcards" src="resources/imagenes/logoFlashcards.JPG" alt=""/>
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
	              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="registro.html" style="color:#18bc9c;"><i class="fas fa-user-plus" style="padding-right:10px;color:#18bc9c;"></i>Registrate</a>
	            </li>
	          </ul>
	        </div>
		      </div>
		    </nav>
		</header>
		<section ng-app="AppRegistro" ng-controller="RegistroCtrl">
			<br><br><br><br>
			<script type="text/javascript">				        
		        document.getElementById("btnRegister").disabled = true;
				
	        	function enableBtnSignIn(){
	        		document.getElementById("btnRegister").style.background = "green";
	        		document.getElementById("btnRegister").style.color = "white";
	        		document.getElementById("btnRegister").disabled = false;
	        	}
			</script>
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-4">
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<form action="crearCuenta.do" method="post" class="form-signin">
								<br>
					            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Registro de Usuarios</h1>
					            <br>
					            <span><sup><i class="fas fa-asterisk" style="color:orange;font-size:10px;margin-right:5px;"></i></sup>Introduzca el nombre de usuario</span>
					            <input type="text" class="form-control" id="inputUsername" ng-model="username" ng-change="validateUsername($event, username)" name="inputUsername" placeholder="Username" required />
		                        <small id="msgUsername" class="mensajesReg">{{messageUsername}}</small>
		                        <br><br>
		                        <span><sup><i class="fas fa-asterisk" style="color:orange;font-size:10px;margin-right:5px;"></i></sup>Introduzca el email</span>
		                        <input type="email" class="form-control" id="inputEmail" ng-model="email" ng-change="validateEmail($event, email)" name="inputEmail" placeholder="Email" required />
		                        <small id="msgEmail" class="mensajesReg">{{messageEmail}}</small>
		                        <br><br>
		                        <span><sup><i class="fas fa-asterisk" style="color:orange;font-size:10px;margin-right:5px;"></i></sup>Introduzca la clave</span>
		                        <input type="password" class="form-control" id="inputClave" ng-model="clave" ng-change="validateClave($event, clave, repClave)" name="inputClave" placeholder="Clave" required />
		                        <small id="msgClave" class="mensajesReg">{{messageClave}}</small>
		                        <br><br>
		                        <span><sup><i class="fas fa-asterisk" style="color:orange;font-size:10px;margin-right:5px;"></i></sup>Vuelva a introducir la clave</span>
		                        <input type="password" class="form-control"  id="inputRepiteClave" ng-model="repClave" ng-change="validateRepClave($event, clave, repClave)" name="inputRepiteClave" placeholder="Repetir Clave" required />
		                        <small id="msgRepClave" class="mensajesReg">{{messageRepClave}}</small>
		                        <br><br>
		                        <small id="msgError" class="mensajesReg">{{messageError}}</small>
		                        <br><br>
		                        <span style="color:orange;font-size:12px;font-weight:bold;"><sup><i class="fas fa-asterisk" style="color:orange;font-size:10px;margin-right:5px;"></i></sup>Todos los campos son obligatorios</span>
		                        <br><br>
		                        <button type="submit" class="btn btn-lg btn-block btn-signin btnBlock" ng-disabled="btnDisabled" id="buttonRegistro" name="buttonRegistro"><i class="fas fa-user-plus" style="padding-right:10px;"></i>Crear usuario</button>
		                        <br><br><br>
					        </form>
						</div>
						<div class="col-md-1"></div>
					</div>
				</div>
				<div class="col-md-4" style="border-left: 0.5px solid black;">
					<br><br><br>
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<form action="iniciarSesion.html" method="get" class="form-signin">
					    		<p style="text-align:center;"><strong>Si ya tienes cuenta, puedes loguearte</strong></p>
				            	<button class="btn btn-primary btn-block" style="background-color:green;border:1px solid green;padding-top:15px;padding-bottom:15px;" type="submit"><i class="fas fa-sign-in-alt" style="padding-right:10px;"></i>Iniciar Sesión</button>
				            </form>
				            
				            <br>
				            
				            <form action="registro.html" method="get" class="form-signin">
				            	<p style="text-align:center;"><strong>Si has olvidado tu clave, puedes recuperarla</strong></p>
				            	<button class="btn btn-primary btn-block" style="background-color:#2BB18F;border:1px solid #2BB18F;padding-top:15px;padding-bottom:15px;" type="submit"><i class="fas fa-key" style="padding-right:10px;"></i>Recupera tu clave</button>
				            </form>
						</div>
						<div class="col-md-1"></div>
					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
		</section>
		
		<script>
		    var app = angular.module('AppRegistro', []);
	        app.controller('RegistroCtrl', function($scope, $http) {
	        	
	        	$scope.btnDisabled = true;
	        	/*document.getElementById("buttonRegistro").style.background="#457D8E";
	        	document.getElementById("buttonRegistro").style.color="#DDDDDC";*/
	        	
	        	$scope.messageUsername = "";
	        	$scope.messageEmail = "";
	        	$scope.messageClave = "";
	        	$scope.messageRepClave = "";
	        	$scope.messageError = "";
	        	
	        	
	        	var listaUsernames = [];
	        	var listaEmails = [];
	        	
	        	var indice = 0;
	        	
	        	var checkUsername = false;
	        	var checkExistUsername = false;
	        	var checkLongUsername = false;
	       		var checkCaracterUsername = true;
	        	
	        	var checkEmail = false;
	        	var existEmail = false;
	        	var checkCaracterEmail = false;
	        	
	        	var checkClave = false;
	        	var checkLongClave = false;
	        	var checkCaracterClave = false;
	        	
	        	var checkRepClave = false;
	        	
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
		       		        	
	        	function enableBtnRegistro(){
	        		if(checkUsername==true && checkEmail==true && checkClave==true && checkRepClave==true){
	        			if($scope.username=="" || $scope.clave=="" || $scope.repClave=="" || $scope.email==""){
	        				$scope.btnDisabled = true;
	        				document.getElementById("msgError").style.color="red";
	        				document.getElementById("buttonRegistro").style.background="##457D8E";
	        				$scope.messageError="Existen campos vacíos o erróneos. Por favor, revísalos para continuar con el registro.";
	        			}else{
	        				$scope.messageError="";
	        				$scope.btnDisabled = false;
	        				document.getElementById("buttonRegistro").style.background="red";
	        				document.getElementById("buttonRegistro").style.color="white";
	        			}
	        		}else{
	        			$scope.btnDisabled = true;
	        			document.getElementById("msgError").style.color="red"
	        			document.getElementById("buttonRegistro").style.background="#457D8E";
	        			/*document.getElementById("buttonRegistro").style.color="#DDDDDC";*/
	        			$scope.messageError="Existen campos vacíos o erróneos. Por favor, revísalos para continuar con el registro.";
	        		}
	        	}
	        	
	        	$scope.validateUsername = function(event, username){
	        		checkUsername = false;
	        		checkExistUsername = false;
	        		checkLongUsername = false;
	        		checkCaracterUsername = true;
	        		
	        		for(indice=0; indice<listaUsernames.length; indice++){
	        			if(username == listaUsernames[indice]){
	        				checkExistUsername = true;
	        				document.getElementById("msgUsername").style.color="red"
	        				$scope.messageUsername = "Error. El username "+username+" existe.";
	        				break;
	        			}
	        		}
	        		
	        		if(checkExistUsername==false){		        			
	        			if(username.length>=5 && username.length<=15){
		        			checkLongUsername = true;
		        			for(indice=0; indice<username.length; indice++){
		        				if(username.charAt(indice)==' '){
		        					checkCaracterUsername=false;
		        					document.getElementById("msgUsername").style.color="red"
		        					$scope.messageUsername = "El username no puede contener espacios.";
		        					break;
		        				}else if((!(username.charAt(indice)>='a' && username.charAt(indice)<='z')) &&
		        				   (!(username.charAt(indice)>='A' && username.charAt(indice)<='Z')) &&
		        				   (!(username.charAt(indice)>='0' && username.charAt(indice)<='9'))){
		        					checkCaracterUsername=false;
		        					document.getElementById("msgUsername").style.color="red"
		        					$scope.messageUsername = "El caracter "+ username.charAt(indice) +" no se permite para este campo.";
		        					break;
		        				}
		        			}
		        			
		        			if(checkCaracterUsername==true){
		        				document.getElementById("msgUsername").style.color="green"
		        				$scope.messageUsername = "El username "+username+" está disponible.";
		        			}
		        			
		        		}else{
		        			document.getElementById("msgUsername").style.color="red"
		        			$scope.messageUsername = "Error. La longitud del username debe de ser entre 5 y 15 caracteres.";
		        		}
	        			
	        			
	        		}
	        		
	        		if(checkExistUsername==false && checkLongUsername==true && checkCaracterUsername==true){
	        			checkUsername = true;
	        		}
	        		
	        		enableBtnRegistro();
	        	}
	        	
	        	$scope.validateEmail = function(event, email){
	        		checkEmail = false;
	        		existEmail = false;
		        	checkCaracterEmail = true;
		        	email = email.toLowerCase();
	        		
	        		for(indice=0; indice<listaEmails.length; indice++){
	        			if(email == listaEmails[indice]){
	        				existEmail = true;
	        				document.getElementById("msgEmail").style.color="red"
	        				$scope.messageEmail = "El email "+ email +" existe.";
	        				break;
	        			}
	        		}
	        		
	        		if(existEmail==false){
		        		for(indice=0; indice<email.length; indice++){
		        			if(email.charAt(indice)==' '){
		        				checkCaracterEmail = false;
		        				document.getElementById("msgEmail").style.color="red"
		        				$scope.messageEmail = "La direccion de email no puede contener espacios.";
		        				break;
		        			}
		        		}
	        		}
	        		
	        		if(existEmail==false && checkCaracterEmail==true){
	        			document.getElementById("msgEmail").style.color="green"
	        			$scope.messageEmail = "El email "+ email + " está disponible.";
	        			checkEmail = true;
	        		}
	        		
	        		enableBtnRegistro();
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
	        					document.getElementById("msgClave").style.color="red"
		    		        	$scope.messageClave = "Error. La clave no puede contener espacios.";
	        					break;
	        				}else if((!(clave.charAt(indice)>='a' && clave.charAt(indice)<='z')) &&
	        				   (!(clave.charAt(indice)>='A' && clave.charAt(indice)<='Z')) &&
	        				   (!(clave.charAt(indice)>='0' && clave.charAt(indice)<='9'))){
	        					checkCaracterClave=false;
	        					document.getElementById("msgClave").style.color="red"
	    		        		$scope.messageClave = "Error. El caracter "+clave.charAt(indice)+" no es valido.";
	        					break;
	        				}
	        			}
	        		}else{
	        			document.getElementById("msgClave").style.color="red"
	        			$scope.messageClave = "Error. La longitud de la clave debe de ser entre 5 y 20 caracteres.";
	        		}
	        		
	        		if(checkLongClave==true && checkCaracterClave==true){
	        			document.getElementById("msgClave").style.color="green";
		        		$scope.messageClave = "La clave es válida.";
	        			checkClave = true;
	        		}
	        		
	        		$scope.validateRepClave(event, clave, repClave);
	        	}
	        	
	        	$scope.validateRepClave = function(event, clave, repClave){
	        		checkRepClave = false;
	        		if(clave==repClave){
	        			checkRepClave = true;
	        			document.getElementById("msgRepClave").style.color="green"
			        	$scope.messageRepClave = "Los campos Clave y Repite Clave coinciden.";
	        		}else{
	        			document.getElementById("msgRepClave").style.color="red"
		        		$scope.messageRepClave = "Error. No coinciden los campos Clave y Repite Clave.";
	        		}
	        		enableBtnRegistro();
	        	}
	        	
	        });
	    </script>
	    
	    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	    <div class="scroll-to-top d-lg-none position-fixed ">
	      <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
	        <i class="fa fa-angle-up"></i>
	      </a>
	    </div>
	    
	    <!-- Alert de Bootbox -->
	    <script src="resources/js/bootbox.min.js"></script>
		
		<script>
			if("${mensaje}" != ""){
				bootbox.alert("${mensaje}");
			}
		</script>
	
  </body>
</html>