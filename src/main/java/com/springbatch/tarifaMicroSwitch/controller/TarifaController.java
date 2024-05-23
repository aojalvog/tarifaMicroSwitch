package com.springbatch.tarifaMicroSwitch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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

	@GetMapping("/list")
	public List<Tarifa> getAll() {
		log.info("<---- Listando tarifas ---->");
		return tarifaServices.findAll();
	}

	@GetMapping("/list/producto/{id}")
	public Optional<Tarifa> getProducto(@PathVariable Long id) throws NotFoundException {
		log.info("<---- Mostrando la tarifa con id {} ---->", id);
		return Optional.of(tarifaServices.findById(id).orElseThrow(() -> new NotFoundException()));
	}
}
