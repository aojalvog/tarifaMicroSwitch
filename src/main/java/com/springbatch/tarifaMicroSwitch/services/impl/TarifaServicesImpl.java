package com.springbatch.tarifaMicroSwitch.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbatch.tarifaMicroSwitch.handler.NotFoundException;
import com.springbatch.tarifaMicroSwitch.model.entity.Tarifa;
import com.springbatch.tarifaMicroSwitch.repository.TarifaRepository;
import com.springbatch.tarifaMicroSwitch.services.TarifaServices;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class TarifaServicesImpl implements TarifaServices {

	private final TarifaRepository tarifaRepository;

	public TarifaServicesImpl(TarifaRepository tarifaRepository) {
		this.tarifaRepository = tarifaRepository;
	}

	// GET
	@Override
	public List<Tarifa> findAll() {
		log.info("<---- Listando el catalogo ---->");
		return tarifaRepository.findAll();
	}

	@Override
	public Optional<Tarifa> findById(Long id) {
		log.info("<---- Comprobando si el producto con id {} existe ---->", id);
		return Optional.ofNullable(tarifaRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Tarifa no encontrada con id " + id)));
	}

}
