package com.example.prtransportador.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Entrega implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long pedidoId;
	
	private LocalDate dataParaBusca;
	private LocalDate previsaoParaEntrega;
	
	private String enderecoOrigem;
	private String enderecoDestino;

}
