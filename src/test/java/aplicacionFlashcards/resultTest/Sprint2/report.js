$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("01UsuarioCreaCuentaUsuario.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Como usuario quiero una cuenta nueva para acceder al sistema",
  "description": "",
  "id": "como-usuario-quiero-una-cuenta-nueva-para-acceder-al-sistema",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Registro correcto. Registrar un usuario exitosamente",
  "description": "",
  "id": "como-usuario-quiero-una-cuenta-nueva-para-acceder-al-sistema;registro-correcto.-registrar-un-usuario-exitosamente",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Una persona quiere registrarse",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Introduce los datos correctamente",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Se registra correctamente",
  "keyword": "Then "
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.una_persona_quiere_registrarse()"
});
formatter.result({
  "duration": 1257333900,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_los_datos_correctamente()"
});
formatter.result({
  "duration": 30035300,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.existEmail(UsuariosMongoDB.java:162)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test01UsuarioCreaCuentaUsuario.introduce_los_datos_correctamente(Test01UsuarioCreaCuentaUsuario.java:26)\r\n\tat ✽.When Introduce los datos correctamente(01UsuarioCreaCuentaUsuario.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.se_registra_correctamente()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 10,
  "name": "Error en el Registro. Existe username",
  "description": "",
  "id": "como-usuario-quiero-una-cuenta-nueva-para-acceder-al-sistema;error-en-el-registro.-existe-username",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "Una persona quiere registrarse",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "Introduce un username existente",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "No se registra",
  "keyword": "Then "
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.una_persona_quiere_registrarse()"
});
formatter.result({
  "duration": 1534600,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_un_username_existente()"
});
formatter.result({
  "duration": 282800,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.existUsername(UsuariosMongoDB.java:169)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test01UsuarioCreaCuentaUsuario.introduce_un_username_existente(Test01UsuarioCreaCuentaUsuario.java:40)\r\n\tat ✽.When Introduce un username existente(01UsuarioCreaCuentaUsuario.feature:12)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 15,
  "name": "Error en el Registro. Caracter invalido en el username",
  "description": "",
  "id": "como-usuario-quiero-una-cuenta-nueva-para-acceder-al-sistema;error-en-el-registro.-caracter-invalido-en-el-username",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "Una persona quiere registrarse",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "El username contiene un caracter invalido",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "No se registra",
  "keyword": "Then "
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.una_persona_quiere_registrarse()"
});
formatter.result({
  "duration": 2276400,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.el_username_contiene_un_caracter_invalido()"
});
formatter.result({
  "duration": 69900,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 304400,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.existEmail(UsuariosMongoDB.java:162)\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.insertUsuario(UsuariosMongoDB.java:65)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test01UsuarioCreaCuentaUsuario.no_se_registra(Test01UsuarioCreaCuentaUsuario.java:45)\r\n\tat ✽.Then No se registra(01UsuarioCreaCuentaUsuario.feature:18)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 20,
  "name": "Error en el Registro. Longitud incorrecta del username",
  "description": "",
  "id": "como-usuario-quiero-una-cuenta-nueva-para-acceder-al-sistema;error-en-el-registro.-longitud-incorrecta-del-username",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "Una persona quiere registrarse",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "La longitud del username es incorrecta",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "No se registra",
  "keyword": "Then "
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.una_persona_quiere_registrarse()"
});
formatter.result({
  "duration": 1798900,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_longitud_del_username_es_incorrecta()"
});
formatter.result({
  "duration": 44600,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 251700,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.existEmail(UsuariosMongoDB.java:162)\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.insertUsuario(UsuariosMongoDB.java:65)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test01UsuarioCreaCuentaUsuario.no_se_registra(Test01UsuarioCreaCuentaUsuario.java:45)\r\n\tat ✽.Then No se registra(01UsuarioCreaCuentaUsuario.feature:23)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 25,
  "name": "Error en el Registro. Caracter invalido en la clave",
  "description": "",
  "id": "como-usuario-quiero-una-cuenta-nueva-para-acceder-al-sistema;error-en-el-registro.-caracter-invalido-en-la-clave",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "Una persona quiere registrarse",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "La clave contiene un caracter invalido",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "No se registra",
  "keyword": "Then "
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.una_persona_quiere_registrarse()"
});
formatter.result({
  "duration": 1605400,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_clave_contiene_un_caracter_invalido()"
});
formatter.result({
  "duration": 60400,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 275600,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.existEmail(UsuariosMongoDB.java:162)\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.insertUsuario(UsuariosMongoDB.java:65)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test01UsuarioCreaCuentaUsuario.no_se_registra(Test01UsuarioCreaCuentaUsuario.java:45)\r\n\tat ✽.Then No se registra(01UsuarioCreaCuentaUsuario.feature:28)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 30,
  "name": "Error en el Registro. Longitud de la clave incorrecta",
  "description": "",
  "id": "como-usuario-quiero-una-cuenta-nueva-para-acceder-al-sistema;error-en-el-registro.-longitud-de-la-clave-incorrecta",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "Una persona quiere registrarse",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "La longitud de la clave es incorrecta",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "No se registra",
  "keyword": "Then "
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.una_persona_quiere_registrarse()"
});
formatter.result({
  "duration": 4630600,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_longitud_de_la_clave_es_incorrecta()"
});
formatter.result({
  "duration": 39700,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 253600,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.existEmail(UsuariosMongoDB.java:162)\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.insertUsuario(UsuariosMongoDB.java:65)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test01UsuarioCreaCuentaUsuario.no_se_registra(Test01UsuarioCreaCuentaUsuario.java:45)\r\n\tat ✽.Then No se registra(01UsuarioCreaCuentaUsuario.feature:33)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 35,
  "name": "Error en el Registro. Existe email",
  "description": "",
  "id": "como-usuario-quiero-una-cuenta-nueva-para-acceder-al-sistema;error-en-el-registro.-existe-email",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 36,
  "name": "Una persona quiere registrarse",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "Introduce un email existente",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "No se registra",
  "keyword": "Then "
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.una_persona_quiere_registrarse()"
});
formatter.result({
  "duration": 1896600,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_un_email_existente()"
});
formatter.result({
  "duration": 264400,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.existEmail(UsuariosMongoDB.java:162)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test01UsuarioCreaCuentaUsuario.introduce_un_email_existente(Test01UsuarioCreaCuentaUsuario.java:75)\r\n\tat ✽.When Introduce un email existente(01UsuarioCreaCuentaUsuario.feature:37)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("02UsuarioIniciaSesion.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Como usuario quiero acceder al sistema para usar la aplicacion",
  "description": "",
  "id": "como-usuario-quiero-acceder-al-sistema-para-usar-la-aplicacion",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Login correcto. Login mediante email",
  "description": "",
  "id": "como-usuario-quiero-acceder-al-sistema-para-usar-la-aplicacion;login-correcto.-login-mediante-email",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Una persona quiere loguearse",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Se loguea con el email",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Se loguea correctamente",
  "keyword": "Then "
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.una_persona_quiere_loguearse()"
});
formatter.result({
  "duration": 1530600,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_con_el_email()"
});
formatter.result({
  "duration": 348600,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.login(UsuariosMongoDB.java:208)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test02UsuarioIniciaSesion.se_loguea_con_el_email(Test02UsuarioIniciaSesion.java:26)\r\n\tat ✽.When Se loguea con el email(02UsuarioIniciaSesion.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_correctamente()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 10,
  "name": "Login correcto. Login mediante username",
  "description": "",
  "id": "como-usuario-quiero-acceder-al-sistema-para-usar-la-aplicacion;login-correcto.-login-mediante-username",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "Una persona quiere loguearse",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "Se loguea con el username",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Se loguea correctamente",
  "keyword": "Then "
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.una_persona_quiere_loguearse()"
});
formatter.result({
  "duration": 1602200,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_con_el_username()"
});
formatter.result({
  "duration": 274100,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.login(UsuariosMongoDB.java:208)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test02UsuarioIniciaSesion.se_loguea_con_el_username(Test02UsuarioIniciaSesion.java:37)\r\n\tat ✽.When Se loguea con el username(02UsuarioIniciaSesion.feature:12)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_correctamente()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 15,
  "name": "Login incorrecto. Error en el email",
  "description": "",
  "id": "como-usuario-quiero-acceder-al-sistema-para-usar-la-aplicacion;login-incorrecto.-error-en-el-email",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "Una persona quiere loguearse",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "El email es erroneo",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "No se puede loguear",
  "keyword": "Then "
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.una_persona_quiere_loguearse()"
});
formatter.result({
  "duration": 1825700,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.el_email_es_erroneo()"
});
formatter.result({
  "duration": 286600,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.login(UsuariosMongoDB.java:208)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test02UsuarioIniciaSesion.el_email_es_erroneo(Test02UsuarioIniciaSesion.java:44)\r\n\tat ✽.When El email es erroneo(02UsuarioIniciaSesion.feature:17)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 20,
  "name": "Login incorrecto. Error en el username",
  "description": "",
  "id": "como-usuario-quiero-acceder-al-sistema-para-usar-la-aplicacion;login-incorrecto.-error-en-el-username",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "Una persona quiere loguearse",
  "keyword": "Given "
});
formatter.step({
  "line": 22,
  "name": "El username es erroneo",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "No se puede loguear",
  "keyword": "Then "
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.una_persona_quiere_loguearse()"
});
formatter.result({
  "duration": 1481200,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.el_username_es_erroneo()"
});
formatter.result({
  "duration": 273500,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.login(UsuariosMongoDB.java:208)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test02UsuarioIniciaSesion.el_username_es_erroneo(Test02UsuarioIniciaSesion.java:56)\r\n\tat ✽.When El username es erroneo(02UsuarioIniciaSesion.feature:22)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 25,
  "name": "Login incorrecto. Error en la clave",
  "description": "",
  "id": "como-usuario-quiero-acceder-al-sistema-para-usar-la-aplicacion;login-incorrecto.-error-en-la-clave",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "Una persona quiere loguearse",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "La clave es erronea",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "No se puede loguear",
  "keyword": "Then "
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.una_persona_quiere_loguearse()"
});
formatter.result({
  "duration": 1517200,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.la_clave_es_erronea()"
});
formatter.result({
  "duration": 275600,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.login(UsuariosMongoDB.java:208)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test02UsuarioIniciaSesion.la_clave_es_erronea(Test02UsuarioIniciaSesion.java:63)\r\n\tat ✽.When La clave es erronea(02UsuarioIniciaSesion.feature:27)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("03UsuarioVerPerfil.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Como usuario quiero ver mi perfil para ver mis datos",
  "description": "",
  "id": "como-usuario-quiero-ver-mi-perfil-para-ver-mis-datos",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Ver perfil con username",
  "description": "",
  "id": "como-usuario-quiero-ver-mi-perfil-para-ver-mis-datos;ver-perfil-con-username",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Una persona quiere ver su perfil",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Se ha logueado con el username",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Ve el perfil con el username",
  "keyword": "Then "
});
formatter.match({
  "location": "Test03UsuarioVePerfil.una_persona_quiere_ver_su_perfil()"
});
formatter.result({
  "duration": 2397600,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.se_loguea_con_el_username()"
});
formatter.result({
  "duration": 296400,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.login(UsuariosMongoDB.java:208)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test03UsuarioVePerfil.se_loguea_con_el_username(Test03UsuarioVePerfil.java:25)\r\n\tat ✽.When Se ha logueado con el username(03UsuarioVerPerfil.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.ve_el_perfil_con_el_username()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 10,
  "name": "Ver perfil con email",
  "description": "",
  "id": "como-usuario-quiero-ver-mi-perfil-para-ver-mis-datos;ver-perfil-con-email",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "Una persona quiere ver su perfil",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "Se ha logueado con el email",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Ve el perfil con el email",
  "keyword": "Then "
});
formatter.match({
  "location": "Test03UsuarioVePerfil.una_persona_quiere_ver_su_perfil()"
});
formatter.result({
  "duration": 1477200,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.se_loguea_con_el_email()"
});
formatter.result({
  "duration": 266600,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.login(UsuariosMongoDB.java:208)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test03UsuarioVePerfil.se_loguea_con_el_email(Test03UsuarioVePerfil.java:36)\r\n\tat ✽.When Se ha logueado con el email(03UsuarioVerPerfil.feature:12)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.ve_el_perfil_con_el_email()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("04UsuarioActualizaPerfil.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Como usuario quiero cambiar mis datos para actualizarlos",
  "description": "",
  "id": "como-usuario-quiero-cambiar-mis-datos-para-actualizarlos",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Actualizar Perfil",
  "description": "",
  "id": "como-usuario-quiero-cambiar-mis-datos-para-actualizarlos;actualizar-perfil",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Una persona quiere actualizar su perfil",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Cambia los datos",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Se actualiza el perfil correctamente",
  "keyword": "Then "
});
formatter.match({
  "location": "Test04UsuarioActualizaPerfil.una_persona_quiere_actualizar_su_perfil()"
});
formatter.result({
  "duration": 1783100,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.login(UsuariosMongoDB.java:208)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test04UsuarioActualizaPerfil.una_persona_quiere_actualizar_su_perfil(Test04UsuarioActualizaPerfil.java:20)\r\n\tat ✽.Given Una persona quiere actualizar su perfil(04UsuarioActualizaPerfil.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test04UsuarioActualizaPerfil.cambia_los_datos()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Test04UsuarioActualizaPerfil.se_actualiza_el_perfil_correctamente()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("05UsuarioEliminaPerfil.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Como usuario quiero eliminar mi perfil para no acceder mas",
  "description": "",
  "id": "como-usuario-quiero-eliminar-mi-perfil-para-no-acceder-mas",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Un usuario va a eliminar su perfil",
  "description": "",
  "id": "como-usuario-quiero-eliminar-mi-perfil-para-no-acceder-mas;un-usuario-va-a-eliminar-su-perfil",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Una persona quiere eliminar su perfil",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Da a eliminar",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Elimina su perfil",
  "keyword": "Then "
});
formatter.match({
  "location": "Test05UsuarioEliminaPerfil.una_persona_quiere_eliminar_su_perfil()"
});
formatter.result({
  "duration": 2588700,
  "error_message": "java.lang.NullPointerException\r\n\tat main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB.login(UsuariosMongoDB.java:208)\r\n\tat test.java.aplicacionFlashcards.stepDefinitions.Test05UsuarioEliminaPerfil.una_persona_quiere_eliminar_su_perfil(Test05UsuarioEliminaPerfil.java:21)\r\n\tat ✽.Given Una persona quiere eliminar su perfil(05UsuarioEliminaPerfil.feature:6)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Test05UsuarioEliminaPerfil.da_a_eliminar()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Test05UsuarioEliminaPerfil.elimina_su_perfil()"
});
formatter.result({
  "status": "skipped"
});
});