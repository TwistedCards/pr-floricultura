package com.example.prfornecedor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prfornecedor.model.InfoFornecedor;
import com.example.prfornecedor.service.InfoService;

//@RefreshScope
@RestController
@RequestMapping("/info")
public class InfoController {

	private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping(value = "/{estado}")
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
		LOG.info("Recebido pedido de informações de {}", estado);
		InfoFornecedor info = infoService.getInfoPorEstado(estado);
		System.out.println("info: " + info.getEndereco() + " --- estado: " + info.getEstado());
		
		return info;
	}
	
}
