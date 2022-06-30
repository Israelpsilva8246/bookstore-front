package com.israel.crudspring.controller;

import java.util.List;

import com.israel.crudspring.model.Cliente;
import com.israel.crudspring.repository.ClienteRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteRepository clienteRepository;
    
    @GetMapping
    public @ResponseBody List<Cliente> list() {
        return clienteRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente) {
        // System.out.println(cliente.getNome());
        return clienteRepository.save(cliente);
        // return ResponseEntity.status(HttpStatus.CREATED)
        //     .body(clienteRepository.save(cliente));
    }
}
