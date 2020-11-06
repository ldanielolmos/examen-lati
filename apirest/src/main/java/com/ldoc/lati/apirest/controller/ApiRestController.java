package com.ldoc.lati.apirest.controller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldoc.lati.apirest.ApirestApplication;
import com.ldoc.lati.apirest.bean.CuentaBean;
import com.ldoc.lati.apirest.bean.DepositoBean;
import com.ldoc.lati.apirest.bean.ResponseBean;
import com.ldoc.lati.apirest.bean.SolicitudBean;
import com.ldoc.lati.apirest.model.CatCuenta;
import com.ldoc.lati.apirest.model.CatOperacion;
import com.ldoc.lati.apirest.model.CatTipoCredito;
import com.ldoc.lati.apirest.model.Cliente;
import com.ldoc.lati.apirest.model.Credito;
import com.ldoc.lati.apirest.model.Cuenta;
import com.ldoc.lati.apirest.model.Deposito;
import com.ldoc.lati.apirest.model.Operacion;
import com.ldoc.lati.apirest.model.Solicitud;
import com.ldoc.lati.apirest.repository.CatCuentaRepository;
import com.ldoc.lati.apirest.repository.CatOperacionRepository;
import com.ldoc.lati.apirest.repository.CatTipoCreditoRepository;
import com.ldoc.lati.apirest.repository.ClienteRepository;
import com.ldoc.lati.apirest.repository.CreditoRepository;
import com.ldoc.lati.apirest.repository.CuentaRepository;
import com.ldoc.lati.apirest.repository.DepositoRepository;
import com.ldoc.lati.apirest.repository.OperacionRepository;
import com.ldoc.lati.apirest.repository.SolicitudRepository;

@RestController
@RequestMapping("ldoc-lati/api/v1")
public class ApiRestController {

	private static final Logger logger = LoggerFactory.getLogger(ApirestApplication.class);

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CatCuentaRepository catCuentaRepository;

	@Autowired
	private CatOperacionRepository catOperacionRepository;

	@Autowired
	private CatTipoCreditoRepository catTipoCreditoRepository;

	@Autowired
	private OperacionRepository operacionRepository;

	@Autowired
	private CuentaRepository cuentaRepository;

	@Autowired
	private SolicitudRepository solicitudRepository;

	@Autowired
	private CreditoRepository creditoRepository;

	@Autowired
	private DepositoRepository depositoRepository;

