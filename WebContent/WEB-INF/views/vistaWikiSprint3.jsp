<!DOCTYPE html>
<html lang="es">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">


  <title>Flashcards - Wiki sobre el Desarrollo del Proyecto (Sprint 3)</title>

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
      
      <li class="nav-item">
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
      <li class="nav-item active" id="sprint3">
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
	       							Sprint 3
	       						</span>
	       					</div>
        					<br>
        					<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							Este Sprint dura del 14 al 27 de octubre de 2019. Se desarrollan las funcionalidades del administrador (generar una clave de usuario, 
        							eliminar usuario, cambiar rol de usuario y modificar el perfil de usuario),  gestión de clubes (creación, eliminación, unirse a un club, 
        							dejar el club y que el administrador elimine a un usuario) y gestión de amistades (enviar y recibir peticiones de amistad, pudiendo 
        							aceptarlas o rechazarlas, eliminar a un amigo, bloquear y desbloquear un usuario). En la Wiki, se detalla la evolución del 
        							desarrollo del proyecto en este Sprint.
        						
        						</span>
        					</div>
        					<br>
       						<span style="text-align:left;font-weight:bold;font-size:17px;">
       							1. Planificación del Sprint
       						</span>
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							El Product Owner proporciona al equipo las tareas priorizadas que forman el Product Backlog:
        						
        						</span>
        					</div>
       						<br>
       							<img src="resources/imagenes/s3-productBacklog.JPG" style="height:300px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							El Product Owner proporciona al equipo las tareas priorizadas que forman el Product Backlog y que son:. Tras analizar dichas tareas, el equipo formó 
        							el Sprint Backlog con las tareas que se van a abordar, dando una estimación sobre lo que se tardará en hacerlas. Estas tareas son:
        						
        						</span>
        					</div>
       						<br>
       							<img src="resources/imagenes/s3-sprintBacklog-1.JPG" style="height:500px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<br>
       							<img src="resources/imagenes/s3-sprintBacklog-2.JPG" style="height:500px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<br>
       							<img src="resources/imagenes/s3-sprintBacklog-3.JPG" style="height:500px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<br>
       							<img src="resources/imagenes/s3-sprintBacklog-4.JPG" style="height:200px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<span style="text-align:left;font-weight:bold;font-size:17px;">
       							2. Desarrollo del Sprint
       						</span>
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							En primer lugar, se crearon las pruebas BDD, respecto a las funcionalidades que se van a desarrollar. 
        							Al finalizar el Sprint, todas las pruebas pasaron exitosamente.
        						
        						</span>
        					</div>
        					<br><br>
       							<img src="resources/imagenes/s3-bdd.JPG" style="height:300px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							Para poder desarrollar la aplicación, se diseñó el siguiente diagrama, 
        							identificando las funcionalidades:
        						
        						</span>
        					</div>
        					<br><br>
       							<img src="resources/imagenes/s3-cdu.JPG" style="height:300px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							Estas son algunos bocetos y capturas de la aplicación:
        						
        						</span>
        					</div>
        					<br><br>
       							<img src="resources/imagenes/s3-cap1.JPG" style="height:300px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<br>
       							<img src="resources/imagenes/s3-cap2.JPG" style="height:300px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<br>
       							<img src="resources/imagenes/s3-cap3.JPG" style="height:300px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<br>
       							<img src="resources/imagenes/s3-cap4.JPG" style="height:300px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<br><br>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							Para hacer un seguimiento de la situación del proyecto de este Sprint, cada día se realizaba una 
        							reunión (Daily Scrum) para analizar lo que se había realizado el día anterior, lo que se realiza 
        							ese día y si había algún inconveniente o problema en el desarrollo del proyecto:
        						
        						</span>
        					</div>
        					<br><br>
       							<img src="resources/imagenes/s3-dailyScrum.JPG" style="height:300px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<span style="text-align:left;font-weight:bold;font-size:17px;">
       							3. Cierre del Sprint
       						</span>
       						<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							Tras el desarrollo del Sprint, se mostraron al Product Owner las funcionalidades realizadas en 
        							el Sprint: funcionalidades de gestión de usuario y de clubes por parte del administrador, 
        							creación y permanencia de clubes, y por último relaciones entre los usuarios. El Product Owner 
        							nos da su aprobación, para que continuemos desarrollando la aplicación.
        						
        						</span>
        					</div>
        					<br>
        					<div style="text-align:justify;">
        						<span style="font-size:14px;">
        						
        							A pesar de haber tenido alguna desviación, en la reunión de retrospectiva se concluye que se ha trabajado 
        							bien durante el Sprint, siguiendo la planificación inicial. En el gráfico Burndown, se aprecia 
        							que la estimación inicial y la evolución real del proyecto en el Sprint, coinciden aproximadamente, teniendo 
        							en cuenta que Zenhub cuenta que en los fines de semana no se trabaja, cuando realmente si se ha trabajado. 
        							En el tablero Scrum, se ha realizad un seguimiento diario de las tareas que se han abordado.
        						
        						</span>
        					</div>
        					<br><br>
       							<img src="resources/imagenes/s3-burndown.JPG" style="height:300px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
       						<br>
       							<img src="resources/imagenes/s3-tableroScrum.JPG" style="height:300px;width:auto;display:block; margin-left:auto;margin-right:auto;" alt="Sprint Backlog (Sprint 1)">
       						<br>
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
        					<div class="row">
        						<div class="col-md-6">
        							<form action="desarrolloProyecto-s2.html">
					        			<button type="submit" class="btn" style="width:100%;height:50px;background-color:#FF2828;color:white;">
					        				<i class="fa fa-arrow-left" aria-hidden="true" style="margin-right:5px;"></i>
					        				Sprint 2 
					        			</button>
					        		</form>
        						</div>
        						<div class="col-md-6">
        							<form action="desarrolloProyecto-s4.html">
					        			<button type="submit" class="btn" style="width:100%;height:50px;background-color:#FFB742;color:white;">
					        				Sprint 4 
					        				<i class="fa fa-arrow-right" aria-hidden="true" style="margin-left:5px;"></i>
					        			</button>
					        		</form>
        						</div>
        					</div>
			        		<br>
			        		<form action="desarrolloProyecto.html">
			        			<button type="submit" class="btn" style="width:100%;height:50px;background-color:green;color:white;">
			        				<i class="fa fa-sitemap" aria-hidden="true" style="margin-right:5px;"></i>
			        				Wiki del Proyecto
			        			</button>
			        		</form>
        				</div>
        				<div class="col-md-4"></div>
        			</div>
        		</div>
        		
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