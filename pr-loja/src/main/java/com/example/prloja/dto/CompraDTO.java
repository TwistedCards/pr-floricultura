package com.example.prloja.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CompraDTO {
	
	@JsonIgnore
	private Long compraId;
	private List<ItemDaCompraDTO> itens;
	private EnderecoDTO enderecoDto;
}
