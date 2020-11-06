package com.ldoc.lati.apirest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "solicitudes")
public class Solicitud {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "fecha_solicitud")
	private Date fechaSolicitud;

	@Column(name = "cliente")
	private int cliente;

	@Column(name = "tipo_credito")
	private String tipoCredito;

	@Column(name = "monto_solicitado")
	private Double montoSolicitado;

	@Column(name = "aprobado")
	private Boolean aprobado;

	@Column(name = "comentarios")
	private String comentarios;

	@Column(name = "id_operacion")
	private int idOperacion;

	public Solicitud() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Solicitud(int id, Date fechaSolicitud, int cliente, String tipoCredito, Double montoSolicitado,
			Boolean aprobado, String comentarios, int idOperacion) {
		super();
		this.id = id;
		this.fechaSolicitud = fechaSolicitud;
		this.cliente = cliente;
		this.tipoCredito = tipoCredito;
		this.montoSolicitado = montoSolicitado;
		this.aprobado = aprobado;
		this.comentarios = comentarios;
		this.idOperacion = idOperacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

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

	public Boolean getAprobado() {
		return aprobado;
	}

	public void setAprobado(Boolean aprobado) {
		this.aprobado = aprobado;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getIdOperacion() {
		return idOperacion;
	}

	public void setIdOperacion(int idOperacion) {
		this.idOperacion = idOperacion;
	}

}