	@PostMapping("/cuentas/create")
	public ResponseEntity<?> createCuenta(@Valid @RequestBody CuentaBean cuentaRequest) {

		Cuenta cuenta = new Cuenta();
		cuenta.setCliente(cuentaRequest.getCliente());
		cuenta.setTipoCuenta(cuentaRequest.getTipoCuenta());
		cuenta.setMontoApertura(cuentaRequest.getMontoApertura());
		cuenta.setFechaApertura(cuentaRequest.getFechaApertura());

		logger.info("Validando si el cliente enviado existe...");
		Cliente clienteEncontrado = clienteRepository.findById(cuenta.getCliente()).orElse(null);
		if (clienteEncontrado == null) {
			logger.info("El cliente enviado no existe...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(),
					"No se encontraron datos del cliente enviado -> " + cuenta.getCliente(), null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Validacion del cliente exitosa...");

		logger.info("Validando si el tipo cuenta enviado existe...");
		CatCuenta catCuentaEncontrada = catCuentaRepository
				.findById(cuenta.getTipoCuenta() == null ? "" : cuenta.getTipoCuenta()).orElse(null);
		if (catCuentaEncontrada == null) {
			logger.info("El tipo cuenta enviado no existe...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(),
					"No se encontraron datos del tipo cuenta enviado -> " + cuenta.getTipoCuenta(), null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Validacion del tipo cuenta exitosa...");

		logger.info("Validando si el tipo operacion CNTA-ALTA existe...");
		CatOperacion catOperacionEncontrado = catOperacionRepository.findById("CNTA-ALTA").orElse(null);
		if (catOperacionEncontrado == null) {
			logger.info("El tipo operacion CNTA-ALTA no existe...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(),
					"No se encontraron datos del tipo operacion CNTA-ALTA, favor de darlo de alta en la base de datos. ",
					null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Validacion del tipo operación CNTA-ALTA exitosa...");

		logger.info("Validando el monto de apertura");
		if (cuenta.getMontoApertura() == null) {
			logger.info("Monto de apertura incorrecto...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Monto de apertura incorrecto. ",
					null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Fin Validando el monto de apertura");

		logger.info("Validando el la fecha de apertura");
		if (cuenta.getFechaApertura() == null) {
			logger.info("Fecha de apertura incorrecto...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Fecha de apertura incorrecta. ",
					null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Fin Validando el la fecha de apertura");

		logger.info("Cargando información para crear el idOperacion ...");
		Operacion operacionCreate = new Operacion();
		operacionCreate.setTipoOperacion(catOperacionEncontrado.getTipoOperacion());
		operacionCreate.setFechaOperacion(new Date());
		logger.info("Fin Cargando información para crear el idOperacion ...");

		logger.info("Insertando información para obtener el idOperacion en la base de datos");
		Operacion operacionCreada = operacionRepository.save(operacionCreate);
		logger.info("Fin Insertando información para obtener el idOperacion en la base de datos");

		logger.info("Cargando información para crear la cuenta ...");
		Cuenta cuentaCrear = new Cuenta();
		cuentaCrear.setTipoCuenta(catCuentaEncontrada.getTipoCuenta());
		cuentaCrear.setCliente(clienteEncontrado.getId());
		cuentaCrear.setMontoApertura(cuenta.getMontoApertura());
		cuentaCrear.setFechaApertura(cuenta.getFechaApertura());
		cuentaCrear.setIdOperacion(operacionCreada.getId());
		cuentaCrear.setComisionApertura((double) 0);
		cuentaCrear.setSaldoFinal(cuenta.getMontoApertura());
		logger.info("Fin Cargando información para crear la cuenta ...");

		logger.info("Insertando información para obtener la nueva cuenta en la base de datos");
		Cuenta cuentaCreada = cuentaRepository.save(cuentaCrear);
		logger.info("Cuenta Creada Correctamente");
		logger.info("Regresando información de la cuenta creada");

		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Cuenta Registrada Correctamente",
				cuentaCreada);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/credito/create")
	public ResponseEntity<?> createCredito(@Valid @RequestBody SolicitudBean solicitudRequest) {

		Solicitud solicitud = new Solicitud();
		solicitud.setCliente(solicitudRequest.getCliente());
		solicitud.setTipoCredito(solicitudRequest.getTipoCredito());
		solicitud.setMontoSolicitado(solicitudRequest.getMontoSolicitado());

		logger.info("Validando si el cliente enviado existe...");
		Cliente clienteEncontrado = clienteRepository.findById(solicitud.getCliente()).orElse(null);
		if (clienteEncontrado == null) {
			logger.info("El cliente enviado no existe...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(),
					"No se encontraron datos del cliente enviado -> " + solicitud.getCliente(), null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Validacion del cliente exitosa...");

		logger.info("Validando si el tipo credito enviado existe...");
		CatTipoCredito catTipoCreditoEncontrado = catTipoCreditoRepository
				.findById(solicitud.getTipoCredito() == null ? "" : solicitud.getTipoCredito()).orElse(null);
		if (catTipoCreditoEncontrado == null) {
			logger.info("El tipo credito enviado no existe...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(),
					"No se encontraron datos del tipo credito enviado -> " + solicitud.getTipoCredito(), null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Validacion del tipo credito exitosa...");

		logger.info("Validando el monto de credito");
		if (solicitud.getMontoSolicitado() == null) {
			logger.info("Monto de credito incorrecto...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Monto de credito incorrecto. ",
					null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Fin Validando el monto de credito");

		logger.info("Validando si el tipo operacion SOL-ALTA existe...");
		CatOperacion catOperacionSolAltaEncontrado = catOperacionRepository.findById("SOL-ALTA").orElse(null);
		if (catOperacionSolAltaEncontrado == null) {
			logger.info("El tipo operacion SOL-ALTA no existe...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(),
					"No se encontraron datos del tipo operacion SOL-ALTA, favor de darlo de alta en la base de datos. ",
					null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Validacion del tipo operación SOL-ALTA exitosa...");

		logger.info("Validando si el tipo operacion CRED-ALTA existe...");
		CatOperacion catOperacionCredAltaEncontrado = catOperacionRepository.findById("CRED-ALTA").orElse(null);
		if (catOperacionCredAltaEncontrado == null) {
			logger.info("El tipo operacion CRED-ALTA no existe...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(),
					"No se encontraron datos del tipo operacion CRED-ALTA, favor de darlo de alta en la base de datos. ",
					null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Validacion del tipo operación CRED-ALTA exitosa...");

		logger.info("Cargando información para crear el idOperacion Solicitud ...");
		Operacion operacionCreateSol = new Operacion();
		operacionCreateSol.setTipoOperacion(catOperacionSolAltaEncontrado.getTipoOperacion());
		operacionCreateSol.setFechaOperacion(new Date());
		logger.info("Fin Cargando información para crear el idOperacion Solicitud ...");

		logger.info("Insertando información para obtener el idOperacion Solicitud en la base de datos");
		Operacion operacionSolicitudCreada = operacionRepository.save(operacionCreateSol);
		logger.info("Fin Insertando información para obtener el idOperacion Solicitud en la base de datos");

		logger.info("Cargando información para guardar la solicitud ...");
		solicitud.setFechaSolicitud(new Date());
		solicitud.setIdOperacion(operacionSolicitudCreada.getId());
		if (solicitud.getMontoSolicitado() % 2 == 0) {
			solicitud.setAprobado(true);
			solicitud.setComentarios("SOLICITUD AUTORIZADA");
		} else {
			solicitud.setAprobado(false);
			solicitud.setComentarios("FALTA CAPACIDAD DE PAGO");
		}
		logger.info("Fin Cargando información para guardar la solicitud ...");

		logger.info("Insertando información para obtener la nueva solicitud en la base de datos");
		Solicitud solicitudCreada = solicitudRepository.save(solicitud);
		logger.info("Solicitud Creada Correctamente");

		logger.info("Validando si se aprobo credito");
		if (!solicitudCreada.getAprobado()) {
			logger.info("Credito no aprobado");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(),
					"Solicitud de credito analizada correctamente.", solicitudCreada);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		logger.info("Cargando información para crear el idOperacion Credito ...");
		Operacion operacionCreateCred = new Operacion();
		operacionCreateCred.setTipoOperacion(catOperacionCredAltaEncontrado.getTipoOperacion());
		operacionCreateCred.setFechaOperacion(new Date());
		logger.info("Fin Cargando información para crear el idOperacion Credito ...");

		logger.info("Insertando información para obtener el idOperacion Credito en la base de datos");
		Operacion operacionCreditoCreada = operacionRepository.save(operacionCreateCred);
		logger.info("Fin Insertando información para obtener el idOperacion Credito en la base de datos");

		logger.info("Credito aprobado");
		logger.info("Cargando información para guardar el credito ...");
		Credito creditoGuardar = new Credito();
		creditoGuardar.setFechaCredito(new Date());
		creditoGuardar.setMontoAprobado(solicitudCreada.getMontoSolicitado());
		creditoGuardar.setPlazoAprobado(12);
		creditoGuardar.setInteresMensual(10.5);
		creditoGuardar.setSolicitud(solicitudCreada.getId());
		creditoGuardar.setIdOperacion(operacionCreditoCreada.getId());
		logger.info("Fin Cargando información para guardar el credito ...");

		logger.info("Insertando información para obtener el nuevo credito en la base de datos");
		Credito creditoCreado = creditoRepository.save(creditoGuardar);
		logger.info("Credito Creado Correctamente");

		logger.info("Regresando informacion del credito");
		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Credito Registrado Correctamente",
				creditoCreado);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping("/deposito/create")
	public ResponseEntity<?> createDeposito(@Valid @RequestBody DepositoBean depositoRequest) {

		Deposito deposito = new Deposito();
		deposito.setCuenta(depositoRequest.getCuenta());
		deposito.setFechaDeposito(depositoRequest.getFechaDeposito());
		deposito.setMontoDeposito(depositoRequest.getMontoDeposito());

		logger.info("Validando si la cuenta enviada existe...");
		Cuenta cuentaEncontrada = cuentaRepository.findById(deposito.getCuenta()).orElse(null);
		if (cuentaEncontrada == null) {
			logger.info("La cuenta enviada no existe...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(),
					"No se encontraron datos de la cuenta enviada -> " + deposito.getCuenta(), null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Validacion de la cuenta exitosa...");

		logger.info("Validando el monto de deposito");
		if (deposito.getMontoDeposito() == null) {
			logger.info("Monto de deposito incorrecto...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Monto de deposito incorrecto. ",
					null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Fin Validando el monto de deposito");

		logger.info("Validando la fecha de deposito");
		if (deposito.getFechaDeposito() == null) {
			logger.info("Fecha de deposito incorrecto...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Fecha de deposito incorrecta. ",
					null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Fin Validando el la fecha de deposito");

		logger.info("Validando si el tipo operacion DEP-ALTA existe...");
		CatOperacion catOperacionEncontrado = catOperacionRepository.findById("DEP-ALTA").orElse(null);
		if (catOperacionEncontrado == null) {
			logger.info("El tipo operacion DEP-ALTA no existe...");
			ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(),
					"No se encontraron datos del tipo operacion DEP-ALTA, favor de darlo de alta en la base de datos. ",
					null);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		logger.info("Validacion del tipo operación DEP-ALTA exitosa...");

		logger.info("Cargando información para crear el idOperacion ...");
		Operacion operacionCreate = new Operacion();
		operacionCreate.setTipoOperacion(catOperacionEncontrado.getTipoOperacion());
		operacionCreate.setFechaOperacion(new Date());
		logger.info("Fin Cargando información para crear el idOperacion ...");

		logger.info("Insertando información para obtener el idOperacion en la base de datos");
		Operacion operacionCreada = operacionRepository.save(operacionCreate);
		logger.info("Fin Insertando información para obtener el idOperacion en la base de datos");

		logger.info("Cargando información para crear el deposito ...");
		deposito.setIdOperacion(operacionCreada.getId());
		logger.info("Fin Cargando información para crear la cuenta ...");

		logger.info("Insertando información para obtener la nueva cuenta en la base de datos");
		Deposito depositoCreado = depositoRepository.save(deposito);
		logger.info("Cuenta Creada Correctamente");
		logger.info("Regresando información de la cuenta creada");

		logger.info("Actualizando información de la cuenta ...");
		cuentaEncontrada.setSaldoFinal(cuentaEncontrada.getSaldoFinal() + depositoCreado.getMontoDeposito());
		Cuenta cuentaActualizada = cuentaRepository.save(cuentaEncontrada);
		logger.info("Fin Actualizando información de la cuenta ...");

		logger.info("Regresando información de la cuenta actualizada");

		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Deposito Registrado Correctamente",
				cuentaActualizada);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
