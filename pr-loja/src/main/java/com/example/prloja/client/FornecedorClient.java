package com.example.prloja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.prloja.dto.InfoFornecedorDTO;
import com.example.prloja.dto.InfoPedidoDTO;
import com.example.prloja.dto.ItemDaCompraDTO;

@Component
@FeignClient(name = "pr-fornecedor")
public interface FornecedorClient {

	@GetMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

	@PostMapping(value = "/pedido/efetuaPedido")
	InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
	
}
