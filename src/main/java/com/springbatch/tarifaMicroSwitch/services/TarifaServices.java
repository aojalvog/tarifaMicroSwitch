package com.springbatch.tarifaMicroSwitch.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbatch.tarifaMicroSwitch.model.entity.Tarifa;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface TarifaServices {

	// Métodos GET

	List<Tarifa> findAll();

	Optional<Tarifa> findById(Long id);

}
