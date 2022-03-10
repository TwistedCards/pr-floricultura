package com.example.prfornecedor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.prfornecedor.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	List<Produto> findByEstado(String estado);
	List<Produto> findByIdIn(List<Long> ids);
}
