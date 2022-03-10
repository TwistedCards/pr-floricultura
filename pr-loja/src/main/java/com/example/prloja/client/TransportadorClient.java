package com.example.prloja.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.prloja.dto.InfoEntregaDTO;
import com.example.prloja.dto.VoucherDTO;

@Component
@FeignClient(name = "pr-transportador", path = "/entrega")
public interface TransportadorClient {

	@PostMapping(value = "/efetuaEntrega")
	public VoucherDTO reservaEntrega(@RequestBody InfoEntregaDTO pedidoDTO);
	
}
