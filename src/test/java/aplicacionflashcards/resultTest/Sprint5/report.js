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
  "duration": 2670219100,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_los_datos_correctamente()"
});
formatter.result({
  "duration": 885599100,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.se_registra_correctamente()"
});
formatter.result({
  "duration": 534188100,
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
  "duration": 7119600,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_un_username_existente()"
});
formatter.result({
  "duration": 693234500,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 43567200,
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
  "duration": 6885100,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.el_username_contiene_un_caracter_invalido()"
});
formatter.result({
  "duration": 48200,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 725127300,
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
  "duration": 8294800,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_longitud_del_username_es_incorrecta()"
});
formatter.result({
  "duration": 45100,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 731069100,
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
  "duration": 6079100,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_clave_contiene_un_caracter_invalido()"
});
formatter.result({
  "duration": 38400,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 651761100,
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
  "duration": 8428000,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_longitud_de_la_clave_es_incorrecta()"
});
formatter.result({
  "duration": 37200,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 706176300,
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
  "duration": 5487600,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_un_email_existente()"
});
formatter.result({
  "duration": 684170800,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 43372500,
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
  "duration": 2668800,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_con_el_email()"
});
formatter.result({
  "duration": 700246200,
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
  "duration": 2852700,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_con_el_username()"
});
formatter.result({
  "duration": 683923900,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_correctamente()"
});
formatter.result({
  "duration": 23400,
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
  "duration": 2472600,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.el_email_es_erroneo()"
});
formatter.result({
  "duration": 732860700,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "duration": 32700,
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
  "duration": 2945300,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.el_username_es_erroneo()"
});
formatter.result({
  "duration": 748453300,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "duration": 23400,
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
  "duration": 3476800,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.la_clave_es_erronea()"
});
formatter.result({
  "duration": 750692100,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "duration": 25300,
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
  "duration": 2817700,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.se_loguea_con_el_username()"
});
formatter.result({
  "duration": 665951900,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.ve_el_perfil_con_el_username()"
});
formatter.result({
  "duration": 116396600,
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
  "duration": 3169400,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.se_loguea_con_el_email()"
});
formatter.result({
  "duration": 704361700,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.ve_el_perfil_con_el_email()"
});
formatter.result({
  "duration": 120897000,
  "status": "passed"
});
formatter.uri("04UsuarioModificaPerfil.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Como usuario quiero cambiar mis datos para actualizarlos",
  "description": "",
  "id": "como-usuario-quiero-cambiar-mis-datos-para-actualizarlos",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Actualizar perfil",
  "description": "",
  "id": "como-usuario-quiero-cambiar-mis-datos-para-actualizarlos;actualizar-perfil",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Una persona quiere actualizar su perfil",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Cambia los datos",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Se actualiza el perfil correctamente",
  "keyword": "Then "
});
formatter.match({
  "location": "Test04UsuarioActualizaPerfil.una_persona_quiere_actualizar_su_perfil()"
});
formatter.result({
  "duration": 775839300,
  "status": "passed"
});
formatter.match({
  "location": "Test04UsuarioActualizaPerfil.cambia_los_datos()"
});
formatter.result({
  "duration": 36700,
  "status": "passed"
});
formatter.match({
  "location": "Test04UsuarioActualizaPerfil.se_actualiza_el_perfil_correctamente()"
});
formatter.result({
  "duration": 221632200,
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
  "line": 4,
  "name": "Administrador cambia el rol a un usuario",
  "description": "",
  "id": "administrador-cambia-el-rol-a-un-usuario",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Administrador cambia el rol a un usuario",
  "description": "",
  "id": "administrador-cambia-el-rol-a-un-usuario;administrador-cambia-el-rol-a-un-usuario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un administrador quiere cambiar el rol de un usuario",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Localiza a ese usuario",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Cambia su rol",
  "keyword": "Then "
});
formatter.match({
  "location": "Test05AdministradorCambiaRol.un_administrador_quiere_cambiar_el_rol_de_un_usuario()"
});
formatter.result({
  "duration": 916660400,
  "status": "passed"
});
formatter.match({
  "location": "Test05AdministradorCambiaRol.localiza_a_ese_usuario()"
});
formatter.result({
  "duration": 87007000,
  "status": "passed"
});
formatter.match({
  "location": "Test05AdministradorCambiaRol.cambia_su_rol()"
});
formatter.result({
  "duration": 132971400,
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
  "line": 4,
  "name": "Administrador elimina a un usuario",
  "description": "",
  "id": "administrador-elimina-a-un-usuario",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Administrador elimina un usuario",
  "description": "",
  "id": "administrador-elimina-a-un-usuario;administrador-elimina-un-usuario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un administrador quiere eliminar a un usuario",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Encuentra a ese usuario",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Le elimina del sistema",
  "keyword": "Then "
});
formatter.match({
  "location": "Test06AdministradorEliminaUsuario.un_administrador_quiere_eliminar_a_un_usuario()"
});
formatter.result({
  "duration": 906492900,
  "status": "passed"
});
formatter.match({
  "location": "Test06AdministradorEliminaUsuario.encuentra_a_ese_usuario()"
});
formatter.result({
  "duration": 48448900,
  "status": "passed"
});
formatter.match({
  "location": "Test06AdministradorEliminaUsuario.le_elimina_del_sistema()"
});
formatter.result({
  "duration": 86524800,
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
  "line": 4,
  "name": "Usuario crea un club",
  "description": "",
  "id": "usuario-crea-un-club",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Un usuario crea un club",
  "description": "",
  "id": "usuario-crea-un-club;un-usuario-crea-un-club",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario no encuentra club",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Crea un club",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Existe el club",
  "keyword": "Then "
});
formatter.match({
  "location": "Test07UsuarioCreaClub.un_usuario_no_encuentra_club()"
});
formatter.result({
  "duration": 1025873300,
  "status": "passed"
});
formatter.match({
  "location": "Test07UsuarioCreaClub.crea_un_club()"
});
formatter.result({
  "duration": 90390400,
  "status": "passed"
});
formatter.match({
  "location": "Test07UsuarioCreaClub.existe_el_club()"
});
formatter.result({
  "duration": 44412800,
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
  "line": 4,
  "name": "Un usuario se une a un club",
  "description": "",
  "id": "un-usuario-se-une-a-un-club",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Un usuario se une a un club",
  "description": "",
  "id": "un-usuario-se-une-a-un-club;un-usuario-se-une-a-un-club",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario encuentra un club",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Solicita unirse",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Forma parte de este club",
  "keyword": "Then "
});
formatter.match({
  "location": "Test08UsuarioSeUneAClub.un_usuario_encuentra_un_club()"
});
formatter.result({
  "duration": 688337900,
  "status": "passed"
});
formatter.match({
  "location": "Test08UsuarioSeUneAClub.solicita_unirse()"
});
formatter.result({
  "duration": 132918100,
  "status": "passed"
});
formatter.match({
  "location": "Test08UsuarioSeUneAClub.forma_parte_de_este_club()"
});
formatter.result({
  "duration": 43336900,
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
  "line": 4,
  "name": "Usuario deja club",
  "description": "",
  "id": "usuario-deja-club",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Un usuario deja un club",
  "description": "",
  "id": "usuario-deja-club;un-usuario-deja-un-club",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario que pertenece a un club",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Deja el club",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "No pertenece al club",
  "keyword": "Then "
});
formatter.match({
  "location": "Test09UsuarioDejaClub.un_usuario_que_pertenece_a_un_club()"
});
formatter.result({
  "duration": 721687100,
  "status": "passed"
});
formatter.match({
  "location": "Test09UsuarioDejaClub.deja_el_club()"
});
formatter.result({
  "duration": 130293300,
  "status": "passed"
});
formatter.match({
  "location": "Test09UsuarioDejaClub.no_pertenece_al_club()"
});
formatter.result({
  "duration": 45412400,
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
  "line": 4,
  "name": "Administrador elimina club",
  "description": "",
  "id": "administrador-elimina-club",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "El administrador elimina el club",
  "description": "",
  "id": "administrador-elimina-club;el-administrador-elimina-el-club",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un administrador quiere eliminar el club",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Elimina el club",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "El club ya no existe",
  "keyword": "Then "
});
formatter.match({
  "location": "Test10AdministradorEliminaClub.un_administrador_de_un_club_quiere_eliminar_el_club()"
});
formatter.result({
  "duration": 695959000,
  "status": "passed"
});
formatter.match({
  "location": "Test10AdministradorEliminaClub.elimina_el_club()"
});
formatter.result({
  "duration": 44762900,
  "status": "passed"
});
formatter.match({
  "location": "Test10AdministradorEliminaClub.el_club_ya_no_existe()"
});
formatter.result({
  "duration": 43930000,
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
  "line": 4,
  "name": "Usuario envia peticion de amistad",
  "description": "",
  "id": "usuario-envia-peticion-de-amistad",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Usuario envia peticion de amistad",
  "description": "",
  "id": "usuario-envia-peticion-de-amistad;usuario-envia-peticion-de-amistad",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario conoce a otro",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Envia una peticion de amistad",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "El otro usuario recibe una peticion de amistad",
  "keyword": "Then "
});
formatter.match({
  "location": "Test11UsuarioEnviaPeticionAmistad.un_usuario_conoce_a_otro()"
});
formatter.result({
  "duration": 955887900,
  "status": "passed"
});
formatter.match({
  "location": "Test11UsuarioEnviaPeticionAmistad.envia_una_peticion_de_amistad()"
});
formatter.result({
  "duration": 1930141300,
  "status": "passed"
});
formatter.match({
  "location": "Test11UsuarioEnviaPeticionAmistad.el_otro_usuario_recibe_una_peticion_de_amistad()"
});
formatter.result({
  "duration": 38677200,
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
  "line": 4,
  "name": "Usuario recibe peticion de amistad",
  "description": "",
  "id": "usuario-recibe-peticion-de-amistad",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Usuario recibe peticion de amistad",
  "description": "",
  "id": "usuario-recibe-peticion-de-amistad;usuario-recibe-peticion-de-amistad",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario del sistema",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Otro usuario le haya enviado una peticion de amistad",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Este usuario la recibe",
  "keyword": "Then "
});
formatter.match({
  "location": "Test12UsuarioRecibePeticionAmistad.un_usuario_del_sistema()"
});
formatter.result({
  "duration": 862540200,
  "status": "passed"
});
formatter.match({
  "location": "Test12UsuarioRecibePeticionAmistad.otro_usuario_le_haya_enviado_una_peticion_de_amistad()"
});
formatter.result({
  "duration": 644579600,
  "status": "passed"
});
formatter.match({
  "location": "Test12UsuarioRecibePeticionAmistad.este_usuario_la_recibe()"
});
formatter.result({
  "duration": 40058300,
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
  "line": 4,
  "name": "Usuario acepta peticion de amistad",
  "description": "",
  "id": "usuario-acepta-peticion-de-amistad",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Usuario acepta peticion de amistad",
  "description": "",
  "id": "usuario-acepta-peticion-de-amistad;usuario-acepta-peticion-de-amistad",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario recibe una peticion",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Acepta la peticion",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Son amigos",
  "keyword": "Then "
});
formatter.match({
  "location": "Test13UsuarioAceptaPeticionAmistad.un_usuario_recibe_una_peticion()"
});
formatter.result({
  "duration": 1341367000,
  "status": "passed"
});
formatter.match({
  "location": "Test13UsuarioAceptaPeticionAmistad.acepta_la_peticion()"
});
formatter.result({
  "duration": 1266624500,
  "status": "passed"
});
formatter.match({
  "location": "Test13UsuarioAceptaPeticionAmistad.son_amigos()"
});
formatter.result({
  "duration": 78492500,
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
  "line": 4,
  "name": "Usuario rechaza peticion de amistad",
  "description": "",
  "id": "usuario-rechaza-peticion-de-amistad",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Usuario rechaza peticion de amistad",
  "description": "",
  "id": "usuario-rechaza-peticion-de-amistad;usuario-rechaza-peticion-de-amistad",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario recibe una peticion de amistad",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Rechaza la peticion",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "No son amigos",
  "keyword": "Then "
});
formatter.match({
  "location": "Test14UsuarioRechazaPeticionAmistad.un_usuario_recibe_una_peticion_de_amistad()"
});
formatter.result({
  "duration": 2744453200,
  "status": "passed"
});
formatter.match({
  "location": "Test14UsuarioRechazaPeticionAmistad.rechaza_la_peticion()"
});
formatter.result({
  "duration": 1290855200,
  "status": "passed"
});
formatter.match({
  "location": "Test14UsuarioRechazaPeticionAmistad.no_son_amigos()"
});
formatter.result({
  "duration": 76307400,
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
  "line": 4,
  "name": "Usuario elimina amigo",
  "description": "",
  "id": "usuario-elimina-amigo",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Usuario elimina amigo",
  "description": "",
  "id": "usuario-elimina-amigo;usuario-elimina-amigo",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario no quiere tener a un usuario de amigo",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Elimina al amigo",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Ya no son amigos",
  "keyword": "Then "
});
formatter.match({
  "location": "Test15UsuarioEliminaAmigo.un_usuario_no_quiere_tener_a_un_usuario_de_amigo()"
});
formatter.result({
  "duration": 849974600,
  "status": "passed"
});
formatter.match({
  "location": "Test15UsuarioEliminaAmigo.elimina_al_amigo()"
});
formatter.result({
  "duration": 1880526800,
  "status": "passed"
});
formatter.match({
  "location": "Test15UsuarioEliminaAmigo.ya_no_son_amigos()"
});
formatter.result({
  "duration": 79554100,
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
  "line": 4,
  "name": "Usuario bloquea a otro usuario",
  "description": "",
  "id": "usuario-bloquea-a-otro-usuario",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Usuario bloquea a otro usuario",
  "description": "",
  "id": "usuario-bloquea-a-otro-usuario;usuario-bloquea-a-otro-usuario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario no quiere que otro usuario sea su amigo",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Bloquea",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "El usuario bloqueado no ve su perfil",
  "keyword": "Then "
});
formatter.match({
  "location": "Test16UsuarioBloqueaUsuario.un_usuario_no_quiere_que_otro_usuario_sea_su_amigo()"
});
formatter.result({
  "duration": 834880500,
  "status": "passed"
});
formatter.match({
  "location": "Test16UsuarioBloqueaUsuario.bloquea()"
});
formatter.result({
  "duration": 1937296500,
  "status": "passed"
});
formatter.match({
  "location": "Test16UsuarioBloqueaUsuario.el_usuario_bloqueado_no_ver_su_perfil()"
});
formatter.result({
  "duration": 78602600,
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
  "line": 4,
  "name": "Usuario desbloquea a usuario bloqueado",
  "description": "",
  "id": "usuario-desbloquea-a-usuario-bloqueado",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Usuario desbloquea a usuario bloqueado",
  "description": "",
  "id": "usuario-desbloquea-a-usuario-bloqueado;usuario-desbloquea-a-usuario-bloqueado",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario quiere desbloquear a uno bloqueado",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Lo desbloquea",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "El usuario queda desbloqueado",
  "keyword": "Then "
});
formatter.match({
  "location": "Test17UsuarioDesbloqueaUsuario.un_usuario_quiere_desbloquear_a_uno_bloqueado()"
});
formatter.result({
  "duration": 869697400,
  "status": "passed"
});
formatter.match({
  "location": "Test17UsuarioDesbloqueaUsuario.lo_desbloquea()"
});
formatter.result({
  "duration": 1915960900,
  "status": "passed"
});
formatter.match({
  "location": "Test17UsuarioDesbloqueaUsuario.el_usuario_queda_desbloqueado()"
});
formatter.result({
  "duration": 75924400,
  "status": "passed"
});
formatter.uri("18UsuarioCreaColeccionFlashcards.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Usuario crea una coleccion de Flashcards",
  "description": "",
  "id": "usuario-crea-una-coleccion-de-flashcards",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Usuario crea una coleccion de Flashcards",
  "description": "",
  "id": "usuario-crea-una-coleccion-de-flashcards;usuario-crea-una-coleccion-de-flashcards",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario va a crear una coleccion",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Inserta las tarjetas e indica con quien compartirlo",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Se crea la coleccion",
  "keyword": "Then "
});
formatter.match({
  "location": "Test18UsuarioCreaColeccionesFlashcards.un_usuario_va_a_crear_una_coleccion()"
});
formatter.result({
  "duration": 694161500,
  "status": "passed"
});
formatter.match({
  "location": "Test18UsuarioCreaColeccionesFlashcards.inserta_las_tarjetas_e_indica_con_quien_compartirlo()"
});
formatter.result({
  "duration": 689791500,
  "status": "passed"
});
formatter.match({
  "location": "Test18UsuarioCreaColeccionesFlashcards.se_crea_la_coleccion()"
});
formatter.result({
  "duration": 670831500,
  "status": "passed"
});
formatter.uri("19UsuarioEliminaColeccionFlashcards.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Usuario elimina coleccion de Flashcards",
  "description": "",
  "id": "usuario-elimina-coleccion-de-flashcards",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Usuario elimina coleccion de Flashcards",
  "description": "",
  "id": "usuario-elimina-coleccion-de-flashcards;usuario-elimina-coleccion-de-flashcards",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario quiere eliminar una coleccion de Flashcards",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Encuentra la coleccion",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "La elimina",
  "keyword": "Then "
});
formatter.match({
  "location": "Test19UsuarioEliminaColeccionFlashcards.un_usuario_quiere_eliminar_una_coleccion_de_Flashcards()"
});
formatter.result({
  "duration": 732305700,
  "status": "passed"
});
formatter.match({
  "location": "Test19UsuarioEliminaColeccionFlashcards.encuentra_la_coleccion()"
});
formatter.result({
  "duration": 682021900,
  "status": "passed"
});
formatter.match({
  "location": "Test19UsuarioEliminaColeccionFlashcards.la_elimina()"
});
formatter.result({
  "duration": 1391364400,
  "status": "passed"
});
formatter.uri("20ModeradorConsultaColeccionesSinEvaluar.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Moderador consulta colecciones sin evaluar",
  "description": "",
  "id": "moderador-consulta-colecciones-sin-evaluar",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Moderador consulta colecciones sin evaluar",
  "description": "",
  "id": "moderador-consulta-colecciones-sin-evaluar;moderador-consulta-colecciones-sin-evaluar",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un moderador consulta las colecciones",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Busca",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Se lista todas sin evaluar",
  "keyword": "Then "
});
formatter.match({
  "location": "Test20ModeradorConsultaColeccionesSinEvaluar.un_moderador_consulta_las_colecciones()"
});
formatter.result({
  "duration": 731694500,
  "status": "passed"
});
formatter.match({
  "location": "Test20ModeradorConsultaColeccionesSinEvaluar.busca()"
});
formatter.result({
  "duration": 1407794500,
  "status": "passed"
});
formatter.match({
  "location": "Test20ModeradorConsultaColeccionesSinEvaluar.se_lista_todas_sin_evaluar()"
});
formatter.result({
  "duration": 80100,
  "status": "passed"
});
formatter.uri("21ModeradorEvaluaPositivamenteColeccionFlashcards.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Moderador evalua positivamente la coleccion",
  "description": "",
  "id": "moderador-evalua-positivamente-la-coleccion",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Moderador evalua positivamente la coleccion",
  "description": "",
  "id": "moderador-evalua-positivamente-la-coleccion;moderador-evalua-positivamente-la-coleccion",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "El moderador evalua la coleccion",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Lo valora positivamente",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "La coleccion puede visualizarse",
  "keyword": "Then "
});
formatter.match({
  "location": "Test21ModeradorEvaluaPositivamenteColeccion.el_moderador_evalua_la_coleccion()"
});
formatter.result({
  "duration": 787354300,
  "status": "passed"
});
formatter.match({
  "location": "Test21ModeradorEvaluaPositivamenteColeccion.lo_valora_positivamente()"
});
formatter.result({
  "duration": 765280200,
  "status": "passed"
});
formatter.match({
  "location": "Test21ModeradorEvaluaPositivamenteColeccion.la_coleccion_puede_visualizarse()"
});
formatter.result({
  "duration": 686781600,
  "status": "passed"
});
formatter.uri("22ModeradorEvaluaNegativamenteColeccionFlashcards.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Moderador evalua negativamente la coleccion",
  "description": "",
  "id": "moderador-evalua-negativamente-la-coleccion",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Moderador evalua negativamente la coleccion",
  "description": "",
  "id": "moderador-evalua-negativamente-la-coleccion;moderador-evalua-negativamente-la-coleccion",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "El moderador analiza la coleccion",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Lo valora negativamente",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "La coleccion se elimina por no cumplir los requisitos",
  "keyword": "Then "
});
formatter.match({
  "location": "Test22ModeradorEvaluaNegativamenteColeccion.el_moderador_analiza_la_coleccion()"
});
formatter.result({
  "duration": 777401200,
  "status": "passed"
});
formatter.match({
  "location": "Test22ModeradorEvaluaNegativamenteColeccion.lo_valora_negativamente()"
});
formatter.result({
  "duration": 661554600,
  "status": "passed"
});
formatter.match({
  "location": "Test22ModeradorEvaluaNegativamenteColeccion.la_coleccion_se_elimina_por_no_cumplir_los_requisitos()"
});
formatter.result({
  "duration": 649832200,
  "status": "passed"
});
formatter.uri("23ModeradorEliminaColecciones.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Moderador elimina colecciones",
  "description": "",
  "id": "moderador-elimina-colecciones",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Moderador elimina colecciones",
  "description": "",
  "id": "moderador-elimina-colecciones;moderador-elimina-colecciones",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un moderador lista las colecciones",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Considere oportuno eliminar una coleccion",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Elimina la coleccion",
  "keyword": "Then "
});
formatter.match({
  "location": "Test23ModeradorEliminaColecciones.un_moderador_lista_las_colecciones()"
});
formatter.result({
  "duration": 2120990100,
  "status": "passed"
});
formatter.match({
  "location": "Test23ModeradorEliminaColecciones.considere_oportuno_eliminar_una_coleccion()"
});
formatter.result({
  "duration": 28500,
  "status": "passed"
});
formatter.match({
  "location": "Test23ModeradorEliminaColecciones.elimina_la_coleccion()"
});
formatter.result({
  "duration": 1435875800,
  "status": "passed"
});
formatter.uri("24UsuarioBuscaColeccionesFlashcards.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Usuario busca colecciones Flashcards",
  "description": "",
  "id": "usuario-busca-colecciones-flashcards",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Un usuario busca colecciones Flashcards",
  "description": "",
  "id": "usuario-busca-colecciones-flashcards;un-usuario-busca-colecciones-flashcards",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario quiere visualizar una coleccion",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Lista las colecciones en el buscador",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Encuentra la coleccion buscada",
  "keyword": "Then "
});
formatter.match({
  "location": "Test24UsuarioBuscaColeccionesFlashcards.un_usuario_quiere_visualizar_una_coleccion()"
});
formatter.result({
  "duration": 1391294100,
  "status": "passed"
});
formatter.match({
  "location": "Test24UsuarioBuscaColeccionesFlashcards.lista_las_colecciones_en_el_buscador()"
});
formatter.result({
  "duration": 1459013500,
  "status": "passed"
});
formatter.match({
  "location": "Test24UsuarioBuscaColeccionesFlashcards.encuentra_la_coleccion_buscada()"
});
formatter.result({
  "duration": 69300,
  "status": "passed"
});
formatter.uri("25UsuarioVisualizaColecciónFlashcards.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Usuario visualiza una coleccion",
  "description": "",
  "id": "usuario-visualiza-una-coleccion",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Usuario visualiza una coleccion",
  "description": "",
  "id": "usuario-visualiza-una-coleccion;usuario-visualiza-una-coleccion",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario localiza una coleccion",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "La abre",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Puede ver las tarjetas y los datos acerca de esta",
  "keyword": "Then "
});
formatter.match({
  "location": "Test25UsuarioVisualizaColeccionFlashcards.un_usuario_localiza_una_coleccion()"
});
formatter.result({
  "duration": 645660700,
  "status": "passed"
});
formatter.match({
  "location": "Test25UsuarioVisualizaColeccionFlashcards.la_abre()"
});
formatter.result({
  "duration": 695566900,
  "status": "passed"
});
formatter.match({
  "location": "Test25UsuarioVisualizaColeccionFlashcards.puede_ver_las_tarjetas_y_los_datos_acerca_de_esta()"
});
formatter.result({
  "duration": 650473200,
  "status": "passed"
});
formatter.uri("26UnUsuarioEnviaUnMensaje.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Un usuario env�a un mensaje",
  "description": "",
  "id": "un-usuario-env�a-un-mensaje",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Un usuario env�a un mensaje",
  "description": "",
  "id": "un-usuario-env�a-un-mensaje;un-usuario-env�a-un-mensaje",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario crea un mensaje",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Escribe ese mensaje",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Envia el mensaje a otro usuario",
  "keyword": "Then "
});
formatter.match({
  "location": "Test26UnUsuarioEnviaUnMensaje.un_usuario_crea_un_mensaje()"
});
formatter.result({
  "duration": 4514700,
  "status": "passed"
});
formatter.match({
  "location": "Test26UnUsuarioEnviaUnMensaje.escribe_ese_mensaje()"
});
formatter.result({
  "duration": 31700,
  "status": "passed"
});
formatter.match({
  "location": "Test26UnUsuarioEnviaUnMensaje.envia_el_mensaje_a_otro_usuario()"
});
formatter.result({
  "duration": 688353200,
  "status": "passed"
});
formatter.uri("27UnUsuarioRecibeUnMensaje.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Un usuario recibe un mensaje",
  "description": "",
  "id": "un-usuario-recibe-un-mensaje",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Un Usuario recibe un mensaje",
  "description": "",
  "id": "un-usuario-recibe-un-mensaje;un-usuario-recibe-un-mensaje",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario que ha iniciado sesion",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Recibe un mensaje",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Puede verlo",
  "keyword": "Then "
});
formatter.match({
  "location": "Test27UnUsuarioRecibeUnMensaje.un_usuario_que_ha_iniciado_sesion()"
});
formatter.result({
  "duration": 849952800,
  "status": "passed"
});
formatter.match({
  "location": "Test27UnUsuarioRecibeUnMensaje.recibe_un_mensaje()"
});
formatter.result({
  "duration": 691844200,
  "status": "passed"
});
formatter.match({
  "location": "Test27UnUsuarioRecibeUnMensaje.puede_verlo()"
});
formatter.result({
  "duration": 39900,
  "status": "passed"
});
formatter.uri("28UnUsuarioVisualizaUnMensaje.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Un Usuario visualiza un mensaje",
  "description": "",
  "id": "un-usuario-visualiza-un-mensaje",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Un Usuario visualiza un mensaje",
  "description": "",
  "id": "un-usuario-visualiza-un-mensaje;un-usuario-visualiza-un-mensaje",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario quiere ver un mensaje",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Abre el mensaje",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Visualiza el mensaje",
  "keyword": "Then "
});
formatter.match({
  "location": "Test28UnUsuarioVisualizaUnMensaje.un_usuario_quiere_ver_un_mensaje()"
});
formatter.result({
  "duration": 650142300,
  "status": "passed"
});
formatter.match({
  "location": "Test28UnUsuarioVisualizaUnMensaje.abre_el_mensaje()"
});
formatter.result({
  "duration": 18400,
  "status": "passed"
});
formatter.match({
  "location": "Test28UnUsuarioVisualizaUnMensaje.visualiza_el_mensaje()"
});
formatter.result({
  "duration": 9700,
  "status": "passed"
});
formatter.uri("29UnUsuarioEliminaUnMensaje.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Un Usuario elimina un mensaje",
  "description": "",
  "id": "un-usuario-elimina-un-mensaje",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Un Usuario elimina un mensaje",
  "description": "",
  "id": "un-usuario-elimina-un-mensaje;un-usuario-elimina-un-mensaje",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario quiere eliminar un mensaje",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Borra el mensaje",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Mensaje borrado",
  "keyword": "Then "
});
formatter.match({
  "location": "Test29UnUsuarioEliminaUnMensaje.un_usuario_quiere_eliminar_un_mensaje()"
});
formatter.result({
  "duration": 103700,
  "status": "passed"
});
formatter.match({
  "location": "Test29UnUsuarioEliminaUnMensaje.borra_el_mensaje()"
});
formatter.result({
  "duration": 15500,
  "status": "passed"
});
formatter.match({
  "location": "Test29UnUsuarioEliminaUnMensaje.mensaje_borrado()"
});
formatter.result({
  "duration": 11500,
  "status": "passed"
});
formatter.uri("30UnUsuarioVisualizaNotificacionesEnPanel.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Un Usuario visualiza notificaciones en un panel",
  "description": "",
  "id": "un-usuario-visualiza-notificaciones-en-un-panel",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Un Usuario visualiza notificaciones en un panel",
  "description": "",
  "id": "un-usuario-visualiza-notificaciones-en-un-panel;un-usuario-visualiza-notificaciones-en-un-panel",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario accede a la pantalla principal",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Abre el panel de notificaciones",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Visualiza las notificaciones",
  "keyword": "Then "
});
formatter.match({
  "location": "Test30UnUsuarioVisualizaNotificacionesEnPanel.un_usuario_accede_a_la_pantalla_principal()"
});
formatter.result({
  "duration": 56800,
  "status": "passed"
});
formatter.match({
  "location": "Test30UnUsuarioVisualizaNotificacionesEnPanel.abre_el_panel_de_notificaciones()"
});
formatter.result({
  "duration": 11400,
  "status": "passed"
});
formatter.match({
  "location": "Test30UnUsuarioVisualizaNotificacionesEnPanel.visualiza_las_notificaciones()"
});
formatter.result({
  "duration": 12100,
  "status": "passed"
});
formatter.uri("31UnUsuarioGanaPuntos.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Un Usuario gana puntos",
  "description": "",
  "id": "un-usuario-gana-puntos",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Un Usuario gana puntos",
  "description": "",
  "id": "un-usuario-gana-puntos;un-usuario-gana-puntos",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario realiza una acci�n",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Consigue un objetivo",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Gana puntos",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "Test31UnUsuarioGanaPuntos.consigue_un_objetivo()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Test31UnUsuarioGanaPuntos.gana_puntos()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("32UnUsuarioVisualizaUnRankingConLosPuntosDeLosUsuarios.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sergio Perez Sanchez"
    }
  ],
  "line": 4,
  "name": "Un Usuario visualiza un ranking con los puntos de los usuarios",
  "description": "",
  "id": "un-usuario-visualiza-un-ranking-con-los-puntos-de-los-usuarios",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Un Usuario visualiza un ranking",
  "description": "",
  "id": "un-usuario-visualiza-un-ranking-con-los-puntos-de-los-usuarios;un-usuario-visualiza-un-ranking",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Un usuario accede a un ranking",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Visualiza el ranking",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Ve una lista con los usuarios con mayor puntuacion",
  "keyword": "Then "
});
formatter.match({
  "location": "Test32UnUsuarioVisualizaUnRankingConLosPuntosDeLosUsuarios.un_usuario_accede_a_un_ranking()"
});
formatter.result({
  "duration": 74500,
  "status": "passed"
});
formatter.match({
  "location": "Test32UnUsuarioVisualizaUnRankingConLosPuntosDeLosUsuarios.visualiza_el_ranking()"
});
formatter.result({
  "duration": 35700,
  "status": "passed"
});
formatter.match({
  "location": "Test32UnUsuarioVisualizaUnRankingConLosPuntosDeLosUsuarios.ve_una_lista_con_los_usuarios_con_mayor_puntuacion()"
});
formatter.result({
  "duration": 15900,
  "status": "passed"
});
formatter.uri("33UsuarioEliminaPerfil.feature");
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
  "location": "Test33UsuarioEliminaPerfil.una_persona_quiere_eliminar_su_perfil()"
});
formatter.result({
  "duration": 972844500,
  "status": "passed"
});
formatter.match({
  "location": "Test33UsuarioEliminaPerfil.da_a_eliminar()"
});
formatter.result({
  "duration": 863175800,
  "status": "passed"
});
formatter.match({
  "location": "Test33UsuarioEliminaPerfil.elimina_su_perfil()"
});
formatter.result({
  "duration": 78081200,
  "status": "passed"
});
});