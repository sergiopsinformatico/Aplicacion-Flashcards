package main.java.aplicacionflashcards.dto;

import java.util.List;

public class ClubDTO {
	
	String idClub;
	String nombreClub;
	String temaClub;
	String administrador;
	List<String> miembros;
	String fechaCreacion;
	boolean pertenezcoClub;
	boolean soyAdministradorClub;
	List<String> bloqueados;
	
	public ClubDTO (String idClub, String nombreClub, String temaClub, 
			String administrador, List<String> miembros, String fechaCreacion, List<String> bloqueados) {
		
		setIdClub(idClub);
		setNombreClub(nombreClub);
		setTemaClub(temaClub);
		setAdministrador(administrador);
		setMiembros(miembros);
		setFechaCreacion(fechaCreacion);
		setBloqueados(bloqueados);
		
	}
	
	public String getIdClub() {
		return idClub;
	}
	public void setIdClub(String idClub) {
		this.idClub = idClub;
	}
	public String getNombreClub() {
		return nombreClub;
	}
	public void setNombreClub(String nombreClub) {
		this.nombreClub = nombreClub;
	}
	public String getTemaClub() {
		return temaClub;
	}
	public void setTemaClub(String temaClub) {
		this.temaClub = temaClub;
	}
	public String getAdministrador() {
		return administrador;
	}
	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}
	public List<String> getMiembros() {
		return miembros;
	}
	public void setMiembros(List<String> miembros) {
		this.miembros = miembros;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public boolean isPertenezcoClub() {
		return pertenezcoClub;
	}
	public void setPertenezcoClub(boolean pertenezcoClub) {
		this.pertenezcoClub = pertenezcoClub;
	}
	public boolean isSoyAdministradorClub() {
		return soyAdministradorClub;
	}
	public void setSoyAdministradorClub(boolean soyAdministradorClub) {
		this.soyAdministradorClub = soyAdministradorClub;
	}
	public List<String> getBloqueados() {
		return bloqueados;
	}
	public void setBloqueados(List<String> bloqueados) {
		this.bloqueados = bloqueados;
	}
	
}
