package com.ldoc.lati.apirest.bean;

import java.util.Date;

public class CuentaBean {

	private int cliente;

	private String tipoCuenta;

	private Double montoApertura;

	private Date fechaApertura;

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Double getMontoApertura() {
		return montoApertura;
	}

	public void setMontoApertura(Double montoApertura) {
		this.montoApertura = montoApertura;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

}
