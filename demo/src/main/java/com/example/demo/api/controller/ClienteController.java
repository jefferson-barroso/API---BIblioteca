package com.example.demo.api.controller;


import com.example.demo.api.dto.ClienteDTO;
import com.example.demo.api.service.ClienteService;
import com.example.demo.api.model.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/listar")
    public ResponseEntity<List<ClienteEntity>> listarTodos() {
        List<ClienteEntity> lista = clienteService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PostMapping(value = "/incluir")
    public ResponseEntity<List<ClienteDTO>> incluir(@RequestBody ClienteDTO request) {
        ClienteEntity clienteEntity = clienteService.incluir(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteEntity.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<ClienteEntity> alterar(@PathVariable Integer id, @RequestBody ClienteDTO request) {
        ClienteEntity lista = clienteService.alterar(id, request);
        return ResponseEntity.ok().body(lista);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<ResponseEntity> deletar(@PathVariable Integer id) {
        ResponseEntity lista = clienteService.deletar(id);
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteEntity> clienteFindById(@PathVariable("id") Integer id){
        ClienteEntity entity = clienteService.clienteFindById(id);
        return ResponseEntity.ok(entity);
    }

}
