package com.springbatch.tarifaMicroSwitch.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table
@Entity
public class Producto {
	private Long id;
	private String lugar;
	private Integer stock;
	private Integer stockReal;
	private Integer stockVirtual;
	private String nombre;
	private Tarifa tarifa;

}
