package com.example.prloja.dto;

import lombok.Data;

@Data
public class EnderecoDTO {
	private String rua;
	private String estado;
	private int numero;
	
	@Override
	public String toString() {
		return "EnderecoDTO [rua=" + rua + ", estado=" + estado + ", numero=" + numero + "]";
	}
	
}
