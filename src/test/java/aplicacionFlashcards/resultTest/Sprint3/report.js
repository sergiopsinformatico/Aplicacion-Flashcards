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
  "duration": 2781921800,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_los_datos_correctamente()"
});
formatter.result({
  "duration": 1034045700,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.se_registra_correctamente()"
});
formatter.result({
  "duration": 505772400,
  "status": "passed"
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
  "duration": 7564900,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_un_username_existente()"
});
formatter.result({
  "duration": 669750900,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 39015200,
  "status": "passed"
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
  "duration": 6959000,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.el_username_contiene_un_caracter_invalido()"
});
formatter.result({
  "duration": 35100,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 829665400,
  "status": "passed"
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
  "duration": 5501300,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_longitud_del_username_es_incorrecta()"
});
formatter.result({
  "duration": 41700,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 618537800,
  "status": "passed"
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
  "duration": 5347600,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_clave_contiene_un_caracter_invalido()"
});
formatter.result({
  "duration": 31300,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 628415400,
  "status": "passed"
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
  "duration": 8224200,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_longitud_de_la_clave_es_incorrecta()"
});
formatter.result({
  "duration": 39500,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 675061400,
  "status": "passed"
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
  "duration": 7761500,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_un_email_existente()"
});
formatter.result({
  "duration": 653447600,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 41801700,
  "status": "passed"
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
  "duration": 2921200,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_con_el_email()"
});
formatter.result({
  "duration": 696081500,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_correctamente()"
});
formatter.result({
  "duration": 26100,
  "status": "passed"
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
  "duration": 3102800,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_con_el_username()"
});
formatter.result({
  "duration": 662485700,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_correctamente()"
});
formatter.result({
  "duration": 23600,
  "status": "passed"
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
  "duration": 2358700,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.el_email_es_erroneo()"
});
formatter.result({
  "duration": 727414400,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "duration": 29700,
  "status": "passed"
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
  "duration": 2910400,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.el_username_es_erroneo()"
});
formatter.result({
  "duration": 689661500,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "duration": 16200,
  "status": "passed"
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
  "duration": 3210400,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.la_clave_es_erronea()"
});
formatter.result({
  "duration": 699475600,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "duration": 25600,
  "status": "passed"
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
  "duration": 3108600,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.se_loguea_con_el_username()"
});
formatter.result({
  "duration": 670744300,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.ve_el_perfil_con_el_username()"
});
formatter.result({
  "duration": 114511800,
  "status": "passed"
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
  "duration": 2882500,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.se_loguea_con_el_email()"
});
formatter.result({
  "duration": 682409700,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.ve_el_perfil_con_el_email()"
});
formatter.result({
  "duration": 118009400,
  "status": "passed"
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
  "duration": 700553000,
  "status": "passed"
});
formatter.match({
  "location": "Test04UsuarioActualizaPerfil.cambia_los_datos()"
});
formatter.result({
  "duration": 38600,
  "status": "passed"
});
formatter.match({
  "location": "Test04UsuarioActualizaPerfil.se_actualiza_el_perfil_correctamente()"
});
formatter.result({
  "duration": 201900200,
  "status": "passed"
});
formatter.uri("05AdministradorCambiaRol.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Administrador cambia el rol a un usuario",
  "description": "",
  "id": "administrador-cambia-el-rol-a-un-usuario",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Administrador cambia el rol a un usuario",
  "description": "",
  "id": "administrador-cambia-el-rol-a-un-usuario;administrador-cambia-el-rol-a-un-usuario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un administrador quiere cambiar el rol de un usuario",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Localiza a ese usuario",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Cambia su rol",
  "keyword": "Then "
});
formatter.match({
  "location": "Test05AdministradorCambiaRol.un_administrador_quiere_cambiar_el_rol_de_un_usuario()"
});
formatter.result({
  "duration": 859773500,
  "status": "passed"
});
formatter.match({
  "location": "Test05AdministradorCambiaRol.localiza_a_ese_usuario()"
});
formatter.result({
  "duration": 82621700,
  "status": "passed"
});
formatter.match({
  "location": "Test05AdministradorCambiaRol.cambia_su_rol()"
});
formatter.result({
  "duration": 127458000,
  "status": "passed"
});
formatter.uri("06AdministradorEliminaUsuario.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Administrador elimina a un usuario",
  "description": "",
  "id": "administrador-elimina-a-un-usuario",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Administrador elimina un usuario",
  "description": "",
  "id": "administrador-elimina-a-un-usuario;administrador-elimina-un-usuario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un administrador quiere eliminar a un usuario",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Encuentra a ese usuario",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Le elimina del sistema",
  "keyword": "Then "
});
formatter.match({
  "location": "Test06AdministradorEliminaUsuario.un_administrador_quiere_eliminar_a_un_usuario()"
});
formatter.result({
  "duration": 865333000,
  "status": "passed"
});
formatter.match({
  "location": "Test06AdministradorEliminaUsuario.encuentra_a_ese_usuario()"
});
formatter.result({
  "duration": 41137600,
  "status": "passed"
});
formatter.match({
  "location": "Test06AdministradorEliminaUsuario.le_elimina_del_sistema()"
});
formatter.result({
  "duration": 80471800,
  "status": "passed"
});
formatter.uri("07UsuarioCreaClub.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Usuario crea un club",
  "description": "",
  "id": "usuario-crea-un-club",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Un usuario crea un club",
  "description": "",
  "id": "usuario-crea-un-club;un-usuario-crea-un-club",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un usuario no encuentra club",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Crea un club",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Existe el club",
  "keyword": "Then "
});
formatter.match({
  "location": "Test07UsuarioCreaClub.un_usuario_no_encuentra_club()"
});
formatter.result({
  "duration": 1086748200,
  "status": "passed"
});
formatter.match({
  "location": "Test07UsuarioCreaClub.crea_un_club()"
});
formatter.result({
  "duration": 81266100,
  "status": "passed"
});
formatter.match({
  "location": "Test07UsuarioCreaClub.existe_el_club()"
});
formatter.result({
  "duration": 40026400,
  "status": "passed"
});
formatter.uri("08UsuarioSeUneClub.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Un usuario se une a un club",
  "description": "",
  "id": "un-usuario-se-une-a-un-club",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Un usuario se une a un club",
  "description": "",
  "id": "un-usuario-se-une-a-un-club;un-usuario-se-une-a-un-club",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un usuario encuentra un club",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Solicita unirse",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Forma parte de este club",
  "keyword": "Then "
});
formatter.match({
  "location": "Test08UsuarioSeUneAClub.un_usuario_encuentra_un_club()"
});
formatter.result({
  "duration": 682100200,
  "status": "passed"
});
formatter.match({
  "location": "Test08UsuarioSeUneAClub.solicita_unirse()"
});
formatter.result({
  "duration": 121920900,
  "status": "passed"
});
formatter.match({
  "location": "Test08UsuarioSeUneAClub.forma_parte_de_este_club()"
});
formatter.result({
  "duration": 41219500,
  "status": "passed"
});
formatter.uri("09UsuarioDejaClub.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Usuario deja club",
  "description": "",
  "id": "usuario-deja-club",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Un usuario deja un club",
  "description": "",
  "id": "usuario-deja-club;un-usuario-deja-un-club",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un usuario que pertenece a un club",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Deja el club",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "No pertenece al club",
  "keyword": "Then "
});
formatter.match({
  "location": "Test09UsuarioDejaClub.un_usuario_que_pertenece_a_un_club()"
});
formatter.result({
  "duration": 679658000,
  "status": "passed"
});
formatter.match({
  "location": "Test09UsuarioDejaClub.deja_el_club()"
});
formatter.result({
  "duration": 121784000,
  "status": "passed"
});
formatter.match({
  "location": "Test09UsuarioDejaClub.no_pertenece_al_club()"
});
formatter.result({
  "duration": 39411300,
  "status": "passed"
});
formatter.uri("10AdministradorEliminaClub.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Administrador elimina club",
  "description": "",
  "id": "administrador-elimina-club",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "El administrador elimina el club",
  "description": "",
  "id": "administrador-elimina-club;el-administrador-elimina-el-club",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un administrador quiere eliminar el club",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Elimina el club",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "El club ya no existe",
  "keyword": "Then "
});
formatter.match({
  "location": "Test10AdministradorEliminaClub.un_administrador_de_un_club_quiere_eliminar_el_club()"
});
formatter.result({
  "duration": 656423800,
  "status": "passed"
});
formatter.match({
  "location": "Test10AdministradorEliminaClub.elimina_el_club()"
});
formatter.result({
  "duration": 39134200,
  "status": "passed"
});
formatter.match({
  "location": "Test10AdministradorEliminaClub.el_club_ya_no_existe()"
});
formatter.result({
  "duration": 42022900,
  "status": "passed"
});
formatter.uri("11UsuarioEnviaPeticionDeAmistad.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Usuario envia peticion de amistad",
  "description": "",
  "id": "usuario-envia-peticion-de-amistad",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Usuario envia peticion de amistad",
  "description": "",
  "id": "usuario-envia-peticion-de-amistad;usuario-envia-peticion-de-amistad",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un usuario conoce a otro",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Envia una peticion de amistad",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "El otro usuario recibe una peticion de amistad",
  "keyword": "Then "
});
formatter.match({
  "location": "Test11UsuarioEnviaPeticionAmistad.un_usuario_conoce_a_otro()"
});
formatter.result({
  "duration": 873670400,
  "status": "passed"
});
formatter.match({
  "location": "Test11UsuarioEnviaPeticionAmistad.envia_una_peticion_de_amistad()"
});
formatter.result({
  "duration": 2848592200,
  "status": "passed"
});
formatter.match({
  "location": "Test11UsuarioEnviaPeticionAmistad.el_otro_usuario_recibe_una_peticion_de_amistad()"
});
formatter.result({
  "duration": 39018400,
  "status": "passed"
});
formatter.uri("12UsuarioRecibePeticionDeAmistad.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Usuario recibe peticion de amistad",
  "description": "",
  "id": "usuario-recibe-peticion-de-amistad",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Usuario recibe peticion de amistad",
  "description": "",
  "id": "usuario-recibe-peticion-de-amistad;usuario-recibe-peticion-de-amistad",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un usuario del sistema",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Otro usuario le haya enviado una peticion de amistad",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Este usuario la recibe",
  "keyword": "Then "
});
formatter.match({
  "location": "Test12UsuarioRecibePeticionAmistad.un_usuario_del_sistema()"
});
formatter.result({
  "duration": 836227700,
  "status": "passed"
});
formatter.match({
  "location": "Test12UsuarioRecibePeticionAmistad.otro_usuario_le_haya_enviado_una_peticion_de_amistad()"
});
formatter.result({
  "duration": 666384900,
  "status": "passed"
});
formatter.match({
  "location": "Test12UsuarioRecibePeticionAmistad.este_usuario_la_recibe()"
});
formatter.result({
  "duration": 45649300,
  "status": "passed"
});
formatter.uri("13UsuarioAceptaPeticionDeAmistad.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Usuario acepta peticion de amistad",
  "description": "",
  "id": "usuario-acepta-peticion-de-amistad",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Usuario acepta peticion de amistad",
  "description": "",
  "id": "usuario-acepta-peticion-de-amistad;usuario-acepta-peticion-de-amistad",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un usuario recibe una peticion",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Acepta la peticion",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Son amigos",
  "keyword": "Then "
});
formatter.match({
  "location": "Test13UsuarioAceptaPeticionAmistad.un_usuario_recibe_una_peticion()"
});
formatter.result({
  "duration": 1083748500,
  "status": "passed"
});
formatter.match({
  "location": "Test13UsuarioAceptaPeticionAmistad.acepta_la_peticion()"
});
formatter.result({
  "duration": 2235767300,
  "status": "passed"
});
formatter.match({
  "location": "Test13UsuarioAceptaPeticionAmistad.son_amigos()"
});
formatter.result({
  "duration": 78841200,
  "status": "passed"
});
formatter.uri("14UsuarioRechazaPeticionDeAmistad.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Usuario rechaza peticion de amistad",
  "description": "",
  "id": "usuario-rechaza-peticion-de-amistad",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Usuario rechaza peticion de amistad",
  "description": "",
  "id": "usuario-rechaza-peticion-de-amistad;usuario-rechaza-peticion-de-amistad",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un usuario recibe una peticion de amistad",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Rechaza la peticion",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "No son amigos",
  "keyword": "Then "
});
formatter.match({
  "location": "Test14UsuarioRechazaPeticionAmistad.un_usuario_recibe_una_peticion_de_amistad()"
});
formatter.result({
  "duration": 3722110300,
  "status": "passed"
});
formatter.match({
  "location": "Test14UsuarioRechazaPeticionAmistad.rechaza_la_peticion()"
});
formatter.result({
  "duration": 2280131500,
  "status": "passed"
});
formatter.match({
  "location": "Test14UsuarioRechazaPeticionAmistad.no_son_amigos()"
});
formatter.result({
  "duration": 78646600,
  "status": "passed"
});
formatter.uri("15UsuarioEliminaAmigo.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Usuario elimina amigo",
  "description": "",
  "id": "usuario-elimina-amigo",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Usuario elimina amigo",
  "description": "",
  "id": "usuario-elimina-amigo;usuario-elimina-amigo",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un usuario no quiere tener a un usuario de amigo",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Elimina al amigo",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Ya no son amigos",
  "keyword": "Then "
});
formatter.match({
  "location": "Test15UsuarioEliminaAmigo.un_usuario_no_quiere_tener_a_un_usuario_de_amigo()"
});
formatter.result({
  "duration": 911407900,
  "status": "passed"
});
formatter.match({
  "location": "Test15UsuarioEliminaAmigo.elimina_al_amigo()"
});
formatter.result({
  "duration": 3030994700,
  "status": "passed"
});
formatter.match({
  "location": "Test15UsuarioEliminaAmigo.ya_no_son_amigos()"
});
formatter.result({
  "duration": 78725000,
  "status": "passed"
});
formatter.uri("16UsuarioBloqueaUsuario.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Usuario bloquea a otro usuario",
  "description": "",
  "id": "usuario-bloquea-a-otro-usuario",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Usuario bloquea a otro usuario",
  "description": "",
  "id": "usuario-bloquea-a-otro-usuario;usuario-bloquea-a-otro-usuario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un usuario no quiere que otro usuario sea su amigo",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Bloquea",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "El usuario bloqueado no ve su perfil",
  "keyword": "Then "
});
formatter.match({
  "location": "Test16UsuarioBloqueaUsuario.un_usuario_no_quiere_que_otro_usuario_sea_su_amigo()"
});
formatter.result({
  "duration": 934677900,
  "status": "passed"
});
formatter.match({
  "location": "Test16UsuarioBloqueaUsuario.bloquea()"
});
formatter.result({
  "duration": 3228440800,
  "status": "passed"
});
formatter.match({
  "location": "Test16UsuarioBloqueaUsuario.el_usuario_bloqueado_no_ver_su_perfil()"
});
formatter.result({
  "duration": 78571600,
  "status": "passed"
});
formatter.uri("17UsuarioDesbloqueaUsuario.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 3,
  "name": "Usuario desbloquea a usuario bloqueado",
  "description": "",
  "id": "usuario-desbloquea-a-usuario-bloqueado",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 5,
  "name": "Usuario desbloquea a usuario bloqueado",
  "description": "",
  "id": "usuario-desbloquea-a-usuario-bloqueado;usuario-desbloquea-a-usuario-bloqueado",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "Un usuario quiere desbloquear a uno bloqueado",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Lo desbloquea",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "El usuario queda desbloqueado",
  "keyword": "Then "
});
formatter.match({
  "location": "Test17UsuarioDesbloqueaUsuario.un_usuario_quiere_desbloquear_a_uno_bloqueado()"
});
formatter.result({
  "duration": 841507900,
  "status": "passed"
});
formatter.match({
  "location": "Test17UsuarioDesbloqueaUsuario.lo_desbloquea()"
});
formatter.result({
  "duration": 2888398900,
  "status": "passed"
});
formatter.match({
  "location": "Test17UsuarioDesbloqueaUsuario.el_usuario_queda_desbloqueado()"
});
formatter.result({
  "duration": 78696500,
  "status": "passed"
});
formatter.uri("18UsuarioEliminaPerfil.feature");
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
  "location": "Test18UsuarioEliminaPerfil.una_persona_quiere_eliminar_su_perfil()"
});
formatter.result({
  "duration": 714984600,
  "status": "passed"
});
formatter.match({
  "location": "Test18UsuarioEliminaPerfil.da_a_eliminar()"
});
formatter.result({
  "duration": 41388300,
  "status": "passed"
});
formatter.match({
  "location": "Test18UsuarioEliminaPerfil.elimina_su_perfil()"
});
formatter.result({
  "duration": 79849200,
  "status": "passed"
});
});