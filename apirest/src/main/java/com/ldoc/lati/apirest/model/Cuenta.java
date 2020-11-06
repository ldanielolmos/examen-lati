package com.ldoc.lati.apirest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "tipo_cuenta")
	private String tipoCuenta;

	@Column(name = "cliente")
	private int cliente;

	@Column(name = "monto_apertura")
	private Double montoApertura;

	@Column(name = "fecha_apertura")
	private Date fechaApertura;

	@Column(name = "id_operacion")
	private int idOperacion;

	@Column(name = "comision_apertura")
	private Double comisionApertura;

	@Column(name = "saldo_final")
	private Double saldoFinal;

	public Cuenta() {
		super();
	}

	public Cuenta(int id, String tipoCuenta, int cliente, Double montoApertura, Date fechaApertura, int idOperacion,
			Double comisionApertura, Double saldoFinal) {
		super();
		this.id = id;
		this.tipoCuenta = tipoCuenta;
		this.cliente = cliente;
		this.montoApertura = montoApertura;
		this.fechaApertura = fechaApertura;
		this.idOperacion = idOperacion;
		this.comisionApertura = comisionApertura;
		this.saldoFinal = saldoFinal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
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

	public int getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(int idOperacion) {
		this.idOperacion = idOperacion;
	}

	public Double getComisionApertura() {
		return comisionApertura;
	}

	public void setComisionApertura(Double comisionApertura) {
		this.comisionApertura = comisionApertura;
	}

	public Double getSaldoFinal() {
		return saldoFinal;
	}

	public void setSaldoFinal(Double saldoFinal) {
		this.saldoFinal = saldoFinal;
	}

}
