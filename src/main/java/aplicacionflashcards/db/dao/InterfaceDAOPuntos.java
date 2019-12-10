package main.java.aplicacionflashcards.db.dao;

import java.util.List;

import main.java.aplicacionflashcards.dto.PuntosDTO;

public interface InterfaceDAOPuntos {
	public PuntosDTO getPuntos(String usuario);
	public boolean actualizaPuntos(PuntosDTO ptosUsuario);
	public List<PuntosDTO> rankingPrimeros();
}
