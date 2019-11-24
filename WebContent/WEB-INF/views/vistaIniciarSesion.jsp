<!DOCTYPE html>
<html lang="en">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Flashcards - Acceder a la Aplicación</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="resources/css/view_IniciarSesion.css"/>
    <link rel="stylesheet" type="text/css" href="resources/css/view_All.css"/>

    <!-- Custom styles for this template -->
    <link href="resources/css/freelancer.min.css" rel="stylesheet">
    
    <!-- Angular JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    
  </head>

  <body id="page-top">		
  
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
	              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger active" href="iniciarSesion.html" style="color:#18bc9c;"><i class="fas fa-sign-in-alt" style="padding-right:10px;color:#18bc9c;"></i>Iniciar Sesión</a>
	            </li>
	            <li class="nav-item mx-0 mx-lg-1">
	              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="registro.html"><i class="fas fa-user-plus" style="padding-right:10px;"></i>Registrate</a>
	            </li>
	          </ul>
	        </div>
	      </div>
	    </nav>
	</header>
	<section>
		<br><br><br><br>
		<script type="text/javascript">				        
	        document.getElementById("btnSignIn").disabled = true;
			
        	function enableBtnSignIn(){
        		document.getElementById("btnSignIn").style.background = "green";
        		document.getElementById("btnSignIn").style.color = "white";
        		document.getElementById("btnSignIn").disabled = false;
        	}
		</script>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-4">
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<form action="iniciarSesion.do" method="post" class="form-signin">
							<br>
				            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Iniciar Sesión</h1>
				            <br>
				            <input type="text" id="inputUsernameEmail" name="inputUsernameEmail" class="form-control" placeholder="Email o usuario" required="" autofocus="">
				            <br>
				            <input type="password" id="inputClave" name="inputClave" class="form-control" placeholder="Contraseña" required="">
				            <br>
				            <div class="middle">
			                	<div class="g-recaptcha positionReCaptcha" data-theme="light" data-sitekey="6LeViL4UAAAAAI8LXCjiOO3iKtIRcwEkWLAYcdST" data-callback="enableBtnSignIn"></div>
			                </div>
				            <button class="btn btn-block btnBlock" type="submit" id="btnSignIn" disabled><i class="fas fa-sign-in-alt" style="padding-right:10px;"></i> Acceder a la Aplicación Flashcards</button>
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
						<form action="registro.html" method="get" class="form-signin">
				    		<p style="text-align:center;"><strong>Si aún no tienes cuenta, puedes crearte una</strong></p>
			            	<button class="btn btn-primary btn-block" style="background-color:red;border:red;padding-top:15px;padding-bottom:15px;" type="submit"><i class="fas fa-user-plus" style="padding-right:10px;"></i>Crear una cuenta nueva</button>
			            </form>
			            <br>
			            <form action="registro.html" method="get" class="form-signin">
			            	<p style="text-align:center;"><strong>Si has olvidado tu clave, puedes recuperarla</strong></p>
			            	<button class="btn btn-primary btn-block" style="background-color:orange;border:orange;padding-top:15px;padding-bottom:15px;" type="submit"><i class="fas fa-key" style="padding-right:10px;"></i>Recupera tu clave</button>
			            </form>
					</div>
					<div class="col-md-1"></div>
				</div>
			</div>
			<!-- <form action="/reset/password/" class="form-reset">
                <input type="email" id="resetEmail" class="form-control" placeholder="Email address" required="" autofocus="">
                <button class="btn btn-primary btn-block" type="submit">Reset Password</button>
                <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>
            </form>
            
            <form action="/signup/" class="form-signup">
                <div class="social-login">
                    <button class="btn facebook-btn social-btn" type="button"><span><i class="fab fa-facebook-f"></i> Sign up with Facebook</span> </button>
                </div>
                <div class="social-login">
                    <button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i> Sign up with Google+</span> </button>
                </div>
                
                <p style="text-align:center">OR</p>

                <input type="text" id="user-name" class="form-control" placeholder="Full name" required="" autofocus="">
                <input type="email" id="user-email" class="form-control" placeholder="Email address" required autofocus="">
                <input type="password" id="user-pass" class="form-control" placeholder="Password" required autofocus="">
                <input type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus="">

                <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
                <a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
            </form>
            <br>-->
			<!--<div class="col-md-4 formAccess textCenter container">
				<br>
				<h4 class="title">Iniciar Sesión</h4>
				<br>
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<form action="acceder.do" method="post" id="Login" name="Login" class="form-signin">
			                <span id="reauth-email" class="reauth-email"></span>
			                <input type="text" class="form-control" id="inputUsernameEmail" name="inputUsernameEmail" placeholder="Username o Email" required autofocus>
			                <br>
			                <input type="password" class="form-control" id="inputClave" name="inputClave" placeholder="Clave" required>
			                <br><br>
			                
			                <br><br>
			                <button class="btn btn-lg btn-block btn-signin btnBlock" id="buttonIS" name="buttonIS" type="submit">Acceder</button>
			                <br>
			                <p><a class="btnRecupera" href="recuperaCuenta.html">Ups.... ¿Olvidasta tu clave?</a></p>
			                <script>
			                	document.getElementById("buttonIS").disabled = true;
					        	function enableBtn(){
					        		document.getElementById("buttonIS").style.background = "#457D8E";
					        		document.getElementById("buttonIS").disabled = false;
					        	}
					        </script>
					     </form>
					</div>
					<div class="col-md-2"></div>
				</div>
			</div>-->
			<div class="col-md-2"></div>
		</div>
	</section>

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
    
    <!--Re captcha google-->
    <script src='https://www.google.com/recaptcha/api.js?'></script>
    
    <!-- Alert de Bootbox -->
    <script src="resources/js/bootbox.min.js"></script>
	
	<script>
		if("${mensaje}" != ""){
			bootbox.alert("${mensaje}");
		}
	</script>

  </body>

</html>