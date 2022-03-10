package com.example.prfornecedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prfornecedor.model.Produto;
import com.example.prfornecedor.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/findByEstado/{estado}")
	public List<Produto> getProdutosPorEstado(@PathVariable String estado) {
		return produtoService.getProdutosPorEstado(estado);
	}
}
