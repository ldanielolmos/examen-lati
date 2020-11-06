package com.ldoc.lati.apirest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creditos")
public class Deposito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "fecha_deposito")
	private Date fechaDeposito;

	@Column(name = "cuenta")
	private int cuenta;

	@Column(name = "monto_deposito")
	private Double montoDeposito;

	@Column(name = "id_operacion")
	private int idOperacion;

	public Deposito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Deposito(int id, Date fechaDeposito, int cuenta, Double montoDeposito, int idOperacion) {
		super();
		this.id = id;
		this.fechaDeposito = fechaDeposito;
		this.cuenta = cuenta;
		this.montoDeposito = montoDeposito;
		this.idOperacion = idOperacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaDeposito() {
		return fechaDeposito;
	}

	public void setFechaDeposito(Date fechaDeposito) {
		this.fechaDeposito = fechaDeposito;
	}

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

	public int getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(int idOperacion) {
		this.idOperacion = idOperacion;
	}

}
