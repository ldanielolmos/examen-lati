package com.ldoc.lati.apirest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cat_cuentas")
public class CatCuenta {

	@Id
	@Column(name = "tipo_cuenta")
	private String tipoCuenta;

	@Column(name = "descripcion")
	private String descripcion;

	public CatCuenta() {
		super();
	}

	public CatCuenta(String tipoCuenta, String descripcion) {
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
