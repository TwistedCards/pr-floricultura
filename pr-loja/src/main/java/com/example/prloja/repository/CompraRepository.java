package com.example.prloja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.prloja.model.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long>{

}
