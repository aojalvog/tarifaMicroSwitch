package com.springbatch.tarifaMicroSwitch.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Tarifa {

	private Long id;
	private String nombre;
	private Double precio;
	private Double iva;
}
