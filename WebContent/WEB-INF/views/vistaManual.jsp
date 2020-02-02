<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">


  <title>Flashcards - Manual de Usuario</title>

  <!-- Custom fonts for this template-->
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
  <link href="resources/css/view_All.css" rel="stylesheet">
  <link href="resources/css/perfil.css" rel="stylesheet">
  
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
          <i class="fa fa-arrow-left" aria-hidden="true"></i>
          <span>Volver a la Aplicación</span></a>
      </li>

      <!-- Divider-->
      <hr class="sidebar-divider my-0">


      <li class="nav-item">
        <a class="nav-link" href="desarrolloProyecto.html">
          <i class="fa fa-sitemap" aria-hidden="true"></i>
          <span>Wiki del Proyecto</span></a>
      </li>    
      
      <li class="nav-item active">
        <a class="nav-link" href="manualProyecto.html">
          <i class="fa fa-book" aria-hidden="true"></i>
          <span>Manual del Proyecto</span></a>
      </li> 
      
      <hr class="sidebar-divider" id="adminSidebarDivider">
      <div class="sidebar-heading" id="adminSidebarTitle">
        SPRINTS
      </div>
      <li class="nav-item" id="sprint0">
        <a class="nav-link" href="desarrolloProyecto-s0.html">
          <i class="fa fa-history" aria-hidden="true"></i>
          <span>Planificación (Sprint 0)</span></a>
      </li>
      
      
      <li class="nav-item" id="sprint1">
        <a class="nav-link" href="desarrolloProyecto-s1.html">
          <i class="fa fa-history" aria-hidden="true"></i>
          <span>Sprint 1</span></a>
      </li>
      <li class="nav-item" id="sprint2">
        <a class="nav-link" href="desarrolloProyecto-s2.html">
          <i class="fa fa-history" aria-hidden="true"></i>
          <span>Sprint 2</span></a>
      </li>
      <li class="nav-item" id="sprint3">
        <a class="nav-link" href="desarrolloProyecto-s3.html">
          <i class="fa fa-history" aria-hidden="true"></i>
          <span>Sprint 3</span></a>
      </li>
      <li class="nav-item" id="sprint4">
        <a class="nav-link" href="desarrolloProyecto-s4.html">
          <i class="fa fa-history" aria-hidden="true"></i>
          <span>Sprint 4</span></a>
      </li>
      <li class="nav-item" id="sprint5">
        <a class="nav-link" href="desarrolloProyecto-s5.html">
          <i class="fa fa-history" aria-hidden="true"></i>
          <span>Sprint 5</span></a>
      </li>
      <li class="nav-item" id="sprint6">
        <a class="nav-link" href="desarrolloProyecto-s6.html">
          <i class="fa fa-history" aria-hidden="true"></i>
          <span>Sprint 6</span></a>
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
          <ul class="navbar-nav ml-auto"></ul>
        </nav>
        
        <div class="container-fluid">
        	<div class="row">
        		<div class="col-md-12">
        			<div class="row">
        				<div class="col-md-1"></div>
        				<div class="col-md-10">
        					<br>
        					<div style="text-align:center;">
	       						<span style="font-weight:bold;font-style: italic;font-size:20px;">
	       							Manual de Usuario
	       						</span>
	       					</div>
	       					<br>
        					<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							A continuación, se muestra en este apartado un manual de usuario con las principales funcionalidades de la aplicación.
        						
        						</span>
        					</div>
        					<br><br>
        					<span style="text-align:left;font-weight:bold;font-size:17px;">
       							1. Registro del Usuario
       						</span>
       						
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							En la primera parte de la reunión, el Product Owner proporcionó al equipo el Product
									Backlog con las tareas priorizadas que son deseables tener al finalizar este Sprint. El equipo
									preguntó dudas sobre las tareas. En la segunda parte de la reunión, el equipo forma el Sprint
									Backlog con las tareas que se van a abordar, dando una estimación sobre lo que se tardará
									en hacerlas. El Product Owner dio su aprobación para abordarlas. Estas tareas se organizaron
									en Historias de Usuario y son las que se aparecen en la siguiente tabla:
        						
        						</span>
        					</div>
        					<span style="text-align:left;font-weight:bold;font-size:17px;">
       							2. Iniciar Sesión
       						</span>
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							En la primera parte de la reunión, el Product Owner proporcionó al equipo el Product
									Backlog con las tareas priorizadas que son deseables tener al finalizar este Sprint. El equipo
									preguntó dudas sobre las tareas. En la segunda parte de la reunión, el equipo forma el Sprint
									Backlog con las tareas que se van a abordar, dando una estimación sobre lo que se tardará
									en hacerlas. El Product Owner dio su aprobación para abordarlas. Estas tareas se organizaron
									en Historias de Usuario y son las que se aparecen en la siguiente tabla:
        						
        						</span>
        					</div>
        					<span style="text-align:left;font-weight:bold;font-size:17px;">
       							3. Recuperar Cuenta
       						</span>
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							En la primera parte de la reunión, el Product Owner proporcionó al equipo el Product
									Backlog con las tareas priorizadas que son deseables tener al finalizar este Sprint. El equipo
									preguntó dudas sobre las tareas. En la segunda parte de la reunión, el equipo forma el Sprint
									Backlog con las tareas que se van a abordar, dando una estimación sobre lo que se tardará
									en hacerlas. El Product Owner dio su aprobación para abordarlas. Estas tareas se organizaron
									en Historias de Usuario y son las que se aparecen en la siguiente tabla:
        						
        						</span>
        					</div>
        					<span style="text-align:left;font-weight:bold;font-size:17px;">
       							4. Ver Perfil de Usuario
       						</span>
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							En la primera parte de la reunión, el Product Owner proporcionó al equipo el Product
									Backlog con las tareas priorizadas que son deseables tener al finalizar este Sprint. El equipo
									preguntó dudas sobre las tareas. En la segunda parte de la reunión, el equipo forma el Sprint
									Backlog con las tareas que se van a abordar, dando una estimación sobre lo que se tardará
									en hacerlas. El Product Owner dio su aprobación para abordarlas. Estas tareas se organizaron
									en Historias de Usuario y son las que se aparecen en la siguiente tabla:
        						
        						</span>
        					</div>
        					<span style="text-align:left;font-weight:bold;font-size:17px;">
       							5. Modificar y Eliminar Cuenta (Recuperación de Cuenta Eliminada)
       						</span>
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							En la primera parte de la reunión, el Product Owner proporcionó al equipo el Product
									Backlog con las tareas priorizadas que son deseables tener al finalizar este Sprint. El equipo
									preguntó dudas sobre las tareas. En la segunda parte de la reunión, el equipo forma el Sprint
									Backlog con las tareas que se van a abordar, dando una estimación sobre lo que se tardará
									en hacerlas. El Product Owner dio su aprobación para abordarlas. Estas tareas se organizaron
									en Historias de Usuario y son las que se aparecen en la siguiente tabla:
        						
        						</span>
        					</div>
        					<span style="text-align:left;font-weight:bold;font-size:17px;">
       							6. Cerrar Cuenta
       						</span>
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							En la primera parte de la reunión, el Product Owner proporcionó al equipo el Product
									Backlog con las tareas priorizadas que son deseables tener al finalizar este Sprint. El equipo
									preguntó dudas sobre las tareas. En la segunda parte de la reunión, el equipo forma el Sprint
									Backlog con las tareas que se van a abordar, dando una estimación sobre lo que se tardará
									en hacerlas. El Product Owner dio su aprobación para abordarlas. Estas tareas se organizaron
									en Historias de Usuario y son las que se aparecen en la siguiente tabla:
        						
        						</span>
        					</div>
        					<!-- Prueba:
        					
        					<span style="text-align:left;font-weight:bold;font-size:17px;">
       							1. Planificación del Sprint
       						</span>
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							En la primera parte de la reunión, el Product Owner proporcionó al equipo el Product
									Backlog con las tareas priorizadas que son deseables tener al finalizar este Sprint. El equipo
									preguntó dudas sobre las tareas. En la segunda parte de la reunión, el equipo forma el Sprint
									Backlog con las tareas que se van a abordar, dando una estimación sobre lo que se tardará
									en hacerlas. El Product Owner dio su aprobación para abordarlas. Estas tareas se organizaron
									en Historias de Usuario y son las que se aparecen en la siguiente tabla:
        						
        						</span>
        					</div>
       						<br>
       							<img src="resources/imagenes/s0-sprintBacklog.JPG" style="height:300px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 0)">
       						<br>
        					
        					 -->
        				</div>
        				<div class="col-md-1"></div>
        			</div>
        		</div>
        	</div>
        	<div class="row">
        		<br><br>
        	</div>
        	<div class="row">
        		<div class="col-md-12">
        			<div class="row">
        				<div class="col-md-4"></div>
        				<div class="col-md-4">
        					<form action="inicio.html">
			        			<button type="submit" class="btn" style="width:100%;height:50px;background-color:green;color:white;">
			        				<i class="fa fa-arrow-left" aria-hidden="true" style="margin-right:5px;"></i>
			        				Volver a la Aplicación
			        			</button>
			        		</form>
        				</div>
        				<div class="col-md-4"></div>
        			</div>
        		</div>
        	</div>
        	<div class="row">
        		<br><br>
        	</div>
        </div>

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

</body>

</html>