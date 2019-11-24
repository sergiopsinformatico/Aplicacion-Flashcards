package main.java.aplicacionflashcards.db.dao;

import java.util.List;
import main.java.aplicacionflashcards.dto.MensajeDTO;

public interface InterfaceDAOMensaje {
	public boolean enviaMensaje(MensajeDTO mensaje);
	public List<MensajeDTO> mensajesEnviados(String username);
	public List<MensajeDTO> mensajesRecibidos(String username);
	public boolean eliminarMensaje(String idMensaje);
}
