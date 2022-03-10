package com.example.prloja.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prloja.dto.CompraDTO;
import com.example.prloja.model.Compra;
import com.example.prloja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@GetMapping(value = "/findById/{id}")
	public Compra getById(@PathVariable("id") Long id) {
		return compraService.getById(id);
	}
	
	@PostMapping(value = "/efetuaCompra")
	public Compra realizaCompra(@RequestBody CompraDTO compra) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return compraService.realizaCompra(compra);
	}
	
}
