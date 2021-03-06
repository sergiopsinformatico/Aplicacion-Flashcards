package main.java.aplicacionflashcards.db.dao;

import java.util.List;

import main.java.aplicacionflashcards.dto.ActivaCuentaDTO;

public interface InterfaceDAOActivaCuenta {
	
	public boolean activacionCuenta(ActivaCuentaDTO activaCuenta);
	public boolean existeActivacionUsuario(String username);
	public boolean insertaAC(ActivaCuentaDTO activaCuenta);
	public boolean eliminaAC(ActivaCuentaDTO activaCuenta);
	public List<ActivaCuentaDTO> leerTodas();
	public void comprobarActivacionesCaducadas();
	
}