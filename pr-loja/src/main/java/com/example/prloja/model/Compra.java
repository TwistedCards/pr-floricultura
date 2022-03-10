package com.example.prloja.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "compra")
public class Compra implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long pedidoId;
	
	private int tempoDePreparo;
	
	private String enderecoDestino;
	
	private LocalDate dataParaEntrega;
	
	private long voucher;
	
	@Enumerated(EnumType.STRING)
	private CompraState state;
	
}
