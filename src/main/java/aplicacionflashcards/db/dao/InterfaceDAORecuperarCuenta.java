package main.java.aplicacionflashcards.db.dao;

import main.java.aplicacionflashcards.dto.RecuperarCuentaDTO;

public interface InterfaceDAORecuperarCuenta {
	
	public boolean insertaRC(RecuperarCuentaDTO recupera);
	public boolean leerRC(String username, String key);
	public boolean existeSolicitudUsuario(String username);
	public boolean eliminarRC(String username);
	public boolean comprobarSolicitudesCaducadas();
	
}