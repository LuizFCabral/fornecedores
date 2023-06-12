package com.fatec.fornecedores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.fornecedores.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository <Fornecedor, Integer>{
    
}
