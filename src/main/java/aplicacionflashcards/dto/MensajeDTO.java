package main.java.aplicacionflashcards.dto;

public class MensajeDTO {
	
	String idMensaje;
	String remitente;
	String destinatario;
	String asunto;
	String mensaje;
	
	public MensajeDTO(String idMensaje, String remitente, String destinatario, String asunto, String mensaje) {
		setIdMensaje(idMensaje);
		setRemitente(remitente);
		setDestinatario(destinatario);
		setAsunto(asunto);
		setMensaje(mensaje);
	}
	
	public String getIdMensaje() {
		return idMensaje;
	}
	
	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}
	
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
