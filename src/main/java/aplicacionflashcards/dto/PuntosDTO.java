package main.java.aplicacionflashcards.dto;

public class PuntosDTO {
	
	String usuario;
	long puntos;
	
	public PuntosDTO (String usuario, long puntos) {
		setUsuario(usuario);
		setPuntos(puntos);
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public long getPuntos() {
		return puntos;
	}
	
	public void setPuntos(long puntos) {
		this.puntos = puntos;
	}
	
}
