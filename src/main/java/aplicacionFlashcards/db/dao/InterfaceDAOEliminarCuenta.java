package main.java.aplicacionFlashcards.db.dao;

import java.util.List;

import main.java.aplicacionFlashcards.dto.EliminarCuentaDTO;

public interface InterfaceDAOEliminarCuenta {
	public boolean insertaEliminado(EliminarCuentaDTO cuenta);
	public boolean leerEliminado(EliminarCuentaDTO cuenta);
	public boolean eliminarEliminado(EliminarCuentaDTO cuenta);
	public List<EliminarCuentaDTO> leerTodos();
	public void comprobarCuentasAEliminar();
}