package com.example.prtransportador.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VoucherDTO {

	private Long numero;
	
	private LocalDate previsaoParaEntrega;
}
