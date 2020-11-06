package com.ldoc.lati.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cat_operaciones")
public class CatOperacion {

	@Id
	@Column(name = "tipo_operacion")
	private String tipoOperacion;

	@Column(name = "descripcion")
	private String descripcion;

	public CatOperacion() {
		super();
	}

	public CatOperacion(String tipoOperacion, String descripcion) {
		super();
		this.tipoOperacion = tipoOperacion;
		this.descripcion = descripcion;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
