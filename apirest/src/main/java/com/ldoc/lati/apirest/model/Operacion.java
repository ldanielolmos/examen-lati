package com.ldoc.lati.apirest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operaciones")
public class Operacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "tipo_operacion")
	private String tipoOperacion;

	@Column(name = "fecha_operacion")
	private Date fechaOperacion;

	public Operacion() {
		super();
	}

	public Operacion(int id, String tipoOperacion, Date fechaOperacion) {
		super();
		this.id = id;
		this.tipoOperacion = tipoOperacion;
		this.fechaOperacion = fechaOperacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

}
