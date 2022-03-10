package com.example.prfornecedor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.prfornecedor.model.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
