package com.ldoc.lati.apirest.bean;

import java.util.Date;

public class DepositoBean {

	private int cuenta;

	private Double montoDeposito;

	private Date fechaDeposito;

	public int getCuenta() {
		return cuenta;
	}

	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}

	public Double getMontoDeposito() {
		return montoDeposito;
	}

	public void setMontoDeposito(Double montoDeposito) {
		this.montoDeposito = montoDeposito;
	}

	public Date getFechaDeposito() {
		return fechaDeposito;
	}

	public void setFechaDeposito(Date fechaDeposito) {
		this.fechaDeposito = fechaDeposito;
	}

}
