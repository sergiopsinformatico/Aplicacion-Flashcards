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
  "duration": 2961773000,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_los_datos_correctamente()"
});
formatter.result({
  "duration": 956340500,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.se_registra_correctamente()"
});
formatter.result({
  "duration": 174678000,
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
  "duration": 4899500,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_un_username_existente()"
});
formatter.result({
  "duration": 672753700,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 40075000,
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
  "duration": 4990900,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.el_username_contiene_un_caracter_invalido()"
});
formatter.result({
  "duration": 38300,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 749979300,
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
  "duration": 3785600,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_longitud_del_username_es_incorrecta()"
});
formatter.result({
  "duration": 51700,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 703799300,
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
  "duration": 4001100,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_clave_contiene_un_caracter_invalido()"
});
formatter.result({
  "duration": 43400,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 675248300,
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
  "duration": 3932500,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.la_longitud_de_la_clave_es_incorrecta()"
});
formatter.result({
  "duration": 39900,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 789214700,
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
  "duration": 4507500,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.introduce_un_email_existente()"
});
formatter.result({
  "duration": 660300300,
  "status": "passed"
});
formatter.match({
  "location": "Test01UsuarioCreaCuentaUsuario.no_se_registra()"
});
formatter.result({
  "duration": 40523300,
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
  "duration": 5760800,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_con_el_email()"
});
formatter.result({
  "duration": 771002400,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_correctamente()"
});
formatter.result({
  "duration": 35000,
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
  "duration": 4642200,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_con_el_username()"
});
formatter.result({
  "duration": 661830800,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.se_loguea_correctamente()"
});
formatter.result({
  "duration": 17900,
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
  "duration": 2997700,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.el_email_es_erroneo()"
});
formatter.result({
  "duration": 716181200,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "duration": 46800,
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
  "duration": 5468400,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.el_username_es_erroneo()"
});
formatter.result({
  "duration": 738523400,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "duration": 16600,
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
  "duration": 3991200,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.la_clave_es_erronea()"
});
formatter.result({
  "duration": 703622800,
  "status": "passed"
});
formatter.match({
  "location": "Test02UsuarioIniciaSesion.no_se_puede_loguear()"
});
formatter.result({
  "duration": 21900,
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
  "duration": 3427900,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.se_loguea_con_el_username()"
});
formatter.result({
  "duration": 731932400,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.ve_el_perfil_con_el_username()"
});
formatter.result({
  "duration": 118968700,
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
  "duration": 3995400,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.se_loguea_con_el_email()"
});
formatter.result({
  "duration": 783913700,
  "status": "passed"
});
formatter.match({
  "location": "Test03UsuarioVePerfil.ve_el_perfil_con_el_email()"
});
formatter.result({
  "duration": 134950300,
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
  "duration": 746982900,
  "status": "passed"
});
formatter.match({
  "location": "Test04UsuarioActualizaPerfil.cambia_los_datos()"
});
formatter.result({
  "duration": 70900,
  "status": "passed"
});
formatter.match({
  "location": "Test04UsuarioActualizaPerfil.se_actualiza_el_perfil_correctamente()"
});
formatter.result({
  "duration": 199452500,
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
  "duration": 718445000,
  "status": "passed"
});
formatter.match({
  "location": "Test33UsuarioEliminaPerfil.da_a_eliminar()"
});
formatter.result({
  "duration": 40047800,
  "status": "passed"
});
formatter.match({
  "location": "Test33UsuarioEliminaPerfil.elimina_su_perfil()"
});
formatter.result({
  "duration": 79742900,
  "status": "passed"
});
});