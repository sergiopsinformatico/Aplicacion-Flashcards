package main.java.aplicacionflashcards.auxiliares;

import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import main.java.aplicacionflashcards.dto.EliminarCuentaDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Email {
	
	/* * * * * * * * * * *
	 *  Env�o de Emails  *
	 * * * * * * * * * * */
	
	/* * * * * *  *
	 *  VARIABLES *
	 * * * * * *  */
	
	private String recibe;
	private String asunto;
	private String mensaje;
	boolean enviado;
	CifradoCaesar caesar;
	
	/* * * * * * * *
	 *  Constantes *
	 * * * * * * * */
	
	static final String CONST_SALUDO = "Hola ";
	static final String CONST_CIERRE = "\nAtentamente, Equipo de Flashcards.";
	static final String CONST_USUARIO = "\nUsuario: ";
	static final String CONST_CLAVE = "\nClave: ";
	static final String CONST_SMTP = "smtp.gmail.com";
	
	//Logger
    private static final Logger LOGGER = Logger.getLogger("main.java.flashcards.auxiliares.Email");
	
    /* * * * * * * * * *
	 *  Activar Cuenta *
	 * * * * * * * * * */
    
	public boolean activarCuenta(UsuarioDTO user, String url) {
		setAsunto("[Flashcards] Activacion Cuenta: "+user.getUsername());
		setMensaje("Bienvenido a la Aplicacion Flashcards!!"+
		"\nPara poder finalizar el registro de su cuenta debe de pulsar sobre el siguiente enlace que aparece a continuacion."+
		"\n"+url+
		"\nDispone de 24 horas para activar la cuenta. En caso de que no lo haga, debe de volverse a registrar."+
		"\nHaciendo clic, acepta que almacenemos en nuestros ficheros los datos que nos haya proporcionado."+
		CONST_CIERRE);
		setRecibe(user.getEmail());
		return enviarMensaje();
	}
	
	/* * * * * * * * * * * * *  *
	 *  Confirmar Cuenta Creada *
	 * * * * * * * * * * * * *  */
	
	public boolean confirmaCuentaCreada(UsuarioDTO user) {
		setAsunto("[Flashcards] Nueva Cuenta Creada "+user.getUsername());
		setMensaje("Su cuenta ha sido creada satisfactoriamente. Sus datos de registro son los siguientes:"+
		CONST_USUARIO+user.getUsername()+
		"\nEmail: "+user.getEmail()+
		CONST_CLAVE+user.getClave()+
		CONST_CIERRE);
		setRecibe(user.getEmail());
		return enviarMensaje();
	}
	
	/* * * * * * * * * * *
	 *  Eliminar Cuenta  *
	 * * * * * * * * * * */
	
	public boolean eliminarCuenta(EliminarCuentaDTO elimina, String email) {
		setAsunto("[Flashcards] Cuenta Eliminada ("+elimina.getUsername()+") - 14 dias");
		setMensaje(CONST_SALUDO+elimina.getUsername()+","+
        "\nSu cuenta va a proceder a eliminarse por completo el "+elimina.getFecha()+"."+
		"\nSi accede antes al sistema con su cuenta, su cuenta no se va a eliminar."+
        CONST_CIERRE);
		setRecibe(email);
		return enviarMensaje();
	}
	
	/* * * * * * * * *  *
	 *  Recuperar Clave *
	 * * * * * * * * *  */
	
	public boolean recuperarClave(UsuarioDTO user, String key) {
		setAsunto("[Flashcards] Recuperacion de la clave de "+user.getEmail());
		setMensaje(CONST_SALUDO+user.getUsername()+"!!"+
		"\nHa solicitado recuperacion de sus datos de su cuenta en Flashcards."+
		"\nSiga el siguiente enlace: "+PropertiesConfig.getProperties("baseURL")+"/restableceClave.html?username="+user.getUsername()+"&keySecurity="+key);
		setRecibe(user.getEmail());
		return enviarMensaje();
	}
	
	/* * * * * * * * * * *
	 *  Reactivar Cuenta *
	 * * * * * * * * * * */
	
	public boolean reactivacionCuenta(UsuarioDTO user) {
		setAsunto("[Flashcards] Reactivacion de la cuenta de "+user.getUsername());
		setMensaje(CONST_SALUDO+user.getNombreApellidos()+"!!"+
		"\nSu cuenta en Flashcards, se ha reactivado y no sera borrada:"+
		CONST_USUARIO+user.getEmail()+" o "+user.getUsername()+
		CONST_CLAVE+user.getClave()+
		CONST_CIERRE);
		setRecibe(user.getEmail());
		return enviarMensaje();
	}
	
	/* * * * * * * * * * *  *
	 *  Generar Nueva Clave *
	 * * * * * * * * * * *  */
	
	public boolean adminGeneraClave(UsuarioDTO user) {
		setAsunto("[Flashcards] Generada clave nueva para "+user.getUsername());
		setMensaje(CONST_SALUDO+user.getUsername()+"!!"+
		"\nSe le ha generado una nueva clave:"+
		CONST_USUARIO+user.getEmail()+" o "+user.getUsername()+
		CONST_CLAVE+user.getClave()+
		CONST_CIERRE);
		setRecibe(user.getEmail());
		return enviarMensaje();
	}
	
	/* * * * * * * * * *
	 *  Env�o de Email *
	 * * * * * * * * * */
	
	private boolean enviarMensaje() {
		enviado = false;
		caesar = new CifradoCaesar();
		try{
			Properties properties = System.getProperties();
			properties.put("mail.smtp.host", CONST_SMTP);
			properties.put("mail.smtp.port", "587");//465 o 587
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.ssl.trust", CONST_SMTP);
			
			Session session = Session.getDefaultInstance(properties, null);
			
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(getRecibe()));
			message.setSubject(getAsunto());
			message.setContent(getMensaje(), "text/plain");
			
			Transport transporte = session.getTransport("smtp");
			transporte.connect(CONST_SMTP, getEnvia(), getClave());
			transporte.sendMessage(message, message.getAllRecipients());
			transporte.close();
			
			enviado = true;
		}catch (Exception me){
			enviado = false;
			LOGGER.log(java.util.logging.Level.INFO, "Fallo en el envio del mensaje");
		}
	    
		return enviado;
	}

	public String getRecibe() {
		return this.recibe;
	}

	public void setRecibe(String recibe) {
		this.recibe = recibe;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	//Datos constantes para enviar un email
	
	private String getClave() {
		return caesar.decryptText(PropertiesConfig.getProperties("emailClave"));
	}
	
	public String getEnvia() {
		return caesar.decryptText(PropertiesConfig.getProperties("emailDireccion"));
	}
}
