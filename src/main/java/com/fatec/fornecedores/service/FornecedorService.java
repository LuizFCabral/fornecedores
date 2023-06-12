package com.fatec.fornecedores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.fornecedores.entities.Fornecedor;
import com.fatec.fornecedores.repositories.FornecedorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> getFornecedores(){
        return fornecedorRepository.findAll();
    }

    public Fornecedor getFornecedorById(int id){
        return fornecedorRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Fornecedor não encontrado")
        );
    }

    public void deleteFornecedor(int id){
        Fornecedor fornecedor = getFornecedorById(id);
        fornecedorRepository.delete(fornecedor);
    }

    public Fornecedor save(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    public void update(int id, Fornecedor fornecedor){
        getFornecedorById(id);
        fornecedorRepository.save(fornecedor);
    }


}
