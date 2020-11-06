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
public class Credito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "fecha_credito")
	private Date fechaCredito;

	@Column(name = "monto_aprobado")
	private Double montoAprobado;

	@Column(name = "plazo_aprobado")
	private int plazoAprobado;

	@Column(name = "interes_mensual")
	private Double interesMensual;

	@Column(name = "solicitud")
	private int solicitud;

	@Column(name = "id_operacion")
	private int idOperacion;

	public Credito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Credito(int id, Date fechaCredito, Double montoAprobado, int plazoAprobado, Double interesMensual,
			int solicitud, int idOperacion) {
		super();
		this.id = id;
		this.fechaCredito = fechaCredito;
		this.montoAprobado = montoAprobado;
		this.plazoAprobado = plazoAprobado;
		this.interesMensual = interesMensual;
		this.solicitud = solicitud;
		this.idOperacion = idOperacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaCredito() {
		return fechaCredito;
	}

	public void setFechaCredito(Date fechaCredito) {
		this.fechaCredito = fechaCredito;
	}

	public Double getMontoAprobado() {
		return montoAprobado;
	}

	public void setMontoAprobado(Double montoAprobado) {
		this.montoAprobado = montoAprobado;
	}

	public int getPlazoAprobado() {
		return plazoAprobado;
	}

	public void setPlazoAprobado(int plazoAprobado) {
		this.plazoAprobado = plazoAprobado;
	}

	public Double getInteresMensual() {
		return interesMensual;
	}

	public void setInteresMensual(Double interesMensual) {
		this.interesMensual = interesMensual;
	}

	public int getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(int solicitud) {
		this.solicitud = solicitud;
	}

	public int getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(int idOperacion) {
		this.idOperacion = idOperacion;
	}

}
