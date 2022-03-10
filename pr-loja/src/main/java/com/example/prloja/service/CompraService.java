package com.example.prloja.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prloja.client.FornecedorClient;
import com.example.prloja.client.TransportadorClient;
import com.example.prloja.dto.CompraDTO;
import com.example.prloja.dto.InfoEntregaDTO;
import com.example.prloja.dto.InfoFornecedorDTO;
import com.example.prloja.dto.InfoPedidoDTO;
import com.example.prloja.dto.VoucherDTO;
import com.example.prloja.model.Compra;
import com.example.prloja.model.CompraState;
import com.example.prloja.repository.CompraRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CompraService {

	@Autowired
	private FornecedorClient fornecedorClient;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private TransportadorClient transportadorClient;
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@HystrixCommand(fallbackMethod = "realizaCompraFallback", 
			threadPoolKey = "realizaCompraThreadPool")
	public Compra realizaCompra(CompraDTO compra) {
		
		final String estado = compra.getEnderecoDto().getEstado();
		
		Compra compraSalva = new Compra();
		compraSalva.setState(CompraState.RECEBIDO);
		compraSalva.setEnderecoDestino(compra.getEnderecoDto().toString());
		compraRepository.save(compraSalva);
		compra.setCompraId(compraSalva.getId());
		
		LOG.info("bucando informações do fornecedor de {}", estado);
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEnderecoDto().getEstado());
		
		LOG.info("realizando um pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		compraSalva.setState(CompraState.PEDIDO_REALIZADO);
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraRepository.save(compraSalva);
		
		InfoEntregaDTO entregaDto = new InfoEntregaDTO();
		entregaDto.setPedidoId(pedido.getId());
		entregaDto.setDataParaEntrega(LocalDate.now().plusDays(pedido.getTempoDePreparo()));
		entregaDto.setEnderecoOrigem(info.getEndereco());
		entregaDto.setEnderecoDestino(compra.getEnderecoDto().toString());
		
		VoucherDTO voucher = transportadorClient.reservaEntrega(entregaDto);
		compraSalva.setState(CompraState.RESERVA_ENTREGA_REALIZADA);
		compraSalva.setDataParaEntrega(voucher.getPrevisaoParaEntrega());
		compraSalva.setVoucher(voucher.getNumero());
		compraRepository.save(compraSalva);
		
		return compraSalva;
	}
	
	// Implementar
	public Compra reprocessaCompra(Long id) {
		return null;
	}
	
	// Implementar
	public Compra cancelaCompra(Long id) {
		return null;
	}
	
	public Compra realizaCompraFallback(CompraDTO compra) {
		if(null != compra.getCompraId()) {
			return compraRepository.findById(compra.getCompraId()).get();
		}
		
		Compra compraFallBack = new Compra();
		compraFallBack.setEnderecoDestino(compra.getEnderecoDto().toString());
		return compraFallBack;
	}

	@HystrixCommand(threadPoolKey = "getByIdThreadPool")
	public Compra getById(Long id) {
		return compraRepository.findById(id).orElse(new Compra());// Se não tiver no BD, ele vai retorar uma compra vazia
	}
}
