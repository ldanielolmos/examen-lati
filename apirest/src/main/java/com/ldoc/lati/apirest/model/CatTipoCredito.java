package com.ldoc.lati.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cat_creditos")
public class CatTipoCredito {

	@Id
	@Column(name = "tipo_credito")
	private String tipoCuenta;

	@Column(name = "descripcion")
	private String descripcion;

	public CatTipoCredito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CatTipoCredito(String tipoCuenta, String descripcion) {
		super();
		this.tipoCuenta = tipoCuenta;
		this.descripcion = descripcion;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
