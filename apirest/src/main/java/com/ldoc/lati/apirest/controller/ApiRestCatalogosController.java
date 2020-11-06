package com.ldoc.lati.apirest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldoc.lati.apirest.ApirestApplication;
import com.ldoc.lati.apirest.bean.ResponseBean;
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
@RequestMapping("ldoc-lati/api/v1/catalogos")
public class ApiRestCatalogosController {

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
	private CreditoRepository creditoRepository;

	@Autowired
	private CuentaRepository cuentaRepository;

	@Autowired
	private DepositoRepository depositoRepository;

	@Autowired
	private SolicitudRepository solicitudRepository;

	@Autowired
	private OperacionRepository operacionRepository;

	@GetMapping("/clientes/getall")
	public ResponseEntity<?> getAllClientes() {
		logger.info("Buscando todos los clientes...");
		List<Cliente> listClientes = clienteRepository.findAll();
		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Consulta Realizada Correctamente",
				listClientes);
		logger.info("Fin Buscando todos los clientes...");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/catCuentas/getall")
	public ResponseEntity<?> getAllCatCuentas() {
		logger.info("Buscando todas las catCuentas...");
		List<CatCuenta> listCatCuentas = catCuentaRepository.findAll();
		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Consulta Realizada Correctamente",
				listCatCuentas);
		logger.info("Fin Buscando todas las catCuentas...");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/catOperaciones/getall")
	public ResponseEntity<?> getAllCatOperaciones() {
		logger.info("Buscando todas las catOperaciones...");
		List<CatOperacion> listCatOperaciones = catOperacionRepository.findAll();
		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Consulta Realizada Correctamente",
				listCatOperaciones);
		logger.info("Fin Buscando todas las catOperaciones...");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/catTipoCredito/getall")
	public ResponseEntity<?> getAllCatTipoCredito() {
		logger.info("Buscando todos los catTipoCredito...");
		List<CatTipoCredito> listCatTipoCreditos = catTipoCreditoRepository.findAll();
		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Consulta Realizada Correctamente",
				listCatTipoCreditos);
		logger.info("Fin Buscando todos los catTipoCredito...");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/creditos/getall")
	public ResponseEntity<?> getAllCreditos() {
		logger.info("Buscando todos los creditos...");
		List<Credito> listCreditos = creditoRepository.findAll();
		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Consulta Realizada Correctamente",
				listCreditos);
		logger.info("Fin Buscando todos los creditos...");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/cuentas/getall")
	public ResponseEntity<?> getAllCuentas() {
		logger.info("Buscando todss las cuentas...");
		List<Cuenta> listCuentas = cuentaRepository.findAll();
		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Consulta Realizada Correctamente",
				listCuentas);
		logger.info("Fin Buscando todas las cuentas...");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/depositos/getall")
	public ResponseEntity<?> getAllDepositos() {
		logger.info("Buscando todos los depositos...");
		List<Deposito> listDepositos = depositoRepository.findAll();
		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Consulta Realizada Correctamente",
				listDepositos);
		logger.info("Fin Buscando todos los depositos...");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/operaciones/getall")
	public ResponseEntity<?> getAllOperaciones() {
		logger.info("Buscando todas las operaciones...");
		List<Operacion> listOperaciones = operacionRepository.findAll();
		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Consulta Realizada Correctamente",
				listOperaciones);
		logger.info("Fin Buscando todas las operaciones...");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/solicitudes/getall")
	public ResponseEntity<?> getAllSolicitudes() {
		logger.info("Buscando todas las solicitudes...");
		List<Solicitud> listSolicitudes = solicitudRepository.findAll();
		ResponseBean response = new ResponseBean(true, HttpStatus.OK.toString(), "Consulta Realizada Correctamente",
				listSolicitudes);
		logger.info("Fin Buscando todas las solicitudes...");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
