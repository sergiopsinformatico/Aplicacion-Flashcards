package main.java.aplicacionflashcards.dto;

import java.util.List;

public class NotificacionesDTO {
	
	String usuario;
	List<String> listaNotificaciones;
	
	public NotificacionesDTO(String usuario, List<String> listaNotificaciones) {
		setUsuario(usuario);
		setListaNotificaciones(listaNotificaciones);
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public List<String> getListaNotificaciones() {
		return listaNotificaciones;
	}
	
	public void setListaNotificaciones(List<String> listaNotificaciones) {
		this.listaNotificaciones = listaNotificaciones;
	}
	
}
