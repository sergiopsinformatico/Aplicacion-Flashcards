package main.java.aplicacionflashcards.db.dao;

import main.java.aplicacionflashcards.dto.NotificacionesDTO;

public interface InterfaceDAONotificaciones {
	public boolean createObjectNotificaciones(NotificacionesDTO notificacion);
	public boolean deleteObjectNotificaciones(String usuario);
	public boolean insertarNotificacion(String usuario, String notificacion);
	public boolean eliminarNotificacion(String usuario, String notificacion);
	public NotificacionesDTO getNotificaciones(String usuario);
}
