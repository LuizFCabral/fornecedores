package com.fatec.fornecedores.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.fornecedores.entities.Fornecedor;
import com.fatec.fornecedores.service.FornecedorService;

@RestController
@RequestMapping("fornecedores")
@CrossOrigin
public class FornecedoresController {
    
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("{id}")
    public ResponseEntity<Fornecedor> getFornecedor(@PathVariable int id){
        Fornecedor fornecedor = fornecedorService.getFornecedorById(id);
        return ResponseEntity.ok().body(fornecedor);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> getFornecedores(){
        List<Fornecedor> fornecedores = fornecedorService.getFornecedores();
        return ResponseEntity.ok().body(fornecedores);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable int id){
        fornecedorService.deleteFornecedor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> eitFornecedor(@PathVariable int id, @RequestBody Fornecedor fornecedor){
        fornecedorService.update(id, fornecedor);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Fornecedor> saveFornecedor(@RequestBody Fornecedor fornecedor){
        Fornecedor fornecedorSalvo = fornecedorService.save(fornecedor);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(fornecedor.getId())
                .toUri();

        return ResponseEntity.created(location).body(fornecedorSalvo);
    }

}
