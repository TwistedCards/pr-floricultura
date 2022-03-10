package com.example.prtransportador.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EntregaDTO {

	private Long pedidoId;
	
	private LocalDate dataParaEntrega;
	
	private String enderecoOrigem;
	private String enderecoDestino;

}
