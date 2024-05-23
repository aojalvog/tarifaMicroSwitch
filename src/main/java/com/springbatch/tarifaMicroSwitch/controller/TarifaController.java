package com.springbatch.tarifaMicroSwitch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbatch.tarifaMicroSwitch.model.entity.Tarifa;
import com.springbatch.tarifaMicroSwitch.services.TarifaServices;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/tarifas")
@Slf4j
public class TarifaController {

	private TarifaServices tarifaServices;

	public TarifaController(TarifaServices tarifaServices) {
		this.tarifaServices = tarifaServices;
	}

	@Autowired
	private Environment environment;

	// Obtener el puerto actual
	@Value("${server.port}")
	private Integer port;

	@GetMapping("/list")
	public ResponseEntity<List<Tarifa>> getAll() {
		List<Tarifa> listTarifa = tarifaServices.findAll();
		for (Tarifa tarifa : listTarifa) {
			tarifa.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		}
		return ResponseEntity.ok(listTarifa);
	}

	@GetMapping("/list/producto/{id}")
	public Optional<Tarifa> getProducto(@PathVariable Long id) throws NotFoundException {
		log.info("<---- Mostrando la tarifa con id {} ---->", id);
		return Optional.of(tarifaServices.findById(id).orElseThrow(NotFoundException::new));

	}
}
