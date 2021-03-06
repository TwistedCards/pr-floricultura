package com.example.prloja.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InfoEntregaDTO {

	private Long pedidoId;
	
	private LocalDate dataParaEntrega;
	
	private String enderecoOrigem;
	private String enderecoDestino;
	
}
