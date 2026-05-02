package com.trips.models;

import java.util.Date;

public class rol {
	
	private Integer id;
	private String nomRol;
	private String descripcion;
	private boolean activo;
	private Date fecha;
	public Integer getId() {
		return id;
	}
	public String getNomRol() {
		return nomRol;
	}
	public void setNomRol(String nomRol) {
		this.nomRol = nomRol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setId(Integer id) {
		this.id = id;
	
	}
	@Override 
	public String toString() {
	    return "Rol [id=" + id +
	           ", nomRol=" + nomRol +
	           ", descripcion=" + descripcion +
	           ", fecha=" + fecha 
	           ;
	}
}
	
	
