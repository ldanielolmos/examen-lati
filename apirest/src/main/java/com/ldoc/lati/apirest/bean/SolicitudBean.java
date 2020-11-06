package com.ldoc.lati.apirest.bean;

public class SolicitudBean {

	private int cliente;

	private String tipoCredito;

	private Double montoSolicitado;

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public String getTipoCredito() {
		return tipoCredito;
	}

	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	public void setMontoSolicitado(Double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

}
