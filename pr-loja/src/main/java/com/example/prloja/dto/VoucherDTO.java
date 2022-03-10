package com.example.prloja.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class VoucherDTO {
	private Long numero;
	private LocalDate previsaoParaEntrega;
}
