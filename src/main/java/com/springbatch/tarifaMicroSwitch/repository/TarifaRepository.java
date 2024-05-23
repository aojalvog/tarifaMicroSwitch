package com.springbatch.tarifaMicroSwitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbatch.tarifaMicroSwitch.model.entity.Tarifa;

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {

}
